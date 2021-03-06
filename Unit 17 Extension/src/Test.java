//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Test extends Ammo
{
//	private Color col;
	private int id;

	public Test(int x, int y, int w, int h, int s) {
		super(x,y,w,h,s,h/2);
//		col=Color.WHITE;
		id=20;
	}

	private void fade() {
		if (getHeight()>0) setHeight(getHeight()-1);
		setD(getHeight()/2);
//		int c=(int)(63*getHeight()/640.0+192);
//		col=new Color(c,c,c);
	}
	
	public void move( String direction )
	{
		if (direction.equals("LEFT")) {
			setX(getX()-1);
		} else if (direction.equals("RIGHT")) {
			setX(getX()+1);
		}else if (direction.equals("UP")) {
			setY(getY()-1);
		}else if (direction.equals("DOWN")) {
			setY(getY()+1);
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void draw( Graphics window )
	{
		fade();
		window.setColor(Color.WHITE);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
