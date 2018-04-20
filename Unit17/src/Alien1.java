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

public class Alien1 extends Alien
{
	private int lf;

	public Alien1()
	{
		this(0,0,30,30,0,1);
	}

	public Alien1(int x, int y, int w, int h, int s, int l)
	{
		super(x, y, w, h, s);
		setLf(l);
	}
	
	public void set(int x, int y, int w, int h, int s, int l) {
		super.set(x, y, w, h, s);
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
	
	public void move(){
		//nothing
	}
	
//	public void move(String s){
//		super.move(s);
//	}
   
	public String toString()
	{
		return "";
	}
}
