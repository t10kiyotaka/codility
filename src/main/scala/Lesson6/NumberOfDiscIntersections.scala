package Lesson6

object NumberOfDiscIntersections {
  def solution(a: Array[Int]): Int = {
    val pointAndIsBeginArr: Seq[(Long, Boolean)] = {
      for(i <- 0 until a.length)
        yield Seq((i.toLong - a(i), true), (i.toLong + a(i), false))
    }.flatten

    val sorted = pointAndIsBeginArr.sortBy {
      case (point, bool) => (point, !bool)
    }

    var cnt, activeCircles = 0
    for((_, isBegin) <- sorted) {
      if(isBegin) {
        cnt += activeCircles
        activeCircles += 1
      } else {
        activeCircles -= 1
      }
      if(cnt > 10E6) return -1
    }
    cnt
  }
}

// https://app.codility.com/demo/results/trainingC2D7RG-SRP/
