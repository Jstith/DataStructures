public class TestNode {
    public static void main(String[] args){
        
        System.out.println("Node Test Program");
  	Node xNode = new Node("Jane", 123456789);
  	System.out.println("initial xNode");
  	System.out.println(xNode.getName());
  	System.out.println(xNode.getSSN());
  	System.out.println(xNode.getKey());
      
        xNode.setName("Jill");
        xNode.setSSN(987654321);
  	System.out.println("changed xNode");
  	System.out.println(xNode.getName());
  	System.out.println(xNode.getSSN());
  	System.out.println(xNode.getKey());
  	
        Node yNode = new Node("Joe", 934567890);
  	System.out.println("initial yNode");
        System.out.println(yNode.getName());
  	System.out.println(yNode.getSSN());
  	System.out.println(yNode.getKey());
      
        xNode.setNext(yNode);
  	System.out.println("yNode through xNode next");
  	System.out.println(xNode.getNext().getName());
  	System.out.println(xNode.getNext().getSSN());
  	System.out.println(xNode.getNext().getKey());
    }
}

