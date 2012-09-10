package ru.numerals

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:39 PM
 */

object Numerals {
  private val MAX_POWER = 21

  private val powers = List (
    List ("0", ""            , ""             ,""              ),  // 1
    List ("1", "тысяча "     , "тысячи "      ,"тысяч "        ),  // 2
    List ("0", "миллион "    , "миллиона "    ,"миллионов "    ),  // 3
    List ("0", "миллиард "   , "миллиарда "   ,"миллиардов "   ),  // 4
    List ("0", "триллион "   , "триллиона "   ,"триллионов "   ),  // 5
    List ("0", "квадриллион ", "квадриллиона ","квадриллионов "),  // 6
    List ("0", "квинтиллион ", "квинтиллиона ","квинтиллионов ")   // 7
  )

  private val digits = List (
    List (""       ,""       , "десять "      , ""            ,""          ),
    List ("один "  ,"одна "  , "одиннадцать " , "десять "     ,"сто "      ),
    List ("два "   ,"две "   , "двенадцать "  , "двадцать "   ,"двести "   ),
    List ("три "   ,"три "   , "тринадцать "  , "тридцать "   ,"триста "   ),
    List ("четыре ","четыре ", "четырнадцать ", "сорок "      ,"четыреста "),
    List ("пять "  ,"пять "  , "пятнадцать "  , "пятьдесят "  ,"пятьсот "  ),
    List ("шесть " ,"шесть " , "шестнадцать " , "шестьдесят " ,"шестьсот " ),
    List ("семь "  ,"семь "  , "семнадцать "  , "семьдесят "  ,"семьсот "  ),
    List ("восемь ","восемь ", "восемнадцать ", "восемьдесят ","восемьсот "),
    List ("девять ","девять ", "девятнадцать ", "девяносто "  ,"девятьсот ")
  )


  /**
   * Convert x to it's string equivalent
   * @param x number to be converted
   * @return converted number to string
   */


  def num2Str (x: Long) : String =
    num2Str(BigInt(x))


  /**
   * Convert x to it's string equivalent
   * @param x number to be converted
   * @return converted number to string
   * @throws IllegalArgumentException if number > 10^21^
   */


  def num2Str (x : BigInt) : String = {
    require (x < BigInt(10).pow(MAX_POWER), "To large number...")

    if (0 == x) "ноль"
    else if (x < 0)
      "минус " + positiveBigInt2Str (-x) dropRight 1
    else positiveBigInt2Str (x) dropRight 1

  }


  /**
   * Convert only non negative number to string
   * @param x number to be converted
   * @return converted number to string
   */


  private def positiveBigInt2Str (x : BigInt) = {
    require (x > BigInt(0), "x must be a positive number!")

    val result = new StringBuilder
    val maxPower = x.toString.length - x.toString.length % 3

    for (p <- maxPower to 0 by -3) {
      val h = (x % BigInt(10).pow(p+3) / BigInt(10).pow(p)).toInt
      if (0 != h) result.append (hundreds2Str (h, powers (p / 3)(0).toInt))
      h match {
        case 0 =>
        case 1 => result append (powers (p / 3)(1))
        case y if (List (2, 3, 4).contains (y)) => result append (powers (p / 3)(2))
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


  private def hundreds2Str (x: Int, gender: Int) = {
    require (
      (0 <= x && 999 > x),
      "x must be between 0 and 999, but passed %d" format (x))
    require (
      (0 == gender || 1 == gender),
      "Gender may be only 0 or 1, but passed %d" format (gender))

    val result = new StringBuilder

    result append digits (x / 100)(4)

    x % 100 / 10 match {
      case y if y > 1 => {
        result append digits (y)(3)
        result append digits (x % 10)(0)
      }
      case 1 => result append digits (x % 10)(2)
      case 0 => result append digits (x % 10)(gender)
    }
    result toString()
  }
}
