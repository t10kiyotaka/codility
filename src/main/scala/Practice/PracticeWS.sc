// 1-1
object Solution1_1 {
  def solution1_1(n: Int): Int = {
    val binary = n.toBinaryString.reverse
    val arr = binary.split("1")
    val adjustedArr = if (binary.head.toString == "0") arr.tail else arr
    if (adjustedArr.nonEmpty) adjustedArr.map(_.size).max
    else 0
  }
}
def toBinary(n: Int) = n.toBinaryString

val x = 2147483647
toBinary(x)

Solution1_1.solution1_1(x)