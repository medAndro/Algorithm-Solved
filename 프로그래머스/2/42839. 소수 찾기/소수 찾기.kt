import kotlin.math.*

class Solution {
    fun solution(numbers: String): Int {
        var answer = 0
        
        val maxNum = numbers.map{
            it.toString()
        }.sortedDescending().joinToString("").toInt()

        val primeNumbers = sieveOfEratosthenes(maxNum).map{it.toString()}

        val numbersCnt = numbers.map{it}.groupingBy{it}.eachCount()
        
        for(i in primeNumbers.indices){
            val primeCnt = primeNumbers[i].groupingBy{it}.eachCount()
            
            var canMake = true
            primeCnt.forEach { (char, count) ->
                if ((numbersCnt[char] ?: 0) < count) {
                    canMake = false
                }
            }
            if(canMake) answer++
            
        }

        return answer
    }
    
    fun sieveOfEratosthenes(limit: Int): List<Int> {
        val isPrime = BooleanArray(limit + 1) { true } // 모든 수를 소수라고 가정
        isPrime[0] = false
        isPrime[1] = false

        for (p in 2..sqrt(limit.toDouble()).toInt()) {
            if (isPrime[p]) {
                // p가 소수이면, p의 배수들은 소수가 아님을 표시
                for (i in p * p..limit step p) {
                    isPrime[i] = false
                }
            }
        }

        val primes = mutableListOf<Int>()
        for (i in 2..limit) {
            if (isPrime[i]) {
                primes.add(i)
            }
        }
        return primes
    }
    
    fun isPrime(n:Int):Boolean {
        if(n<2) return false
        for(i in 2..sqrt(n.toDouble()).toInt()){
            if(n%i == 0) return false
        }
        return true
        
    }

}