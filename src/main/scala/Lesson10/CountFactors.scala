package Lesson10

object CountFactors {
  def solution(n: Int): Int = {
    var i: Long = 1
    var cnt = 0
    while(i * i < n) {
      if(n % i == 0) cnt += 2
      i += 1
    }
    if(i * i == n) cnt +=1
    cnt
  }
}

// https://app.codility.com/demo/results/trainingGPJ8B8-MTY/
