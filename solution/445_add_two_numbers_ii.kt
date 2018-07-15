import java.util.Stack

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        var list1 = l1
        var list2 = l2
        var digitSum: Int
        var digitCarry = 0
        var tmpNode: ListNode?

        while (list1 != null) {
            stack1.push(list1.`val`)
            list1 = list1.next
        }

        while (list2 != null) {
            stack2.push(list2.`val`)
            list2 = list2.next
        }

        while (stack1.isNotEmpty() || stack2.isNotEmpty() || digitCarry > 0) {
            digitSum = digitCarry

            if (stack1.isNotEmpty()) {
                digitSum += stack1.pop()
            }

            if (stack2.isNotEmpty()) {
                digitSum += stack2.pop()
            }

            tmpNode = ListNode(digitSum % 10)
            tmpNode.next = result
            result = tmpNode

            digitCarry = digitSum / 10
        }

        return result
    }

    fun printNode(head: ListNode?) {
        var tmpNode = head

        while (tmpNode != null) {
            print("%d, ".format(tmpNode.`val`))
            tmpNode = tmpNode.next
        }
        println()
    }

    fun buildList(input: IntArray): ListNode? {
        var head: ListNode? = null
        var tmp: ListNode?

        for (i in input.lastIndex downTo 0) {
            tmp = ListNode(input[i])
            tmp.next = head
            head = tmp
        }

        return head
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val input1 = intArrayOf(5) // intArrayOf(7, 2, 4, 3)
    val input2 = intArrayOf(5) // intArrayOf(5, 6, 4)
    val l1: ListNode?
    val l2: ListNode?
    val result: ListNode?

    l1 = sol.buildList(input1)
    l2 = sol.buildList(input2)
    result = sol.addTwoNumbers(l1, l2)
    sol.printNode(result)
}

