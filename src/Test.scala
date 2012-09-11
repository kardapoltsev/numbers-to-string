import ru.numerals.Gender

/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {
    import ru.numerals.Numerals._

//    println(1253,num2Str(1253))
//    println(-12311545,num2Str(-12311545))
    val bi = BigInt("1000201")
    println(bi,num2Str(bi))

//    println(Gender.Feminine.id)
//    println(Gender.Feminine.toString)

    import ru.numerals.Money._
    println(ruMoney(bi))

  }

}
