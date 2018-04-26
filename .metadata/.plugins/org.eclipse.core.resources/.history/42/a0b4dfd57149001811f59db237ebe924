//© A+ Computer Science  -  www.apluscompsci.com
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

public class Alien1a extends Alien1
{

	public Alien1a()
	{
		this(0,0,30,30,0,1);
	}

	public Alien1a(int x, int y, int w, int h, int s, int l)
	{
		super(x, y, w, h, s, l);
	}
	
	public void set(int x, int y, int w, int h, int s, int l) {
		super.set(x, y, w, h, s, l);
	}

    public void move()
	{
    	if (getY()%60==1&&getX()+getWidth()+getSpeed()<=783) {
    		for (int i=0; i<getSpeed(); i++) super.move("RIGHT");
		} else if (getY()%60==31&&getX()-getSpeed()>0){
			for (int i=0; i<getSpeed(); i++) super.move("LEFT");
		} else {
			super.move("DOWN");
		}
	}
   
	public String toString()
	{
		return "";
	}
}
