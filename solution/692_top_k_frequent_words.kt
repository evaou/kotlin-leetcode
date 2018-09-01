import java.util.PriorityQueue

// 692
class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freqMap: HashMap<String, Int> = hashMapOf()
        var result: List<String> = listOf()
        val maxHeap =  PriorityQueue<String> {
            a, b ->
            if (freqMap.getValue(b) != freqMap.getValue(a)) {
                100 * (freqMap.getValue(b) - freqMap.getValue(a))
            } else {
                var result = 0

                for (i in 0 until Math.max(a.length, b.length)) {
                    if (i >= a.length) {
                        result = -1
                        break
                    }

                    if (i >= b.length) {
                        result = 1
                        break
                    }

                    result = a[i] - b[i]
                    if (result != 0) {
                        break
                    }
                }

                result
            }
        }

        for (word in words) {
            freqMap[word] = freqMap.getOrDefault(word, 0) + 1
        }

        for (item in freqMap) {
            maxHeap.add(item.key)
        }

        for (i in 0 until k) {
            result += listOf(maxHeap.remove())
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val words: Array<String> = arrayOf("a","aa","aaa")
    val k = 1
    val result: List<String>

    result = sol.topKFrequent(words, k)
    println(result)
}

