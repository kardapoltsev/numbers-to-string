/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {
    import ru.numerals.Numerals._

    println(1253,num2Str(1253))
    println(-12311545,num2Str(-12311545))
    val bi = BigInt("512345678901234567890")
    println(bi,num2Str(bi))


    assert(num2Str(1) == "один","1 => %s".format (num2Str(1)))
    assert(num2Str(13) == "тринадцать","13")
    assert(num2Str(125) == "сто двадцать пять","125 => %s".format (num2Str(125)))
    assert(num2Str(99945612311545L) ==
      "девяносто девять триллионов девятьсот сорок пять миллиардов шестьсот " +
        "двенадцать миллионов триста одиннадцать тысяч пятьсот сорок пять",
      "99945612311545 => %s".format (num2Str(99945612311545L)))

  }

}
