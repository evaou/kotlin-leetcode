class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        // only one 1 bit
        /*
        var num = n
        var count = 0

        while (num > 0) {
            if (num and 1 == 1) {
                count++
            }
            num = num.shr(1)
        }

        return (count == 1)
        */

        return (n > 0) and (n and (n-1) == 0)
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 218
    val result: Boolean

    result = sol.isPowerOfTwo(n)
    println(result)
}

