/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
		
		Deck deck1= new Deck(new String[]{"A", "B","C","D","E"}, new String[]{"red","yellow","green","blue"}, new int[]{1,2,3,4,5});
		Deck deck2= new Deck(new String[]{"A", "B"}, new String[]{"red","yellow"}, new int[]{1,2});
		Deck deck3= new Deck(new String[]{"A", "B","C"}, new String[]{"red","yellow","green"}, new int[]{1,2,3});
		
		System.out.println(deck1);
		System.out.println("");
		System.out.println(deck2);
		System.out.println("");
		System.out.println(deck3);
		System.out.println("");
		
		while(!deck2.isEmpty()) {
			System.out.println(deck2.deal());
		}
		
		System.out.println("");
		System.out.println(deck2);
		System.out.println("");
		
		deck2.shuffle();
		
		System.out.println("");
		System.out.println(deck2);
		System.out.println("");
		
		for (int i=0; i<5; i++) {
			System.out.println(deck3.deal());
		}
		
		System.out.println("");
		System.out.println(deck3);
		System.out.println("");
		
		
		Deck Standard = new Deck(new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}, new String[]{"Spades", "Hearts", "Clubs", "Diamonds"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
		System.out.print(Standard);
	}
}
