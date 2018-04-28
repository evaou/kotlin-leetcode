class Solution {
    fun canWinNim(n: Int): Boolean {
        val result: Boolean

        if (n == 0) {
            result = false
        } else {
            result = (n % 4) != 0
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 4
    val result: Boolean

    result = sol.canWinNim(n)
    println(result)
}



