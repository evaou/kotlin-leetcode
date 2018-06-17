class Solution {
    fun isPowerOfFour(num: Int): Boolean {
        return (num > 0) && (num and (num-1) == 0) && (num and 0x55555555 != 0)
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 1
    val result: Boolean

    result = sol.isPowerOfFour(n)
    println(result)
}

