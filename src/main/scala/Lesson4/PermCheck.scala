package Lesson4

object PermCheck {
  def solution(a: Array[Int]): Int = {
    val arr = a.sorted.toSeq
    val permutationArr = 1 to a.size
    arr.equals(permutationArr) match {
      case true => 1
      case false => 0
    }
  }
}

// https://app.codility.com/demo/results/trainingXC2SA2-9VY/


