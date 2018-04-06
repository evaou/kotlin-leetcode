class Solution {
    var used: Array<Boolean> = arrayOf()
    val map = HashMap<Int, Boolean>()

    fun canIWin(max: Int, total: Int): Boolean {
        val sum = (max+1)*max/2
        if (sum < total) {
            return false
        }

        if (total <= 0 || max >= total) {
            return true
        }

        used = Array<Boolean>(max, {false})
        return helper(total)
    }

    fun helper(total: Int): Boolean {
        if (total <= 0) {
            return false
        }

        val key = format(used)
        if (map.containsKey(key)) {
            return map.getValue(key)
        }

        for (i in 0 until used.size) {
            if (used[i]) {
                continue
            }

            used[i] = true
            if (!helper(total - (i+1))) {
                map[key] = true
                used[i] = false
                return true
            }
            used[i] = false
        }

        map[key] = false
        return map.getValue(key)
    }

    fun format(used: Array<Boolean>): Int {
        var num = 0

        for (b in used) {
            num = num.shl(1)
            if (b) {
                num = num or 1
            }
        }

        return num
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val max = 4
    val total = 6
    val result: Boolean

    result = sol.canIWin(max, total)
    println(result)
}


