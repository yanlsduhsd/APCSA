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
	//private BlinkyBall ball;
	//private SpeedUpBall ball;
	
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Block line, line2;
	private int rightScore, leftScore;
	private int randomX, randomY;
	
	//private Block a, b, c, d;

	
	public Pong()
	{
		//set up all variables related to the game
		
		do {
			randomX=(int)(Math.signum(Math.random()-0.5)*(Math.random()*2+1));
		} while (randomX==0);
		
		do {
			randomY=(int)(Math.signum(Math.random()-0.5)*Math.sqrt(9-randomX*randomX));
		} while (randomY==0);
		
		ball = new Ball(395, 257, 10, 10, Color.RED,randomX,randomY);
		
		//ball = new BlinkyBall(395, 257, 10, 10, Color.RED,randomX,randomY);
		
		//ball = new SpeedUpBall(395, 257, 10, 10, Color.RED,randomX,randomY);
		
		leftPaddle = new Paddle(50, 232, 10, 60, Color.BLUE, 5); 
		rightPaddle = new Paddle(750, 232, 10, 60, Color.BLUE, 5);
		line = new Block(0,0,800,1);
		line2 = new Block(0,525,800,1);
		
		//a=new Block(120,202,80,120);
		//b=new Block(300,50,200,60);
		//c=new Block(600,202,80,120);
		//d=new Block(300,404,200,60);

		keys = new boolean[4];

    
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
		if(back==null){
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));
	
		}
		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		line.draw(graphToBack);
		line2.draw(graphToBack);
		
		//a.draw(graphToBack);
		//b.draw(graphToBack);
		//c.draw(graphToBack);
		//d.draw(graphToBack);
		
		graphToBack.clearRect(99, 540, 650, 149);
		graphToBack.drawString("rightScore: "+rightScore,600, 550);
		graphToBack.drawString("leftScore: "+leftScore,100, 550);

		
		//see if ball hits left wall or right wall
		if(!(ball.getX()>=0 && ball.getX()+ball.getWidth()<=800))
		{
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			if(ball.getX()<10)
			{
				rightScore++;
			}
			else if(ball.getX()>790)
			{
				leftScore++;
			}
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(400, 300);
			
			do {
				randomX=(int)(Math.signum(Math.random()-0.5)*(Math.random()*2+1));
			} while (randomX==0);
			
			do {
				randomY=(int)(Math.signum(Math.random()-0.5)*Math.sqrt(9-randomX*randomX));
			} while (randomY==0);
			
			ball.setXSpeed(randomX);
			ball.setYSpeed(randomY);
		}

		
		//see if the ball hits the top or bottom wall 
		if(!(ball.getY()>=0+Math.abs(ball.getYSpeed()) && ball.getY()<=524-ball.getYSpeed()-ball.getHeight()))
		{
			ball.setYSpeed(-1*ball.getYSpeed());
		}



		//see if the ball hits the left paddle
		/*if (ball.getX()<=leftPaddle.getX()+leftPaddle.getWidth()+Math.abs(ball.getXSpeed())
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
			if (ball.getX()>= rightPaddle.getX()+Math.abs(ball.getXSpeed())) {
				ball.setYSpeed(-1*ball.getYSpeed());
			} else {
				ball.setXSpeed(-1*ball.getXSpeed());
			}
		}*/
		
		
		if (ball.didCollideTop(leftPaddle)||ball.didCollideBottom(leftPaddle)||ball.didCollideTop(rightPaddle)||ball.didCollideBottom(rightPaddle)){
			ball.setYSpeed(-1*ball.getYSpeed());
		}
		if (ball.didCollideLeft(leftPaddle)){
			ball.setXSpeed(-1*ball.getXSpeed());
		}
		if (ball.didCollideRight(rightPaddle)){
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
		
		if(keys[0] == true&&leftPaddle.getY()>0+leftPaddle.getSpeed())
		{
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true&&leftPaddle.getY()<524-leftPaddle.getSpeed()-leftPaddle.getHeight())
		{
			leftPaddle.moveDownAndDraw(graphToBack);
		}
		if(keys[2] == true&&rightPaddle.getY()>0+rightPaddle.getSpeed())
		{
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true&&rightPaddle.getY()<524-rightPaddle.getSpeed()-rightPaddle.getHeight())
		{
			rightPaddle.moveDownAndDraw(graphToBack);
		}







		
		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'S' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'K' : keys[3]=true; break;

		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'S' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'K' : keys[3]=false; break;

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