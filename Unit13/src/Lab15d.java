//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class Lab15d
{
	public static void main( String args[] ) throws IOException
	{
		FancyWords jackson=new FancyWords("");
		Scanner file =new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit13\\src\\lab15d.dat"));
		for (int i = file.nextInt(); i>=0; i--){
			jackson.setWords(file.nextLine());
			System.out.println(jackson);
		}
		file.close();




	}
}