/*
create array with roman value from large to small [1000, 500, 100, 50, 10, 5, 1]
create minusSet with left roman value [100, 10, 1]
create map from roman value to roman char {1000: M, 500: D, 100: C, 50: L, 10: X, 5: V, 1: I}

finalChars = ""

while value > 0
    for array index from small to large
        multiplier = value / array[index]
        if multiplier >= 1
            index = current array index
            break

    tmpValue = value + 1
    if index is not 0
        find minusIndex >= index, and in minusSets
        tmpValue = array[index-1] - array[minusIndex]

    if value >= tmpValue
        tmpChars = map[array[minusIndex]]map[array[index-1]]
        value -= tmpValue
    else
        tmpChars = map[array[index]] repeat multiplier
        value -= array[index] * multiplier

    finalChars += tmpChars

Roman numeral
1) I-1, V-5, X-10, L-50, C-100, D-500, M-1000
2) read from left to right
3) larger right minus left
4) char not repeat more than 3
5) minus left is only I/X/C

e.g. 1996
1996/1000 >= 1  => M, 1996-1000 = 996
996/500 >= 1, 996 > (1000-100) => MCM, 996 - (1000-100) = 96
96/50 >= 1, 96 > (100-10) => MCMXC, 96 - (100-10) = 6
6/5 >= 1, 6 < (10-1) => MCMXCV, 6 - 5 = 1
1/1 >= 1, 1 < (5-1) => MCMXCVI, 1 - 1 = 0

e.g. 2469, MMCDLXIX
2469/1000 >= 1 => M*2, 2469 - 1000*2 = 469
469/100 >=1 => CD, 469 - (500-100) = 69
69/50 >= 1 => L, 69 - 50 = 19
19/10 >= 1 => X, 19 - 10 - 9
9/5 >= 1 => IX, 9 - (10-1) = 0
*/

class Solution {
    fun intToRoman(num: Int): String {
        var romanStr = ""
        var value = num
        var tmpValue: Int
        val romanValueArray = intArrayOf(1000, 500, 100, 50, 10, 5, 1)
        val minusRomanValueList = listOf(100, 10, 1)
        val romanMap = mapOf(1000 to "M", 500 to "D", 100 to "C", 50 to "L", 10 to "X", 5 to "V", 1 to "I")
        var multiplier = 0
        var currentIndex = 0
        var minusIndex = 0
        var tmpStr: String

        while (value > 0) {
            for (i in currentIndex until romanValueArray.size) {
                multiplier = value / romanValueArray[i]
                if (multiplier >= 1) {
                    currentIndex = i
                    break
                }
            }

            tmpValue = value + 1
            if (currentIndex > 0) {
                for (j in currentIndex until romanValueArray.size) {
                    if (minusRomanValueList.contains(romanValueArray[j])) {
                        minusIndex = j
                        tmpValue = romanValueArray[currentIndex-1] - romanValueArray[minusIndex]
                        break
                    }
                }
            }

            if (value >= tmpValue) {
                tmpStr = romanMap[romanValueArray[minusIndex]] + romanMap[romanValueArray[currentIndex-1]]
                value -= tmpValue
            } else {
                tmpStr = ""
                for (k in 0 until multiplier) {
                    tmpStr += romanMap[romanValueArray[currentIndex]]
                }
                value -= romanValueArray[currentIndex] * multiplier
            }

            romanStr += tmpStr
        }

        return romanStr
    }
}

fun main(args: Array<String>) {
    val romanInt = 1996 // 2469
    val sol = Solution()

    println(sol.intToRoman(romanInt))
}