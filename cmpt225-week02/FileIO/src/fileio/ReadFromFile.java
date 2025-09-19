package fileio;
import java.util.Scanner;
import java.io.*;

public class ReadFromFile {

	public static void useBufferedReader(String path) throws Exception {
		BufferedReader input = new BufferedReader(new FileReader(path));
		
		//	read the first line and print it 
		String s = input.readLine();
		System.out.println(s);

		// for other lines parse them into string, string, int 
		s = input.readLine();
		while (s != null) {
			String[] tokens = s.split(" ");
			int grade = Integer.parseInt(tokens[2]);
			System.out.println(tokens[0] + " " + tokens[1] + " " + grade);
			// C-style print format is also possible
//			System.out.printf("%s, %s, %d\n", tokens[0], tokens[1], grade);
			s = input.readLine();
		}
		
		// Close the file
		input.close();
	}

	public static void useScanner(String path)  throws FileNotFoundException{

		File file = new File(path);
		Scanner reader = new Scanner(file);
			
		String s = reader.nextLine();
		System.out.println(s);
		//	read data from the input file 
		while (reader.hasNext()) {
			String firstName = reader.next();
			String lastName = reader.next();
			int grade = reader.nextInt();
			System.out.println(firstName + " "  + lastName + " " + grade);
		}

		// Close the file
		reader.close();

	}

	// If the file cannot be opened the Scanner constructor throws an exception.
	public static void main(String[] args) throws Exception
	{
		
		String path = "c:\\Users\\Kisha\\Desktop\\-=CMPT225\\Lecture03\\src\\mytext.txt";

//		useScanner(path);
		useBufferedReader(path);

	}
}
