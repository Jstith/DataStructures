// Joram Stith
// Data Structures
// Dr. Parker

public class StudentEmailNode {
  /**
  * This class holds the necessary information for a student email node.
  * All class level variables are public, since all can be freely accessed and modified.
  * @param inp_number   Student Number (int)
  * @param inp_name     Student Email Username (string)
  */

  // Class level variables
  public int studentNumber;
  public String emailUserName;

  // Constructor (student number, student email username)
  public StudentEmailNode(int inp_number, String inp_name) {
      studentNumber = inp_number;
      emailUserName = inp_name;
  }

  // toString method with basic information - for debugging
  @Override
  public String toString() {
    return "StudentEmailNode with studentNumber " + Integer.toString(studentNumber) + ", emailUserName " + emailUserName;
  }
}
