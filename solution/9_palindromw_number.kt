class Solution {
    fun isPalindrome(x: Int): Boolean {
        val str = x.toString()
        val strLen = str.length
        val time: Int = strLen/2
        var leftChar: Char
        var rightChar: Char
        var result = true

        for (i in 0 until time) {
            leftChar = str[i]
            rightChar = str[strLen-i-1]
            if (leftChar != rightChar) {
                result = false
                break
            }
        }

        return result
    }
}

fun main(args: Array<String>) {
    val input = 121
    val output: Boolean
    val sol = Solution()

    output = sol.isPalindrome(input)

    println(output)
}
