class Solution {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        var count = 0

        for (i in L..R) {
            if (hasPrimeSetBit(i)) {
                count++
            }
        }

        return count
    }

    fun hasPrimeSetBit(num: Int): Boolean {
        var input = num
        var count = 0
        var tmp = 0
        var isPrime = true

        while (input != 0) {
            tmp = input and 1
            count += tmp
            input = input.shr(1)
        }

        if (count <= 1) {
            return false
        }

        for (i in 2 until count) {
            if (count % i == 0) {
                isPrime = false
                break
            }
        }

        return isPrime
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val L = 10
    val R = 15
    val result: Int

    result = sol.countPrimeSetBits(L, R)
    println(result)
}



