# Data Structures Notebook

By: _Joram Stith_

## Introduction

This document contains a collection of explanations and examples for computationally efficient implementations of fundamental data structures. The following data structures are explained in this document:

- Lists
  - array-based lists
  - linked lists
- Stacks
- Queues
- Binary Search Trees
- AVL Trees
- Heaps (Priority Queues)
- Hashes (Dictionaries)
- Graphs

## Lists

### Array-base List

#### createEmptyList()

```python
def createEmptyList():
  node list[100]
  n = 0
```

#### access(uList, i)

```python
def access(uList, i):
  return list[i]
```

#### length(uList)

```python
def length(uList):
  return n
```

#### isEmptyList(uList)

```python
def isEmptyList(uList):
  return n == 0
```

#### insert(uList, x)

```python
def insert(uList, x):
  list[n] = x
  x += 1
  return uList
```

#### searchFor(uList, key)

```python
def searchFor(uList, key):
  for i in range(n):
    if list[i] == key:
      return i
  return -1
```
