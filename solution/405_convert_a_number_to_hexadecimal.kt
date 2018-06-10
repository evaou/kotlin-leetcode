class Solution {
    fun toHex(num: Int): String {
        var result = ""
        var inputNum = num.toLong()
        var tmpNum: Long
        val map = hashMapOf(10 to "a", 11 to "b", 12 to "c", 13 to "d", 14 to "e", 15 to "f")

        if (inputNum < 0) {
            inputNum = -inputNum
            inputNum = inputNum xor 0xffffffff
            inputNum += 1
        }

        while (inputNum > 0) {
            tmpNum = inputNum and 0xf
            inputNum = inputNum.shr(4)

            if (map.containsKey(tmpNum.toInt())) {
                result = map[tmpNum.toInt()] + result
            } else {
                result = "%d".format(tmpNum) + result
            }
        }

        if (result.isEmpty()) {
            result = "0"
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val num = 26 //-1 // "ffffffff"  26 // "1a"
    val result: String

    result = sol.toHex(num)
    println(result)
}

