//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Class
{
	private String name;
	//private Student[] studentList;
	private ArrayList<Student> studentList = new ArrayList<Student>();
	
	public Class()
	{
		name="";
		//studentList=new Student[0];
	}
	
	public Class(String cName, int stuCount)
	{
		name=cName;
		//studentList=new Student[stuCount];
		for (int i=0; i<stuCount; i++){
			studentList.add(null);
		}
	
	}
	
	public void addStudent(int stuNum, Student s)
	{
		//studentList[stuNum]=s;
		studentList.set(stuNum, s);

	}
	
	public String getClassName()
	{
	   return name;	
	}
	
	public double getClassAverage()
	{
		double classAverage=0.0;
		
		/*for (int i=0; i<studentList.length; i++) {
			classAverage+=getStudentAverage(i);
		}
		classAverage/=studentList.length;*/
		for (int i=0; i<studentList.size(); i++) {
			classAverage+=getStudentAverage(i);
		}
		classAverage/=studentList.size();

		return classAverage;
	}
	
	public double getStudentAverage(int stuNum)
	{
		//return studentList[stuNum].getAverage();
		return studentList.get(stuNum).getAverage();
	}

	public double getStudentAverage(String stuName)
	{
		int index=0;
		/*for (int i=0; i<studentList.length; i++) {
			if (getStudentName(i).equals(stuName)) {
				index=i;
				break;
			}
		}*/
		for (int i=0; i<studentList.size(); i++) {
			if (getStudentName(i).equals(stuName)) {
				index=i;
				break;
			}
		}


		//return studentList[index].getAverage();
		return studentList.get(index).getAverage();
	}
	
	public String getStudentName(int stuNum)
	{
		//return studentList[stuNum].getName();
		return studentList.get(stuNum).getName();
	}

	public void sort() {
		/*Student temp;
		boolean sorted = false; 
		while (!sorted) {
			sorted = true;
			//for (int i=0; i<studentList.length-1; i++) {
			//	if (studentList[i].compareTo(studentList[i+1])>0) {
			//		temp=studentList[i];
			//		studentList[i]=studentList[i+1];
			//		studentList[i+1]=temp;
			//		sorted = false;
			//	}
			//}
			for (int i=0; i<studentList.size()-1; i++) {
				if (studentList.get(i).compareTo(studentList.get(i+1))>0) {
					studentList.add(i+2,studentList.get(i));
					studentList.remove(i);
					sorted = false;
				}
			}
		}*/
		Collections.sort(studentList);
	}
		
	/*public String getStudentWithHighestAverage()
	{
		double high = Double.MIN_VALUE;
		String hName ="";

		for (int i=0; i<studentList.length; i++) {
			if (getStudentAverage(i)>high) {
				high=getStudentAverage(i);
				hName=getStudentName(i);
			}
		}
		



		return hName;
	}*/

	/*public String getStudentWithLowestAverage()
	{
		double low = Double.MAX_VALUE;
		String lName ="";		

		for (int i=0; i<studentList.length; i++) {
			if (getStudentAverage(i)<low) {
				low=getStudentAverage(i);
				lName=getStudentName(i);
			}
		}




		return lName;
	}*/
	
	public String getStudentWithHighestAverage()
	{
		int index=0;

		for (int i=0; i<studentList.size()-1; i++) {
			if (studentList.get(i).compareTo(studentList.get(i+1))==-1) {
				index=i+1;
			}
		}
		return getStudentName(index);
	}
	
	public String getStudentWithLowestAverage()
	{
		int index=0;

		for (int i=0; i<studentList.size()-1; i++) {
			if (studentList.get(i).compareTo(studentList.get(i+1))==1) {
				index=i+1;
			}
		}
		return getStudentName(index);
	}
	
	public String getFailureList(double failingGrade)
	{
		String output="";
		
		/*for (int i=0; i<studentList.length; i++) {
			if (getStudentAverage(i)<failingGrade) {
				output+=getStudentName(i)+" ";
			}
		}*/
		for (int i=0; i<studentList.size(); i++) {
			if (getStudentAverage(i)<failingGrade) {
				output+=getStudentName(i)+" ";
			}
		}



		return output;
	}
	
	public String toString()
	{
		String output=""+getClassName()+"\n";

		/*for (int i=0; i<studentList.length; i++) {
			output+=String.format(studentList[i] +"\t%.2f\n",getStudentAverage(i));
		}*/
		for (int i=0; i<studentList.size(); i++) {
			output+=String.format(studentList.get(i) +"\t%.2f\n",getStudentAverage(i));
		}



		return output;
	}  	
}