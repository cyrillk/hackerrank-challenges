package cracking

object FactorialFold {

  def calculate(num: Int): BigInt = {
    (1 to num).map(x => BigInt(x)).foldLeft(BigInt(1))((a, b) => a * b)
  }
}
