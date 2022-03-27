// Joram Stith
// Data Structures
// Dr. Parker

public class Node {

  // Class level variables
  private String name;
  private int social_security_num;
  private int academic_id;
  private boolean comp_sci_student;
  private Node next;

  // "Bare bones" constructor (name and SSN)
  public Node(String inp_name, int inp_ssn) {
      name = inp_name;
      social_security_num = inp_ssn;
  }

  // Overloaded constructor (name, SSN, ac id, comp_sci_student)
  public Node(String inp_name, int inp_ssn, int inp_acid, boolean inp_compsci) {
      name = inp_name;
      social_security_num = inp_ssn;
      academic_id = inp_acid;
      comp_sci_student = inp_compsci;
  }

  // Mutator Methods:

  // Mutator to set the next node pointed to
  public void setNext(Node inp_node) {
    next = inp_node;
  }

  // mutator to set the SSN
  public void setSSN(int inp_ssn) {
    social_security_num = inp_ssn;
  }

  // mutator to set the name
  public void setName(String inp_name) {
    name = inp_name;
  }

  // Accessor Methods:

  // Accessor method to return next node
  public Node getNext() {
    return next;
  }

  // Accessor to get name
  public String getName() {
    return name;
  }

  // Accessor to get SSN
  public int getSSN() {
    return social_security_num;
  }

  // Accessor to get last 4 of SSN
  public String getKey() {
    String value = Integer.toString(social_security_num);
    return value.substring(value.length() - 4);
  }

  // toString method with basic information
  @Override
  public String toString() {
    return "Student Node with name " + name + ", SSN " + social_security_num;
  }
}
