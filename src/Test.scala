import ru.numerals.Numerals._
import ru.numerals.Money._
import ru.numerals.Fractions._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args: Array[String]) {

    1 to 100 foreach (x => println (num2Str (BigInt (x))))
    10000 to 10100 foreach (x => println (ruMoney (BigInt (x))))
    1 to 100 foreach (x => println (fraction2Str ("%s/%s".format (x - 1, x))))
  }
}
