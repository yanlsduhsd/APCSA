import java.util.Arrays;

public class Numbers {
	public static void main(String[] args) {
		System.out.println(isGoofy(12));
		System.out.println(isGoofy(15));
		System.out.println(isGoofy(26));
		System.out.println(isGoofy(8));
		System.out.println(isGoofy(1234));
		System.out.println(isGoofy(0));
		System.out.println(Arrays.toString(getSomeGoofyNumbers(3)));
		System.out.println(Arrays.toString(getSomeGoofyNumbers(15)));
	}
	public static boolean isGoofy(int num) {
		String numstring = ""+num;
		int sum=0;
		for (int i=0; i<numstring.length(); i++) {
			if (((int)numstring.charAt(i)-48)!=0&&num%((int)numstring.charAt(i)-48)==0) {
				sum+=(int)numstring.charAt(i)-48;
			}

		}
		
		if (sum%2==1) {
			return true;
		}
		return false;
	}
	public static int[] getSomeGoofyNumbers(int count) {
		int[] output = new int[count];
		int counter=1;
		for (int i=0; i<output.length; i++) {
			while (!isGoofy(counter)) {
				counter++;
			}
			output[i]=counter;
			counter++;
		}
		return output;
	}
}