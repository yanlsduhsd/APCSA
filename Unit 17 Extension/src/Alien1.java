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

public class Alien1 extends MovingThing
{
	private int lf;
	private int speed;
	private Image image;

	public Alien1()
	{
		this(0,0,30,30,0,1);
	}

	public Alien1(int x, int y, int w, int h, int s, int l)
	{
		super(x, y, w, h);
		speed=s;
		setLf(l);
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
	
	public void set(int x, int y, int w, int h, int s, int l) {
		super.set(x, y, w, h);
		setSpeed(s);
		setLf(l);
	}

	public void setLf(int l) {
		lf=l;
	}
	
	public void dec(int l) {
		lf-=l;
	}

	public int getLf() {
		return lf;
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
			setX(getX()-1);
		} else if (direction.equals("RIGHT")&&getX()+getWidth()+1<=783) {
			setX(getX()+1);
		}else if (direction.equals("UP")&&getY()-1>0) {
			setY(getY()-1);
		}else if (direction.equals("DOWN")&&getY()+getHeight()+1<=560) {
			setY(getY()+1);
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	public void move(){
		//placeholder
	}
	
//	public void move(String s){
//		super.move(s);
//	}
   
	public String toString()
	{
		return "";
	}
}
