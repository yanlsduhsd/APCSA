//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Lab24d
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner (new File("H:\\APCSA_github\\APCSA\\Unit14\\src\\lab24d.dat"));
		
		int num=file.nextInt();
		file.nextLine();
		
		TicTacToe polk;
		
		for (int i=0; i<num; i++) {
			polk=new TicTacToe(file.nextLine());
			System.out.println(polk);
		}







	}
}



