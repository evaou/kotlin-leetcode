class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution(head: ListNode?) {
    val curHead: ListNode? = head

    fun getRandom(): Int {
        var tmpNode: ListNode? = curHead
        var order: Int = (Math.random()*10).toInt()

        while (order > 0) {
            order--
            if (tmpNode?.next == null) {
                tmpNode = curHead
            } else {
                tmpNode = tmpNode.next
            }
        }

        return tmpNode!!.`val`
    }
}

fun main(args: Array<String>) {
    val head = ListNode(1)
    val sol = Solution(head)
    val result: Int

    head.next = ListNode(2)
    head.next?.next = ListNode(3)

    result = sol.getRandom()
    println(result)
}


