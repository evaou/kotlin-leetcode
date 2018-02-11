/*

multiplierList = listOf(10000, 1000, 100, 10)
numberList is empty

go thru each number
    digitList = empty list
    sum = 0
    isDividable = true

    go thru each multiplier in multiplierList
        if multiplier > number
            continue

        tmpDigit = (number-sum)/multiplier
        if tmpDigit >= 0
            digitList += listOf(tmpDigit)
            sum += tmpDigit * multiplier

    if digitList has 0
        continue

    digitList += listOf(number - sum)

    tmpDigit = number - sum
    if tmpDiti is 0
        continue
    digitList += listOf(tmpDigit)

    got thru each digit in digitList
        if ( (number % digit) != 0)
            isDividable = false
            break

    if isDividable
        numberList += listOf(number)

return numberList

 */

class Solution {
    fun selfDividingNumbers(left: Int, right: Int): List<Int> {
        var numberList: List<Int> = listOf()
        val multiplierList = listOf(10000, 1000, 100, 10)
        var digitList: List<Int>
        var sum: Int
        var isDividable: Boolean
        var tmpDigit: Int

        for (number in left..right) {
            digitList = listOf()
            sum = 0
            isDividable = true

            for (multiplier in multiplierList) {
                if (multiplier > number) {
                    continue
                }
                tmpDigit = (number-sum) / multiplier
                if (tmpDigit >= 0) {
                    digitList += listOf(tmpDigit)
                    sum += tmpDigit * multiplier
                }
            }

            if (digitList.contains(0)) {
                continue
            }

            tmpDigit = number - sum
            if (tmpDigit == 0) {
                continue
            }
            digitList += listOf(tmpDigit)

            for (digit in digitList) {
                if ((number % digit) != 0) {
                    isDividable = false
                    break
                }
            }

            if (isDividable) {
                numberList += listOf(number)
            }
        }

        return numberList
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val left = 1
    val right = 22
    val list: List<Int>

    list = sol.selfDividingNumbers(left, right)
    println(list)
}