/*
while (node1 is not empty) or (node2 is not empty)
    node1Value = (node1 is not empty) ? node1.val : -1
    node2Value = (node2 is not empty) ? node2.val : -1

    if node1Value <= node2Value
        ll3.insert(node1Value)
        node1 = node1?.next
    else
        ll3.insert(node2Value)
        node2 = node2?.next

return ll3.head
*/

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class LinkedList {
    var head: ListNode? = null

    fun insert(value: Int) {
        var curNode = head
        val newNode = ListNode(value)

        if (head == null) {
            head = newNode
            return
        }

        while (curNode?.next != null) {
            curNode = curNode.next
        }

        curNode?.next = newNode
    }

    fun printNode() {
        var curNode = head

        while (curNode != null) {
            print("%d ".format(curNode.`val`))
            curNode = curNode.next
        }

        println()
    }
}

class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        val ll3 = LinkedList()
        var node1 = l1
        var node2 = l2
        var value1: Int
        var value2: Int

        while (node1 != null || node2 != null) {
            value1 = Int.MAX_VALUE
            value2 = Int.MAX_VALUE

            if (node1 != null) {
                value1 = node1.`val`
            }

            if (node2 != null) {
                value2 = node2.`val`
            }

            if (value1 <= value2) {
                ll3.insert(value1)
                node1 = node1?.next
            } else {
                ll3.insert(value2)
                node2 = node2?.next
            }
        }

        return ll3.head
    }
}

fun main(args: Array<String>) {
    val ll1 = LinkedList() // 1->2->4
    val ll2 = LinkedList() // 1->3->4
    val ll3 = LinkedList() // 1->1->2->3->4->4
    val sol = Solution()

    ll1.insert(1)
    ll1.insert(2)
    ll1.insert(4)
    ll1.printNode()

    ll2.insert(1)
    ll2.insert(3)
    ll2.insert(4)
    ll2.printNode()

    ll3.head = sol.mergeTwoLists(ll1.head, ll2.head)
    ll3.printNode()
}