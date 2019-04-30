package Lesson1

object BinaryGap {
  def solution(n: Int): Int = {
    val binary = n.toBinaryString.reverse
    val arr = binary.split("1")
    val adjustedArr = if (binary.head.toString == "0") arr.tail else arr
    if (adjustedArr.nonEmpty) adjustedArr.map(_.size).max
    else 0
  }
}

// https://app.codility.com/demo/results/training2928W4-JJK/