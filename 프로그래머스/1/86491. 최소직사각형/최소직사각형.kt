import kotlin.math.*

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        for(i in sizes.indices){
            sizes[i] = sizes[i].sorted().toIntArray()
        }
        
        var maxV = 0
        var maxH = 0
        for(i in sizes.indices){
            maxV = max(sizes[i][0], maxV)
            maxH = max(sizes[i][1], maxH)
        }
        
        return maxV*maxH
    }
}