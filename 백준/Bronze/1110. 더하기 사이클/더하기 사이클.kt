fun main() {
    val originNum = readln().toInt()
    var targetNum = originNum.toInt()
    var count = 0
    while (true) {
        val nums = numToNums(targetNum)
        val newNums = "${nums[1]}${numToNums(nums.sum())[1]}".toInt()
        count++
        if (originNum == newNums) {
            println(count)
            return
        }
        targetNum = newNums
    }
}

fun numToNums(num: Int): List<Int> = "%02d".format(num).run { listOf(this[0], this[1]) }.map { it.toString().toInt() }
