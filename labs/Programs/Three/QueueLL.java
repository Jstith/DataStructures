// Joram Stith
// Data Structures
// Dr. Parker
// 06APR2022

public class QueueLL {

  private Node p_front;
  private Node p_end;
  private int n;

  public QueueLL() {
      p_front = null;
      p_end = null;
      n = 0;
  }

  public Node front() {
    return p_front;
  }

  public Node dequeue() {
    Node temp = p_front;
    if(p_front == null) {
      return null;
    }
    p_front = p_front.getNext();
    temp.setNext(null);
    n--;
    return temp;
  }

  public void enqueue(Node inp_node) {
    if(p_end != null) {
      p_end.setNext(inp_node);
    }
    else {
      p_front = inp_node;
    }
    p_end = inp_node;
    n++;
  }

  public boolean isEmpty() {
    return p_front == null;
  }

  // Dr. Parker's printQueue method
  // printQueue method for QueueLL
  public void printQueue() {
      System.out.println(n);
      Node temp = p_front;
      while (temp != null) {
          System.out.println(temp.getKey());
          temp = temp.getNext();
      }
  }
}
