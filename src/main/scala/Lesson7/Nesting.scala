package Lesson7

object Nesting {
  def solution(s: String): Int = {
    val stack = scala.collection.mutable.Stack[Char]()
    s.foreach{ chr =>
      if(stack.isEmpty) stack.push(chr)
      else if(stack.head == '(' && chr == ')') stack.pop
      else stack.push(chr)
    }
    if(stack.isEmpty) 1 else 0
  }
}
// https://app.codility.com/demo/results/trainingAP9WFE-JP3/
