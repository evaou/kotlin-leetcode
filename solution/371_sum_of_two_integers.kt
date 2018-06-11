class Solution {
    fun getSum(a: Int, b: Int): Int {
        val result = a xor b
        val carry = (a and b).shl(1)

        if (carry != 0) {
            return getSum(result, carry)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val a = 2
    val b = 2
    val result: Int

    result = sol.getSum(a, b)
    println(result)
}

