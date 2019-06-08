package Lesson8

object EquiLeader {
  def solution(a: Array[Int]): Int = {
    // aのDominatorを求める
    val groupMap = a.foldLeft(Map[Int, Int]()){ (stock, num) =>
      stock.get(num) match {
        case None => stock + (num -> 1)
        case _ => stock.updated(num, stock(num) + 1)
      }
    }
    val dominantOpt = groupMap.filter(m => m._2 > a.length / 2)
    if(dominantOpt.isEmpty) return 0
    val dominant = dominantOpt.keys.head
    val dominantCount = dominantOpt.getOrElse(dominant, 0)

    // Dominatorの出現回数を、累積和の配列にする
    val sumArr = Array.fill(a.length)(0)
    for(i <- 0 until a.length){
      if(i == 0 && a(i) == dominant) sumArr(i) = 1
      else if(i == 0 && a(i) != dominant) sumArr(i) = 0
      else if(a(i) == dominant) sumArr(i) = sumArr(i-1) + 1
      else sumArr(i) = sumArr(i-1)
    }

    // 2つの配列でともに条件を満たす場合をカウントする
    def rec(i: Int, acc: Int): Int = {
      val firstArrLength = i + 1
      val secondArrLength = a.length - firstArrLength
      if(i == a.length - 1) acc
      else if(sumArr(i) > firstArrLength / 2
        && dominantCount - sumArr(i) > secondArrLength / 2) rec(i+1, acc+1)
      else rec(i+1, acc)
    }
    rec(0, 0)
  }
}
