import org.specs2.mutable.Specification

/**
 * User: alexey
 * Date: 5/29/13
 * Time: 12:01 PM
 */
class NumeralsTest extends Specification {
  import ru.numerals.Numerals._
  import ru.numerals.Gender._
  "Numerals" should {
    "Convert small numbers from 1 up to 9" in {
      num2Str(1) shouldEqual("один")
      num2Str(3) shouldEqual("три")
      num2Str(9) shouldEqual("девять")
    }
    "Convert small numbers from 1 up to 9 with differ genders" in {
      num2Str(1, Masculine) shouldEqual("один")
      num2Str(1, Feminine) shouldEqual("одна")
      num2Str(1, Neuter) shouldEqual("одно")

      num2Str(5, Masculine) shouldEqual("пять")
      num2Str(5, Feminine) shouldEqual("пять")
      num2Str(5, Neuter) shouldEqual("пять")
    }
    "Convert Large numbers such as 1001" in {
      num2Str(1001) shouldEqual("одна тысяча один")
      num2Str(3002345) shouldEqual("три миллиона две тысячи триста сорок пять")
    }
  }
}
