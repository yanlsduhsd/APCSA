//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{

		roman=str;

	}

	public RomanNumeral(Integer orig)
	{

		number=orig;

	}

	public void setNumber(Integer num)
	{

		
		number=num;


	}

	public void setRoman(String rom)
	{

		roman=rom;

	}

	public Integer getNumber()
	{
		number=0;
		for(int i=0; i<LETTERS.length;i++) {
			while (roman.indexOf(LETTERS[i])==0) {
				number+=NUMBERS[i];
				roman=roman.substring(LETTERS[i].length());
			}
		}
		return number;
	}

	public String toString()
	{
		roman="";
		for (int i =0; i<NUMBERS.length; i++) 
		{
			while (number>=NUMBERS[i]) {
				roman+=LETTERS[i];
				number-=NUMBERS[i];
			}
		}
		return roman + "\n";
	}
}