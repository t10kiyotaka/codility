package Lesson3

object Frogjmp {
  def solution(x: Int, y: Int, d: Int): Int = {
    if (y - x <= 0) 0
    else Math.ceil((y - x) / d.toDouble).toInt
  }
}
// https://app.codility.com/demo/results/trainingB4NR9D-V7U/
