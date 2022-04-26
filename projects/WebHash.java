// Joram Stith
// Data Structures
// Dr. Parker

public class WebHash {

	private StudentEmailNode[] dict_primary;
	private int n;
  private int size = 511;

	public WebHash() {
		dict_primary = new StudentEmailNode[size];
		n = 0;
	}

	public boolean isEmptyDict() {
		return n==0;
	}

  // Generates both hashes for double hashing algorithm
	private int[] hashes(int key) {
    int[] builder = new int[2];
    builder[0] = key % size;
		int hash2;
		for(hash2 = 0; key != 0; key /= 10) {
			hash2 += key % 10;
		}
    builder[1] = hash2;
		return builder;
	}

  // Method to add a new StudentEmailNode to the hash
	public void insert(int studentNumber, String emailUserName) {
    StudentEmailNode student = new StudentEmailNode(studentNumber, emailUserName);
    int[] hash = hashes(studentNumber);

		// Double hashes key
		int indexAddress = (hash[0] + hash[1]) % size;
    while(dict_primary[indexAddress] != null) {
      indexAddress = (indexAddress + hash[1]) % size;
    }
		dict_primary[indexAddress] = student;
		n++;
	}

	public String lookUp(int studentNumber) {
    System.out.println("in method");
    // Double hashes key
    int[] hash = hashes(studentNumber);
    System.out.println("uh oh");
		int indexAddress = (hash[0] + hash[1]) % size;
    int counter = 0;

    while(true) {

      System.out.println("caught in the while");
      // Cover edge case where node(s) causing collision was removed
      if(dict_primary[indexAddress] == null) {
        System.out.println("null found");
        indexAddress = (indexAddress + hash[1]) % size;
      }
      // Finds matching email username based on student number
      else if(dict_primary[indexAddress].studentNumber == studentNumber) {
        System.out.println("found it");
        return dict_primary[indexAddress].emailUserName;
      }
      // Break condition
      else {
        System.out.println("break condition");
        if(counter++ == size) {
          return ("Email Username for " + Integer.toString(studentNumber) + " not Found in Database.\n");
        }
      }
    }
	}

	public void delete(int studentNumber) {

    // Double hashes key
    int[] hash = hashes(studentNumber);
		int indexAddress = (hash[0] + hash[1]) % size;
    int counter = 0;

    while(true) {
      // Cover edge case where node(s) causing collision was removed
      if(dict_primary[indexAddress] == null) {
        indexAddress = (indexAddress + hash[1]) % size;
      }
      // Finds and removes matching email username based on student number
      else if(dict_primary[indexAddress].studentNumber == studentNumber) {
        dict_primary[indexAddress] = null;
        return;
      }
      // Break condition
      else {
        if(counter++ == size) {
          return;
        }
      }
    }
  }

  public String[] printWrite() {
    String[] output = new String[size];
    for(int x = 0; x < size; x++) {
      output[x] = Integer.toString(dict_primary[x].studentNumber) + "," + dict_primary[x].emailUserName;
    }
    return output;
  }
}
