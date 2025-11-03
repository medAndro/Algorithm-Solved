class Solution {
    fun solution(numbers: IntArray): String {
        var answer = numbers.map{it.toString()}.sortedWith{a, b -> 
        -("$a$b".compareTo("$b$a"))
        }.joinToString("")
        return if (answer[0] == '0') "0" else answer
    }
}