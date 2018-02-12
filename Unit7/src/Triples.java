//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{
		number=num;

	}

	public void setNum(int num)
	{
		number=num;

	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int thing;
		while (c>0) {
			thing=c;
			c=a%c;
			a=thing;
		}
		while (b>0) {
			thing=b;
			b=a%b;
			a=thing;
		}
		
		return a;

	}

	public String toString()
	{
		String output="";
		for (int i=1; i<=number; i++) {
			
			for (int j=i; j<=number; j++) {
				
				for (int k=j; k<=number; k++) {
					if (Math.sqrt(Math.pow(i, 2)+Math.pow(j, 2))==k&&greatestCommonFactor(i,j,k)==1) {
						output+=String.format("%s %s %s\n",i,j,k);
					}
				}
			}
		}
		




		return output+"\n";
	}
}