//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Student implements Comparable<Student>
{
	private String myName;
	private Grades myGrades;
	
	public Student()
	{
		setName("");
		myGrades = new Grades("");
	}
	
	public Student(String name, String gradeList)
	{

		setName(name);
		myGrades= new Grades(gradeList);

	}
	
	public boolean equals(Student stu) {
		
		return (myName+" = "+myGrades).equals(stu.toString());
		
	}
	
	public void setName(String name)
	{
		myName=name;

	}	
	
	public void setGrades(String gradeList)
	{
		myGrades.setGrades(gradeList);
	
	}
	
	public void setGrade(int spot, double grade)
	{
		myGrades.setGrade(spot, grade);

	}

	public String getName()
	{
		return myName;
	}
	
	public int getNumGrades()
	{
		return myGrades.getNumGrades();
	}

	public double getSum()
	{
		return myGrades.getSum();
	}
	
	public double getAverage()
	{
		return getSum()/getNumGrades();
	}

	public double getAverageMinusLow()
	{
		return (getSum()-getLowGrade())/(getNumGrades()-1);
	}
	
	public double getHighGrade()
	{
		return myGrades.getHighGrade();		
	}
	
	public double getLowGrade()
	{
		return myGrades.getLowGrade();	
	}
	
	public String toString()
	{
		return myName+" = "+myGrades;
	}

	@Override
	public int compareTo(Student stu) {
		// TODO Auto-generated method stub
		if (getAverage()<stu.getAverage()) {
			return -1;
		} else if (getAverage()==stu.getAverage()) {
			return 0;
		} else {
			return 1;
		}
	}

}