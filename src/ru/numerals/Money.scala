package ru.numerals

import Numerals.num2Str

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {

  private val rubles = List ("рубль","рубля","рублей")
  private val kopecks = List ("копейка","копейки","копеек")

  /**
   * 12345 => 123 руб. 45 коп.
   * @param x
   */
  def ruMoney (x : BigInt) = {
//    val rubNum = num2Str(x/100)
//    val kopNum = num2Str(x%100)
//    val rub = rubNum.last match {
//      case "1" => rubles(0)
//      case x if List("2","3","4") contains(x) => rubles(1)
//      case _ => rubles(2)
//    }
//    "%s %s %s коп." format (rubNum,rub,kop)
  }
}
