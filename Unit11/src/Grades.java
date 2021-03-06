//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	//private double[] grades;
	private ArrayList<Double> grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		Scanner thing = new Scanner(gradeList);
		//grades = new double[thing.nextInt()];
		grades = new ArrayList<Double>();
		thing.next();
		thing.next();
		/*for (int i=0; i<grades.length; i++) {
			grades[i]=thing.nextDouble();
		}*/
		while (thing.hasNextDouble()) {
			grades.add(thing.nextDouble());
		}
		
		thing.close();

	}
	
	public void setGrade(int spot, double grade)
	{

		//grades[spot]=grade;
		grades.set(spot, grade);

	}
	
	public double getSum()
	{
		double sum=0.0;

		/*for (int i=0; i<grades.length; i++) {
			sum+=grades[i];
		}*/
		for (int i = 0; i<grades.size(); i++) {
			sum+=grades.get(i);
		}


		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;

		/*for (int i=0; i<grades.length; i++) {
			if (grades[i]<low) {
				low=grades[i];
			}
		}*/
		for (int i=0; i<grades.size(); i++) {
			if (grades.get(i)<low) {
				low=grades.get(i);
			}
		}



		return low;
	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;


		/*for (int i=0; i<grades.length; i++) {
			if (grades[i]>high) {
				high=grades[i];
			}
		}*/
		for (int i=0; i<grades.size(); i++) {
			if (grades.get(i)>high) {
				high=grades.get(i);
			}
		}


		return high;
	}
	
	public int getNumGrades()
	{
		//return grades.length;
		return grades.size();
	}
	
	public String toString()
	{
		String output="";
		/*for (int i=0; i<grades.length; i++) {
			output+=grades[i] + " ";
		}*/
		for (int i = 0; i<grades.size(); i++) {
			output+=grades.get(i)+" ";
		}




		return output;
	}	
}