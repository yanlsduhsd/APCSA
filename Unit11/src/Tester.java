public class Tester
{
   public static void main( String args[] )
   {
		Class test = new Class("Comp Sci 1",9);
		test.addStudent(0,new Student("8","4 - 77 77 77 77"));
		test.addStudent(1,new Student("3","4 - 22 22 22 22"));
		test.addStudent(2,new Student("4","4 - 33 33 33 33"));
		test.addStudent(3,new Student("9","4 - 88 88 88 88"));
		test.addStudent(4,new Student("1","4 - 0 0 0 0"));
		test.addStudent(5,new Student("2","4 - 11 11 11 11"));
		test.addStudent(6,new Student("7","4 - 66 66 66 66"));
		test.addStudent(7,new Student("5","4 - 44 44 44 44"));
		test.addStudent(8,new Student("6","4 - 55 55 55 55"));
		System.out.println(test);
		
		test.sort();
		
		System.out.println(test);
	}		
}