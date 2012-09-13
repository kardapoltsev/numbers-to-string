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


  def digits (gender : Gender, part : Part) = {
    (part, gender) match {
      case (Num,       Masculine) =>  digitsNSM
      case (Num,       Feminine ) =>  digitsNSF
      case (Num,       Neuter   ) =>  digitsNSN
      case (Adjective, Masculine) =>  digitsASM
      case (Adjective, Feminine ) =>  digitsASF
      case (Adjective, Neuter   ) =>  digitsASN
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

  private val digitsNSM = List (
    List ("",         "десять ",        "",             ""),
    List ("один ",    "одиннадцать ",   "десять ",      "сто "),
    List ("два ",     "двенадцать ",    "двадцать ",    "двести "),
    List ("три ",     "тринадцать ",    "тридцать ",    "триста "),
    List ("четыре ",  "четырнадцать ",  "сорок ",       "четыреста "),
    List ("пять ",    "пятнадцать ",    "пятьдесят ",   "пятьсот "),
    List ("шесть ",   "шестнадцать ",   "шестьдесят ",  "шестьсот "),
    List ("семь ",    "семнадцать ",    "семьдесят ",   "семьсот "),
    List ("восемь ",  "восемнадцать ",  "восемьдесят ", "восемьсот "),
    List ("девять ",  "девятнадцать ",  "девяносто ",   "девятьсот ")
  )


  private val digitsNSF = List (
    List ("",         "десять ",        "",             ""),
    List ("одна ",    "одиннадцать ",   "десять ",      "сто "),
    List ("две ",     "двенадцать ",    "двадцать ",    "двести "),
    List ("три ",     "тринадцать ",    "тридцать ",    "триста "),
    List ("четыре ",  "четырнадцать ",  "сорок ",       "четыреста "),
    List ("пять ",    "пятнадцать ",    "пятьдесят ",   "пятьсот "),
    List ("шесть ",   "шестнадцать ",   "шестьдесят ",  "шестьсот "),
    List ("семь ",    "семнадцать ",    "семьдесят ",   "семьсот "),
    List ("восемь ",  "восемнадцать ",  "восемьдесят ", "восемьсот "),
    List ("девять ",  "девятнадцать ",  "девяносто ",   "девятьсот ")
  )


  private val digitsNSN = List (
    List ("",         "десять ",        "",             ""),
    List ("одно ",    "одиннадцать ",   "десять ",      "сто "),
    List ("два ",     "двенадцать ",    "двадцать ",    "двести "),
    List ("три ",     "тринадцать ",    "тридцать ",    "триста "),
    List ("четыре ",  "четырнадцать ",  "сорок ",       "четыреста "),
    List ("пять ",    "пятнадцать ",    "пятьдесят ",   "пятьсот "),
    List ("шесть ",   "шестнадцать ",   "шестьдесят ",  "шестьсот "),
    List ("семь ",    "семнадцать ",    "семьдесят ",   "семьсот "),
    List ("восемь ",  "восемнадцать ",  "восемьдесят ", "восемьсот "),
    List ("девять ",  "девятнадцать ",  "девяносто ",   "девятьсот ")
  )



//  private val digits = List (
//    List ("",         "",         "",         "десять ",        "",             ""),
//    List ("один ",    "одна ",    "одно ",    "одиннадцать ",   "десять ",      "сто "),
//    List ("два ",     "две ",     "два ",     "двенадцать ",    "двадцать ",    "двести "),
//    List ("три ",     "три ",     "три ",     "тринадцать ",    "тридцать ",    "триста "),
//    List ("четыре ",  "четыре ",  "четыре ",  "четырнадцать ",  "сорок ",       "четыреста "),
//    List ("пять ",    "пять ",    "пять ",    "пятнадцать ",    "пятьдесят ",   "пятьсот "),
//    List ("шесть ",   "шесть ",   "шесть ",   "шестнадцать ",   "шестьдесят ",  "шестьсот "),
//    List ("семь ",    "семь ",    "семь ",    "семнадцать ",    "семьдесят ",   "семьсот "),
//    List ("восемь ",  "восемь ",  "восемь ",  "восемнадцать ",  "восемьдесят ", "восемьсот "),
//    List ("девять ",  "девять ",  "девять ",  "девятнадцать ",  "девяносто ",   "девятьсот ")
//  )

  private val digitsASM = List (
    List ("",           "десятый ",      "",               ""),
    List ("первый ",    "одиннадцатый ",  "десятый ",       "сотый "),
    List ("второй ",    "двенадцатый ",   "двадцатый ",     "двухсотый "),
    List ("третий ",    "тринадцатый ",   "тридцатый ",     "трехсотый "),
    List ("четвертый ", "четырнадцатый ", "сороковой ",     "четырсотый "),
    List ("пятый ",     "пятнадцатый ",   "пятьдесятый ",   "пятисотый "),
    List ("шестой ",    "шестнадцатый ",  "шестьдесятый ",  "шестисотый "),
    List ("седьмой ",   "семнадцатый ",   "семьдесятый ",   "семисотый "),
    List ("восьмой ",   "восемнадцатый ", "восемьдесятый ", "восемисотый "),
    List ("девятый ",   "девятнадцатый ", "девяностый ",    "девятисотый ")
  )



  private val digitsASF = List (
    List ("",           "десятая ",       "",               ""),
    List ("первая ",    "одиннадцатая ",  "десятая ",       "сотая "),
    List ("вторая ",    "двенадцатая ",   "двадцатая ",     "двухсотая "),
    List ("третья ",    "тринадцатая ",   "тридцатая ",     "трехсотая "),
    List ("четвертая ", "четырнадцатая ", "сороковая ",     "четырехсотая "),
    List ("пятая ",     "пятнадцатая ",   "пятидесятая ",   "пятисотая "),
    List ("шестая ",    "шестнадцатая ",  "шестидесятая ",  "шестисотая "),
    List ("седьмая ",   "семнадцатая ",   "семидесятая ",   "семисотая "),
    List ("восьмая ",   "восемнадцатая ", "восемидесятая ", "восьмисотая "),
    List ("девятая ",   "девятнадцатая ", "девяностая ",    "девятисотая ")
  )


  private val digitsASN = List (
    List ("",           "десятое ",        "",             ""),
    List ("первое ",    "одиннадцатое ",   "десятое ",      "сто "),
    List ("второе ",    "двенадцатое ",    "двадцатое ",    "двести "),
    List ("третье ",    "тринадцатое ",    "тридцатое ",    "триста "),
    List ("четвертое ", "четырнадцатое ",  "сороковое ",       "четыреста "),
    List ("пятое ",     "пятнадцатое ",    "пятидесятое ",   "пятьсот "),
    List ("шестое ",    "шестнадцатое ",   "шестидесятое ",  "шестьсот "),
    List ("седьмое ",   "семнадцатое ",    "семидесятое ",   "семьсот "),
    List ("восьмое ",   "восемнадцатое ",  "восемидесятое ", "восемьсот "),
    List ("девятое ",   "девятнадцатое ",  "девяностоое ",   "девятьсот ")
  )

  /**
   * Convert number to it's string equivalent
   * @param x number to be converted
   * @param gender providing right suffix to numeral string,
   *               default is Masculine
   * @return converted number to string
   * @throws IllegalArgumentException if number > 10^21^
   */


//  def num2Str (x: BigInt, gender: Gender, capitalize : Boolean) =
//    convert (x,gender,capitalize)
//
//
//  def num2Str (x: BigInt) = convert (x)
//
//
//  def num2Str (x: String, gender : Gender, capitalize : Boolean) =
//    convert (BigInt (x),gender,capitalize)
//
//
//  def num2Str (x: String) = convert (BigInt (x))
//
//
//  def num2Str (x: Long, gender: Gender, capitalize : Boolean) =
//    convert(BigInt (x),gender,capitalize)
//
//
//  def num2Str (x: Long) = convert(BigInt (x))


//  private def convert (x: BigInt,
//                       gender: Gender = Masculine,
//                       capitalize : Boolean = false) : String =
//    convert(x,gender,capitalize,powers, digits)


//  def denominator2Str (x : BigInt,
//                       form : Form,
//                       capitalize : Boolean = false) = {
//    val p = powers
//    val d = form match {
//      case Singular => adjDigitsSingular
//      case Plural => adjDigitsPlural
//    }
//    convert(x,Feminine,capitalize,p,d)
//  }


  def convert (x: BigInt,
               gender: Gender,
//               form : Form,
               part : Part
               ) : String = {

    require (x < BigInt (10).pow (MAX_POWER), "To large number...")

    if (0 == x) "ноль"
    else if (x < 0)
      "минус " + positiveBigInt2Str (-x, gender,part) dropRight 1
    else positiveBigInt2Str (x, gender, part) dropRight 1
  }


  /**
   * Convert only non negative number to string
   * @param x number to be converted
   * @return converted number to string
   */


  private def positiveBigInt2Str ( x: BigInt,
                                   gender: Gender,
                                   part : Part
                                   ) = {

    require (x > BigInt (0), "x must be a positive number!")

    val result = new StringBuilder
    val maxPower = x.toString ().length - x.toString ().length % 3

    for (pow <- maxPower to 0 by -3) {
      val  g = if (0 == pow) gender else Gender(powers (pow / 3)(0).toInt)
      val p = if (0 == pow) part else Num

      val h = (x % BigInt (10).pow (pow + 3) / BigInt (10).pow (pow)).toInt
      if (0 != h) result.append (hundreds2Str (h, g, p))
      h%10 match {
        case 0 =>
        case 1 => result append (powers (pow / 3)(3))
        case y if Set (2, 3, 4) contains  y => result append (powers (pow / 3)(2))
        case _ => result append (powers (pow / 3)(3))
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


  private def hundreds2Str (x: Int, gender: Gender, part : Part ) = {
    require (
      (0 <= x && 1000 > x),
      "x must be between 0 and 999, but passed %d" format (x))

    val result = new StringBuilder

//    println("x = %d" format (x))
//    println(digits)

    val hp = if (0 == x%100) part else Num
    val tp = if (0 == x%10) part else Num

    result append digits (gender,hp) (x / 100)(3)

//    println("Converting %d with gender %s".format (x,gender))

    x % 100 / 10 match {
      case y if y > 1 => {
        result append digits (gender,tp) (y)(2)
        result append digits (gender,part) (x % 10) (0)
      }
      case 1 => result append digits (gender,part) (x % 10)(1)
      case 0 => result append digits (gender,part) (x % 10)(0)
    }
    result toString()
  }
}
