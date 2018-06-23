class Solution {
    fun maxProduct(words: Array<String>): Int {
        var max = 0
        val newWords = IntArray(words.size){0}
        var word: String
        var tmp: Int

        for (i in 0 until words.size) {
            word = words[i]
            for (j in 0 until word.length) {
                newWords[i] = newWords[i] or 1.shl(word[j]-'a')
            }
        }

        for (i in  0 until newWords.size) {
            for (j in i+1 until newWords.size) {
                tmp = newWords[i] and newWords[j]
                if (tmp == 0) {
                    max = Math.max(max, words[i].length * words[j].length)
                }
            }
        }

        return max
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val words = arrayOf("a","ab","abc","d","cd","bcd","abcd")
    val result: Int

    result = sol.maxProduct(words)
    println(result)
}

