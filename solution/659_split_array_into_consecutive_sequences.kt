class Solution {
    fun isPossible(nums: IntArray): Boolean {
        val freqMap: HashMap<Int, Int> = hashMapOf()
        val needMap: HashMap<Int, Int> = hashMapOf()
        var result = true

        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        // greedy
        for (num in nums) {
            if (freqMap[num] == 0) {
                continue
            }

            if (needMap.getOrDefault(num, 0) > 0) {
                needMap[num] = needMap.getValue(num) - 1
                needMap[num+1] = needMap.getOrDefault(num+1, 0) + 1
            } else if (freqMap.getOrDefault(num+1, 0) > 0 && freqMap.getOrDefault(num+2, 0) > 0) {
                freqMap[num+1] = freqMap.getValue(num+1) - 1
                freqMap[num+2] = freqMap.getValue(num+2) - 1
                needMap[num+3] = needMap.getOrDefault(num+3, 0) + 1
            } else {
                result = false
                break
            }

            freqMap[num] = freqMap.getValue(num) - 1
        }

        return result
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val s = intArrayOf(1,2,3,4,4,5)
    val result: Boolean

    result = sol.isPossible(s)
    println(result)
}

