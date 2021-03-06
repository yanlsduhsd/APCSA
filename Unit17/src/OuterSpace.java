//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
	private Ship ship;
//	private Alien alienOne;
//	private Alien alienTwo;

    private AlienHorde horde;
	private Bullets shots;

	private boolean fire;

	private boolean[] keys;
	private BufferedImage back;
	
//	private Ammo ammo;

	public OuterSpace()
	{
		setBackground(Color.black);

		keys = new boolean[5];

		//instantiate other instance variables
		//Ship, Alien
		ship = new Ship(360,500,30,30,2);
		
		horde = new AlienHorde(0);
//		horde.add(new Alien(200,100,30,30,1));
//		horde.add(new Alien(100,200,30,30,1));
		
		for (int i=150; i<=735; i+=90) {
			for (int j=15; j<=255; j+=60) {
				horde.add(new Alien(i,j,30,30,1));
			}
		}
		
		shots = new Bullets();
		fire = true;
		
//		alienOne = new Alien(200,100,30,30,1);
//		alienTwo = new Alien(100,200,30,30,1);
//		ammo = new Ammo(50,50,2);

		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

   public void update(Graphics window)
   {
	   paint(window);
   }

	public void paint( Graphics window )
	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

//		graphToBack.setColor(Color.BLUE);
//		graphToBack.drawString("StarFighter ", 25, 50 );
		graphToBack.setColor(Color.BLACK);
		graphToBack.fillRect(0,0,800,600);
		
		
		
		if(keys[0] == true)
		{
			ship.move("LEFT");
		}
		if(keys[1] == true)
		{
			ship.move("RIGHT");
		}
		if(keys[2] == true)
		{
			ship.move("UP");
		}
		if(keys[3] == true)
		{
			ship.move("DOWN");
		}
		

		if(keys[4] && fire) {
			shots.add(new Ammo(ship.getX()+(int)(ship.getWidth()*0.5)-5,ship.getY()+(int)(ship.getHeight()*0.5)-5,3));
			fire=false;
		}

		//add code to move Ship, Alien, etc.


		//add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship

		graphToBack.setColor(Color.GRAY);
		for (int i=1; i<783; i+=10) {
			graphToBack.fillRect(i, 515, 6, 1);
		}
		
		horde.drawEmAll(graphToBack);
		shots.drawEmAll(graphToBack);
		
		ship.draw(graphToBack);
		
		horde.moveEmAll();
		shots.moveEmAll();
		
		horde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();

		
//		graphToBack.setColor(Color.BLUE);
//		graphToBack.fillRect(ship.getX(), ship.getY(), 15, 15);
//		graphToBack.setColor(Color.RED);
//		graphToBack.fillRect(ship.getX()+15, ship.getY()+15, 15, 15);
		
		graphToBack.setColor(Color.RED);
		graphToBack.fillRect(0, 560, 784, 1);
		graphToBack.fillRect(783, 0, 1, 561);
		graphToBack.fillRect(0, 0, 784, 1);
		graphToBack.fillRect(0, 0, 1, 561);
		
		
		
		twoDGraph.drawImage(back, null, 0, 0);
		
		
	}


	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			keys[4] = false;
			fire = true;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e)
	{
      //no code needed here
	}

   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(5);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}
}

