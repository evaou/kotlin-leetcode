class Solution {
    fun reverse(x: Int): Int {
        val str = "$x"
        var outStr = ""
        var startIdx = 0
        val endIdx = str.length - 1
        val outInt: Int
        val outLong: Long

        if (x < 0) {
            outStr += str[0]
            startIdx = 1
        }

        for (i in endIdx downTo startIdx) {
            outStr += str[i]
        }

        outLong = outStr.toLong()

        if (outLong > Int.MAX_VALUE || outLong < Int.MIN_VALUE) {
            outInt = 0
        } else {
            outInt = outStr.toInt()
        }

        return outInt
    }
}

fun main(args: Array<String>) {
    val input = -2147483648 // 1534236469, 9646324351, 123, -123, 120
    val output: Int
    val sol = Solution()

    println(Int.MIN_VALUE)
    output = sol.reverse(input)

    println(output)
}
