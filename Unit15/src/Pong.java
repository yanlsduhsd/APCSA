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

public class Pong extends Canvas implements KeyListener, Runnable
{
	private Ball ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Block block;

	public Pong()
	{
		//set up all variables related to the game
		ball = new Ball(400, 300, 10, 10, Color.RED, 3, 2);
		leftPaddle = new Paddle(50, 285, 10, 60, Color.BLUE, 5); 
		rightPaddle = new Paddle(750, 285, 10, 60, Color.BLUE, 5);
		block = new Block(300, 300, 50, 50);


		keys = new boolean[9];

    
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		//starts the key thread to log key strokes
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
		if(back==null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);


		//see if ball hits left wall or right wall
		if(!(ball.getX()>=10 && ball.getX()<=790))
		{
			//ball.setXSpeed(0);
			//ball.setYSpeed(0);
			ball.setXSpeed(-1*ball.getXSpeed());
		}

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=0+Math.abs(ball.getYSpeed()) && ball.getY()<=600-ball.getYSpeed()-ball.getHeight()))
		{
			ball.setYSpeed(-1*ball.getYSpeed());
		}



		//see if the ball hits the left paddle
		if (ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())
				&& 
				(ball.getY()>= leftPaddle.getY()&&ball.getY()<leftPaddle.getHeight()+leftPaddle.getY()||
				ball.getY()+ball.getHeight()>=leftPaddle.getY() &&
				ball.getY()+ball.getHeight()<leftPaddle.getY()+leftPaddle.getHeight())) {
			if (ball.getX()<= leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-1*ball.getYSpeed());
			} else {
				ball.setXSpeed(-1*ball.getXSpeed());
			}
		}
		

		//see if the ball hits the right paddle
		
		if (ball.getX()>=rightPaddle.getX()-Math.abs(ball.getXSpeed())
				&& 
				(ball.getY()>= rightPaddle.getY()&&ball.getY()<rightPaddle.getHeight()+rightPaddle.getY()||
				ball.getY()+ball.getHeight()>=rightPaddle.getY() &&
				ball.getY()+ball.getHeight()<rightPaddle.getY()+rightPaddle.getHeight())) {
			if (ball.getX()>= rightPaddle.getX()-Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-1*ball.getYSpeed());
			} else {
				ball.setXSpeed(-1*ball.getXSpeed());
			}
		}
		


		//see if the paddles need to be moved
		
		if(keys[0] == true&&leftPaddle.getY()>0+leftPaddle.getSpeed())
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true&&leftPaddle.getY()<600-leftPaddle.getSpeed()-leftPaddle.getHeight())
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true&&rightPaddle.getY()>0+rightPaddle.getSpeed())
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true&&rightPaddle.getY()<600-rightPaddle.getSpeed()-rightPaddle.getHeight())
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[4] == true)
		{
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(400, 300);
			ball.setXSpeed(0);
			ball.setYSpeed(0);
		}
		if(keys[5] == true)
		{
			ball.setXSpeed(1);
		}
		if(keys[6] == true)
		{
			ball.setXSpeed(-1);
		}
		if(keys[7] == true)
		{
			ball.setYSpeed(1);
		}
		if(keys[8] == true)
		{
			ball.setYSpeed(-1);
		}







		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
			
			case 'Q' : keys[4]=true; break;
			case 'E' : keys[5]=true; break;
			case 'R' : keys[6]=true; break;
			case 'T' : keys[7]=true; break;
			case 'Y' : keys[8]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
			
			case 'Q' : keys[4]=false; break;
			case 'E' : keys[5]=false; break;
			case 'R' : keys[6]=false; break;
			case 'T' : keys[7]=false; break;
			case 'Y' : keys[8]=false; break;
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