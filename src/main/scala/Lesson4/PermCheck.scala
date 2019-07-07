package Lesson4

object PermCheck {

  def solution(a: Array[Int]): Int = {
    val actualSize = a.toSet.size
    val expectedSize = (1 to Math.max(a.length, a.max)).size
    if(actualSize == expectedSize) 1 else 0
  }

  @deprecated
  def solution_old(a: Array[Int]): Int = {
    val arr = a.sorted.toSeq
    val permutationArr = 1 to a.size
    arr.equals(permutationArr) match {
      case true => 1
      case false => 0
    }
  }
}

// https://app.codility.com/demo/results/trainingUGNAGH-W76/


