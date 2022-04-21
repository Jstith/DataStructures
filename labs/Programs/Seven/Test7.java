// Import statements for writing files
import java.io.PrintWriter;
import java.io.IOException;

// Import statements for reading files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

// Import statements for reading input
import java.util.Scanner;

public class Test7 {

    public static String[] readInts(String fileName) {

		String[] values = new String[5];
	    try {
	    	File inp_file = new File(fileName);
	    	Scanner reader = new Scanner(inp_file);
        for(int x = 0; x < 5; x++) {
	    		values[x] = Integer.toString((Integer.parseInt(reader.nextLine()) * 2));
	    	}
	    	reader.close();
	    }
	    catch(FileNotFoundException e) {
	    	System.out.println("File exception " + e);
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("Invalid input " + e);
	    }
	    return values;
	}

	public static boolean writeInts(String fileName, String[] inputs) {
		try {
		    PrintWriter out = new PrintWriter(fileName);
		    for(int x = 0; x < inputs.length; x++) {
          out.println(inputs[x]);
        }
        out.close();
		    return true;
		}
		catch(IOException e) {
		    System.out.println("Input/output error " + e);
		}
		return false;
	}

	public static void main(String[] args) {
    String[] toWrite = readInts("file.txt");
    writeInts("output.txt", toWrite);
	}
}
