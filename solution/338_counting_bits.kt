class Solution {
    fun countBits(num: Int): IntArray {
        val result = IntArray(num+1){0}

        for (i in 1..num) {
            result[i] = result[i/2] + (i and 1)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val num = 5
    val result: IntArray

    result = sol.countBits(num)
    println(result.joinToString())
}

