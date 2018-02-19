/*

fun findRedundantConnection()
    go thru each edge
        seen is clear
        if isConnected(connectedGraph, edge.u, edge.v)
            return edge

        connectedGraph[edge.u] += edge.v
        connectedGraph[edge.v] += edge.u


fun isConnected(connectedGraph, u, v)
    if connectedGraph[u] or connectedGraph[v] is empty list
        return false

    if seen doesn't contain u
        add u in seen

        for node in connectedGraph[u]
            if node == v
                return true

            if seen contains node
                continue
            else
                if isConnected(connectedGraph, node, v)
                    return true

    return false

 */

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val connectedGraph = Array<ArrayList<Int>>(edges.size){arrayListOf()}
        var seenNodeList: ArrayList<Int>
        var startNode: Int
        var endNode: Int
        var removedEdge = intArrayOf()

        for (edge in edges) {
            seenNodeList = arrayListOf()
            startNode = edge[0]
            endNode = edge[1]
            if (isConnected(connectedGraph, startNode, endNode, seenNodeList)) {
                removedEdge = edge
                break
            }
            connectedGraph[startNode-1].add(endNode)
            connectedGraph[endNode-1].add(startNode)
        }

        return removedEdge
    }

    fun isConnected(connectedGraph: Array<ArrayList<Int>>, startNode: Int, endNode: Int, seenNodeList: ArrayList<Int>): Boolean {
        if (connectedGraph[startNode-1].isEmpty() || connectedGraph[endNode-1].isEmpty()) {
            return false
        }

        if (!seenNodeList.contains(startNode)) {
            seenNodeList.add(startNode)

            for (node in connectedGraph[startNode - 1]) {
                if (node == endNode) {
                    return true
                }

                if (seenNodeList.contains(node)) {
                    continue
                } else {
                    if (isConnected(connectedGraph, node, endNode, seenNodeList)) {
                        return true
                    }
                }
            }
        }

        return false
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val edges = arrayOf(intArrayOf(3, 4), intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 5), intArrayOf(2, 5))
    val result: IntArray // (2, 5)

    result = sol.findRedundantConnection(edges)
    println(result.toList().toString())
}