import java.util.Arrays;

public class Test {
	
	public static void main (String[] args) {
		
		
		Deck standard = new Deck(new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}, new String[]{"Spades", "Hearts", "Clubs", "Diamonds"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
		
		Card[] board = new Card[9];
		int a=0;
		
		boolean validmove=true;
		
		for (int i=0; i<9; i++) {
			board[i]=standard.deal();
		}
		System.out.println(Arrays.toString(board));
		while (validmove) {
			validmove=false;
			for (int i=0; i<8; i++) {
				if (board[i].pointValue()>10&&i<7) {
					for (int j=i+1; j<8; j++) {
						if (board[j].pointValue()>10&&board[i].pointValue()!=board[j].pointValue()) {
							for (int k=j+1; k<9; k++) {
								if (board[k].pointValue()>10&&board[k].pointValue()!=board[i].pointValue()&&board[k].pointValue()!=board[j].pointValue()) {
									board[i]=standard.deal();
									board[j]=standard.deal();
									board[k]=standard.deal();
									System.out.println("gi");
									System.out.println(Arrays.toString(board));
									validmove=true;
								}
							}
						}
					}
				} else {
					for (int j=i+1; j<9; j++) {
						if (board[i].pointValue()+board[j].pointValue()==10) {
							board[i]=standard.deal();
							board[j]=standard.deal();
							System.out.println("hi");
							System.out.println(Arrays.toString(board));
							validmove=true;
						}
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
			
			if (a>=3000) {
				System.out.println("Oops.");
				break;
			}
		}
		
		
	}
	
}