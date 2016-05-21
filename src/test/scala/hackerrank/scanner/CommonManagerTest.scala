package hackerrank.scanner

import java.io.ByteArrayInputStream

import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable

class CommonManagerTest extends FunSuite with Matchers {

  test("Sample scenario") {

    val actualInput = List(
      "6",
      "Hilary",
      "James",
      "Sarah Fred",
      "Sarah Paul",
      "Fred Hilary",
      "Fred Jenny",
      "Jenny James"
    )

    val expectedOutput = List(
      "Fred"
    )

    assertResults(actualInput, expectedOutput)
  }

  test("Simple scenario") {

    val actualInput = List(
      "3",
      "Hilary",
      "James",
      "Sarah Hilary",
      "Sarah James"
    )

    val expectedOutput = List(
      "Sarah"
    )

    assertResults(actualInput, expectedOutput)
  }

  private def assertResults(actualInput: List[String], expectedOutput: List[String]): Unit = {
    val is = new ByteArrayInputStream(actualInput.mkString("\n").getBytes)
    val os = new java.io.ByteArrayOutputStream()

    Console.withIn(is) {
      Console.withOut(os) {
        CommonManagerTest.main(Array.empty[String])
      }
    }

    expectedOutput.mkString("\n") shouldEqual os.toString.dropRight(1)
  }
}

private object CommonManagerTest {

  case class Employee(name: String, reporters: Set[Employee] = Set.empty[Employee])

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(Console.in)

    sc.nextLine() // skip count
    val first = sc.nextLine()
    val second = sc.nextLine()

    val lines = mutable.ListBuffer.empty[String]

    while (sc.hasNextLine)
      lines.append(sc.nextLine())

    val root: Set[Employee] = add(lines)

    val ff = findManagers(root, first)
    val ss = findManagers(root, second)
    val result = ff.intersect(ss).head

    println(result)
  }

  private def add(lines: Seq[String]): Set[Employee] = {
    lines.foldLeft(Set.empty[Employee]) { case (tree, line) =>
      val names = line.split(" ", 2) // get a pair of names
      update(tree, names(0), names(1))
    }
  }

  private def update(root: Set[Employee], manager: String, resource: String): Set[Employee] = {
    root match {
      case s if s.isEmpty => Set(Employee(manager, Set(Employee(resource))))
      case s => append(s, manager, resource)
    }
  }

  private def append(root: Set[Employee], manager: String, resource: String): Set[Employee] = {
    root map {
      case person if person.name == manager =>
        Employee(person.name, person.reporters + Employee(resource))
      case person =>
        Employee(person.name, append(person.reporters, manager, resource))
    }
  }
  private def findManagers(employees: Set[Employee], name: String): Seq[String] = {

    employees.foldLeft(Seq.empty[String]) {
      case (acc, e) if e.reporters.exists(_.name == name) =>
        Seq(e.name) ++ acc
      case (acc, e) =>
        findManagers(e.reporters, name) match {
          case Nil => acc
          case s => s ++ Seq(e.name) ++ acc
        }
    }
  }
}