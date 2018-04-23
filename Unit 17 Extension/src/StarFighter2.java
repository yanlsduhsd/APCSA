//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import javax.swing.JFrame;
import java.awt.Component;

public class StarFighter2 extends JFrame
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public StarFighter2()
	{
		super("STARFIGHTER");
		setSize(WIDTH,HEIGHT);

		OuterSpace2 theGame = new OuterSpace2();
		((Component)theGame).setFocusable(true);

		getContentPane().add(theGame);

		setVisible(true);
	}

	public static void main( String args[] )
	{
		StarFighter2 run = new StarFighter2();
	}
}