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

public class Burst extends Ammo
{
	private int direction;

	public Burst()
	{
		this(5,5,1,0);
	}
	
	public Burst(int x, int y, int s, int dir)
	{
		super(x,y,4,4,s,12);
		direction = dir;
	}

	public Burst(int x, int y, int w, int h, int s, int d, int dir) {
		set(x,y,w,h);
		setSpeed(s);
		setD(d);
		direction = dir;
	}

	public void draw( Graphics window )
	{
		//add code to draw the ammo
		window.setColor(Color.RED);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public void move(int x, int y, int r) {
		if (direction==0) for (int i=0; i<getSpeed()*3; i++) super.move("UP");
		else if (direction==2) for (int i=0; i<getSpeed()*3; i++) super.move("RIGHT");
		else if (direction==4) for (int i=0; i<getSpeed()*3; i++) super.move("DOWN");
		else if (direction==6) for (int i=0; i<getSpeed()*3; i++) super.move("LEFT");
		else if (direction==1) {
			for (int i=0; i<getSpeed()*2; i++) super.move("UP");
			for (int i=0; i<getSpeed()*2; i++) super.move("RIGHT");
		} else if (direction==3) {
			for (int i=0; i<getSpeed()*2; i++) super.move("DOWN");
			for (int i=0; i<getSpeed()*2; i++) super.move("RIGHT");
		} else if (direction==5) {
			for (int i=0; i<getSpeed()*2; i++) super.move("DOWN");
			for (int i=0; i<getSpeed()*2; i++) super.move("LEFT");
		} else if (direction==7) {
			for (int i=0; i<getSpeed()*2; i++) super.move("UP");
			for (int i=0; i<getSpeed()*2; i++) super.move("LEFT");
		}

	}

	public String toString()
	{
		return super.toString()+" "+getSpeed();
	}
}
