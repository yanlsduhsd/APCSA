//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;
import java.io.File;

public class GradeBookFileRunner
{
   public static void main( String args[] ) throws Exception
   {
	   
	   ArrayList<Class> myClasses = new ArrayList<Class>();
	   
	   out.println("Welcome to the Class Stats program!\n\n");
		
		Scanner file = new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit11\\src\\gradebook.dat"));
		//Class thing = new Class (file.nextLine(), file.nextInt());
		myClasses.add(new Class (file.nextLine(), file.nextInt()));
		
		file.nextLine();
		int counter=0;
		
		while (file.hasNextLine()) {
			//thing.addStudent(counter, new Student(file.nextLine(),file.nextLine()));
			myClasses.get(0).addStudent(counter, new Student(file.nextLine(),file.nextLine()));
			counter++;
		}
		
		//since there is no other input, I will not attempt to enable the addition of more classes.
		
		
		out.println(myClasses.get(0));
		
		myClasses.get(0).sort();
		
		out.println(myClasses.get(0));
		
		out.println("Failure List = " + myClasses.get(0).getFailureList(70));	
		out.println("Highest Average = " + myClasses.get(0).getStudentWithHighestAverage());
		out.println("Lowest Average = " + myClasses.get(0).getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",myClasses.get(0).getClassAverage()));
		
		/*
		out.println(thing);
		
		thing.sort();
		
		out.println(thing);
		
		out.println("Failure List = " + thing.getFailureList(70));	
		out.println("Highest Average = " + thing.getStudentWithHighestAverage());
		out.println("Lowest Average = " + thing.getStudentWithLowestAverage());
								
		out.println(String.format("Class Average = %.2f",thing.getClassAverage()));
		*/
		
		file.close();








	}		
}