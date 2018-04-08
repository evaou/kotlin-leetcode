enum class Status {
    UNVISITED,
    VISITING,
    VISITED
}

class Solution {
    val stack = ArrayList<Int>()

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array<MutableList<Int>>(numCourses, {mutableListOf()})
        val visited = Array(numCourses, {Status.UNVISITED})

        for (edge in prerequisites) {
            graph[edge[1]].add(edge[0])
        }

        for (i in 0 until numCourses) {
            if (hasCycle(graph, i, visited)) {
                return intArrayOf()
            }
        }

        return stack.toIntArray().reversedArray()
    }

    fun hasCycle(graph: Array<MutableList<Int>>, node: Int, visited: Array<Status>): Boolean {
        if (visited[node] == Status.VISITED) {
            return false
        }

        if (visited[node] == Status.VISITING) {
            return true
        }

        visited[node] = Status.VISITING

        for (neighbor in graph[node]) {
            if (hasCycle(graph, neighbor, visited)) {
                return true
            }
        }

        visited[node] = Status.VISITED
        stack.add(node)

        return false
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val numCourses = 4
    val prerequisites = arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))
    val result: IntArray

    result = sol.findOrder(numCourses, prerequisites)
    println(result.joinToString(", "))
}



