fun main() {
    readLine()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    var Y = 10 * arr.size
    var M = 15 * arr.size
    arr.forEach {
        Y += (it / 30) * 10
        M += (it / 60) * 15

    }
    when {
        Y == M -> print("Y M $Y")
        Y > M -> print("M $M")
        else -> print("Y $Y")
    }
}