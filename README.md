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
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if(k == 0 || a.isEmpty) return a
    val cycleTimes = k % a.length
    a.takeRight(cycleTimes) ++ a.dropRight(cycleTimes)
  }
}
```
[Result page](https://app.codility.com/demo/results/training92BN98-XV9/)


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

## 3-3
```scala
object TapeEquilibrium {
  def solution(a: Array[Int]): Int = {
    val aLength = a.length
    val sumArr = Array.fill(aLength + 1)(0)
    for(i <- 1 to aLength) {
      sumArr(i) = sumArr(i-1) + a(i-1)
    }

    val diffArr = Array.fill(aLength)(0)
    for(i <- 1 until aLength) {
      diffArr(i) = { sumArr(i) - (sumArr.last - sumArr(i)) }.abs
    }
    diffArr.tail.min
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingGYER8V-966/)


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
    val actualSize = a.toSet.size
    val expectedSize = (1 to Math.max(a.length, a.max)).size
    if(actualSize == expectedSize) 1 else 0
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingUGNAGH-W76/)


## 4-3
```scala
object MaxCounters {
  def solution(n: Int, a: Array[Int]): Array[Int] = {
    val arr = Array.fill(n)(0)
    var currentMax = 0
    var fill = 0

    for(i <- 0 until a.length) {
      if(a(i) == n+1) fill = currentMax
      else {
        val index = a(i)-1
        arr.update(index, Math.max(arr(index) + 1, fill + 1))
        currentMax = Math.max(currentMax, arr(index))
      }
    }

    arr.map(i => Math.max(fill, i))
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingT6C8R9-HCW/)


## 4-4
```scala
object MissingInteger {
  def solution(a: Array[Int]): Int = {
    var ans = 0
    val sortedArr = a.sorted

    if(a.length == 1) {
      if(a.head != 1) ans = 1 else ans = a.head + 1
      return ans
    }
    if(sortedArr.last < 1 || sortedArr.head > 1) return 1

    for(i <- 1 until a.length) {
      if(sortedArr(i-1) >= 0) {
        if (sortedArr(i) > sortedArr(i-1) + 1) {
          return sortedArr(i-1) + 1
        }
      } else if (sortedArr(i) > 1) return 1
    }
    if(ans == 0) sortedArr.last + 1 else ans
  }
}
```
[Result page](https://app.codility.com/demo/results/training9UHXSE-HGZ/)



## 5-1
```scala
object PassingCars {
  def solution(a: Array[Int]): Int = {
    val sumArr = Array.fill(a.length + 1)(0)
    for (i <- 0 until a.length){
      if (a(i) == 1) sumArr(i+1) = sumArr(i)
      else sumArr(i+1) = sumArr(i) + 1
    }
    val ans: Long = a.zipWithIndex.foldLeft(0L){ case (acc, (num, index)) =>
      if (num == 0) acc
      else acc + sumArr(index)
    }
    if (ans > 1000000000) -1 else ans.toInt
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingZAJ24V-RF5/)

## 5-2
```scala
object GenomicRangeQuery {
  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {

    // Make Accumulated Array: which counts the number of A,C,G,T
    val defaultMap = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)
    val sumArr: Array[Map[Char, Int]] = Array.fill(s.length)(defaultMap)
    for((char, i) <- s.zipWithIndex) {
      if(i == 0) sumArr(i) = sumArr(i).updated(char, sumArr(i)(char) + 1)
      else sumArr(i) = sumArr(i-1).updated(char, sumArr(i-1)(char) + 1)
    }


    val ans = for(i <- 0 until p.length) yield {
      val start = p(i)
      val end = q(i)
      "ACGT".map { char =>
        val offset = if(start > 0) sumArr(start - 1)(char) else 0
        sumArr(end)(char) - offset
      }.indexWhere(_ > 0) + 1
    }
    ans.toArray
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingHXFDC6-W49/)

## 5-3
```scala
object MinAvgTwoSlice {
  def solution(a: Array[Int]): Int = {
    val aLength = a.length
    var index = 0
    var min = Double.MaxValue

    for(i <- 0 until aLength-1) {
      val avgBy2 = (a(i) + a(i+1)) / 2D
      if(avgBy2 < min) {
        min = avgBy2
        index = i
      }

      if(i < aLength - 2) {
        val avgBy3 = (a(i) + a(i+1) + a(i+2)) / 3D
        if(avgBy3 < min) {
          min = avgBy3
          index = i
        }
      }
    }
    index
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingZZ4C3G-QQF/)

## 5-4
```scala
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

```
[Result page](https://app.codility.com/demo/results/trainingWNQPJ6-PU2/)



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

    Math.max(product1, product2)
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingSWUC2Z-3S7/)

## 6-3
```scala
object Triangle {
  def solution(a: Array[Int]): Int = {
    val sortedArr = a.sorted
    var ans = 0
    for(i <- 2 until a.length) {
      if(sortedArr(i-2).toLong + sortedArr(i-1).toLong > sortedArr(i).toLong)
        return 1
    }
    ans
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingVBPRQ6-WFP/)


## 6-4
```scala
// I could not solve by myself. 
object NumberOfDiscIntersections {
  def solution(a: Array[Int]): Int = {
    val pointAndIsBeginArr: Seq[(Long, Boolean)] = {
      for(i <- 0 until a.length)
        yield Seq((i.toLong - a(i), true), (i.toLong + a(i), false))
    }.flatten

    val sorted = pointAndIsBeginArr.sortBy {
      case (point, bool) => (point, !bool)
    }

    var cnt, activeCircles = 0
    for((_, isBegin) <- sorted) {
      if(isBegin) {
        cnt += activeCircles
        activeCircles += 1
      } else {
        activeCircles -= 1
      }
      if(cnt > 10E6) return -1
    }
    cnt
  }
}

```
[Result page](https://app.codility.com/demo/results/trainingC2D7RG-SRP/)


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

## 7-2
```scala
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

```
[Result page](https://app.codility.com/demo/results/trainingTVTNAP-JF3/)

## 7-3
```scala
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
```
[Result page](https://app.codility.com/demo/results/trainingAP9WFE-JP3/)

## 7-4
```scala
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

```
[Result page](https://app.codility.com/demo/results/trainingCRYA4C-2JU/)


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


## 9-2
```scala
object MaxSliceSum {
  def solution(a: Array[Int]): Int = {
    val maxSumAndTmpSum = (a.head, 0)
    a.foldLeft(maxSumAndTmpSum) { case ((maxSum, tmpSum), num) =>
      val tmp = if(tmpSum + num >= 0) Math.max(tmpSum + num, num)
      else num
      val max = Math.max(maxSum, tmp)
      (max, tmp)
    }._1
  }
}
```
[Result page](https://app.codility.com/demo/results/training3EZGE9-QHY/)


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

## 10-2
```scala
object MinPerimeterRectangle {
  def solution(n: Int): Int = {
    def mkDivisors(n: Int, i: Int = 1, acc: Array[(Int, Int)]): Array[(Int, Int)] = {
      if(i * i > n) acc
      else if(i * i == n) mkDivisors(n, i+1, (i, i)   +: acc)
      else if(n % i == 0) mkDivisors(n, i+1, (i, n/i) +: acc)
      else mkDivisors(n, i+1, acc)
    }
    val divisorArr = mkDivisors(n, acc = Array.empty[(Int, Int)])
    val perimeterArr = divisorArr.map { tuple => (tuple._1 + tuple._2) * 2 }
    perimeterArr.min
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingWMZTVS-VZ4/)

## 10-3
```scala
object Peaks {
  def solution(a: Array[Int]): Int = {
    var peakIndexArr: Array[Int] = Array.empty
    val aLenght = a.length
    for(i <- 1 until aLenght -1 ) {
      if(a(i-1) < a(i) && a(i) > a(i+1)) peakIndexArr = i +: peakIndexArr
    }
    val peakCount = peakIndexArr.length

    // Array: each value is 0 or 1.
    // The value is 1 if the index of value is peak. Otherwise 0.
    val peakFlagArr = Array.fill(aLenght)(0)
    peakIndexArr.foreach { i =>
      peakFlagArr(i) = 1
    }

    // Accumulated sum of the peakFlagArr
    val peakFlagSumArr = Array.fill(aLenght)(0)
    for(i <- 0 until aLenght) {
      if(i == 0) peakFlagSumArr(i) = peakFlagArr(i)
      else peakFlagSumArr(i) = peakFlagSumArr(i-1) + peakFlagArr(i)
    }

    val result = 0
    for(i <- peakCount to 1 by -1) {
      if(aLenght % i == 0) {
        val splitNumber = aLenght / i
        var blockNumber = 1
        var invalidBlockCount = 0

        // Check if the all blocks contains a peak
        while(splitNumber * blockNumber <= aLenght) {
          val lastIndexOfBlock = splitNumber * blockNumber - 1
          val offset = if(blockNumber == 1) 0
          else peakFlagSumArr(lastIndexOfBlock - splitNumber)
          if(peakFlagSumArr(lastIndexOfBlock) - offset < 1)
            invalidBlockCount += 1
          blockNumber += 1
        }
        if(invalidBlockCount == 0) return i
      }
    }
    result
  }
}
```
[Result page](https://app.codility.com/demo/results/trainingGFYFJ2-M66/)

