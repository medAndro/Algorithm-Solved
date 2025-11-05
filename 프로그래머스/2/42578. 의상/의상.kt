class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = clothes.groupBy{it[1]}.mapValues{ (type, item) -> item.size+1 }.values.fold(1){ 
        acc, count ->
        acc* count}-1
    
        return answer
    }
}