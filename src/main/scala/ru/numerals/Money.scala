package ru.numerals

import ru.numerals.Numerals._
import io.Source
import java.io.{FileNotFoundException, BufferedWriter, FileWriter, File}

/**
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {

  private val RUB_GENDER = 0
  private val RUB_ONE = 1
  private val RUB_TWO = 2
  private val RUB_MANY = 3
  private val KOP_GENDER = 4
  private val KOP_ONE = 5
  private val KOP_TWO = 6
  private val KOP_MANY = 7


  /**
   * Convert x to money using default currency RUR from money file
   * @param x amount to be converted
   * @return converted string
   */
  def ruMoney (x: BigInt) = convertMoney (x,"RUR")


  /**
   * Converting x to money using currency cur
   * @param x amount to be converted
   * @param cur currency. Should be present in money file
   * @return converted string
   */
  def money (x : BigInt,cur : String) = convertMoney(x,cur)


  private def convertMoney (x: BigInt, currency : String) = {

    val cur = this.currencies(currency)

    val r = x / 100
    val k = x % 100
    val rubNum = num2Str (r, Gender.withName(cur(RUB_GENDER)))
    val kopNum = num2Str (k, Gender.withName(cur(KOP_GENDER)))
    val rub = (r % 100).toInt match {
      case a if 10 < a && 20 > a => cur (RUB_MANY)
      case a => a % 10 match {
        case 1 => cur (RUB_ONE)
        case y if Set (2, 3, 4) contains y => cur (RUB_TWO)
        case _ => cur (RUB_MANY)
      }
    }
    val kop = (k % 100).toInt match {
      case a if 10 < a && 20 > a => cur (KOP_MANY)
      case a => a % 10 match {
        case 1 => cur (KOP_ONE)
        case y if Set (2, 3, 4) contains y => cur (KOP_TWO)
        case _ => cur (KOP_MANY)
      }
    }
    "%s %s %s %s" format(rubNum, rub, kopNum, kop)
  }

  private lazy val currencies = getResources


  private def getResources = {
   val r = try {
     Source.fromFile("money.txt").getLines().toList
      .filter(!_.startsWith("//")).map(_.split(":").toList)
    } catch {
      case e : FileNotFoundException =>
        defaultResource
    }

    if (r.isEmpty)
      throw new RuntimeException ("No currency in money file!")

    val wrongLines = r.filter(9 != _.length)
    if (!wrongLines.isEmpty)
      throw new RuntimeException (
        "Wrong money file! Check lines %s".format (wrongLines))

    r.map {
      case cur :: tail => cur -> tail
    }.toMap
  }


	private def defaultResource = List(
		"RUR:Masculine:рубль:рубля:рублей:Feminine:копейка:копейки:копеек".split(":").toList,
		"USD:Masculine:доллар:доллара:долларов:Masculine:цент:цента:центов".split(":").toList
	)
}
