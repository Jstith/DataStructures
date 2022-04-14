// Joram Stith
// Data Structures
// Dr. Parker

// MODIFIED FOR BST WITH TWO NEXT POINTERS, LEFT AND RIGHT

public class Node {
  /**
  * This class holds the necessary information for a student.
  * All class level variables are private, with accessor and mutator functions available to modify them.
  * @param inp_name     name of student (string)
  * @param inp_ssn      ssn of student (int)
  * @param inp_acid     academic id of student (optional, int)
  * @param inp_compsci  incidates if student is a comp sci major (optional, bool)
  */

  // Class level variables
  private String name;
  private int social_security_num;
  private int academic_id;
  private boolean comp_sci_student;
  private Node left, right;
  private int key;

  // "Bare bones" constructor (name and SSN)
  public Node(String inp_name, int inp_ssn) {
      name = inp_name;
      social_security_num = inp_ssn;
      key = getKey();
  }

  // Overloaded constructor (name, SSN, ac id, comp_sci_student)
  public Node(String inp_name, int inp_ssn, int inp_acid, boolean inp_compsci) {
      name = inp_name;
      social_security_num = inp_ssn;
      academic_id = inp_acid;
      comp_sci_student = inp_compsci;
      key = getKey();
  }

  // Mutator Methods:

  // Mutator to set the next node pointed to
  public void setLeft(Node inp_node) {
    left = inp_node;
  }

   // Mutator to set the next node pointed to
  public void setRight(Node inp_node) {
    right = inp_node;
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
  public Node getLeft() {
    return left;
  }

  // Accessor method to return next node
  public Node getRight() {
    return right;
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
  public int getKey() {
    String value = Integer.toString(social_security_num);
    return Integer.parseInt(value.substring(value.length() - 4));
  }

  // toString method with basic information
  @Override
  public String toString() {
    return "Student Node with name " + name + ", SSN " + social_security_num;
  }
}
