

//6-1

//object Distinct {
//  def solution(a: Array[Int]): Int = {
//    a.distinct.length
//  }
//}




// 2-1
//object OddOccurrencesInArray {
////  def solution(a: Array[Int]) = {
////    val empMap: Map[Int, Boolean] = Map()
////    val groupMap = a.foldLeft(empMap){ (stock, num) =>
////      stock.contains(num) match {
////        case true => stock - num
////        case false => stock + (num -> true)
////      }
////    }
////    groupMap.keys.head
////  }
//  def solution(a: Array[Int]): Int = {
//    a.foldLeft(Set[Int]()){ (stock, num) =>
//      stock.contains(num) match {
//        case true => stock - num
//        case false => stock + num
//      }
//    }.head
//  }
//}


//val arr = Array(9,3,9,7,7,7,3)
//OddOccurrencesInArray.solution(arr)
//
//val m = Map[Int, Boolean]()
//val m2 = m + (1 -> true, 2 -> false)
//m2 - 2


//val m: Map[Int, Int] = Map()
//m ++ Map(1 -> 2)
//val arr = Array(1,2,3,4,2,3)
//
//arr.foldLeft(m)((a,b) =>
//  a.contains(b) match {
//    case true => a ++ Map(b -> (a(b) + 1))
//    case false => a ++ Map(b -> 1)
//  }
//)





//// 1-1
//object Solution1_1 {
//  def solution1_1(n: Int): Int = {
//    val binary = n.toBinaryString.reverse
//    val arr = binary.split("1")
//    val adjustedArr = if (binary.head.toString == "0") arr.tail else arr
//    if (adjustedArr.nonEmpty) adjustedArr.map(_.size).max
//    else 0
//  }
//}
//def toBinary(n: Int) = n.toBinaryString
//
//val x = 2147483647
//toBinary(x)
//
//Solution1_1.solution1_1(x)