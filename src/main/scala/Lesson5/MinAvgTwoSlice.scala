package Lesson5

object MinAvgTwoSlice {
  def solution(a: Array[Int]): Int = {
    val aLength = a.length
    var index = 0
    var min = Double.MaxValue

    for(i <- 0 until aLength-1) {
      val avgBy2 = (a(i) + a(i+1)) / 2D
      if(avgBy2 < min) {
        min = avgBy2
        index = i
      }

      if(i < aLength - 2) {
        val avgBy3 = (a(i) + a(i+1) + a(i+2)) / 3D
        if(avgBy3 < min) {
          min = avgBy3
          index = i
        }
      }
    }
    index
  }
}

// https://app.codility.com/demo/results/trainingZZ4C3G-QQF/
