// Import statements for writing files
import java.io.PrintWriter;
import java.io.IOException;

// Import statements for reading files
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

public class Test3 {
    public static void main(String[] args) {
	    String builder = new String();

	    try {
	    	File inp_file = new File("input.txt");
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


		try {
		    PrintWriter out = new PrintWriter("output.txt");
		    out.println(builder);
		    out.close();
		}
		catch(IOException e) {
		    System.out.println("Input/output error " + e);
		}
	}
}

	
