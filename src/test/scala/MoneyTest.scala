import org.specs2.mutable.Specification

/**
 * User: alexey
 * Date: 5/29/13
 * Time: 12:20 PM
 */
class MoneyTest extends Specification {
  import ru.numerals.Money._
  import ru.numerals.Gender._
  "Money should be converted to strings" should {
    "convert RUR money" in {
      ruMoney(10125) shouldEqual("сто один рубль двадцать пять копеек")
      ruMoney(100001) shouldEqual("одна тысяча рублей одна копейка")
    }
  }
}