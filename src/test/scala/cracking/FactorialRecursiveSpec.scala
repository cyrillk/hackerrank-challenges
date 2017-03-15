package cracking

import org.scalatest.{FunSuite, Matchers}

class FactorialRecursiveSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    FactorialRecursive.calculate(1) should be (1)
  }

  test("simple scenario 2") {
    FactorialRecursive.calculate(10) should be (3628800)
  }

  test("simple scenario 3") {
    FactorialRecursive.calculate(45) should be (BigInt("119622220865480194561963161495657715064383733760000000000"))
  }
}
