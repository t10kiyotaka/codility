package Lesson9

object MaxSliceSum {
  def solution(a: Array[Int]): Int = {
    val maxSumAndTmpSum = (a.head, 0)
    a.foldLeft(maxSumAndTmpSum) { case ((maxSum, tmpSum), num) =>
      val tmp = if(tmpSum + num >= 0) Math.max(tmpSum + num, num)
      else num
      val max = Math.max(maxSum, tmp)
      (max, tmp)
    }._1
  }
}
// https://app.codility.com/demo/results/training3EZGE9-QHY/
