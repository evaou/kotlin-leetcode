# Kotlin LeetCode
- [How to Install Kotlin](#how-to-install-kotlin)    
- [How to Run Kotlin Program](#how-to-run-kotlin-program)    
- [LeetCode Problems](#leetcode-problems)  
  - [Bit Manipulation](#bit-manipulation) 
  - [Brainteaser](#brainteaser)
  - [Minimax](#minimax)
  - [Topological Sort](#topological-sort)

## How to Install Kotlin

    $ sdk install kotlin 

## How to Run Kotlin Program 
Compile a application

    $ kotlinc solution/1_two_sum.kt -include-runtime -d result.jar
    $ java -jar result.jar

+ **-include-runtime** makes the resulting .jar file self-contained and runnable by including the Kotlin runtime library in it
+ **-d** indicates what we want the output of the compiler to be called

Compile a library

    $ kotlinc solution/1_two_sum.kt -d result.jar
    $ kotlin -classpath result.jar _1_two_sumKt

## [LeetCode Problems](https://leetcode.com/problemset/all/)

### [Bit Manipulation](https://leetcode.com/tag/bit-manipulation/)
- shr()/shl() moves one bit right/left
- Bit operators are and/or/xor/inv()
- a^b = x <=> a^x = b
- (a^b)^b = a <=> a^0 = a
- a = a^a^a
- n and  -n: get the rightmost set bit
- n's 1 bit count = (n/2)'s 1 bit count + (n and 1)
- 2's complement = n.inv() + 1
- Hamming distance is the bit count at which position the two integer's bits are different
- Total hamming distance is the sum of 0 bit count timing 1 bit count at each bit position
- UTF-8 (8-bit Unicode Transformation Format) has 1-4 bytes, 1 byte has highest 0 bit. 
For n (2/3/4) bytes, the first byte has n highest 1 bits and prefix 01 bits for the following n-1 bytes
- Moore's voting algorithm: cancel out two different elements, the remaining one is 

### [Brainteaser](https://leetcode.com/tag/brainteaser/)

### [Heap](https://leetcode.com/tag/heap/)
- java.util.PriorityQueue
- use poll() instead of checking the data structure

### [Linked List](https://leetcode.com/tag/linked-list/)
- quotient (/) and remainder (%)
- java.util.Stack
- find middle node by 2-step move pointer

### [Minimax](https://leetcode.com/tag/minimax/)
Minimax is to minimize the possible loss for a worst case scenario. 
There are two players who both play optimally. 
The **maximizer** tries to get the highest score while the **minimizer** tries to get the lowest score. 
The solution is to use recursion with memorization.

### [Queue](https://leetcode.com/tag/queue/)

### [Topological Sort](https://leetcode.com/tag/topological-sort/)
Topological Sort is for DAG (Directed Acyclic Graph) and is a linear ordering of vertices in which every directed edge has the first vertex come before the second vertex.
The solution is based on DFS (Depth First Search) and pushes a vertex into stack when all of its adjacent vertices are in stack.
DAG is represented with adjacency list.
    






