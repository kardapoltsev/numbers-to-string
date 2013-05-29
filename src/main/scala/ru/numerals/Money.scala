package ru.numerals

import ru.numerals.Numerals._
import io.Source
import java.io.{FileNotFoundException, BufferedWriter, FileWriter, File}

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {
  import Gender._

  private val RUB_GENDER = 1
  private val RUB_ONE = 2
  private val RUB_TWO = 3
  private val RUB_MANY = 4
  private val KOP_GENDER = 5
  private val KOP_ONE = 6
  private val KOP_TWO = 7
  private val KOP_MANY = 8


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

    val cur = getCurrency(currency)

    val r = x / 100
    val k = x % 100
    val rubNum = num2Str (r, Gender.withName(cur(RUB_GENDER)))
    val kopNum = num2Str (k, Gender.withName(cur(KOP_GENDER)))
    val rub = (r % 100).toInt match {
      case a if (10 < a && 20 > a) => cur (RUB_MANY)
      case a => a % 10 match {
        case 1 => cur (RUB_ONE)
        case y if Set (2, 3, 4) contains y => cur (RUB_TWO)
        case _ => cur (RUB_MANY)
      }
    }
    val kop = (k % 100).toInt match {
      case a if (10 < a && 20 > a) => cur (KOP_MANY)
      case a => a % 10 match {
        case 1 => cur (KOP_ONE)
        case y if Set (2, 3, 4) contains y => cur (KOP_TWO)
        case _ => cur (KOP_MANY)
      }
    }
    "%s %s %s %s" format(rubNum, rub, kopNum, kop)
  }


  private def getCurrency (cur : String) = {
    val currency = getResources.filter(cur == _.head)

    if (currency.isEmpty)
      throw new RuntimeException ("No such currency - %s!" format cur)
    if (1 != currency.length)
      throw new RuntimeException ("Currency %s defined %d times in money file!".
        format (cur,currency.length))

    currency.head
  }


  private def getResources = {
   val r = try {
     Source.fromFile("money.txt").getLines().toList
      .filter(!_.startsWith("//")).map(_.split(":").toList)
    } catch {
      case e : FileNotFoundException => {
        createDefaultMoneyFile()
        Source.fromFile("money.txt").getLines().toList
          .filter(!_.startsWith("//")).map(_.split(":").toList)
      }
    }

    if (r.isEmpty)
      throw new RuntimeException ("No currency in money file!")

    val wrongLines = r.filter(9 != _.length)
    if (!wrongLines.isEmpty)
      throw new RuntimeException (
        "Wrong money file! Chech lines %s".format (wrongLines))

    r
  }


  private def createDefaultMoneyFile () {
    try{
      val fileStream = new FileWriter("money.txt")

      fileStream.write(
        "// Lines started with // will be ignored\n" +
          "//\n" +
          "// валюта:род:один:два:много:род:один:два:много\n" +
          "// род может быть Masculine, Feminine, Neuter" +
          "//\nRUR:Masculine:рубль:рубля:рублей:Feminine:копейка:копейки:копеек\n" +
          "USD:Masculine:доллар:доллара:долларов:Masculine:цент:цента:центов")

      fileStream.close()

    }catch  {
      //TODO: Exception handling
      case e : Exception => System.err.println("Error: " + e.getMessage)
    }
  }
}
