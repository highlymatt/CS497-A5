#CS497 - Assignment 5
Matthew Jelonek

## 1) Remove Invalid Parenthesis

- make a hashSet to keep track of all strings visited
- make a queue and store initial string in queue
- use bfs to traverse through string
- generate all possible states of string polled for queue by removing each parenthesis from the current string one at a time and storing it in queue
- keep checking until string is valid and store valid string in ArrayList
- return result

Time complexity:  O(n*2^n)
Space complexity:  O(n)

## 2) Maximum Absolute Difference in BST

- store min and prev as global variables
- use dfs to traverse through the tree
- as do inorder traversal store the previous val in prev
- compare the difference and store the smaller value in min
** You only need to calculate and compare the parent and children nodes since a BST stores smaller values to the left and larger to the right**
- return min

Time complexity: O(n)  
Space complexity: O(1)  

## 3) Shortest Path Visiting all Nodes

- Make a queue and have it store arrays that stores the index of the node and BitState
- Add all the nodes index's and BitStates into the queue. ex) {index, Bitstate}
- Create a 2d array to keep track of all the nodes that are visited
- have a counter for shortest path
- use an alternate form of BFS that allows you to revisit nodes but will not run into an infinite loop thanks to a Record of current nodes and their BitState
- once BitSate == endState, meaning all nodes have been visited, return shortest path counter

Time complexity:O(n*2^n)   
Space complexity: O(n*2^n)  

## 4) Binary Tree Maximum Path Sum

- use DFS to traverse the BT
- keep track of the maximum Sum from the left and right nodes
- update maxSum if curr sum is >
- return largest sum depending on which children (left or right) has the bigger sum and continue to travers the tree

Time complexity: O(n)  
Space complexity:  O(1)  

## 5) Lexicographical Numbers

naive approach:
- generate list of numbers stored as strings
- Then use Arrays.sort (Quicksort) to sort the array in lexicographical order
- return array

Using DFS:
- pass the current value, size of array (n), and ArrayList into a dfs function
- Base case: if current value > n return. **The lexicographical numbers are out of range**
- add current value to list
- recursively call dfs updating current value by multiplying the value by 10. (The next smallest number in lex order)
- repeat until base case is met
- Start increasing curr value by 1 if curr%10 != 9
- return arraylist

Time complexity: O(n)  
Space complexity: O(1)  

