class Solution {
    fun myAtoi(str: String): Int {
        val signCharArray = charArrayOf('+', '-')
        val numCharArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        val intCharArray = signCharArray + numCharArray
        var newStr = str.trim()
        val maxNumLen = Int.MAX_VALUE.toString().length

        for (i in 0 until newStr.length) {
            if (!intCharArray.contains(newStr[i])) {
                newStr = newStr.substring(0..(i-1))
                break
            }
        }

        if (newStr.length > 1 && signCharArray.contains(newStr[0]) && signCharArray.contains(newStr[1])) {
            return 0
        }

        if (newStr.startsWith('+')) {
            newStr = newStr.substring(1)
        }

        if (newStr.isEmpty()) {
            return 0
        } else if (newStr.length == 1) {
            if (signCharArray.contains(newStr[0])) {
                return 0
            }
        }

        if (newStr.startsWith('-')) {
            if (newStr.length > maxNumLen+1 || newStr.toLong() < Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }
        } else {
            if (newStr.length > maxNumLen || newStr.toLong() > Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
        }

        return newStr.toInt()
    }
}

fun main(args: Array<String>) {
    val input = "9223372036854775809" //""    +1146905820n1" // "      -11919730356x", "2147483648", "-2147483647", "  -0012a42", "  010", "+-2", "+1", "9223372036854775809", "2147483648", "-", "+", "", "123"
    val output: Int
    val sol = Solution()

    output = sol.myAtoi(input)

    println(output)
}
