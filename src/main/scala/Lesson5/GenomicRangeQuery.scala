package Lesson5

object GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {

    // Make Accumulated Array: which counts the number of A,C,G,T
    val defaultMap = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)
    val sumArr: Array[Map[Char, Int]] = Array.fill(s.length)(defaultMap)
    for((char, i) <- s.zipWithIndex) {
      if(i == 0) sumArr(i) = sumArr(i).updated(char, sumArr(i)(char) + 1)
      else sumArr(i) = sumArr(i-1).updated(char, sumArr(i-1)(char) + 1)
    }


    val ans = for(i <- 0 until p.length) yield {
      val start = p(i)
      val end = q(i)
      "ACGT".map { char =>
        val offset = if(start > 0) sumArr(start - 1)(char) else 0
        sumArr(end)(char) - offset
      }.indexWhere(_ > 0) + 1
    }
    ans.toArray
  }
}

// https://app.codility.com/demo/results/trainingHXFDC6-W49/
