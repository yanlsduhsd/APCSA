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

public class Alien1c extends Alien1
{
	private int[] directions;
	private int counter;
	
	public Alien1c()
	{
		this(0,0,30,30,0,1,new int[]{});
	}

	public Alien1c(int x, int y, int w, int h, int s, int l, int[] direct)
	{
		super(x, y, w, h, s, l);
		directions=direct;
		counter=0;
	}
	
	public void set(int x, int y, int w, int h, int s, int l) {
		super.set(x, y, w, h, s, l);
	}
	
    public void move()
	{
    	if (counter>=directions.length) super.move("DOWN");
    	else if (directions[counter]<10) counter++;
    	else {
	    	if (directions[counter]%10==3) {
	    		for (int i=0; i<getSpeed(); i++) super.move("DOWN");
	    		directions[counter]-=10;
	    	} else if (directions[counter]%10==2) {
	    		for (int i=0; i<getSpeed(); i++) super.move("UP");
	    		directions[counter]-=10;
	    	} else if (directions[counter]%10==1) {
	    		for (int i=0; i<getSpeed(); i++) super.move("RIGHT");
	    		directions[counter]-=10;
	    	} else if (directions[counter]%10==0) {
	    		for (int i=0; i<getSpeed(); i++) super.move("LEFT");
	    		directions[counter]-=10;
	    	} else {
	    		directions[counter]-=10;
	    	}
    	}
	}
   
	public String toString()
	{
		return "";
	}
}
