import ru.numerals.Fractions
import ru.numerals.Gender._
import ru.numerals.Form._
import ru.numerals.Part._
import ru.numerals.Numerals._
import ru.numerals.Money._
import ru.numerals.Fractions._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {

//    println (1000215, num2Str(BigInt(1000215)))
//
//    println (10115, ruMoney(10115))

    println("23/457", Fractions.fraction2Str("23/457"))
    println("21/457", Fractions.fraction2Str("21/457"))
  }
}
