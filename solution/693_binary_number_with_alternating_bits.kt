class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        var tmpNum = n
        var tmpBit: Int
        var preBit: Int
        var result = true

        preBit = tmpNum and 1
        tmpNum = tmpNum.shr(1)

        while (tmpNum != 0) {
            tmpBit = tmpNum and 1
            if (tmpBit == preBit) {
                result = false
                break
            }

            preBit = tmpBit
            tmpNum = tmpNum.shr(1)
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 5
    val result: Boolean

    result = sol.hasAlternatingBits(n)
    println(result)
}



