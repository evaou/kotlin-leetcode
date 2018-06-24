# Kotlin LeetCode
- [How to Install Kotlin](#how-to-install-kotlin)    
- [How to Run Kotlin Program](#how-to-run-kotlin-program)    
- [LeetCode Problems](#leetcode-problems)   
  - [Brainteaser](#brainteaser)
  - [Minimax](#minimax)
  - [Topological Sort](#topological-sort)
- [Data Structure](#data-structure) 
    - [Linked List](#linked-list)
    - [Hash Table](#hash-table)
    - [Tree](#tree)
    - [Array](#array)
    - [Stack](#stack)
    - [Other](#other)

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
    
## Data Structure

### Linked List
A linked list is represented by a pointer to the first node called **head**.
Each node contains a **data** and a pointer to the **next** node. 
The last node is **null**.
- Dynamic size
- Easy to insert or delete node
- No random access
- Extra memory for pointer
- LeetCode
[2](https://leetcode.com/problems/add-two-numbers/description/),
[21](https://leetcode.com/problems/merge-two-sorted-lists/description/),
[24](https://leetcode.com/problems/swap-nodes-in-pairs/description/),
[160](https://leetcode.com/problems/intersection-of-two-linked-lists/#/description),
[382](https://leetcode.com/problems/linked-list-random-node/description/)

### Hash Table
**Hash table** uses an array to store data with the unique generated index.
**Hash function** converts a key to an array index, 
which easily computes and uniformly distributes the keys.
- Fast insertion or search
- LeetCode
[1](https://leetcode.com/problems/two-sum/description/),
[3](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/),
[12](https://leetcode.com/problems/integer-to-roman/description/),
[13](https://leetcode.com/problems/roman-to-integer/description/),
[37](https://leetcode.com/problems/sudoku-solver/#/description),
[718](https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/),
[746](https://leetcode.com/problems/min-cost-climbing-stairs/description/),
[763](https://leetcode.com/problems/partition-labels/description/),
[767](https://leetcode.com/problems/reorganize-string/description/)

### Tree
The topmost node is called **root**. 
**Parent** and **children** nodes are directly above or under each other.
The node which has no children is called **leave**.
- Hierarchical data
- LeetCode
[113](https://leetcode.com/problems/path-sum-ii/#/description),
[669](https://leetcode.com/problems/trim-a-binary-search-tree/description/),
[684](https://leetcode.com/problems/redundant-connection/description/),
[687](https://leetcode.com/problems/longest-univalue-path/description/)

### Array
**Array** holds a fix number of items with the same type.
- LeetCode
[4](https://leetcode.com/problems/median-of-two-sorted-arrays/description/),
[5](https://leetcode.com/problems/longest-palindromic-substring/description/),
[6](https://leetcode.com/problems/zigzag-conversion/description/),
[7](https://leetcode.com/problems/reverse-integer/description/),
[8](https://leetcode.com/problems/string-to-integer-atoi/description/),
[9](https://leetcode.com/problems/palindrome-number/description/),
[14](https://leetcode.com/problems/longest-common-prefix/description/),
[26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/), 
[27](https://leetcode.com/problems/remove-element/description/),
[28](https://leetcode.com/problems/implement-strstr/description/),
[35](https://leetcode.com/problems/search-insert-position/description/),
[486](https://leetcode.com/problems/predict-the-winner/description/),
[658](https://leetcode.com/problems/find-k-closest-elements/description/),
[733](https://leetcode.com/problems/flood-fill/description/),
[744](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/),
[766](https://leetcode.com/problems/toeplitz-matrix/description/)

### List
**List** can add/remove element and check if the list contains certain element
- LeetCode
[39](https://leetcode.com/problems/combination-sum/description/),
[46](https://leetcode.com/problems/permutations/description/),
[51](https://leetcode.com/problems/n-queens/description/),
[78](https://leetcode.com/problems/subsets/description/),
[329](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/),
[526](https://leetcode.com/problems/beautiful-arrangement/description/)

### Stack
- LeetCode
[20](https://leetcode.com/problems/valid-parentheses/description/),
[32](https://leetcode.com/problems/longest-valid-parentheses/#/description),
[84](https://leetcode.com/problems/largest-rectangle-in-histogram/#/description)

### Other
- LeetCode
[46](https://leetcode.com/problems/permutations/#/description),
[728](https://leetcode.com/problems/self-dividing-numbers/description/)
