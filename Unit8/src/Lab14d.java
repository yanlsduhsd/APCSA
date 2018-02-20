//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

public class Lab14d
{
	public static void main( String args[] )
	{
		//add test cases
		Grades monroe = new Grades(new double[]{100,90,85,72.5,95.6});
		System.out.println(monroe);
		monroe.setGrades(new double[]{50,100,80});
		System.out.println(monroe);
		monroe.setGrades(new double[]{93,-90,90});
		System.out.println(monroe);
		monroe.setGrades(new double[]{1,2,3,4,5,6,7,8,9});
		System.out.println(monroe);
	}
}