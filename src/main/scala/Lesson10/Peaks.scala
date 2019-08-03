package Lesson10

object Peaks {
  def solution(a: Array[Int]): Int = {
    var peakIndexArr: Array[Int] = Array.empty
    val aLenght = a.length
    for(i <- 1 until aLenght -1 ) {
      if(a(i-1) < a(i) && a(i) > a(i+1)) peakIndexArr = i +: peakIndexArr
    }
    val peakCount = peakIndexArr.length

    // Array: each value is 0 or 1.
    // The value is 1 if the index of value is peak. Otherwise 0.
    val peakFlagArr = Array.fill(aLenght)(0)
    peakIndexArr.foreach { i =>
      peakFlagArr(i) = 1
    }

    // Accumulated sum of the peakFlagArr
    val peakFlagSumArr = Array.fill(aLenght)(0)
    for(i <- 0 until aLenght) {
      if(i == 0) peakFlagSumArr(i) = peakFlagArr(i)
      else peakFlagSumArr(i) = peakFlagSumArr(i-1) + peakFlagArr(i)
    }

    val result = 0
    for(i <- peakCount to 1 by -1) {
      if(aLenght % i == 0) {
        val splitNumber = aLenght / i
        var blockNumber = 1
        var invalidBlockCount = 0

        // Check if the all blocks contains a peak
        while(splitNumber * blockNumber <= aLenght) {
          val lastIndexOfBlock = splitNumber * blockNumber - 1
          val offset = if(blockNumber == 1) 0
          else peakFlagSumArr(lastIndexOfBlock - splitNumber)
          if(peakFlagSumArr(lastIndexOfBlock) - offset < 1)
            invalidBlockCount += 1
          blockNumber += 1
        }
        if(invalidBlockCount == 0) return i
      }
    }
    result
  }
}

// https://app.codility.com/demo/results/trainingGFYFJ2-M66/
