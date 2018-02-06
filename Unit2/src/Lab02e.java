//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab02e
{
	public static void main( String[] args )
   {
		//add test cases
		Circle thing = new Circle();
		thing.setRadius(12);
		thing.calculateArea();
		thing.print();
		thing.setRadius(665);
		thing.calculateArea();
		thing.print();
		thing.setRadius(234);
		thing.calculateArea();
		thing.print();
		thing.setRadius(7.4);
		thing.calculateArea();
		thing.print();
		thing.setRadius(0.34564);
		thing.calculateArea();
		thing.print();
		thing.setRadius(4);
		thing.calculateArea();
		thing.print();
		thing.setRadius(5/Math.sqrt(Math.PI));
		thing.calculateArea();
		thing.print();
	}
}