package Lesson4

object MaxCounters {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val arr = Array.fill(n)(0)
    var currentMax = 0
    var fill = 0

    for(i <- 0 until a.length) {
      if(a(i) == n+1) fill = currentMax
      else {
        val index = a(i)-1
        arr.update(index, Math.max(arr(index) + 1, fill + 1))
        currentMax = Math.max(currentMax, arr(index))
      }
    }

    arr.map(i => Math.max(fill, i))
  }
}

// https://app.codility.com/demo/results/trainingT6C8R9-HCW/
