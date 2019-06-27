package Lesson3

object TapeEquilibrium {
  def solution(a: Array[Int]): Int = {
    val sumArr = Array.fill(a.length + 1)(0)
    for(i <- 1 to a.length) {
      sumArr(i) = sumArr(i-1) + a(i-1)
    }

    val diffArr = Array.fill(a.length)(0)
    for(i <- 1 until a.length) {
      diffArr(i) = (sumArr(i) - (sumArr.last - sumArr(i))).abs
    }
    diffArr.tail.min
  }
}
