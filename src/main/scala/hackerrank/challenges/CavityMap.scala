package hackerrank.challenges

import scala.collection.mutable

/**
  * https://www.hackerrank.com/challenges/cavity-map
  */
object CavityMap {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)
    val count = sc.nextLine().trim.toInt

    val array = mutable.ArrayBuffer.empty[mutable.ArrayBuffer[String]]

    for (_ <- 0 until count) {
      val line = sc.nextLine().trim.toCharArray.map(b => String.valueOf(b - 48))
      array += mutable.ArrayBuffer(line: _*)
    }

    val cavities = mutable.ListBuffer.empty[(Int, Int)]

    for (i <- 1 until count - 1) {
      for (j <- 1 until count - 1) {
        val item = array(i)(j).toInt

        if (array(i - 1)(j).toInt < item && array(i + 1)(j).toInt < item &&
          array(i)(j - 1).toInt < item && array(i)(j + 1).toInt < item) {
          cavities += ((i, j))
        }
      }
    }

    cavities foreach { case (i, j) =>
      array(i).update(j, "X")
    }

    array.foreach(s => println(s.mkString("")))
  }
}
