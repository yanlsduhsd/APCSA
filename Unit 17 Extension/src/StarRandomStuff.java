//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class StarRandomStuff extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarRandomStuff()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterRandomStuff theGame = new OuterRandomStuff();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		StarRandomStuff run = new StarRandomStuff();
	}
}