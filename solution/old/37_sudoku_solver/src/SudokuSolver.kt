import java.io.File
import java.util.Scanner

fun printArray(array: Array<Array<String>>) {
    val num = array.size

    for (i in 0 until num) {
        for (j in 0 until num) {
            print("${array[i][j]} ")
        }
        println()
    }
}

fun isValidSudoValue(value: String, array: Array<Array<String>>, row: Int, col: Int): Boolean {
    val size = array.size
    val blockSize = 3
    val rowStart: Int
    val colStart: Int
    var x: Int
    var y: Int

    for (i in 0 until size) {
        if (array[row][i] != "." &&
            array[row][i] == value) {
            return false
        }

        if (array[i][col] != "." &&
            array[i][col] == value) {
            return false
        }
    }

    rowStart = row/blockSize
    colStart = col/blockSize

    for (i in 0 until blockSize) {
        for (j in 0 until blockSize) {
            x = blockSize * rowStart + i
            y = blockSize * colStart + j

            if (array[x][y] != "." &&
                array[x][y] == value) {
                return false
            }
        }
    }

    return true
}

fun solveSudo(array: Array<Array<String>>): Boolean {
    val size = array.size
    var value: String

    for (i in 0 until size) {
        for (j in 0 until size) {
            if (array[i][j] != ".") {
                continue
            }

            for (k in 1..size) {
                value = k.toString()
                if (isValidSudoValue(value, array, i, j)) {
                    array[i][j] = value

                    if (solveSudo(array)) {
                        return true
                    } else {
                        array[i][j] = "."
                    }
                }
            }

            return false
        }
    }

    return true
}

fun main(args: Array<String>) {
    val fileName = "input.txt"
    val file = File(fileName)
    val input = Scanner(file)
    var strLine: String
    val regex = Regex("\\s")
    val num = 9
    val array = Array(num, {Array(num, {" "})})
    var i = 0
    var list: List<String>

    while (input.hasNext()) {
        strLine = input.nextLine()
        list = strLine.split(regex)
        array[i++] = list.toTypedArray()
    }

    solveSudo(array)

    printArray(array)
}