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
	private int ID;

	public Circle()
	{
		this(5,5,1,0,0);
	}
	
	public Circle(int x, int y, int s, int ang, int id)
	{
		super(x,y,6,6,s,10);
		angle = ang*2*Math.PI/360;
		r = 20;
		ID = id;
	}

	public Circle(int x, int y, int w, int h, int s, int d, int ang, int id) {
		set(x,y,w,h);
		setSpeed(s);
		setD(d);
		angle = ang*2*Math.PI/360;
		r = 20;
		ID = id;
	}
	
	public int getId() {
		return ID;
	}
	
	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.GREEN);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void move(int x, int y, int radius) {
		
		if (angle==Math.PI*2000) angle=0;
		angle+=getSpeed()*2*Math.PI/360;
		
		if (r>radius&&Math.round(180*angle/Math.PI)%4==0) r--;
		if (r<radius&&Math.round(180*angle/Math.PI)%4==0) r++;
		
		setPos(x+(int)(Math.cos(angle)*r)-3,y+(int)(Math.sin(angle)*r)-3);
		
		if (r<0) setPos(20000, 20000);
	}

	public String toString()
	{
		return super.toString()+" "+getSpeed();
	}
}
