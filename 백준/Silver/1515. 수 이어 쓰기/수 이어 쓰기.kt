fun main() {
    val removedNums = readln()
    var searchIndex = 0
    var num = 0

    while (searchIndex < removedNums.length) {
        num++
        val currentNum = num.toString()

        var i = 0  // current_num의 인덱스
        while (i < currentNum.length && searchIndex < removedNums.length) {
            if (currentNum[i] == removedNums[searchIndex]) {
                searchIndex++
            }
            i++
        }
    }

    println(num)
}