package Lesson5

object PassingCars {
  def solution(a: Array[Int]): Int = {
    var sumArr = Array.fill(a.length + 1)(0)
    for (i <- 0 until a.length){
      if (a(i) == 1) sumArr(i+1) = sumArr(i)
      else sumArr(i+1) = sumArr(i) + 1
    }
    val ans: Long = a.zipWithIndex.foldLeft(0L){ (acc, numAndIdx) =>
      if (numAndIdx._1 == 0) acc
      else acc + sumArr(numAndIdx._2)
    }
    if (ans > 1000000000) -1 else ans.toInt
  }
}

// https://app.codility.com/demo/results/trainingZAJ24V-RF5/
