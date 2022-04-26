// Joram Stith
// Data Structures
// Dr. Parker

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.io.IOException;

public class MainUI {

  private Scanner keyboard;
  private boolean inpError;
  private WebHash objHash;

  public MainUI() {
    keyboard = new Scanner(System.in);
  }

  public void load() {
    // Load all data, call mainLoop at end
    System.out.println("load all the data");
    mainLoop();
  }

  public void mainLoop() {
    while(true) {
      clearScreen();
      System.out.println("Welcome to Student Idea Database Manager!");
      System.out.println("Please select an option from the following list:");
      System.out.println("\n________ Student Tasks: ________");
      System.out.println("0.\tView Student");
      System.out.println("1.\tAdd Student");
      System.out.println("2.\tRemove Student");
      System.out.println("3.\tUpdate Student Info");
      System.out.println("4.\tFind Student Login Name");
      System.out.println("\n________ Idea Tasks: ________");
      System.out.println("5.\tAdd Student Idea");
      System.out.println("6.\tGet Global Top Idea");
      System.out.println("7.\tRemove Global Idea");
      System.out.println("\n________ General Tasks: ________");
      System.out.println("8.\tSave Current Data");
      System.out.println("9.\tSave and Exit");
      System.out.println("\nEnter number of choice:");
      int choice = getNumberInput(0, 9);
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public int getNumberInput(int low, int high) {
    boolean inpError;
    int lookupNum = -1;
    do {
      inpError = true;
      System.out.print("> ");
      try {
        String input = keyboard.nextLine();
        lookupNum = Integer.parseInt(input);
        if(lookupNum <= high && lookupNum >= low) {
          inpError = false;
        }
        else {
          System.out.println("Sorry, invalid option. Please try again.");
        }
      }
      catch (NumberFormatException e) {
        System.out.println("Sorry, invalid input. Please try again.");
      }
    } while(inpError);
    return lookupNum;
  }

  public void WebHash_Load() {
    // Rather than clog up RAM with all files loaded at once, read file when function is entered and save and close when function exits.
    // TODO: add function to save or laod all the files from text (for my work, load the hash data)
    System.out.println("Loading email hash database...");
    objHash = new WebHash();
    String line, emailUserName;
    int studentNumber;
    String[] parsed;
    try {
      Scanner reader = new Scanner(new File("data/hashData"));
      while(reader.hasNextLine()) {
        line = reader.nextLine();
        parsed = line.split(",");
        studentNumber = Integer.parseInt(parsed[0]);
        emailUserName = parsed[1];
        objHash.insert(studentNumber, emailUserName);
      }
      reader.close();
    } catch(FileNotFoundException e) {
      System.out.println("There was an error opening the hash data file " + e);
      return;
    }
    System.out.println("... Email hash database successfully loaded!\n");
    // object is not getting treated properly
    // TODO: Fix error here, data is not getting loaded
  }

  public void WebHash_Write() {
    // Rather than clog up RAM with all files loaded at once, read file when function is entered and save and close when function exits.
    // TODO: add function to save or laod all the files from text (for my work, load the hash data)
    System.out.println("Saving email hash database...");

    try (PrintWriter writer = new PrintWriter("data/hashData")) {
      String[] data = objHash.printWrite();
      for(int x=0; x < data.length; x++) {
        writer.println(data[x]);
      }
      writer.close();
    } catch(IOException e) {
      System.out.println("There was an error opening the hash data file " + e);
      return;
    }
    System.out.println("... Email hash database successfully saved!\n");
  }

  public void WebHash_Interact() {

    // MUST RUN WebHash_Load FIRST!
    System.out.println("________ Student Email Login Lookup ________");
    System.out.println("Enter student number to receive their email login name in stunning O(1) average time!");
    int lookup_num = -1;
    do {
      inpError = true;
      System.out.print("> ");
      try {
        String input = keyboard.nextLine();
        System.out.print("got input: ");
        System.out.println(input);
        lookup_num = Integer.parseInt(input);
        inpError = false;
      }
      catch (NumberFormatException e) {
        System.out.println("Sorry, invalid input. Please try again.");
      }
    } while(inpError);
    System.out.println(lookup_num);
    String loginName = objHash.lookUp(lookup_num);
    System.out.println("Email login for key " + Integer.toString(lookup_num) + " is:\t" + loginName);
  }

  public static void main(String[] args) {
    MainUI run = new MainUI();
    run.load();
    // to test: WebHash.insert()
    //TODO: Maybe move this to a whole new file.
    // yuh.WebHash_Load();
    // yuh.WebHash_Interact();
    // yuh.WebHash_Write();
  }
}
