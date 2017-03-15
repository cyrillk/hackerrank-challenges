package cracking

import org.scalatest.{FunSuite, Matchers}

class FactorialFoldSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    FactorialFold.calculate(1) should be (1)
  }

  test("simple scenario 2") {
    FactorialFold.calculate(10) should be (3628800)
  }

  test("simple scenario 3") {
    FactorialFold.calculate(45) should be (BigInt("119622220865480194561963161495657715064383733760000000000"))
  }
}
