/**
 * Created with IntelliJ IDEA.
 * Date: 9/10/12
 * Time: 3:35 PM
 */

object Test {
  def main (args : Array[String]) {
    import ru.numerals.Numerals._

//    println(1,num2String(1))
//    println(-2,num2String(-2))
//    println(-13,num2String(-13))
//    println(-25,num2String(-25))
//    println(125,num2String(125))
//    println(-1253,num2String(-1253))
//    println(-12311545,num2String(-12311545))
//    println(45612311545L,num2String(45612311545L))
//    val bi = BigInt("12345678901234567890")
//    println(bi > 10)
//    println(bi,num2String(bi))
//    println(0,num2String(0))


    assert(num2String(1) == "один","1 => %s".format (num2String(1)))
    assert(num2String(13) == "тринадцать","13")
    assert(num2String(125) == "сто двадцать пять","125 => %s".format (num2String(125)))
    assert(num2String(99945612311545L) ==
      "девяносто девять триллионов девятьсот сорок пять миллиардов шестьсот " +
        "двенадцать миллионов триста одиннадцать тысяч пятьсот сорок пять",
      "99945612311545 => %s".format (num2String(99945612311545L)))

  }

}
