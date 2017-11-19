# Kotlin LeetCode
- [How to Run Kotlin Program](#how-to-run-kotlin-program)    
- [LeetCode Problems by Data Structure](#data-structure)    

## How to Run Kotlin Program 
Produce a runnable JAR assembly

    $ kotlinc 1_two_sum.kt -include-runtime -d result.jar
    $ java -jar result.jar

## Data Structure
- [Linked List](#linked-list)
- [Hash Table](#hash-table)
- [Tree](#tree)
- [Stack](#stack)
- [Other](#other)

### Linked List
A linked list is represented by a pointer to the first node called **head**.
Each node contains a **data** and a pointer to the **next** node. 
The last node is **null**.
- Dynamic size
- Easy to insert or delete node
- No random access
- Extra memory for pointer
- LeetCode
[160](https://leetcode.com/problems/intersection-of-two-linked-lists/#/description)

### Hash Table
**Hash table** uses an array to store data with the unique generated index.
**Hash function** converts a key to an array index, 
which easily computes and uniformly distributes the keys.
- Fast insertion or search
- LeetCode
[1](https://leetcode.com/problems/two-sum/description/)
[37](https://leetcode.com/problems/sudoku-solver/#/description)

### Tree
The topmost node is called **root**. 
**Parent** and **children** nodes are directly above or under each other.
The node which has no children is called **leave**.
- Hierarchical data
- LeetCode
[113](https://leetcode.com/problems/path-sum-ii/#/description)

### Stack
- LeetCode
[32](https://leetcode.com/problems/longest-valid-parentheses/#/description),
[84](https://leetcode.com/problems/largest-rectangle-in-histogram/#/description)

### Other
- LeetCode
[46](https://leetcode.com/problems/permutations/#/description)