package codility

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

import scala.collection.mutable
import scala.util.Random

class Codility1Spec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  def solution(A: Array[Int]): Int = {

    var result = 0

    import scala.collection.mutable

    // naive memoization
    val cacheLeft = mutable.HashSet.empty[Int]
    val cacheRight = mutable.HashSet.empty[Int]

    // left side loop
    for (q <- 1 until A.length) {
      val a = A(q)

      if (!cacheLeft.contains(a)) {

        // right side loop
        for (p <- q + 2 until A.length - 1) {
          val b = A(p)

          if (!cacheRight.contains(b)) {
            if (result == 0 || a + b < result) result = a + b
          } else {
            cacheRight += b
          }
        }
      } else {
        cacheLeft += a
      }

      cacheRight.clear()
    }

    result
  }

  "Scenario #1" should "pass" in {
    solution(Array(5, 2, 4, 6, 3, 7)) shouldBe 5
  }

  "Scenario #2" should "pass" in {
    solution((1 until 10000).map(_ => Random.nextInt(1000)).toArray) shouldNot be(0)
  }
}