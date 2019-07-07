package Lesson2

object CyclicRotation {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if(k == 0 || a.isEmpty) return a
    val cycleTimes = k % a.length
    a.takeRight(cycleTimes) ++ a.dropRight(cycleTimes)
  }

  @deprecated
  def solution_old(a: Array [Int], k: Int): Array[Int] = {
    a.isEmpty match {
      case true => Array()
      case false =>
        if (k == 0)
          a
        else {
          val head = a.reverse.head
          val tail = a.reverse.tail
          solution(head +: tail.reverse, k - 1)
        }
    }
  }
}

// https://app.codility.com/demo/results/training92BN98-XV9/

