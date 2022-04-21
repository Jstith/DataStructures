// Import statements for writing files
import java.io.PrintWriter;
import java.io.IOException;

// Import statements for reading files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Test4 {
    
    public static String readInts(String fileName) {
		
		String builder = new String();
	    try {
	    	File inp_file = new File(fileName);
	    	Scanner reader = new Scanner(inp_file);
	    	while(reader.hasNextLine()) {
	    		builder += Integer.toString((Integer.parseInt(reader.nextLine()) * 2));
	    		builder += "\n";
	    	}
	    	reader.close();
	    }
	    catch(FileNotFoundException e) {
	    	System.out.println("File exception " + e);
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("Invalid input " + e);
	    }

	    return builder;
	}

	public static boolean writeInts(String fileName, String input) {

		try {
		    PrintWriter out = new PrintWriter(fileName);
		    out.println(input);
		    out.close();
		    return true;
		}
		catch(IOException e) {
		    System.out.println("Input/output error " + e);
		}
		return false;
	}

	public static void main(String[] args) {
		readInts("input.txt");
		writeInts("output.txt");
	}
}