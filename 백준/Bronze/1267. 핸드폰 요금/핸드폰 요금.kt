fun main() {
    readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    var Y = 0
    var M = 0
    arr.forEach {
        Y += 10
        M += 15
        Y += (it / 30) * 10
        M += (it / 60) * 15

    }
    when {
        Y == M -> print("Y M $Y")
        Y > M -> print("M $M")
        else -> print("Y $Y")
    }
}