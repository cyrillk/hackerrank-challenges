package codility

import org.scalatest.{FlatSpec, Matchers}
import sample.matchers.SystemInputOutputMatcher

class Codility2Spec extends FlatSpec with Matchers with SystemInputOutputMatcher {

  def solution(A: Array[Int]): Boolean = {

    // counting the number of diffs in original and sorted arrays
    val diffs = (A zip A.sorted).foldLeft(0) {
      case (sum, (left, right)) if left == right => sum
      case (sum, _) => sum + 1
    }

    if (diffs <= 2) true else false
  }

  "Scenario #1" should "pass" in {
    solution(Array(1, 5, 3, 3, 7)) shouldBe (true)
  }

  "Scenario #2" should "pass" in {
    solution(Array(1, 3, 5, 3, 4)) shouldBe (false)
  }

  "Scenario #3" should "pass" in {
    solution(Array(1)) shouldBe (true)
  }
}