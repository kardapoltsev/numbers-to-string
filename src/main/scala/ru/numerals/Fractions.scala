package ru.numerals

/**
 * Created with IntelliJ IDEA.
 * Date: 9/13/12
 * Time: 12:52 PM
 */

object Fractions {

  import Numerals._
  import Gender._
  import Form._
  import Part._


  def fraction2Str (f: String) = {
    val (n, d) = f.span (_.toString != "/")

    if ("0" == n) num2Str (BigInt (0))
    else {
      val num = num2Str (BigInt (n), Feminine)
      val form = if ("1" == n.last.toString) Singular else Plural
      val den = num2Str (BigInt (d.tail), Feminine, Adjective, form)
      "%s %s" format(num, den)
    }
  }
}
