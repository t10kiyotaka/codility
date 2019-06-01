package Lesson10

object CountFactors {
  def solution(n: Int): Int = {
    def rec(n: Int, i: Long, acc: Int): Int = {
      if (i * i > n) acc
      else if (n == i * i) acc + 1
      else if (n % i == 0) rec(n, i+1, acc+2)
      else rec(n, i+1, acc)
    }
    rec(n, 1, 0)
  }
}

// https://app.codility.com/demo/results/trainingTB8N3V-D24/
