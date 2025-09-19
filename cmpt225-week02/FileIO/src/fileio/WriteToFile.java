package fileio;
import java.io.*;

public class WriteToFile {

	public static void main(String[] args) throws FileNotFoundException
	{
		
/*		if (args.length != 1)
		{
			System.out.println("number of arguments = " + args.length);
			throw new IllegalArgumentException(args.length + " arguments");
		}
*/	
		File file = new File("c:\\Users\\Kisha\\Desktop\\-=CMPT225\\Lecture03\\src\\write2file.txt");

		PrintWriter output = new PrintWriter(file);

		//write formatted output to the file 
		output.print("Tom Sawyer ");
		output.println(90);
		output.print("Huck Finn ");
		output.println(85);
		output.print("Mary Jane ");
		output.println(99);
		
		PrintStream screenoutput = System.out; 
		screenoutput.println("DDD");

		// Close the file
		output.close();
	}

}
