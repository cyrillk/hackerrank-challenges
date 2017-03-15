package cracking

import org.scalatest.{FunSuite, Matchers}

class CommonDivisorSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    CommonDivisor.calculate(18, 35) should be (1)
  }

  test("simple scenario 2") {
    CommonDivisor.calculate(28851538, 1183019) should be (17657)
  }

  test("simple scenario 3") {
    CommonDivisor.calculate(9, 12) should be (3)
  }

  test("simple scenario 4") {
    CommonDivisor.calculate(12, 9) should be (3)
  }
}
