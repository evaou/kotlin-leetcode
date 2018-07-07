class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {
    fun numComponents(head: ListNode?, G: IntArray): Int {
        var num = 0
        var curNode = head
        val hashSet = HashSet<Int>(G.toList())

        while (curNode != null) {
            if (hashSet.contains(curNode.`val`)
                && !hashSet.contains(curNode.next?.`val`)) {
                num++
            }

            curNode = curNode.next
        }

        return num
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
    val input = intArrayOf(0, 1, 2, 3, 4)
    val G = intArrayOf(0, 3, 1, 4)
    val head: ListNode?
    val result: Int

    head = sol.buildList(input)
    result = sol.numComponents(head, G)
    println(result)
}

