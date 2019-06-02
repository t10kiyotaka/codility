package Lesson3

object PermMissingElem {
  def solution(a: Array[Int]): Int = {
    val expectedArr: Seq[Int] = (1 to a.length + 1).toList
    val diff: Seq[Int] = expectedArr.diff(a.toList)
    diff.nonEmpty match {
      case true => diff(0)
      case _ => 1
    }
  }
}

// https://app.codility.com/demo/results/trainingXE5VA2-4UK/
