class Solution {
    fun canTransform(start: String, end: String): Boolean {
        if (start.length != end.length) {
            return false
        }

        val newStart = start.filter { it != 'X' }
        val newEnd = end.filter { it != 'X' }

        if (newStart != newEnd) {
            return false
        }

        var sl = 0
        var sr = 0
        var el = 0
        var er = 0

        for (i in 0 until start.length) {
            if (start[i] == 'L') {
                sl++
            }

            if (start[i] == 'R') {
                sr++
            }

            if (end[i] == 'L') {
                el++
            }

            if (end[i] == 'R') {
                er++
            }

            if ( sl > el || sr < er ) {
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val start = "XXRXXLXXXX" // "RXXLRXRXL"
    val end = "XXXXRXXLXX" // "XRLXXRRLX"
    val result: Boolean

    result = sol.canTransform(start, end)
    println(result)
}



