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
  def fraction2Str (f : String) = {
    val (n,d) = f.span(_.toString != "/")

    val num = num2Str (BigInt(n),Feminine)
    val form = if ("1" == n.last.toString) Singular else Plural
//    println(n.last)
//    println (form)
    val den = num2Str (BigInt(d.tail), Feminine, Adjective, form)

    "%s %s" format (num, den)

  }
}
