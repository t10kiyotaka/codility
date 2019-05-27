package Lesson8


object Dominator {
  def solution(a: Array[Int]): Int = {
    val groupMap = a.foldLeft(Map[Int, Int]()){ (stock, num) =>
      stock.get(num) match {
        case None => stock + (num -> 1)
        case _ => stock.updated(num, stock(num) + 1)
      }
    }
    val dominant = groupMap.filter(m => m._2 > a.length / 2)
    if (dominant.nonEmpty) a.indexOf(dominant.keys.head) else -1
  }
}
