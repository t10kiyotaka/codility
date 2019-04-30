package Lesson2

object OddOccurrencesInArray {
  def solution(a: Array[Int]): Int = {
    a.foldLeft(Set[Int]()){ (stock, num) =>
      stock.contains(num) match {
        case true => stock - num
        case false => stock + num
      }
    }.head
  }
}

// https://app.codility.com/demo/results/trainingCEAU63-TV5/
