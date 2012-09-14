import io.Source
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

    println(ruMoney(BigInt(10013)))
    println(money(BigInt(1000201),"USD"))

  }
}
