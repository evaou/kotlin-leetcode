class Solution {
    fun readBinaryWatch(num: Int): List<String> {
        var result: List<String> = listOf()

        for (h in 0 until 12) {
            for (m in 0 until 60) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                    result += "%d:%02d".format(h, m)
                }
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val num = 1
    val result: List<String>

    result = sol.readBinaryWatch(num)
    println(result)
}

