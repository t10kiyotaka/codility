package Lesson7

object StoneWall {
  def solution(h: Array[Int]): Int = {
    val stack = scala.collection.mutable.Stack[Int]()

    h.foldLeft(0) { (cnt, cur) =>
      if(stack.nonEmpty && stack.head > cur) {
        while (stack.nonEmpty && stack.head > cur) {
          stack.pop()
        }
      }
      if(stack.isEmpty || stack.head < cur) {
        stack.push(cur)
        cnt + 1
      } else {
        cnt
      }
    }

  }
}

// https://app.codility.com/demo/results/trainingCRYA4C-2JU/
