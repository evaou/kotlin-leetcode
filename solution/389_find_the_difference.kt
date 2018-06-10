class Solution {
    fun findTheDifference(s: String, t: String): Char {
        var result = 0

        for (i in s) {
            result = result xor i.toInt()
        }

        for (i in t) {
            result = result xor i.toInt()
        }

        return result.toChar()
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val s = "abcd"
    val t = "abcde"
    val result: Char

    result = sol.findTheDifference(s, t)
    println(result)
}

