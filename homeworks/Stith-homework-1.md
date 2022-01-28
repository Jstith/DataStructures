# Homework 1 - Any Size List with Pointers and Nodes

```
2/c Joram Stith
COM 212 Data Structures
Dr. Parker
01FEB2022
```

## Problem 1a:

```
Describe how to use a set of nodes with pointers (as described in class) to implement an unordered list with no size limit.
Determine how to do the following functions: access, length, concat, createEmptyList, isEmptyList, searchFor, remove,
inserti, and insert. How would any of these functions change if the list was to be ordered?
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

Functions:
access(L, i)   		returns xi
length(L)  		returns n
concat(L1, L2)		returns a new list with L2 concatenated on to L1
createEmptyList()	returns a newly created empty list
isEmptyList(L)		returns true if L is empty and false if it is not
searchFor(L, key)	returns i where the key of xi = key
remove(L, i)		returns a list with xi removed
			the old xi+1 is now xi, etc.
inserti(L, i, x)	returns a list with x inserted as xi  
			the old xi is now xi+1, etc.
insert(L, x)		returns a list with x inserted anywhere
			if L is unordered at the proper location (say xi)
			if L is ordered the old xi is now xi+1, etc.
sort(L)			returns the list in sorted order
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
