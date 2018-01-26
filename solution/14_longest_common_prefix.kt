/*

strPrefix = ""
strPrefixLen = -1

if (strs.size < 0)
    return strPrefix

for each str
    if first str
        strPrefixLen = str.length
    else if strPrefixLen > str.length
        strPrefixLen = str.length

if strPrefixLen == 0
    return strPrefix

index = 0
isEqual = true
while (index <= strPrefixLen)
    tmpChar = ""

    for i = 0 until strs.size
        if i==0
            tmpChar = strs[i][index]
        else if tmpChar != strs[i][index]
            isEqual = false
            break

    if !isEqual
        break

    strPrefix += tmpChar
    index++

return strPrefix

*/

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var strPrefix = ""
        var strPrefixLen = -1
        var tmpStr: String
        var isEqual = true
        var index = 0

        if (strs.size < 0) {
            return strPrefix
        }

        strs.map {
            if (strPrefixLen == -1) {
                strPrefixLen = it.length
            } else if (strPrefixLen > it.length) {
                strPrefixLen = it.length
            }
        }

        if (strPrefixLen == 0) {
            return strPrefix
        }

        while (index < strPrefixLen) {
            tmpStr = ""
            for (i in 0 until strs.size) {
                if (i == 0) {
                    tmpStr = strs[i][index].toString()
                } else if (tmpStr != strs[i][index].toString()) {
                    isEqual = false
                    break
                }
            }

            if (!isEqual) {
                break
            }

            strPrefix += tmpStr
            index++
        }

        return strPrefix
    }
}

fun main(args: Array<String>) {
    val strArray: Array<String> = arrayOf("", "b") //arrayOf(), arrayOf(""), arrayOf("ab", "abcbcd", "abcd")
    val sol = Solution()

    println(sol.longestCommonPrefix(strArray))
}