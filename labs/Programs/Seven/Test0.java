import java.io.PrintWriter;
import java.io.IOException;

public class Test0 {
    public static void main(String[] args) {
	try {
	    PrintWriter out = new PrintWriter("output.txt");
	    out.println(44);
	    out.close();
	}
	catch(IOException e) {
	    System.out.println("Input/output error " + e);
	}
    }
}

	
