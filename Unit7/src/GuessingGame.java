//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class GuessingGame
{
	private int upperBound, number, input, counter;
	private Scanner keyboard = new Scanner(System.in);
	
	public GuessingGame(int stop)
	{
		do {
			System.out.print("Guessing Game - how many numbers? ");
			upperBound=keyboard.nextInt();
			this.playGame();
		} while (keyboard.next().toLowerCase().equals("y"));

	}

	public void playGame()
	{
	
		number=(int)(Math.random()*upperBound)+1;
		input=0;
		counter=0;
		while (input!=number) {
			System.out.printf("\nEnter a number between 1 and %s ",upperBound);
			input=keyboard.nextInt();
			if (input>upperBound||input<1) {
				System.out.print("Number out of Range!");
			} else {
				counter++;
			}
		}
		System.out.printf("\nIt took %s guesses to guess %s.\nYou guessed wrong %.0f percent of the time.",counter,number,(((counter-1.0)/counter)*100));
		//Not sure what the given percentages are; did actual percent wrong.
		System.out.print("\n\n\nDo you want to play again? ");
	


	}

	public String toString()
	{
		String output="Guessing Game - how many numbers? ";
		return output;
	}
}