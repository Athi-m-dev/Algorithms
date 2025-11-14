# Introduction 
 --  Understand what heaps are and how they work
 --  Explore the benefits of using heaps.
 --  Cover complete theory and code implementation of heaps.
 --  Learn about heap sort, priority queue, and custom implementation of heaps.

# What is a Heap?
 -- Heaps allow for storing and searching elements based on a specific criteria.
 -- Storing elements in an array or tree are common methods.
    -- A heap is a specialized tree-based data structure that satisfies the heap property.

# Why Use a Heap?
 -- Heaps are useful when you need to frequently access the smallest (or largest) element in a collection.
 -- They provide efficient insertion and deletion operations, making them ideal for priority queues and scheduling tasks.
 -- Inserting and sorting an item in an array takes O(n log n) time
 -- The main purpose of a data structure is to retrieve queries in constant time
 -- The problem is that inserting an item in the current data structure takes a lot of time
 -- To reduce the insertion time, the solution is to use a heap data structure
 -- Using heaps, the insertion time can be reduced to O(log n)

# Heap Structure
 -- A heap is a specialized tree-based data structure that satisfies the heap property.
 -- In a max-heap, for any given node, the value of the node is greater than or equal to the values of its children.
 -- In a min-heap, for any given node, the value of the node is less than or equal to the values of its children.
 -- Heaps are typically implemented as binary trees, where each parent node has at most two children.
 -- Heaps are often represented as arrays for efficient storage and access.

# The logic behind representing the array as a tree
    -- The root element will be at index 0
    -- For any given node at index i:
        -- The left child will be at index 2*i + 1
        -- The right child will be at index 2*i + 2
        -- The parent node will be at index (i - 1) / 2 (using integer division)
    -- This representation allows for efficient access and manipulation of the heap elements.

# Minimum and Maxheap violation due to inserted item
 -- In a min-heap, if a new element is inserted that is smaller than the current minimum, the heap property is violated.
 -- In a max-heap, if a new element is inserted that is larger than the current maximum, the heap property is violated.




# Inserting and Removing Elements in a Heap
 -- Insertion in a heap involves using the upheap method and has a complexity of log n.
 -- Removing an element from a heap involves rebalancing the heap to ensure the next smallest item is on top.



 
