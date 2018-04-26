//© A+ Computer Science  -  www.apluscompsci.com
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
	private int d;

	public Ammo()
	{
		this(0,0,0,0);
	}

	public Ammo(int x, int y)
	{
		//add code
		this(x,y,0,0);
	}

	public Ammo(int x, int y, int s, int d)
	{
		//add code
		super(x,y,10,10);
		setSpeed(s);
		setD(d);
	}

	public Ammo(int x, int y, int w, int h, int s, int d) {
		super(x,y,w,h);
		setSpeed(s);
		setD(d);
	}
	
	public void set(int x, int y, int w, int h, int s, int d) {
		super.set(x, y, w, h);
		setSpeed(s);
		setD(d);
	}
	
	public void setSpeed(int s)
	{
	   //add code
		speed=s;
	}
	
	public void setD(int dm)
	{
	   //add code
		d=dm;
	}

	public int getSpeed()
	{
	   return speed;
	}
	
	public int getD()
	{
	   return d;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.YELLOW);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void move(int x, int y, int r) {
		for (int i = 0; i<getSpeed(); i++) move("UP");
	}
	
	public int getId() {
		return -1;
	}
	
	
	public void move( String direction )
	{
		//add code to draw the ammo
		if (direction.equals("LEFT")&&getX()-1>0) {
			setX(getX()-1);
		} else if (direction.equals("RIGHT")&&getX()+getWidth()+1<=783) {
			setX(getX()+1);
		}else if (direction.equals("UP")&&getY()-1>0) {
			setY(getY()-1);
		}else if (direction.equals("DOWN")&&getY()+getHeight()+1<=560) {
			setY(getY()+1);
		}
	}

	public String toString()
	{
		return super.toString()+" "+getSpeed();
	}
}
