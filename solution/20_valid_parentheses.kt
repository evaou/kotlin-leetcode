/*
create leftSet including "(", "{", "["
create rightToLeftMap for {")": "(", "}": "{", "]": "["}
create stack

go through each char in input string
    if char in leftSet
        put char in stack
    else // char in rightSet
        tmpChar = rightToLeftMap(char)
        if stack is empty or poped top char != tmpChar
            return false

if stack is not empty
    return false

return true
*/

class Solution {
    fun isValid(s: String): Boolean {
        val leftSet = listOf("(", "[", "{")
        val rightToLeftMap = mapOf(")" to "(", "]" to "[", "}" to "{")
        val stack = ArrayList<String>()
        var tmpStr: String
        var leftStr: String

        for (i in 0 until s.length) {
            tmpStr = s[i].toString()

            if (leftSet.contains(tmpStr)) {
                stack.add(tmpStr)
            } else {
                leftStr = rightToLeftMap.getValue(tmpStr)
                if (stack.isEmpty() ||
                    leftStr != stack.removeAt(stack.lastIndex)) {
                    return false
                }
            }
        }

        if (stack.isNotEmpty()) {
            return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    val inputStr = "[" // "()", "(]", "([)]", "()[]{}", "]", "["
    val sol = Solution()

    println(sol.isValid(inputStr))
}