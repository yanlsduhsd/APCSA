//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;
import java.lang.Math;
import java.util.Scanner;

public class Grades
{
	//instance variables
	
	double[] thing;

	//constructor

	public Grades() {
		setGrades(new double[]{});
	}
	
	public Grades(double[] arr) {
		setGrades(arr);
	}

	//set method
	public void setGrades(double[] arr) {
		thing=arr;
	}


	private double getSum()
	{
		double sum=0.0;

		for (double i: thing) {
			sum+=i;
		}


		return sum;
	}

	public double getAverage()
	{
		double average=0.0;

		average=getSum()/thing.length;

		return average;
	}


	public String toString() {
		String output = "";
		for (int i=0; i<thing.length; i++) {
			output+=String.format("grade %s :: %.2f\n",i,thing[i]);
		}
		output+=String.format("\naverage = %.2f\n\n",getAverage());
		return output;
	}
	


}