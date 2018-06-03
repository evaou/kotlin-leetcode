class Solution {
    fun integerReplacement(n: Int): Int {
        // iteration
        var num = n.toLong()
        var count = 0

        while (num > 1) {
            count++

            if (num and 1.toLong() == 1.toLong()) {
                if (((num+1) % 4 == 0.toLong()) && (num != 3.toLong())) {
                    num++
                } else {
                    num--
                }
            } else {
                num = num.shr(1)
            }
        }

        return count

        /* recursion
        if (n == 1) {
            return 0
        }

        if (n % 2 == 0) {
            return 1 + integerReplacement(n/2)
        }

        val num = n.toDouble()
        val a = (num-1)/2
        val b = (num+1)/2
        return 2 + Math.min(integerReplacement(a.toInt()), integerReplacement(b.toInt()))
        */
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val n = 1234 //65535 //7
    val result: Int

    result = sol.integerReplacement(n)
    println(result)
}

