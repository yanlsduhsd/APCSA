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

public class Circle extends Ammo
{
	private double angle;
	private int r;

	public Circle()
	{
		this(5,5,1,0);
	}
	
	public Circle(int x, int y, int s, double ang)
	{
		super(x,y,6,6,s,8);
		angle = ang;
		r=20;
	}

	public Circle(int x, int y, int w, int h, int s, int d, double ang) {
		set(x,y,w,h);
		setSpeed(s);
		setD(d);
		angle = ang;
		r=20;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.GREEN);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void move(int x, int y, int radius) {
		
		if (angle==Math.PI*2000000) angle=0;
		angle+=getSpeed()*Math.PI/360;
		
		if (r>radius&&Math.round(360*angle/Math.PI)%4==0) r--;
		if (r<radius&&Math.round(360*angle/Math.PI)%4==0) r++;
		
		setPos(x+(int)(Math.cos(angle)*r)-3,y+(int)(Math.sin(angle)*r)-3);
	}

	public String toString()
	{
		return super.toString()+" "+getSpeed();
	}
}
