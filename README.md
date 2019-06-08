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


## 3-2
```scala
object PermMissingElem {
  def solution(a: Array[Int]): Int = {
    val expectedArr: Seq[Int] = (1 to a.length + 1).toList
    val diff: Seq[Int] = expectedArr.diff(a.toList)
    diff.nonEmpty match {
      case true => diff(0)
      case _ => 1
    }
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingXE5VA2-4UK/)


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


## 5-1
```scala
object PassingCars {
  def solution(a: Array[Int]): Int = {
    var sumArr = Array.fill(a.length + 1)(0)
    for (i <- 0 until a.length){
      if (a(i) == 1) sumArr(i+1) = sumArr(i)
      else sumArr(i+1) = sumArr(i) + 1
    }
    val ans: Long = a.zipWithIndex.foldLeft(0L){ (acc, numAndIdx) =>
      if (numAndIdx._1 == 0) acc
      else acc + sumArr(numAndIdx._2)
    }
    if (ans > 1000000000) -1 else ans.toInt
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingZAJ24V-RF5/)

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

## 7-1
```scala
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
```
[Result page](https://app.codility.com/demo/results/training6PMF7W-GVN/)


## 8-1
```scala
object Dominator {
  def solution(a: Array[Int]): Int = {
    val groupMap = a.foldLeft(Map[Int, Int]()){ (stock, num) =>
      stock.get(num) match {
        case None => stock + (num -> 1)
        case _ => stock.updated(num, stock(num) + 1)
      }
    }
    val dominant = groupMap.filter(m => m._2 > a.length / 2)
    if (dominant.nonEmpty) a.indexOf(dominant.keys.head) else -1
  }
}
```
[Result page](https://app.codility.com/demo/results/training8SU4KZ-2Z3/)


## 8-2
```scala
object EquiLeader {
  def solution(a: Array[Int]): Int = {
    // aのDominatorを求める
    val groupMap = a.foldLeft(Map[Int, Int]()){ (stock, num) =>
      stock.get(num) match {
        case None => stock + (num -> 1)
        case _ => stock.updated(num, stock(num) + 1)
      }
    }
    val dominantOpt = groupMap.filter(m => m._2 > a.length / 2)
    if(dominantOpt.isEmpty) return 0
    val dominant = dominantOpt.keys.head
    val dominantCount = dominantOpt.getOrElse(dominant, 0)

    // Dominatorの出現回数を、累積和の配列にする
    val sumArr = Array.fill(a.length)(0)
    for(i <- 0 until a.length){
      if(i == 0 && a(i) == dominant) sumArr(i) = 1
      else if(i == 0 && a(i) != dominant) sumArr(i) = 0
      else if(a(i) == dominant) sumArr(i) = sumArr(i-1) + 1
      else sumArr(i) = sumArr(i-1)
    }

    // 2つの配列でともに条件を満たす場合をカウントする
    def rec(i: Int, acc: Int): Int = {
      val firstArrLength = i + 1
      val secondArrLength = a.length - firstArrLength
      if(i == a.length - 1) acc
      else if(sumArr(i) > firstArrLength / 2
        && dominantCount - sumArr(i) > secondArrLength / 2) rec(i+1, acc+1)
      else rec(i+1, acc)
    }
    rec(0, 0)
  }
}
```
[Result page](https://app.codility.com/demo/results/training4X55GP-HWD/)



## 9-1
```scala
object MaxProfit {
  def solution(a: Array[Int]): Int = {
    val diffArr = Array.fill(a.length -1)(0)
    for(i <- 0 until a.length - 1){
      diffArr(i) = a(i+1) - a(i)
    }
    var tmpSum = 0
    var ret = 0
    diffArr.foreach { i =>
      tmpSum = Math.max(0, tmpSum + i)
      ret = Math.max(ret, tmpSum)
    }
    ret
  }
}
```
[Result page](https://app.codility.com/demo/results/training36VWWN-P7S/)

## 10-1
```scala
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
```
[Result page](https://app.codility.com/demo/results/trainingTB8N3V-D24/)

