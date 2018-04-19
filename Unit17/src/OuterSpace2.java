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

public class OuterSpace2 extends Canvas implements KeyListener, Runnable
{
	private Ship ship;

    private AlienHorde horde;
	private Bullets shots;

	private boolean fire;

	private boolean[] keys;
	private BufferedImage back;


	public OuterSpace2()
	{
		setBackground(Color.black);

		keys = new boolean[8];

		ship = new Ship(360,500,30,30,2);
		
		horde = new AlienHorde(0);

		for (int i=150; i<=735; i+=90) {
			for (int j=15; j<=255; j+=60) {
				horde.add(new Alien(i,j,30,30,1));
			}
		}
		
		shots = new Bullets();
		fire = true;
		
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
		Graphics2D twoDGraph = (Graphics2D)window;

		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));


		Graphics graphToBack = back.createGraphics();

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
//		if(keys[2] == true)
//		{
//			ship.move("UP");
//		}
//		if(keys[3] == true)
//		{
//			ship.move("DOWN");
//		}
		

		if(keys[4] && fire) {
			shots.add(new Ammo(ship.getX()+(int)(ship.getWidth()*0.5)-5,ship.getY()+(int)(ship.getHeight()*0.5)-5,3));
			fire=false;
		}
		
		if(keys[5] && fire) {
			for (int i=0; i<9; i++) {
				int x=ship.getX()+(int)(ship.getWidth()*0.5)-5+30*(i%3-1);
				int y=ship.getY()+(int)(ship.getHeight()*0.5)-5+30*(i/3);
				if (x>0&&x+5<783&&y>0)
				shots.add(new Ammo(x,y,3));
			}
			fire=false;
		}

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
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[5] = true;
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
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[5] = true;
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

