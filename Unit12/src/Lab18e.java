//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class Lab18e
{
	public static void main( String args[] ) throws IOException
	{

		Scanner file = new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit12\\src\\lab18e.dat"));

		int size = file.nextInt();
		Worde[] list = new Worde[size];
		file.nextLine();
		
		for (int i=0; i<size; i++) {
			list[i] = new Worde(file.nextLine());
		}
		
		Worde temp;
		boolean sorted = false;  //this is still terrible, but who cares.
		while (!sorted) {
			sorted = true;
			for (int i=0; i<list.length-1; i++) {
				if (list[i].compareTo(list[i+1])>0) {
					temp=list[i];
					list[i]=list[i+1];
					list[i+1]=temp;
					sorted = false;
				}
			}
		}
		
		for (int i=0; i<size; i++) {
			System.out.println(list[i]);
		}










	}
}