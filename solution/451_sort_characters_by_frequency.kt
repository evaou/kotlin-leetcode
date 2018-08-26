import java.util.*

class Solution {
    fun frequencySort(s: String): String {
        var result = ""
        val map: HashMap<Char, Int> = hashMapOf()
        val queue = PriorityQueue<Char> {a, b -> map.getValue(b) - map.getValue(a)}

        for (c in s) {
            map[c] = map.getOrDefault(c, 0) + 1
        }

        map.forEach { key, _ ->
            queue.add(key)
        }

        var tmpC: Char
        while (queue.isNotEmpty()) {
            tmpC = queue.poll()
            result += CharArray(map.getValue(tmpC)){tmpC}.joinToString("")
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val s = "raaeaedere"
    val result: String

    result = sol.frequencySort(s)
    println(result)
}

