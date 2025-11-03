class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = IntArray(commands.size)
        val inputList = array.toList()
        
        for(i in commands.indices){
            val cmd = commands[i]
            val subList = inputList.subList(cmd[0]-1, cmd[1]).sorted()
            answer[i] = subList[cmd[2]-1]
        }
        return answer
    }
}