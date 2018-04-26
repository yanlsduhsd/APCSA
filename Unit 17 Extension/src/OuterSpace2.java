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

    private AlienHorde2 horde;
	private Bullets shots;

	private boolean[] keys;
	private BufferedImage back;
	private int counter;
	private int clock;
	private int selected;
	private int approxAngle;

	public OuterSpace2()
	{
		setBackground(Color.black);

		keys = new boolean[20];

		ship = new Ship(360,500,30,30,2);
		
		horde = new AlienHorde2();

		for (int i=150; i<=735; i+=90) {
			for (int j=15; j<=255; j+=60) {
				horde.add(new Alien1a(i,j,30,30,3,20,0,783));
			}
		}
		
		counter=160;
		clock=0;
		
		selected=0;
		
		shots = new Bullets();
		
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
		
		if (counter<160&&selected==0) counter+=2;
		if (counter<160&&selected==1) counter++;
		if (counter<160&&selected==2) counter+=10;
		if (counter<160&&selected==3) counter+=2;
		
		if (clock>2000000) clock=0;
		else clock++;
		
		graphToBack.setColor(Color.BLUE);
		graphToBack.fillRect(10, 10, counter, 10);
		
		displayIcon(selected, graphToBack);
		
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
		

		if(keys[4] == true && counter==160 && selected!=3) {
			if (selected==0) shots.add(new Ammo(ship.getX()+(int)(ship.getWidth()*0.5)-5,ship.getY()+(int)(ship.getHeight()*0.5)-5,3,20));
			if (selected==1) for (int i=0; i<8; i++) shots.add(new Burst(ship.getX()+(int)(ship.getWidth()*0.5)-2,ship.getY()+(int)(ship.getHeight()*0.5)-2,2,i));
			if (selected==2) shots.add(new Ammo(ship.getX()+(int)(ship.getWidth()*0.5)-2,ship.getY()+(int)(ship.getHeight()*0.5)-2,4,4,5,4));
			counter=0;
		}
		
		if (selected==3) {
			if (approxAngle==360000) approxAngle=0;
			approxAngle++;
			if (counter==160) {
				int rand = shots.getRandomCircleId();
				if (rand!=-1) {
					shots.add(new Circle(ship.getX()+(int)(ship.getWidth()*0.5)-3,ship.getY()+(int)(ship.getHeight()*0.5)-3,1,rand*40+approxAngle,rand));
					counter=0;
				}
			}
		}
		
		if (keys[5]) {
			if (selected!=0) counter=0;
			selected=0;
		} else if (keys[6]) {
			if (selected!=1) counter=0;
			selected=1;
		} else if (keys[7]) {
			if (selected!=2) counter=0;
			selected=2;
		} else if (keys[8] && selected!=3) {
			counter=0;
			approxAngle=0;
			selected=3;
		}
		
		
		
		if(keys[9] == true) {
			for (int i=0; i<9; i++) {
				int x=ship.getX()+(int)(ship.getWidth()*0.5)-5+30*(i%3-1);
				int y=ship.getY()+(int)(ship.getHeight()*0.5)-5+30*(i/3);
				if (x>0&&x+5<783&&y>0)
				shots.add(new Ammo(x,y,3,20));
			}
			counter=0;
		}
		if (keys[16] == true && counter==160) {
			for (int i=150; i<=735; i+=90) {
				for (int j=15; j<=255; j+=60) {
					horde.add(new Alien1a(i,j,30,30,3,20,0,783));
				}
			}
			counter=0;
		}
		
		if (keys[15] == true && counter==160) {
			for (int i=210; i<=570; i+=90) {
				for (int j=15; j<=255; j+=60) {
					horde.add(new Alien1a(i,j,30,30,3,20,200,583));
				}
			}
			counter=0;
		}
		
		if (keys[17] == true && counter==160) {
			for (int i=0; i<10; i++) {
				horde.add(new Alien1b((int)(Math.random()*750)+15,(int)(Math.random()*200)+15,30,30,1,10));
			}
			counter=0;
		}
		
		if(keys[18] == true) {
			for (int i=0; i<8; i++) {
				shots.add(new Burst(ship.getX()+(int)(ship.getWidth()*0.5)-2,ship.getY()+(int)(ship.getHeight()*0.5)-2,2,i));
			}
			counter=0;
		}

		graphToBack.setColor(Color.GRAY);
		for (int i=1; i<783; i+=10) {
			graphToBack.fillRect(i, 515, 6, 1);
		}
		
		
		horde.drawEmAll(graphToBack);
		shots.drawEmAll(graphToBack);
		
		ship.draw(graphToBack);
		
		if (clock%3==0) {
			horde.moveEmAll();
		}
		
		if (selected!=3) shots.moveEmAll(1000,1000,-1);
		else if (keys[4]) shots.moveEmAll(ship.getX()+(int)(ship.getWidth()*0.5), ship.getY()+(int)(ship.getHeight()*0.5), 120);
		else shots.moveEmAll(ship.getX()+(int)(ship.getWidth()*0.5), ship.getY()+(int)(ship.getHeight()*0.5),60);
		
		horde.removeDeadOnes(shots.getList());
		shots.cleanEmUp();

		graphToBack.setColor(Color.RED);
		graphToBack.fillRect(0, 560, 784, 1);
		graphToBack.fillRect(783, 0, 1, 561);
		graphToBack.fillRect(0, 0, 784, 1);
		graphToBack.fillRect(0, 0, 1, 561);
		
		
		
		twoDGraph.drawImage(back, null, 0, 0);
		
		
	}
	
	public void displayIcon(int a, Graphics g) {
		
			g.setColor(Color.YELLOW);
			g.fillRect(15, 30, 10, 10);
			
			g.setColor(Color.RED);
			g.fillRect(39, 30, 2, 2);
			g.fillRect(39, 38, 2, 2);
			g.fillRect(35, 34, 2, 2);
			g.fillRect(43, 34, 2, 2);
			
			g.setColor(Color.YELLOW);
			g.fillRect(54, 33, 4, 4);
			g.fillRect(62, 33, 4, 4);
			g.fillRect(70, 33, 4, 4);
			
			g.setColor(Color.GREEN);
			g.drawOval(82, 29, 12, 12);
			
			g.setColor(Color.RED);
			if (a==0) {
				g.drawRoundRect(11, 26, 18, 17, 3, 3);
			} else if (a==1) {
				g.drawRoundRect(31, 26, 17, 17, 3, 3);
			} else if (a==2) {
				g.drawRoundRect(50, 26, 28, 17, 3, 3);
			} else if (a==3) {
				g.drawRoundRect(79, 26, 19, 18, 3, 3);
			}
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
		if (e.getKeyCode() == KeyEvent.VK_1)
		{
			keys[5] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_2)
		{
			keys[6] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_3)
		{
			keys[7] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_4)
		{
			keys[8] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[9] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[16] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[17] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[18] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_T)
		{
			keys[15] = true;
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
		}
		if (e.getKeyCode() == KeyEvent.VK_1)
		{
			keys[5] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_2)
		{
			keys[6] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_3)
		{
			keys[7] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_4)
		{
			keys[8] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_Q)
		{
			keys[9] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			keys[16] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_E)
		{
			keys[17] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_R)
		{
			keys[18] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_T)
		{
			keys[15] = false;
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

