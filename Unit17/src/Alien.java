//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		//add code here
		this(x,y,30,30,0);
	}

	public Alien(int x, int y, int s)
	{
		//add code here
		this(x,y,30,30,s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("\\alien.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	
	public void set(int x, int y, int w, int h, int s) {
		super.set(x, y, w, h);
		setSpeed(s);
	}
	
	public void setSpeed(int s)
	{
	   //add code
		speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
	   //add code here
	   
	   if (direction.equals("LEFT")&&getX()-getSpeed()>0) {
			setX(getX()-speed);
		} else if (direction.equals("RIGHT")&&getX()+getWidth()+getSpeed()<=783) {
			setX(getX()+speed);
		}else if (direction.equals("UP")&&getY()-getSpeed()>0) {
			setY(getY()-speed);
		}else if (direction.equals("DOWN")&&getY()+getHeight()+getSpeed()<=560) {
			setY(getY()+speed);
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return "";
	}
}
