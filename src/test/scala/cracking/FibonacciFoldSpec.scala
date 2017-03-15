package cracking

import org.scalatest.{FunSuite, Matchers}

class FibonacciFoldSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    FibonacciFold.calculate(3) should be (2)
  }

  test("simple scenario 2") {
    FibonacciFold.calculate(10) should be (55)
  }

  test("simple scenario 3") {
    FibonacciFold.calculate(45) should be (1134903170)
  }
}
