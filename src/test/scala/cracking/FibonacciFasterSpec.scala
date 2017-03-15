package cracking

import org.scalatest.{FunSuite, Matchers}

class FibonacciFasterSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    FibonacciFaster.calculate(3) should be (2)
  }

  test("simple scenario 2") {
    FibonacciFaster.calculate(10) should be (55)
  }

  test("simple scenario 3") {
    FibonacciFaster.calculate(45) should be (1134903170)
  }
}
