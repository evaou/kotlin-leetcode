class Solution {
    fun letterCasePermutation(S: String): List<String> {
        val result = ArrayList<String>()

        findStr(S, 0, result)

        return result.toList()
    }

    fun findStr(S: String, index: Int, result: ArrayList<String>) {
        if (index == S.length) {
            result.add(S)
            return
        }

        val tmpS = S.toCharArray()

        findStr(tmpS.joinToString(""), index+1, result)

        if (S[index].isLetter()) {
            if (S[index].isLowerCase()) {
                tmpS[index] = S[index].toUpperCase()
            } else {
                tmpS[index] = S[index].toLowerCase()
            }

            findStr(tmpS.joinToString(""), index+1, result)
        }
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val S = "C" //"12345" //""3z4" //"a1b2"
    val result: List<String>

    result = sol.letterCasePermutation(S)
    println(result)
}



