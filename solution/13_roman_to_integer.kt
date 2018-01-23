/*
index = 0
while index < strLen
    get current value
    get next value
    if nextValue > currentValue
       tmpSum = nextValue - currentValue
       index++
    else
       tmpSum = currentValue

    sum += tmpSum
    index++
return sum

Roman numeral
1) I-1, V-5, X-10, L-50, C-100, D-500, M-1000
2) read from left to right
3) add smaller or equal right
4) larger right minus left
*/

class Solution {
    fun romanToInt(s: String): Int {
        val strLen = s.length
        val romanMap: Map<Char, Int> = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var sum = 0
        var tmpSum: Int
        var index = 0
        var curValue: Int
        var nextValue: Int

        while (index < strLen - 1) {
            curValue = romanMap.get(s[index])!!
            nextValue = romanMap.get(s[index+1])!!

            if (nextValue > curValue) {
                tmpSum = nextValue - curValue
                index++
            } else {
                tmpSum = curValue
            }

            sum += tmpSum
            index++
        }

        if (index < strLen) {
            sum += romanMap.get(s[index])!!
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val romanStr = "DCXXI" // "DCXXI", "MCMXCVI", 1000 + (1000 - 100) + (100 - 10) + 5 + 1
    val sol = Solution()

    val result = sol.romanToInt(romanStr)

    println(result)
}