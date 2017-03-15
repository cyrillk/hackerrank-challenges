package cracking

import org.scalatest.{FunSuite, Matchers}

class FibonacciSlowerSpec extends FunSuite with Matchers {

  test("simple scenario 1") {
    FibonacciSlower.calculate(3) should be (2)
  }

  test("simple scenario 2") {
    FibonacciSlower.calculate(10) should be (55)
  }

  test("simple scenario 3") {
    FibonacciSlower.calculate(45) should be (1134903170)
  }
}
