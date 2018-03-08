//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Monster implements Comparable
{
	private int myWeight;
	private int myHeight;
	private int myAge;

	//write a default Constructor
	public Monster() {
		setAll(0,0,0);
	}


	//write an initialization constructor with an int parameter ht
	public Monster(int ht) {
		setAll(ht,0,0);
	}


	//write an initialization constructor with int parameters ht and wt
	public Monster(int ht, int wt) {
		setAll(ht,wt,0);
	}



	//write an initialization constructor with int parameters ht, wt, and age
	public Monster(int ht, int wt, int age) {
		setAll(ht,wt,age);
	}


	//modifiers - write set methods for height, weight, and age
	public void setHeight(int ht) {
		myHeight=ht;
	}
	public void setWeight(int wt) {
		myWeight=wt;
	}
	public void setAge(int age) {
		myAge=age;
	}
	public void setAll(int ht, int wt, int age) { //I'm lazy.
		myHeight=ht;
		myWeight=wt;
		myAge=age;
	}
	
	//accessors - write get methods for height, weight, and age
	public int getHeight(){
		return myHeight;
	}
	public int getWeight(){
		return myWeight;
	}
	public int getAge(){
		return myAge;
	}
	
	
	//creates a new copy of this Object
	public Object clone()
	{
	   return new Monster(myHeight, myWeight, myAge);
	}

	public boolean equals( Object obj )
	{

		return String.format("%s %s %s", myHeight, myWeight, myAge).equals(obj.toString());
		//return myHeight==obj.getHeight()&&myWeight==obj.getWeight()&&myAge==obj.getAge();
	}

	public int compareTo( Object obj )
	{
		Monster rhs = (Monster)obj;

		if (myHeight>rhs.getHeight()) {
			return 1;
		} else if (myHeight<rhs.getHeight()) {
			return -1;
		}
		if (myWeight>rhs.getWeight()) {
			return 1;
		} else if (myWeight<rhs.getWeight()) {
			return -1;
		}
		if (myAge>rhs.getAge()) {
			return 1;
		} else if (myAge<rhs.getAge()) {
			return -1;
		}


		return 0;
	}

	//write a toString() method
	public String toString(){
		return String.format("%s %s %s", myHeight, myWeight, myAge);
	}
	
}