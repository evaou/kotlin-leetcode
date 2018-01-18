# Kotlin LeetCode
- [How to Install Kotlin](#how-to-install-kotlin)    
- [How to Run Kotlin Program](#how-to-run-kotlin-program)    
- [LeetCode Problems](https://leetcode.com/problemset/all/)    
    * [Linked List](#linked-list)
    * [Hash Table](#hash-table)
    * [Tree](#tree)
    * [Array](#array)
    * [Stack](#stack)
    * [Other](#other)

## How to Install Kotlin

    $ sdk install kotlin 

## How to Run Kotlin Program 
Produce a runnable JAR assembly
+ **-d** indicates what we want the output of the compiler to be called
+ **-include-runtime** makes the resulting .jar file self-contained and runnable by including the Kotlin runtime library in it


    $ kotlinc solution/1_two_sum.kt -include-runtime -d result.jar
    $ java -jar result.jar

Produce a library

    $ kotlinc solution/1_two_sum.kt -d result.jar
    $ kotlin -classpath result.jar _1_two_sumKt
    
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
[160](https://leetcode.com/problems/intersection-of-two-linked-lists/#/description)

### Hash Table
**Hash table** uses an array to store data with the unique generated index.
**Hash function** converts a key to an array index, 
which easily computes and uniformly distributes the keys.
- Fast insertion or search
- LeetCode
[1](https://leetcode.com/problems/two-sum/description/),
[3](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/),
[37](https://leetcode.com/problems/sudoku-solver/#/description)

### Tree
The topmost node is called **root**. 
**Parent** and **children** nodes are directly above or under each other.
The node which has no children is called **leave**.
- Hierarchical data
- LeetCode
[113](https://leetcode.com/problems/path-sum-ii/#/description)

### Array
**Array** holds a fix number of items with the same type.
- LeetCode
[4](https://leetcode.com/problems/median-of-two-sorted-arrays/description/),
[5](https://leetcode.com/problems/longest-palindromic-substring/description/),
[6](https://leetcode.com/problems/zigzag-conversion/description/),
[7](https://leetcode.com/problems/reverse-integer/description/),
[8](https://leetcode.com/problems/string-to-integer-atoi/description/),
[9](https://leetcode.com/problems/palindrome-number/description/)

### Stack
- LeetCode
[32](https://leetcode.com/problems/longest-valid-parentheses/#/description),
[84](https://leetcode.com/problems/largest-rectangle-in-histogram/#/description)

### Other
- LeetCode
[46](https://leetcode.com/problems/permutations/#/description)
