import java.io.File
import java.util.Scanner

fun printArray(array: IntArray) {
    for (i in 0 until array.size) {
        print("${array[i]} ")
    }
    println()
}

fun swap(array: IntArray, firstIndex: Int, secondIndex: Int) {
    val temp = array[firstIndex]
    array[firstIndex] = array[secondIndex]
    array[secondIndex] = temp
}

fun permu(array: IntArray, startIndex: Int, endIndex: Int) {
    if (startIndex == endIndex) {
        printArray(array)
    }

    for (i in startIndex..endIndex) {
        swap(array, startIndex, i)
        permu(array, startIndex+1, endIndex)
        swap(array, startIndex, i)
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val list = mutableListOf<Int>()

    while (input.hasNextInt()) {
        list.add(input.nextInt())
    }

    val array = list.toIntArray()

    for (i in 1 until array.size) {
        array[i-1] = i
    }

    permu(array, 0, array.size - 1)
}