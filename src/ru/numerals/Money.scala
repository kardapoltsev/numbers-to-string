package ru.numerals

import ru.numerals.Numerals._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {

//  import Gender._
//
//  private val rubles = List ("рубль", "рубля", "рублей")
//  private val kopecks = List ("копейка", "копейки", "копеек")
//
//
//  /**
//   * 12345 => сто двадцать три рубля сорок пять копеек
//   * @param x amount to be converted
//   */
//
//
//  def ruMoney (x : String, capitalize : Boolean) =
//    convert (BigInt(x),capitalize)
//
//
//  def ruMoney (x : String) =
//    convert (BigInt(x))
//
//
//  /**
//   * 12345 => сто двадцать три рубля сорок пять копеек
//   * @param x amount to be converted
//   */
//
//
//  def ruMoney (x : Long, capitalize : Boolean) =
//    convert (BigInt(x),capitalize)
//
//
//  def ruMoney (x : Long) =
//    convert (BigInt(x))
//
//
//  /**
//   * 12345 => сто двадцать три рубля сорок пять копеек
//   * @param x amount to be converted
//   */
//  def ruMoney (x: BigInt, capitalize : Boolean) =
//    convert (x,capitalize)
//
//
//  def ruMoney (x: BigInt) =
//    convert (x)
//
//  private def convert (x: BigInt, capitalize : Boolean = false) = {
//    val r = x / 100
//    val k = x % 100
//    val rubNum = num2Str (r, Masculine,capitalize)
//    val kopNum = num2Str (k, Feminine,capitalize=false)
//    val rub = (r % 100).toInt match {
//      case a if (10 < a && 20 > a) => rubles (2)
//      case a => a % 10 match {
//        case 1 => rubles (0)
//        case y if Set (2, 3, 4) contains y => rubles (1)
//        case _ => rubles (2)
//      }
//    }
//    val kop = (k % 100).toInt match {
//      case a if (10 < a && 20 > a) => kopecks (2)
//      case a => a % 10 match {
//        case 1 => kopecks (0)
//        case y if Set (2, 3, 4) contains y => kopecks (1)
//        case _ => kopecks (2)
//      }
//    }
//    "%s %s %s %s" format(rubNum, rub, kopNum, kop)
//  }

}
