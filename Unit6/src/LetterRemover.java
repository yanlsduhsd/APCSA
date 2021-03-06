//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		//call set
		sentence = "Example";
		lookFor = 'm';
	}

	//add in second constructor
	public LetterRemover(String s, char rem) {
		sentence = s;
		lookFor = rem;
	}
	
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned=sentence;
		int a = 0;
		while (cleaned.indexOf(lookFor)>=0) {
			
			if (cleaned.indexOf(lookFor)-1!=cleaned.length()) {
				cleaned = cleaned.substring(0, cleaned.indexOf(lookFor)) + cleaned.substring(cleaned.indexOf(lookFor)+1);
			} else {
				cleaned = cleaned.substring(0, cleaned.indexOf(lookFor));
			}
			
			
			
			a++;
			if (a>200) {
				break;
			}
		}



		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor + "\n" + removeLetters() + "\n";
	}
}