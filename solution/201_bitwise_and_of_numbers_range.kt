class Solution {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var i = 0
        var start = m
        var end = n

        while (start != end) {
            start = start.shr(1)
            end = end.shr(1)
            i++
        }

        return start.shl(i)
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val m = 5
    val n = 7
    val result: Int

    result = sol.rangeBitwiseAnd(m, n)
    println(result)
}

