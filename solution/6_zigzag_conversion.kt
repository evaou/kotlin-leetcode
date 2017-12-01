class Solution {
    fun convert(s: String, numRows: Int): String {
        val n = numRows - 1
        var a: Int
        var b: Int
        val len = s.length
        val numCols = len
        val array = Array(numRows, {IntArray(numCols, {-1})})
        val numArray = IntArray(numRows, {0})
        var col: Int
        var row: Int
        var index: Int
        var resultStr = ""

        if (numRows == 1 || len == 1) {
            return s
        }

        for (i in 0 until len) {
            a = i/n
            b = i%n

            if (a % 2 == 0) {
                row = b
            } else {
                row = n - b
            }
            col = numArray[row]
            array[row][col] = i

            numArray[row] = col + 1
        }

        for (i in 0 until numRows) {
            for (j in 0 until numCols) {
                index = array[i][j]
                if (index == -1) {
                    continue
                }
                resultStr += "${s[index]}"
            }
        }

        return resultStr
    }
}

fun main(args: Array<String>) {
    val inputStr = "AB" // "A" //"PAYPALISHIRING"
    val rowNum = 3 // 2 //3
    val resultStr: String
    val sol = Solution()

    resultStr = sol.convert(inputStr, rowNum)

    println(resultStr)
}
