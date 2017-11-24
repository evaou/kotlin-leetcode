class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val hashTable = HashMap<Char, Int>()
        var startIdx = 0
        var maxLen = 0
        var char: Char
        var tmpLen: Int

        for (i in s.indices) {
            char = s[i]

            if (!hashTable.containsKey(char)) {
                hashTable.put(char, i)
            } else {
                tmpLen = i - startIdx
                maxLen = Math.max(maxLen, tmpLen)
                startIdx = Math.max(startIdx, hashTable.getValue(char) + 1)
                hashTable[char] = i
            }
        }

        tmpLen = s.length - startIdx
        maxLen = Math.max(maxLen, tmpLen)

        return maxLen
    }
}

fun main(args: Array<String>) {
    val inputStr = "abba" //"aab" //"au" //"" //""c" //"pwwkew" //"bbbbb" //"abcabcbb"
    val resultLen: Int
    val sol = Solution()

    resultLen = sol.lengthOfLongestSubstring(inputStr)

    println(resultLen)
}
