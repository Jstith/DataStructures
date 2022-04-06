// Joram Stith
// Data Structures
// Dr. Parker
// 06APR2022

public class QueueA {

  private Node[] a_arr;
  private int front;
  private int num_elements;

  public QueueA() {
    a_arr = new Node[100];
    front = 0;
    num_elements = 0;
  }

  public boolean isEmpty() {
    return num_elements == 0;
  }

  public Node front() {
    return a_arr[front];
  }

  public Node dequeue() {
    Node ret_node = a_arr[front];
    front = (front + 1) % 100;
    num_elements--;
    return ret_node;
  }

  public void enqueue(Node inp_node) {
    int add_location = (front + num_elements) % 100;
    a_arr[add_location] = inp_node;
    num_elements++;
  }

  // Dr. Parker's method!
  // printQueue method for QueueA
    public void printQueue() {
        int tail = (front + num_elements) % 100;
        System.out.println(front);
        System.out.println(tail);
        if (front <= tail)
           for(int i = front; i < tail; i++)
               System.out.println(a_arr[i].getKey());
        else {
           for(int i = front; i < 100; i++)
               System.out.println(a_arr[i].getKey());
           for(int i = 0; i < tail; i++)
               System.out.println(a_arr[i].getKey());
        }
    }
}
