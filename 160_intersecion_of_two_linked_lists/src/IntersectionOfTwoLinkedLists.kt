import java.io.File
import java.util.Scanner

data class Node (
    val data: String,
    val next: Node?
)

class LinkedList {
    var head: Node? = null
}

fun main(args: Array<String>) {
    val fileName = "input.txt"
    val file = File(fileName)
    val input = Scanner(file)
    var inputStr: String

    val list1: LinkedList
    val list2: LinkedList

    while (input.hasNext()) {
        inputStr = input.next()
        println(inputStr)
    }
}