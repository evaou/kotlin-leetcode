class Solution {
    private var result: List<List<String>> = listOf()

    fun solveNQueens(n: Int): List<List<String>> {
        val visitedCols = ArrayList<Int>()
        val cols = IntArray(n){it}
        val colIdx = 0

        findQueen(visitedCols, cols, colIdx)

        return result
    }

    fun findQueen(visitedCols: ArrayList<Int>, cols: IntArray, colIdx: Int) {
        var tmpStr: String
        var queen: List<String>
        var isDiagonal: Boolean
        var curRow: Int
        var curCol: Int
        var tmpCol: Int

        if (colIdx == cols.size) {
            queen = listOf()

            for (i in visitedCols.iterator()) {
                tmpStr = ""
                for (j in 0 until cols.size) {
                    if (i==j) {
                        tmpStr += "Q"
                    } else {
                        tmpStr += "."
                    }
                }
                queen += listOf(tmpStr)
            }

            result += listOf(queen)

            return
        }

        for (i in 0 until cols.size) {
            if (visitedCols.contains(cols[i])) {
                continue
            }

            isDiagonal = false
            curRow = visitedCols.size
            curCol = i
            for (tmpRow in 0 until visitedCols.size) {
                tmpCol = visitedCols[tmpRow]
                if (Math.abs(curRow-tmpRow) == Math.abs(curCol-tmpCol)) {
                    isDiagonal = true
                    break
                }
            }

            if (isDiagonal) {
                continue
            }

            visitedCols.add(cols[i])
            findQueen(visitedCols, cols, colIdx+1)
            visitedCols.remove(cols[i])
        }

    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 4
    val result: List<List<String>>

    result = sol.solveNQueens(n)

    for (i in result.iterator()) {
        for (j in i.iterator()) {
            println(j)
        }
        println()
    }
}


