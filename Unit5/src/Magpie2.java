/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	private int counter=0;
	
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		
		if (statement.indexOf("i am your lord and master") >= 0)
		{
			response = "No you are not.";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("brother") >= 0)
		{
			response = "I wish I had a brother.";
		}
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0
				|| statement.indexOf("bird") >= 0
				|| statement.indexOf("fish") >= 0
				|| statement.indexOf("human") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("mauro") >= 0)
		{
			response = "He sounds like a good teacher.";
		}
		else if (statement.indexOf("no") >= 0
				|| statement.indexOf("don't") >= 0
				|| statement.indexOf("bad") >= 0
				|| statement.indexOf("never") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("happy") >= 0
				|| statement.indexOf("glad") >= 0
				|| statement.indexOf("good") >= 0
				|| statement.indexOf("nice") >= 0
				|| statement.indexOf("dead") >= 0)
		{
			response = "I'm pleased you feel that way.";
		}
		else if (statement.indexOf("hi") >= 0
				|| statement.indexOf("hello") >= 0)
		{
			response = "Hello.";
		}
		else if (statement.trim().equals(""))
		{
			counter++;
			if (counter==1) {
				response = "Say something, please.";
			} else if (counter==2) {
				response = "That's not funny.";
			} else if (counter==3) {
				response = "Are you still there?";
			} else if (counter==8||counter==21||counter==53) {
				response = "Boop.";
			} else {
				response = "...";
			}
		}
		else
		{
			response = getRandomResponse();
		}
		
		
		if (!statement.trim().equals("")) {
			counter=0;
		}
		
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 9;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Great.";
		}
		else if (whichResponse == 5)
		{
			response = "That's nice to hear.";
		}
		else if (whichResponse == 6)
		{
			response = "How intriguing.";
		}
		else if (whichResponse == 7)
		{
			response = "I'm sorry, could you repeat that.";
		}
		else if (whichResponse == 8)
		{
			response = "Huh?";
		}

		return response;
	}
}
