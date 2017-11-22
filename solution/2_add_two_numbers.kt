
class ListNode(var `val`: Int = 0 ) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var dummyHead = ListNode(0)
        var curNode1 = l1
        var curNode2 = l2
        var value1: Int
        var value2: Int
        var carry = 0
        var sum: Int
        var tmpNode: ListNode?
        var curNode = dummyHead

        while (curNode1 != null || curNode2 != null || carry > 0) {
            value1 = curNode1?.`val` ?: 0
            value2 = curNode2?.`val` ?: 0
            sum = value1 + value2 + carry
            carry = sum / 10
            tmpNode = ListNode(sum % 10)

            curNode.next = tmpNode
            curNode = tmpNode

            curNode1 = curNode1?.next
            curNode2 = curNode2?.next
        }

        return dummyHead.next
    }
}

fun genList(array: IntArray): ListNode? {
    var tmpNode: ListNode?
    var resultList: ListNode? = null

    for (i in array.reversed()) {
        tmpNode = ListNode(i)
        tmpNode.next = resultList
        resultList = tmpNode
    }

    return resultList
}

fun printList(list: ListNode?) {
    var tmpNode = list

    print("[")
    while (tmpNode != null) {
        print("${tmpNode.`val`}")
        tmpNode = tmpNode.next
        if (tmpNode != null) {
            print(", ")
        }
    }
    println("]")
}


fun main(args: Array<String>) {
    val l1Value = intArrayOf(2, 4, 3) // (1, 8) // (1, 9, 9, 9, 9, 9, 9, 9, 9, 9)
    val l2Value = intArrayOf(5, 6, 4) // (0)    // (9)
    val l1: ListNode?
    val l2: ListNode?
    val l3: ListNode?
    val sol = Solution()

    l1 = genList(l1Value)
    l2 = genList(l2Value)

    l3 = sol.addTwoNumbers(l1, l2)

    printList(l1)
    printList(l2)
    printList(l3)
}
