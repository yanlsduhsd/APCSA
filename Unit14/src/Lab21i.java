//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab21i
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file =new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit14\\src\\lab21i.dat"));
		
		Maze Harrison;
		
		while (file.hasNextInt()) {
			int size=file.nextInt();
			file.nextLine();
			Harrison = new Maze(size, file.nextLine());
			System.out.println(Harrison+"\n\n");
		}
	}
}