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

public class Alien1b extends Alien1
{

	public Alien1b()
	{
		this(0,0,30,30,0,1);
	}

	public Alien1b(int x, int y, int w, int h, int s, int l)
	{
		super(x, y, w, h, s, l);
	}
	
	public void set(int x, int y, int w, int h, int s, int l) {
		super.set(x, y, w, h, s, l);
	}

    public void move()
	{
    	if (getY()%120<20||(getY()%120<60&&getY()%120>39)) {
    		for (int i=0; i<getSpeed(); i++) {
        		super.move("RIGHT");
        	}
    		super.move("DOWN");
		} else if (getY()%120<40) {
    		for (int i=0; i<2*getSpeed(); i++) {
        		super.move("RIGHT");
        	}
    		super.move("DOWN");
		} else if (getY()%120<80||getY()%120>99){
			for (int i=0; i<getSpeed(); i++) {
        		super.move("LEFT");
        	}
			super.move("DOWN");
		} else {
			for (int i=0; i<2*getSpeed(); i++) {
        		super.move("LEFT");
        	}
			super.move("DOWN");
		}
    	
	}
   
	public String toString()
	{
		return "";
	}
}
