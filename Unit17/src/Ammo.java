//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing
{
	private int speed;

	public Ammo()
	{
		this(0,0,0);
	}

	public Ammo(int x, int y)
	{
		//add code
		this(x,y,0);
	}

	public Ammo(int x, int y, int s)
	{
		//add code
		super(x,y,10,10);
		setSpeed(s);
	}

	public Ammo(int x, int y, int w, int h, int s) {
		super(x,y,w,h);
		setSpeed(s);
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

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	
	public void move( String direction )
	{
		//add code to draw the ammo
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

	public String toString()
	{
		return super.toString()+" "+getSpeed();
	}
}
