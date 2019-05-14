package Lesson6

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

// https://app.codility.com/demo/results/trainingSWUC2Z-3S7/

