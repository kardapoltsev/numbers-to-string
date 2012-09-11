import ru.numerals.Numerals._
import ru.numerals.Money._

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {


    val bi = BigInt("1000201")
    println(bi,num2Str(bi))

    println(ruMoney(bi))

  }

}
