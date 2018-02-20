/*

go thru string to get letterMap (HashMap<Char, IntArray>) with start/end index

startIdx = 0
curLetter = S[startIdx]
endIdx = letterMap[curLetter][1]
curIdx = startIdx

while endIdx < S.length

    while curIdx <= endIdx
        curLetter = S[curIdx]
        endIdx = max(endIdx, letterMap[curLetter][1])
        curIdx++

    list.add(endIdx-startIdx+1)

    startIdx = curIdx
    curLetter = S[startIdx]
    endIdx = letterMap[curLetter][1]

 */

class Solution {
    fun partitionLabels(S: String): List<Int> {
        val letterMap = HashMap<Char, IntArray>()
        var letter: Char
        var endIdx = 0
        var curIdx = 0
        var startIdx: Int
        var curLetter: Char
        var partitionLenList: List<Int> = listOf()

        for (i in 0 until S.length) {
            letter = S[i]
            if (!letterMap.contains(letter)) {
                letterMap.put(letter, intArrayOf(i, i))
            } else {
                letterMap.getValue(letter)[1] = i
            }
        }

        while (endIdx < S.length && curIdx < S.length) {
            startIdx = curIdx
            curLetter = S[startIdx]
            endIdx = letterMap.getValue(curLetter)[1]

            while (curIdx <= endIdx) {
                curLetter = S[curIdx]
                endIdx = Math.max(endIdx, letterMap.getValue(curLetter)[1])
                curIdx++
            }

            partitionLenList += listOf(endIdx-startIdx+1)

        }

        return partitionLenList
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val S = "ababcbacadefegdehijhklij"
    val result: List<Int>

    result = sol.partitionLabels(S)
    println(result.toString())
}


