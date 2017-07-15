/*
    Since the two linked lists finally align together, we could go through two sequences simultaneously.
    One sequence starts with the first linked list and then the second linked list.
    The other sequence starts with the second linked and then the first linked list.
*/

import java.io.File
import java.util.Scanner

class Node(val data: String) {
    var next: Node? = null
}

class LinkedList {
    var head: Node? = null
    var length: Int = 0

    fun insert(data: String) {
        val newNode = Node(data)

        newNode.next = head
        head = newNode
    }

    fun print() {
        var currentNode: Node? = head

        while (currentNode != null) {
            print("${currentNode.data} -> ")
            currentNode = currentNode.next
        }

        println("null")
    }
}

fun readLinkedList(str: String): LinkedList {
    val regex = Regex("\\s+")
    val strList: List<String> = str.split(regex)
    var str: String
    val dataList = mutableListOf<String>()
    val linkedList = LinkedList()

    for (i in 0 until strList.size) {
        str = strList[i]
        if (str == "->") {
            continue
        }
        dataList.add(str)
    }

    while (dataList.size > 0) {
        str = dataList.removeAt(dataList.lastIndex)
        linkedList.insert(str)
        linkedList.length++
    }

    linkedList.print()

    return linkedList
}

fun findIntersectedNode(linkedList1: LinkedList, linkedList2: LinkedList) {
    var node1: Node? = linkedList1.head
    var node2: Node? = linkedList2.head
    var intersectedStr: String = "null"
    val length = linkedList1.length + linkedList2.length

    if (node1 == null || node2 == null) {
        println(intersectedStr)
        return
    }

    for (i in 0 until length) {
        if (node1!!.data == node2!!.data) {
            intersectedStr = node1.data
            break
        }

        node1 = node1.next
        node2 = node2.next

        if (node1 == null) {
            node1 = linkedList2.head
        }

        if (node2 == null) {
            node2 = linkedList1.head
        }
    }

    println(intersectedStr)
}

fun main(args: Array<String>) {
    val fileName = "input.txt"
    val file = File(fileName)
    val input = Scanner(file)
    val linkedList1: LinkedList
    val linkedList2: LinkedList

    linkedList1 = readLinkedList(input.nextLine())
    linkedList2 = readLinkedList(input.nextLine())

    findIntersectedNode(linkedList1, linkedList2)
}