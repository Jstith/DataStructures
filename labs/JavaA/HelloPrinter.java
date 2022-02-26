// Import Statements
import java.util.Scanner;

// Main Class
public class HelloPrinter {

  // Implementation using a for loop
  private static void printCount(int n) {
    for(int x = 0; x < 10; x++) {
      if(x % 2 == 0) {
        System.out.print((x/2+n) + " ");
      }
      else if(x % 3 == 0) {
        System.out.print("0 ");
      }
      else {
        System.out.print(x + " ");
      }
    }
    System.out.println();
    return;
  }

  // Implementation using a while loop
  private static void printCountWhile(int n) {
    int x = 0;
    while(x < 10) {
      if(x % 2 == 0) {
        System.out.print((x/2+n) + " ");
      }
      else if(x % 3 == 0) {
        System.out.print("0 ");
      }
      else {
        System.out.print(x + " ");
      }
      x ++;
    }
    System.out.println();
    return;
  }

  // Main method, gets input and calls methods
  public static void main(String[] args) {
    Scanner inp = new Scanner(System.in);

    // For loop input and call
    System.out.println("Enter a number to use in the for-loop function:");
    int input = inp.nextInt();
    printCount(input);

    // While loop input and call
    System.out.println("Enter a number to use in the while-loop function:");
    input = inp.nextInt();
    printCountWhile(5);
  }
}
