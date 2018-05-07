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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	
	private Paddle paddle;

	private boolean[] keys;
	private BufferedImage back;
	private int randomX, randomY;
	
	private ArrayList<Block> bricks;
	


	
	public Pong()
	{
		
		do {
			randomX=(int)(Math.signum(Math.random()-0.5)*(Math.random()*2+1));
		} while (randomX==0);
		
		do {
			randomY=(int)(Math.signum(Math.random()-0.5)*Math.sqrt(9-randomX*randomX));
		} while (randomY==0);
		
		ball = new Ball(395, 257, 10, 10, Color.RED,randomX,randomY);
		bricks = new ArrayList<Block>();
		
		paddle = new Paddle(50, 232, 40, 40, Color.BLUE, 3);
		

		keys = new boolean[4];
		
		one();
		
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
	}
	
	public void collision(Ball bal) {
		for (int i=0; i<bricks.size(); i++) {
			if (bal.didCollideBottom(bricks.get(i))||bal.didCollideTop(bricks.get(i))) {
				bal.setYSpeed(-1*bal.getYSpeed());
				bricks.remove(i--);
			} else if (bal.didCollideLeft(bricks.get(i))||bal.didCollideRight(bricks.get(i))) {
				bal.setXSpeed(-1*bal.getXSpeed());
				bricks.remove(i--);
			}
		}
	}
	public void draw(Graphics g) {
		for (Block b: bricks) {
			b.draw(g);
		}
	}
//	17*23*2
	public void one() {
		for (int i=0; i<17; i++) {
			bricks.add(new Block(1+46*i,0,46,28,Color.RED));
			bricks.add(new Block(1+46*i,28,46,28,Color.RED));
			bricks.add(new Block(1+46*i,504,46,28,Color.RED));
			bricks.add(new Block(1+46*i,532,46,28,Color.RED));
		}
		for (int i=0; i<16; i++) {
			bricks.add(new Block(1,56+28*i,46,28,Color.RED));
			bricks.add(new Block(47,56+28*i,46,28,Color.RED));
			bricks.add(new Block(691,56+28*i,46,28,Color.RED));
			bricks.add(new Block(737,56+28*i,46,28,Color.RED));
		}
	}
	
   public void update(Graphics window){
	   paint(window);
   }

   public void paint(Graphics window)
   {
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D)window;

		//take a snap shop of the current screen and same it as an image
		//that is the exact same width and height as the current screen
		if(back==null){
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
	
		}
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.WHITE);
		graphToBack.fillRect(0,0,800,600);
		
		
		ball.moveAndDraw(graphToBack);
		paddle.draw(graphToBack);

		graphToBack.setColor(Color.black);
		graphToBack.drawLine(0, 0, 783, 0);
		graphToBack.drawLine(0, 0, 0, 560);
		graphToBack.drawLine(783, 0, 783, 560);
		graphToBack.drawLine(0,560, 783, 560);

		draw(graphToBack);
		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=0+Math.abs(ball.getYSpeed()) && ball.getY()<=560-ball.getYSpeed()-ball.getHeight()))
		{
			ball.setYSpeed(-1*ball.getYSpeed());
		}
		if(!(ball.getX()>=0+Math.abs(ball.getXSpeed()) && ball.getX()<=783-ball.getXSpeed()-ball.getWidth()))
		{
			ball.setXSpeed(-1*ball.getXSpeed());
		}
		
		
		if (ball.didCollideTop(paddle)||ball.didCollideBottom(paddle)){
			ball.setYSpeed(-1*ball.getYSpeed());
		}
		if (ball.didCollideLeft(paddle)||ball.didCollideRight(paddle)){
			ball.setXSpeed(-1*ball.getXSpeed());
		}
		
		/*if (ball.didCollideLeft(a)||ball.didCollideLeft(b)||ball.didCollideLeft(c)||ball.didCollideLeft(d)
				||ball.didCollideRight(a)||ball.didCollideRight(b)||ball.didCollideRight(c)||ball.didCollideRight(d)){
			ball.setXSpeed(-1*ball.getXSpeed());
		}
		if (ball.didCollideTop(a)||ball.didCollideTop(b)||ball.didCollideTop(c)||ball.didCollideTop(d)
				||ball.didCollideBottom(a)||ball.didCollideBottom(b)||ball.didCollideBottom(c)||ball.didCollideBottom(d)){
			ball.setYSpeed(-1*ball.getYSpeed());
		}*/


		//see if the paddles need to be moved
		
		if(keys[0] == true&&paddle.getY()>0+paddle.getSpeed())
		{
			paddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true&&paddle.getY()<560-paddle.getSpeed()-paddle.getHeight())
		{
			paddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true&&paddle.getX()>0+paddle.getSpeed())
		{
			paddle.moveLeftAndDraw(graphToBack);
		}
		if(keys[3] == true&&paddle.getX()<783-paddle.getSpeed()-paddle.getWidth())
		{
			paddle.moveRightAndDraw(graphToBack);
		}

		collision(ball);





		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'A' : keys[2]=true; break;
			case 'D' : keys[3]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'A' : keys[2]=false; break;
			case 'D' : keys[3]=false; break;

		}
	}

	public void keyTyped(KeyEvent e){}
	
   public void run()
   {
   	try
   	{
   		while(true)
   		{
   		   Thread.currentThread().sleep(8);
            repaint();
         }
      }catch(Exception e)
      {
      }
  	}	
}