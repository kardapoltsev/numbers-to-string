package ru.numerals

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */


object Numerals {

  import Gender._

  private val MAX_POWER = 21


  def digits (gender: Gender) = {
    gender match {
      case Masculine => RuStrings.digitsM
      case Feminine => RuStrings.digitsF
      case Neuter => RuStrings.digitsN
    }
  }


  private val powers = List (
    //    Gender, one, two, many
    List ("0", "", "", ""), // 1
    List ("1", "тысяча ", "тысячи ", "тысяч "), // 2
    List ("0", "миллион ", "миллиона ", "миллионов "), // 3
    List ("0", "миллиард ", "миллиарда ", "миллиардов "), // 4
    List ("0", "триллион ", "триллиона ", "триллионов "), // 5
    List ("0", "квадриллион ", "квадриллиона ", "квадриллионов "), // 6
    List ("0", "квинтиллион ", "квинтиллиона ", "квинтиллионов ") // 7
  )


  def num2Str (x: BigInt) = convert (x)


  def num2Str (x: BigInt, gender: Gender) = convert (x, gender)


  private def convert (x: BigInt,
                       gender: Gender = Masculine
                        ): String = {

    require (x < BigInt (10).pow (MAX_POWER), "To large number...")

    if (0 == x) "ноль"
    else if (x < 0)
      "минус " + positiveBigInt2Str (-x, gender) dropRight 1
    else positiveBigInt2Str (x, gender) dropRight 1
  }


  private def positiveBigInt2Str (x: BigInt, gender: Gender) = {

    require (x > BigInt (0), "x must be a positive number!")

    val result = new StringBuilder
    val maxPower = x.toString ().length - x.toString ().length % 3

    for (pow <- maxPower to 0 by -3) {
      val g = if (0 == pow) gender else Gender (powers (pow / 3)(0).toInt)

      val h = (x % BigInt (10).pow (pow + 3) / BigInt (10).pow (pow)).toInt
      if (0 != h) {
        result.append (hundreds2Str (h, g))
        h % 100 / 10 match {
          case 1 => result append (powers (pow / 3)(3))
          case _ => {
            h % 10 match {
              case 1 => result append (powers (pow / 3)(1))
              case y if Set (2, 3, 4) contains y =>
                result append (powers (pow / 3)(2))
              case _ => result append (powers (pow / 3)(3))
            }
          }
        }
      }
    }
    result.toString ()
  }


  private def hundreds2Str (x: Int, gender: Gender) = {
    require (0 <= x && 1000 > x, "x must be between 0 and 999, but passed %d" format (x))

    val result = new StringBuilder

    result append digits (gender)(x / 100)(3)

    x % 100 / 10 match {
      case y if y > 1 =>
        result append digits (gender)(y)(2)
        result append digits (gender)(x % 10)(0)
      case 1 => result append digits (gender)(x % 10)(1)
      case 0 => result append digits (gender)(x % 10)(0)
    }
    result toString()
  }
}
