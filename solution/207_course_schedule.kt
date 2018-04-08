enum class Status {
    UNVISITED,
    VISITED,
    VISITING
}

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array<MutableList<Int>>(numCourses, {mutableListOf()})
        val visited = Array<Status>(numCourses, {Status.UNVISITED})

        for (edge in prerequisites) {
            graph[edge[1]].add(edge[0])
        }

        for (i in 0 until visited.size) {
            if (hasCycle(graph, i, visited)) {
                return false
            }
        }

        return true
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

        return false
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val numCourses = 2
    val prerequisites = arrayOf(intArrayOf(1, 0))
    val result: Boolean

    result = sol.canFinish(numCourses, prerequisites)
    println(result)
}



