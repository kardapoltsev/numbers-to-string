import ru.numerals.Form
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
    println (1, convert(BigInt(1),Masculine,Num))
    println (1, convert(BigInt(1),Masculine,Adjective))
    println (121, convert(BigInt(121),Masculine,Adjective))
    println (113, convert(BigInt(113),Masculine,Adjective))
    println (113123, convert(BigInt(113123),Masculine,Adjective))
  }
}
