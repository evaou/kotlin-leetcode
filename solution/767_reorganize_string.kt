/*

charCountMap

go thru each char in string
    update charCountMap

get sortedCharCountMap

index = 0
go thru each char in sortedCharCountMap
    get char and charCount
    if charCount > (charSize+1)/2
        return ""
    go thru charCount
        newCharArray[index] = char
        index += 2
        if index >= charSize
            index = 1

return newCharArray
 */

class Solution {
    fun reorganizeString(S: String): String {
        val charCountMap = HashMap<Char, Int>()
        val sortedCharCountMap: Map<Char, Int>
        var tmpChar: Char
        var tmpCount: Int
        var index = 0
        val resultStr: String
        val resultCharArray = CharArray(S.length)

        for (i in 0 until S.length) {
            tmpChar = S[i]
            if (!charCountMap.containsKey(tmpChar)) {
                charCountMap.put(tmpChar, 1)
            } else {
                charCountMap.set(tmpChar, charCountMap.getValue(tmpChar)+1)
            }
        }

        sortedCharCountMap = charCountMap.toList().sortedByDescending { (_, value) -> value }.toMap()

        for (item in sortedCharCountMap.entries) {
            tmpChar = item.key
            tmpCount = item.value

            if (tmpCount > (S.length+1)/2) {
                return ""
            }

            for (i in 0 until tmpCount) {
                resultCharArray[index] = tmpChar
                index += 2
                if (index >= S.length) {
                    index = 1
                }
            }
        }

        resultStr = resultCharArray.joinToString("")

        return resultStr
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val inputStr = "abbabbaaab" //"cxmwmmm", "sfffp", "aaaab", "baaba", "aaab", "aab"
    val resultStr: String

    resultStr = sol.reorganizeString(inputStr)
    println(resultStr)
}