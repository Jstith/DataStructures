public class Student {

	private String name;
	private int grade;

	public Student(String inpName, int inpGrade) {
		name = inpName;
		grade = inpGrade;
	}

	// Accessors
	public int getGrade() {
		return grade;
	}

	public String getName() {
		return name;
	}

	// Mutators
	public void setGrade(int inpGrade) {
		grade = inpGrade;
	}

	public void setName(String inpName) {
		name = inpName;
	}
}