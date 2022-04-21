import java.io.PrintWriter;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) {
	try {
	    PrintWriter out = new PrintWriter("input.txt");
	    out.println(44);
	    out.println(67);
	    out.println(-3);
	    out.close();
	}
	catch(IOException e) {
	    System.out.println("Input/output error " + e);
	}
    }
}

	
