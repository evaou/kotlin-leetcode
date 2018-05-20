class Solution {
    fun findComplement(num: Int): Int {
        var result = 0
        var tmpNum = num
        var complementBit: Int
        var count = 0
        var posNum: Int

        while (tmpNum != 0) {
            complementBit = (tmpNum and 1) xor 1
            posNum = Math.pow(2.0, count.toDouble()).toInt()
            result += complementBit*posNum
            tmpNum = tmpNum.shr(1)
            count++
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val num = 5
    val result: Int

    result = sol.findComplement(num)
    println(result)
}



