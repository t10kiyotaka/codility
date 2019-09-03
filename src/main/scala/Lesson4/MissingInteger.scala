package Lesson4

object MissingInteger {
  def solution(a: Array[Int]): Int = {
    var ans = 0
    val sortedArr = a.sorted

    if(a.length == 1) {
      if(a.head != 1) ans = 1 else ans = a.head + 1
      return ans
    }
    if(sortedArr.last < 1 || sortedArr.head > 1) return 1

    for(i <- 1 until a.length) {
      if(sortedArr(i-1) >= 0) {
        if (sortedArr(i) > sortedArr(i-1) + 1) {
          return sortedArr(i-1) + 1
        }
      } else if (sortedArr(i) > 1) return 1
    }
    if(ans == 0) sortedArr.last + 1 else ans
  }
}

// https://app.codility.com/demo/results/training9UHXSE-HGZ/
