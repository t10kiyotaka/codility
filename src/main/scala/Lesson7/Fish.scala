package Lesson7

import scala.collection.mutable

object Fish {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    val stack: mutable.Stack[(Int, Int)] = mutable.Stack[(Int, Int)]()

    for(i <- 0 until a.length) {
      if(stack.isEmpty || stack.head._2 == 0 || b(i) == 1)
        stack.push((a(i), b(i)))
      else {
        while(stack.nonEmpty && stack.head._2 == 1 && stack.head._1 < a(i)) {
          stack.pop()
        }
        if(stack.nonEmpty && stack.head._2 == 1 && stack.head._1 > a(i)) stack
        else stack.push((a(i), b(i)))
      }
    }
    stack.length
  }
}

// https://app.codility.com/demo/results/trainingTVTNAP-JF3/

