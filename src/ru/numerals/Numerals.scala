package ru.numerals

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */


object Numerals {

  import Gender._
  import Form._
  import Part._

  private val MAX_POWER = 21


  def digits (gender : Gender, part : Part, form : Form) = {
    (form,part, gender) match {
      case (Singular, Num,       Masculine) =>  ruStrings.digitsNSM
      case (Singular, Num,       Feminine ) =>  ruStrings.digitsNSF
      case (Singular, Num,       Neuter   ) =>  ruStrings.digitsNSN
      case (Singular, Adjective, Masculine) =>  ruStrings.digitsASM
      case (Singular, Adjective, Feminine ) =>  ruStrings.digitsASF
      case (Singular, Adjective, Neuter   ) =>  ruStrings.digitsASN
      case (Plural,   Adjective, Feminine ) =>  ruStrings.digitsAPF
      case _ => ruStrings.digitsNSM
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


  def num2Str (x: BigInt, gender : Gender) = convert (x,gender)


  def num2Str (x: BigInt, gender : Gender, part : Part, form : Form) = convert (x,gender,part,form)


  private def convert (x: BigInt,
               gender: Gender = Masculine,
               part : Part = Num,
               form : Form = Singular
               ) : String = {

    require (x < BigInt (10).pow (MAX_POWER), "To large number...")

    if (0 == x) "ноль"
    else if (x < 0)
      "минус " + positiveBigInt2Str (-x, gender,part,form) dropRight 1
    else positiveBigInt2Str (x, gender, part,form) dropRight 1
  }


  /**
   * Convert only non negative number to string
   * @param x number to be converted
   * @return converted number to string
   */


  private def positiveBigInt2Str ( x: BigInt,
                                   gender: Gender,
                                   part : Part,
                                   form : Form
                                   ) = {

    require (x > BigInt (0), "x must be a positive number!")

    val result = new StringBuilder
    val maxPower = x.toString ().length - x.toString ().length % 3

    for (pow <- maxPower to 0 by -3) {
      val  g = if (0 == pow) gender else Gender(powers (pow / 3)(0).toInt)
      val p = if (0 == pow) part else Num
      val f = if (0 == pow) form else Singular

      val h = (x % BigInt (10).pow (pow + 3) / BigInt (10).pow (pow)).toInt
      if (0 != h) {
        result.append (hundreds2Str (h, g, p, f))
        h%100/10 match {
          case 1 => result append (powers (pow/3)(3))
          case _ => {
            h % 10 match {
              case 1 => result append (powers (pow / 3)(1))
              case y if Set (2, 3, 4) contains  y => result append (powers (pow / 3)(2))
              case _ => result append (powers (pow / 3)(3))
            }
          }
        }
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


  private def hundreds2Str (x: Int, gender: Gender, part : Part, form : Form ) = {
    require (
      (0 <= x && 1000 > x),
      "x must be between 0 and 999, but passed %d" format (x))

    val result = new StringBuilder

//    println("x = %d" format (x))
//    println(digits)

    val hp = if (0 == x%100) part else Num
    val tp = if (0 == x%10) part else Num
    val f = form

    result append digits (gender,hp,f) (x / 100)(3)

//    println("Converting %d with gender %s".format (x,gender))

    x % 100 / 10 match {
      case y if y > 1 => {
        result append digits (gender,tp,f) (y)(2)
        result append digits (gender,part,f) (x % 10) (0)
      }
      case 1 => result append digits (gender,part,f) (x % 10)(1)
      case 0 => result append digits (gender,part,f) (x % 10)(0)
    }
    result toString()
  }
}
