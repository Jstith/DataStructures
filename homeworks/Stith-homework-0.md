# Homework 0 - Set Size Lists with Arrays and Nodes

```
2/c Joram Stith
COM 212 Data Structures
Dr. Parker
27JAN2022
```

## Problem:

```
Describe how to use an array to implement an unordered list of nodes (as described in class).
Assume the max number of nodes (elements) is 100. Determine how to do the following functions:
access, length, concat, createEmptyList, isEmptyList, searchFor, remove, inserti, and insert.
How would any of these functions change if the list was to be ordered?
```

This additional information is provided about the definition of a list and functions for a list:

```
Lists

List L = x0  x1  x2  x3 ... xn-1     n =  # elements
If a list is ordered than the key of xi-1 <= the key of xi for all i where
0 < i < n.
The sort symbol <= can be replaced by >= or any other function that
determines ordering in the keys.
An unordered does not have this restriction.
```

| Functions         | Definitions                                                                                                                            |
|:----------------- |:-------------------------------------------------------------------------------------------------------------------------------------- |
| access(L, i)      | returns xi                                                                                                                             |
| length(L)         | returns n                                                                                                                              |
| concat(L1, L2)    | returns a new list with L2 concatenated on to L1                                                                                       |
| createEmptyList() | returns a newly created empty list                                                                                                     |
| isEmptyList(L)    | returns true if L is empty and false if it is not                                                                                      |
| searchFor(L, key) | returns i where the key of xi = key                                                                                                    |
| remove(L, i)      | returns a list with xi removed the old xi+1 is now xi, etc.                                                                            |
| inserti(L, i, x)  | returns a list with x inserted as xi the old xi is now xi+1, etc.                                                                      |
| insert(L, x)      | returns a list with x inserted anywhere if L is unordered at the proper location (say xi) if L is ordered the old xi is now xi+1, etc. |
| sort(L)           | returns the list in sorted order                                                                                                       |

## Solution

### Declaration

To begin, if we want to make a list that can hold up to 100 nodes, we must set aside space in memory equal to 100 * the size of a node (we'd also need some space for storing temporary values and pointers, but we'll get there later). So, if your node is 64 bits large, you'd need to allocate 6,400 bits of storage as an array to hold the elements of the list. As elements are added to the list (the size of the list changes), values will be added to the array from smallest memory location to largest (while the size of the list may appear to change, the size of the array holding the list's content won't).

### access(L, i)

_returns xi_

To access an element in a list, the function must receive a pointer to the array in memory (L) and an index to find in the list (i). Then, the function would go through the memory until it reaches the `node size * i` memory address, from which it would return the next `node size` bits of data.

#### Ordered vs Unordered

This function is unchanged if the list is ordered or not, since the index doesn't care what's at that memory location, just where it is relative to memory addresses.

### length(L)

_returns n_

To find the length of the list, the function must receive a pointer to the array in memory (L). Then, the function would go through the array `node size` bits at a time, and see if the memory is holding a value (note zero or null is a value, looking for defined vs undefined). When the function finds the last memory space filled (find the empty one and subtract `node size`), return `(final memory address - initial memory address) / node size`.

#### Ordered vs Unordered

This function is unchanged if the list is ordered or not, because the values of the list will still populate the smallest possible memory addresses in the array (even if they're random in the list).

### concat(L1, L2)

_returns a new list with L2 concatenated on to L1_

To concat two lists, the function must receive pointers to two lists in memory. Then, the function must do the following:

- Determine how much space is left in the array holding L1
- Create a new array in memory
- Copy all values from L1 to the new list
- Starting at the next empty array slot, start copying values from L2 one at a time to the new list.
- Continue until either L2 is out of defined elements or the new list hits 100 elements.
- Return the new list

#### Ordered vs Unordered

This function is unchanged if the list is ordered or not for the same reason that the length function is unchanged.

### createEmptyList()

_returns a newly created empty list_

This function does the same thing as the [declaration paragraph](#Declaration).

### isEmptyList(L)

_returns true if L is empty and false if it is not_

This function behaves similarly to parts of the concat function. Given a pointer to a list in memory (L), the function must go through each index of the array holding the list and check if there's a defined value in it (a set of data that matches the shape of a node). As soon as it finds one, it can return `True`. If the check reaches `start address + 100 * node size` and still hasn't found a defined value, it can return `False`.

### searchFor(L, key)

_returns i where the key of xi = key_

This function must do the following:

- Start at the lowest memory address in the array's space
- Go one array block at a time comparing the value in the block to the pointed at value from the function (L), advancing `node size` bits each time
- When the function finds the first instance where L is equal to the stored value, return `(largest attempted memory address - base memory address) / node size`.

#### Ordered vs Unordered

This function can be implemented differently if the list is ordered. Rather than just checking for a matching value, the function can perform a mathematical comparison on the data in the array block, and as soon as it reaches a value greater than L, the function can return early and return null, -1, or whatever indicates the element is not in the list.

### remove(L, i)

_returns a list with xi removed the old xi+1 is now xi, etc._

This function must do the following:

- Jump to `base memory address + node size * i`
- Remove all data from that entry
- Use the length() function to find the end of the array
- Iterate through the rest of the memory addresses from i to the result of length()
  - Copy the data to a temporary location
  - Move the data from the placeholder to the array slot behind it

### inserti(L, i, x)

_returns a list with x inserted as xi the old xi is now xi+1, etc._

This function is not dependent on if the list is ordered or not. The function must do the following:

- jump to the memory location `base memory address + node size * i`
- copy the current node there to a temporary location
- replace the current node with x
- Use the length() function to find the end of the array
- Iterate through the rest of the memory addresses from i to the result of length()
  - Copy the data to a temporary location (will need two in total)
  - Replace the copied data with the data in the currently used temporary store
    - A bit can be used to indicate which temporary store is currently holding the data to be copied, or a comparison to null can be made (less efficient)

### insert(L, x)

_returns a list with x inserted anywhere if L is unordered at the proper location (say xi) if L is ordered the old xi is now xi+1, etc._

#### Unordered

The function can do the following:

- Call the length() function to figure out where the end of the list is in the array
- Go to the memory address `base memory address + 100 * (length() + 1)`
- Insert x into that memory address (if it's not 100)
- Return the list

#### Ordered

The function can do the following:

- Using the same process as searchFor(), start at the beginning of the array and compare each value to L.
- As soon as there is a value larger than L, set a variable i to `(current memory address - base memory address) / node size) - 1`
- Call the inserti() function using L, i, and x.

### Other notes

There are other instances where using the length() function could lower the number of comparisons necessary to complete the function. If programming for speed and efficiency, use length() as your upper bound instead of 100 whenever possible.

Ordered and unordered in this assignment are in reference to the logical ordering of the data in the list (e.g. numbers going from small to large), not the location of the list elements in the array holding them (I don't see why that would ever be "randomly" assigned).
