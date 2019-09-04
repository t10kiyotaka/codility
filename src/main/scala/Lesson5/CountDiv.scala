package Lesson5

object CountDiv {
  def solution(a: Int, b: Int, k: Int): Int = {
    // Add 1 in considering of 0 % n == 0
    val countDivA = a / k + 1
    val countDivB = b / k + 1

    // When a % k == 0, exclude the boundary 1.
    val modifiedA = if(a % k == 0) countDivA - 1 else countDivA

    countDivB - modifiedA
  }
}

// https://app.codility.com/demo/results/trainingWNQPJ6-PU2/
