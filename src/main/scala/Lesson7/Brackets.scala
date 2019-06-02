package Lesson7

object Brackets {
  def solution(s: String): Int = {
    val bracketsMap = Map(")" -> "(", "}" -> "{", "]" -> "[")
    val stack: Array[String] = Array.fill(s.length)("")
    var index = 0
    s.foreach{ str =>
      str.toString.matches("(\\(|\\[|\\{)") match {
        case true => stack(index) = str.toString; index += 1
        case false => {
          if (index == 0) return 0
          else if (stack(index-1) == bracketsMap(str.toString)) index -= 1
          else return 0
        }
      }
    }
    if (index == 0) 1 else 0
  }
}

// https://app.codility.com/demo/results/training6PMF7W-GVN/
