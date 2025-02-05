fun main() {
    val removedNums = ArrayDeque(readln().map { it.toString() })

    var num = 0
    while (removedNums.isNotEmpty()) {
        num++
        val compareNums = num.toString()

        if (removedNums[0] in compareNums) {
            val subCompareNums = compareNums.substring(compareNums.indexOf(removedNums[0]))
            for (c in subCompareNums) {
                if (removedNums.isNotEmpty() && c.toString() == removedNums[0]) {
                    removedNums.removeFirst()
                }
            }
        }
    }

    println(num)
}