/*
resultChar = firstChar
go thru each char in sorted array
    if char - target > 0
        resultChar = char
        break

return resultChar
 */

class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        var resultChar = letters[0]

        for (i in 0 until letters.size) {
            if ((letters[i]-target) > 0) {
                resultChar = letters[i]
                break
            }
        }

        return resultChar
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val letters = charArrayOf('c', 'f', 'j')
    val target = 'k'
    val result: Char

    result = sol.nextGreatestLetter(letters, target)
    println(result)
}