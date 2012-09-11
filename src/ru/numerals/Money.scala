package ru.numerals

import ru.numerals.Numerals._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {

  import Gender._

  private val rubles = List ("рубль", "рубля", "рублей")
  private val kopecks = List ("копейка", "копейки", "копеек")


  /**
   * 12345 => сто двадцать три рубля сорок пять копеек
   * @param x amount to be converted
   */


  def ruMoney (x : String) : String = ruMoney(BigInt(x))


  /**
   * 12345 => сто двадцать три рубля сорок пять копеек
   * @param x amount to be converted
   */


  def ruMoney (x : Long) : String = ruMoney(BigInt(x))


  /**
   * 12345 => сто двадцать три рубля сорок пять копеек
   * @param x amount to be converted
   */
  def ruMoney (x: BigInt) = {
    val r = x / 100
    val k = x % 100
    val rubNum = num2Str (r, Masculine)
    val kopNum = num2Str (k, Feminine)
    val rub = (r % 10).toInt match {
      case 1 => rubles (0)
      case a if Set (2, 3, 4) contains a => rubles (1)
      case _ => rubles (2)
    }
    val kop = (k % 10).toInt match {
      case 1 => kopecks (0)
      case a if Set (2, 3, 4) contains a => kopecks (1)
      case _ => kopecks (2)
    }
    "%s %s %s %s" format(rubNum, rub, kopNum, kop)
  }
}
