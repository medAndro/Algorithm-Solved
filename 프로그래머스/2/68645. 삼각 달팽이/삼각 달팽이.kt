class Solution {
    fun solution(n: Int): IntArray {
        
        val endNum = (1..n).toList().sum()
        
        var l = List(n){mutableListOf<Int>()}
        var r = List(n){mutableListOf<Int>()}

        var nn = n
        var index = 0
        var type = "좌빗면"
        var counter = 0
        while(nn != 0){
           for (i in 0 until nn){
               counter++
               when{
                    type == "좌빗면" -> {
                        l[index].add(counter)
                        index++
                    }
                    type == "하단" -> {
                        l[index].add(counter)
                    }
                    type == "우빗면" -> {
                        r[index].add(0, counter)
                        index--
                    }
                 }
            }
            when{
                type == "좌빗면" -> {
                    type = "하단"
                    index--
                }
                type == "하단" ->{
                     type = "우빗면"
                    index--
                }
                type == "우빗면" -> {
                    type = "좌빗면"
                    index++
                    index++
                }
            }
            nn--
        }

        val triangle = l.mapIndexed{index, v->
            v + r[index]
        }
        
        return triangle.flatten().toIntArray()
    }
}