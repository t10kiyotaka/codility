package Lesson10

object MinPerimeterRectangle {
  def solution(n: Int): Int = {
    def mkDivisors(n: Int, i: Int = 1, acc: Array[(Int, Int)]): Array[(Int, Int)] = {
      if(i * i > n) acc
      else if(i * i == n) mkDivisors(n, i+1, (i, i)   +: acc)
      else if(n % i == 0) mkDivisors(n, i+1, (i, n/i) +: acc)
      else mkDivisors(n, i+1, acc)
    }
    val divisorArr = mkDivisors(n, acc = Array.empty[(Int, Int)])
    val perimeterArr = divisorArr.map { tuple => (tuple._1 + tuple._2) * 2 }
    perimeterArr.min
  }
}

// https://app.codility.com/demo/results/trainingWMZTVS-VZ4/
