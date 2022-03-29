// Joram Stith Unordered List Method
// Data Structures
// Dr. Parker

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

  public Node searchRemove(int key) {
    Node temp = head;
    Node tail = null;
    while(temp != null) {
      // Edge cases not addressed
      if(temp.getKey() == key) {
        if(temp.getNext() == null && tail == null) {
          head = null;
        }
        else if(temp.getNext() == null) {
          tail.setNext(null);
        }
        else if(tail == null) {
          head = head.getNext();
        }
        else {
          tail.setNext(temp.getNext());
        }
        return temp;
      }
      tail = temp;
      temp = temp.getNext();
    }
    return null;
  }

  public String printList() {
    String builder = "";
    Node temp = head;
    while(temp != null) {
      builder += Integer.toString(temp.getKey());
      builder += "\n";
      temp = temp.getNext();
    }
    System.out.print(builder);
    return builder;
  }

}
