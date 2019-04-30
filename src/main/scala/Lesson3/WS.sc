def solution(x: Int, y: Int, d: Int): Int = {
  if (y - x <= 0) 0
  else Math.ceil((y - x) / d.toDouble).toInt
}

val x = 10
val y = 85
val d = 30

solution(x,y,d)

Math.ceil((y - x) / d)
Math.floor((y - x) / d)
Math.round((y - x) / d)
Math.ceil((y - x) / d.toDouble)