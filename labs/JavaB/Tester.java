import java.util.Scanner;

public class Tester {
	
	private static Student[] fillMain(Student[] inpArr) {
		
		Scanner keyboard = new Scanner(System.in);
		String inpName;
		int inpGrade;

		for(int x = 0; x < 5; x++) {
			
			System.out.println("Enter student name for student #" + x);
			inpName = keyboard.next();

			System.out.println("Enter student grade for student #" + x);
			inpGrade = keyboard.nextInt();

			inpArr[x] = new Student(inpName, inpGrade);
		}
		return inpArr;
	}

	public static void main(String[] args) {
		Student[] classMembers = new Student[5];
		fillMain(classMembers);

		// Test Commands
		System.out.println("Testing commands (running without error shows successful propagation of array:");

		System.out.println(classMembers[0].getGrade());
		System.out.println(classMembers[1].getName());
		classMembers[2].setGrade(95);
		classMembers[3].setName("Bob");
		System.out.println(classMembers[4].getGrade());
	}
}