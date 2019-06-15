package Lesson9

object  MaxProfit {
  def solution(a: Array[Int]): Int = {
    val diffArr = Array.fill(a.length -1)(0)
    for(i <- 0 until a.length - 1){
      diffArr(i) = a(i+1) - a(i)
    }
    var tmpSum = 0
    var ret = 0
    diffArr.foreach { i =>
      tmpSum = Math.max(0, tmpSum + i)
      ret = Math.max(ret, tmpSum)
    }
    ret
  }
}

// https://app.codility.com/demo/results/training36VWWN-P7S/
