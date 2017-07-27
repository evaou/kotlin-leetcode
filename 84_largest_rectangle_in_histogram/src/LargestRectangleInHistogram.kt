import java.io.File
import java.util.Scanner

class Stack(val size: Int) {
    var top = -1
    val array = IntArray(size)

    fun isEmpty(): Boolean {
        if (top == -1) {
            return true
        }

        return false
    }

    fun isFull(): Boolean {
        if (top == (size - 1)) {
            return true
        }

        return false
    }

    fun peek(): Int {
        if (isEmpty()) {
            println("Empty stack. No peak.")
        }

        return array[top]
    }

    fun push(value: Int) {
        if (isFull()) {
            println("Stack is full. Cannot push element.")
            return
        }

        array[++top] = value
    }

    fun pop(): Int {
        if (isEmpty()) {
            println("Stack is empty. Cannot pop element")
            return -1
        }

        return array[top--]
    }
}

fun readHistogramHeight(filename: String): IntArray {
    val file = File(filename)
    val input = Scanner(file)
    val list = mutableListOf<Int>()

    while (input.hasNextInt()) {
        list.add(input.nextInt())
    }

    return list.toIntArray()
}

fun printArray(array: IntArray, str: String = "") {
    print(str)

    for (i in 0 until array.size) {
        print("%d ".format(array[i]))
    }

    println()
}

fun findLargestRectangleArea(histogram: IntArray): Int {
    val stack = Stack(histogram.size)
    var area = 0
    var index = 0
    var tmpIndex: Int
    var tmpArea: Int
    var width: Int

    while (index < histogram.size) {
        if (stack.isEmpty() || histogram[index] >= histogram[stack.peek()]) {
            stack.push(index)
            index++
            continue
        }

        while (!stack.isEmpty() && histogram[index] < histogram[stack.peek()]) {
            tmpIndex = stack.pop()

            if (stack.isEmpty()) {
                width = index
            } else {
                width = index - stack.peek() - 1
            }

            tmpArea = histogram[tmpIndex] * width
            if (tmpArea > area) {
                area = tmpArea
            }
        }
    }

    return area
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val histogram: IntArray
    val area: Int

    histogram = readHistogramHeight(filename)
    printArray(histogram, "histogram: ")

    area = findLargestRectangleArea(histogram)
    println("Area: $area")
}