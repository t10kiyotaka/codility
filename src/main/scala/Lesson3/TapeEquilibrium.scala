package Lesson3

object TapeEquilibrium {
  def solution(a: Array[Int]): Int = {
    val aLength = a.length
    val sumArr = Array.fill(aLength + 1)(0)
    for(i <- 1 to aLength) {
      sumArr(i) = sumArr(i-1) + a(i-1)
    }

    val diffArr = Array.fill(aLength)(0)
    for(i <- 1 until aLength) {
      diffArr(i) = { sumArr(i) - (sumArr.last - sumArr(i)) }.abs
    }
    diffArr.tail.min
  }
}

// https://app.codility.com/demo/results/trainingGYER8V-966/
