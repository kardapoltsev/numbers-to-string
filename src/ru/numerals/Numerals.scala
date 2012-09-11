package ru.numerals

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */


object Numerals {

  import Gender._

  private val MAX_POWER = 21

  private val powers = List (
    List ("0", "", "", ""), // 1
    List ("1", "тысяча ", "тысячи ", "тысяч "), // 2
    List ("0", "миллион ", "миллиона ", "миллионов "), // 3
    List ("0", "миллиард ", "миллиарда ", "миллиардов "), // 4
    List ("0", "триллион ", "триллиона ", "триллионов "), // 5
    List ("0", "квадриллион ", "квадриллиона ", "квадриллионов "), // 6
    List ("0", "квинтиллион ", "квинтиллиона ", "квинтиллионов ") // 7
  )

  private val digits = List (
    List ("",      "",     "", "десять ", "", ""),
    List ("один ", "одна ", "одно ", "одиннадцать ", "десять ", "сто "),
    List ("два ", "две ", "два ", "двенадцать ", "двадцать ", "двести "),
    List ("три ", "три ", "три ", "тринадцать ", "тридцать ", "триста "),
    List ("четыре ", "четыре ","четыре ", "четырнадцать ", "сорок ", "четыреста "),
    List ("пять ", "пять ","пять ", "пятнадцать ", "пятьдесят ", "пятьсот "),
    List ("шесть ", "шесть ","шесть ", "шестнадцать ", "шестьдесят ", "шестьсот "),
    List ("семь ", "семь ", "семь ", "семнадцать ", "семьдесят ", "семьсот "),
    List ("восемь ", "восемь ","восемь ", "восемнадцать ", "восемьдесят ", "восемьсот "),
    List ("девять ", "девять ","девять ", "девятнадцать ", "девяносто ", "девятьсот ")
  )


  /**
   * Convert x to it's string equivalent
   * @param x number to be converted
   * @return converted number to string
   */


  def num2Str (x: String): String = num2Str (BigInt (x))


  /**
   * Convert x to it's string equivalent
   * @param x number to be converted
   * @return converted number to string
   */


  def num2Str (x: Long): String = num2Str (BigInt (x))


  def num2Str (x: Long, gender: Gender): String =
    num2Str (BigInt (x), gender)


  /**
   * Convert x to it's string equivalent
   * @param x number to be converted
   * @param gender providing right suffix to numeral string,
   *               default is Masculine
   * @return converted number to string
   * @throws IllegalArgumentException if number > 10^21^
   */


  def num2Str (x: BigInt, gender: Gender = Masculine): String = {
    require (x < BigInt (10).pow (MAX_POWER), "To large number...")

    if (0 == x) "ноль"
    else if (x < 0)
      "минус " + positiveBigInt2Str (-x, gender) dropRight 1
    else positiveBigInt2Str (x, gender) dropRight 1
  }


  /**
   * Convert only non negative number to string
   * @param x number to be converted
   * @return converted number to string
   */


  private def positiveBigInt2Str (x: BigInt, gender: Gender) = {
    require (x > BigInt (0), "x must be a positive number!")

    val result = new StringBuilder
    val maxPower = x.toString ().length - x.toString ().length % 3

    for (p <- maxPower to 0 by -3) {
      val  g = if (0 == p) gender else Gender(powers (p / 3)(0).toInt)

      val h = (x % BigInt (10).pow (p + 3) / BigInt (10).pow (p)).toInt
      if (0 != h) result.append (hundreds2Str (h, g))
      h%10 match {
        case 0 =>
        case 1 => result append (powers (p / 3)(1))
        case y if Set (2, 3, 4) contains  y => result append (powers (p / 3)(2))
        case _ => result append (powers (p / 3)(3))
      }
    }
    result.toString ()
  }


  /**
   * Convert number from 0 to 999 to string
   * @param x number to be converted
   * @param gender male/female
   * @return converted number to string
   */


  private def hundreds2Str (x: Int, gender: Gender) = {
    require (
      (0 <= x && 1000 > x),
      "x must be between 0 and 999, but passed %d" format (x))

    val result = new StringBuilder

    result append digits (x / 100)(5)

//    println("Converting %d with gender %s".format (x,gender))

    x % 100 / 10 match {
      case y if y > 1 => {
        result append digits (y)(4)
        result append digits (x % 10)(gender.id)
      }
      case 1 => result append digits (x % 10)(3)
      case 0 => result append digits (x % 10)(gender.id)
    }
    result toString()
  }
}
