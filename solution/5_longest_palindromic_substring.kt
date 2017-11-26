class Solution {
    fun longestPalindrome(s: String): String {
        val newStr = CharArray(2 * s.length - 1 + 2) {'#'}
        val lenArray = IntArray(newStr.size) {1}
        var newIdx: Int
        var offset: Int
        var leftIdx: Int
        var rightIdx: Int
        var maxLen = 1
        var maxIdx = 0
        val startIdx: Int

        for (i in s.indices) {
            newIdx = 2 * i + 1
            newStr[newIdx] = s[i]
        }

        for (i in newStr.indices) {
            offset = 1
            leftIdx = i - offset
            rightIdx = i + offset
            while (leftIdx >= 0 && rightIdx <= newStr.lastIndex) {
                if (newStr[leftIdx] == newStr[rightIdx]) {
                    offset++
                    leftIdx = i - offset
                    rightIdx = i + offset
                } else {
                    break
                }
            }

            lenArray[i] = offset - 1
        }

        for (i in lenArray.indices) {
            if (lenArray[i] > maxLen) {
                maxLen = lenArray[i]
                maxIdx = i
            }
        }

        startIdx = (maxIdx-1)/2 - (maxLen-1)/2

        return s.substring(startIdx until startIdx+maxLen)
    }
}

fun main(args: Array<String>) {
    val inputStr = "babad" // "cbbd"
    val resultStr: String
    val sol = Solution()

    resultStr = sol.longestPalindrome(inputStr)

    println(resultStr)
}
