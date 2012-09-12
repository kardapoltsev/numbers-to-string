import ru.numerals.Gender
import ru.numerals.Numerals._
import ru.numerals.Money._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {

    for (i <- 1000 to 1100) {
      println(ruMoney(i))
    }
//          println(ruMoney(1022))

  }
}
