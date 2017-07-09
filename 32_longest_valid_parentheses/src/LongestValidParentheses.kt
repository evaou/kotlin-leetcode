import java.io.File
import java.util.Scanner

fun getLongestValidParentheses(inputStr: String) {
    val stack = ArrayList<Char>()
    var validLen = 0
    var popChar: Char
    val leftChar: Char = '('
    val rightChar: Char = ')'
    var hasRight = false

    inputStr.map { it ->
        stack.add(it)
    }

    while (stack.isNotEmpty()) {
        popChar = stack.removeAt(stack.lastIndex)

        if (hasRight) {
            if (popChar == leftChar) {
                validLen += 2
                print("%c%c".format(leftChar, rightChar))
                hasRight = false
            }
        } else if (popChar == rightChar) {
            hasRight = true
        }
    }

    println(":%d".format(validLen))
}

fun main(args: Array<String>) {
    val fileName = "input.txt"
    val file = File(fileName)
    val input = Scanner(file)
    var inputStr: String

    while (input.hasNext()) {
        inputStr = input.next()
        getLongestValidParentheses(inputStr)
    }
}