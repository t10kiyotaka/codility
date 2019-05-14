# Summery

## 1-1
```scala
object BinaryGap {
  def solution(n: Int): Int = {
    val binary = n.toBinaryString.reverse
    val arr = binary.split("1")
    val adjustedArr = if (binary.head.toString == "0") arr.tail else arr
    if (adjustedArr.nonEmpty) adjustedArr.map(_.size).max
    else 0
  }
}
```
[Result page](https://app.codility.com/demo/results/training2928W4-JJK/)

## 2-1
```scala
object CyclicRotation {
  def solution(a: Array [Int], k: Int): Array[Int] = {
    a.isEmpty match {
      case true => Array()
      case false =>
        if (k == 0)
          a
        else {
          val head = a.reverse.head
          val tail = a.reverse.tail
          solution(head +: tail.reverse, k - 1)
        }
    }
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingH2ESKE-JEN/)

## 2-2
```scala
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
```
[Result page](https://app.codility.com/demo/results/trainingCEAU63-TV5/)


## 3-1
```scala
object Frogjmp {
  def solution(x: Int, y: Int, d: Int): Int = {
    if (y - x <= 0) 0
    else Math.ceil((y - x) / d.toDouble).toInt
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingB4NR9D-V7U/)

## 4-1
```scala
object FrogRiverOne {
  def solution(x: Int, a: Array[Int]): Int = {
    val goalSet = (1 to x).toSet
    def lec(set: Set[Int], acc: Int): Int = {
      if (set == goalSet) acc - 1
      else if (acc == a.size) -1
      else lec(set + a(acc), acc + 1)
    }
    lec(Set(), 0)
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingX2C8SS-TQG/)

## 4-2
```scala
object PermCheck {
  def solution(a: Array[Int]): Int = {
    val arr = a.sorted.toSeq
    val permutationArr = 1 to a.size
    arr.equals(permutationArr) match {
      case true => 1
      case false => 0
    }
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingXC2SA2-9VY/)

## 6-1
```scala
object Distinct {
  def solution(a: Array[Int]): Int = {
    a.distinct.length
  }
}
```
[Result page](https://app.codility.com/demo/results/training6QYMAV-XFR/)

## 6-2
```scala
object MaxProductOfThree {
  def solution(a: Array[Int]): Int = {
    val sortedArr = a.sorted
    val arraySize = sortedArr.size

    // 配列の最後尾から3つの要素の積
    val i1 = sortedArr(arraySize - 1)
    val i2 = sortedArr(arraySize - 2)
    val i3 = sortedArr(arraySize - 3)
    val product1 = Seq(i1, i2, i3).product

    // 配列の最後尾1要素と最初の2要素の積
    val j1 = sortedArr(0)
    val j2 = sortedArr(1)
    val product2 = Seq(i1, j1, j2).product

    if (product1 > product2) product1 else product2
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingSWUC2Z-3S7/)