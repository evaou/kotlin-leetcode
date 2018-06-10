class Solution {
    fun validUtf8(data: IntArray): Boolean {
        var result = true
        var count = 0

        for (i in data) {
            if (count == 0) {
                if (i.shr(5) == 0b110) {
                    count = 1
                } else if (i.shr(4) == 0b1110) {
                    count = 2
                } else if (i.shr(3) == 0b11110) {
                    count = 3
                } else if (i.shr(7) != 0b0) {
                    result = false
                    break
                }
            } else {
                if (i.shr(6) == 0b10) {
                    count--
                } else {
                    result = false
                    break
                }
            }
        }

        if (count > 0) {
            result = false
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val data = intArrayOf(237/*235, 140, 4*//*197, 130, 1*/)
    val result: Boolean

    result = sol.validUtf8(data)
    println(result)
}

