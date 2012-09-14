package ru.numerals

import ru.numerals.Numerals._
import io.Source
import java.io.{FileNotFoundException, BufferedWriter, FileWriter, File}
import tools.nsc.io.Path

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 8:47 PM
 */

object Money {
  import Gender._


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
    val rubNum = num2Str (r, Masculine)
    val kopNum = num2Str (k, Feminine)
    val rub = (r % 100).toInt match {
      case a if (10 < a && 20 > a) => cur (3)
      case a => a % 10 match {
        case 1 => cur (1)
        case y if Set (2, 3, 4) contains y => cur (2)
        case _ => cur (3)
      }
    }
    val kop = (k % 100).toInt match {
      case a if (10 < a && 20 > a) => cur (6)
      case a => a % 10 match {
        case 1 => cur (4)
        case y if Set (2, 3, 4) contains y => cur (5)
        case _ => cur (6)
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

    val wrongLines = r.filter(7 != _.length)
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
        "// валюта:один:два:много:один:два:много\n" +
        "//\nRUR:рубль:рубля:рублей:копейка:копейки:копеек\n" +
        "USD:доллар:доллара:долларов:цент:цента:центов")

      fileStream.close()

    }catch  {
      //TODO: Exception handling
      case e : Exception => System.err.println("Error: " + e.getMessage)
    }
  }
}
