// Joram Stith Unordered List Method
// Data Structures
// Dr. Parker
// 29MAR2022

public class List {

  private int list_length;
  private Node head;

  public List() {
    head = null;
  }

  public int length() {
    return list_length;
  }

  public boolean isEmptyList() {
    return list_length == 0;
  }

  public void insert(Node x) {
    //Might crash on first iteration
    x.setNext(head);
    head = x;
    list_length++;
  }

  public Node searchReturn(int key) {
    Node temp = head;
    while(temp != null) {
      if(temp.getKey() == key) {
        return temp;
      }
      temp = temp.getNext();
    }
    return null;
  }


  // Holds a second pointer to the previous list element rather than checking one adead of the current
  // Still in O(n), just has different edge case handling.
  public Node searchRemove(int key) {
    Node temp = head;
    Node previous = null;

    while(temp != null) {
      if(temp.getKey() == key) {
        if(temp.getNext() == null && previous == null) {
          head = null;
        }
        else if(temp.getNext() == null) {
          previous.setNext(null);
        }
        else if(previous == null) {
          head = head.getNext();
        }
        else {
          previous.setNext(temp.getNext());
        }
        list_length -= 1;
        return temp;
      }
      previous = temp;
      temp = temp.getNext();
    }
    return null;
  }

  // Modified to print nicely with dictionary class
  public void printList() {
    Node temp = head;
    while(temp != null) {
      System.out.print(Integer.toString(temp.getKey()) + " ");
      temp = temp.getNext();
    }
  }

}
