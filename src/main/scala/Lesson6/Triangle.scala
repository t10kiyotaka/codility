package Lesson6

object Triangle {
  def solution(a: Array[Int]): Int = {
    val sortedArr = a.sorted
    var ans = 0
    for(i <- 2 until a.length) {
      if(sortedArr(i-2).toLong + sortedArr(i-1).toLong > sortedArr(i).toLong)
        return 1
    }
    ans
  }
}

// https://app.codility.com/demo/results/trainingVBPRQ6-WFP/
