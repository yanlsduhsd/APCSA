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

	private int leftBound, rightBound;
	
	public Alien1a()
	{
		this(0,0,30,30,0,1,0,783);
	}

	public Alien1a(int x, int y, int w, int h, int s, int l, int lBound, int rBound)
	{
		super(x, y, w, h, s, l);
		setBounds(lBound, rBound);
	}
	
	public void set(int x, int y, int w, int h, int s, int l, int lB, int rB) {
		super.set(x, y, w, h, s, l);
		setBounds(lB, rB);
	}

	public void setBounds(int lB, int rB) {
		leftBound=lB;
		rightBound=rB;
	}
	
    public void move()
	{
    	if (getY()%60==1&&getX()+getWidth()+getSpeed()<=rightBound) {
    		for (int i=0; i<getSpeed(); i++) super.move("RIGHT");
		} else if (getY()%60==31&&getX()-getSpeed()>leftBound){
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
