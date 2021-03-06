//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200, 200, 10, 10);
		xSpeed = 3;
		ySpeed = 1;
	}

	//add the other Ball constructors
	
	public Ball(int x, int y)
	{
		super(x, y, 10, 10);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h)
	{
		super(x, y, w, h);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c)
	{
		super(x, y, w, h, c);
		xSpeed = 3;
		ySpeed = 1;
	}
	public Ball(int x, int y, int w, int h, Color c, int xSpd, int ySpd)
	{
		super(x, y, w, h, c);
		xSpeed = xSpd;
		ySpeed = ySpd;
	}
	
	
	
	
	
	
	
	
	
	
	
	   
   //add the set methods
	
	public void setXSpeed(int xSpd) {
		xSpeed = xSpd;
	}
	public void setYSpeed(int ySpd) {
		ySpeed = ySpd;
	}
	public void set(int x, int y, int w, int h, Color c, int xSpd, int ySpd) {
		super.set(xSpd, ySpd, w, h, c);
		setXSpeed(xSpd);
		setYSpeed(ySpd);
	}
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
//	  super.draw(window, Color.WHITE);

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);

		//draw the ball at its new location
      super.draw(window);
   }
   
	public boolean equals(Object obj)
	{
		Ball ball = (Ball) obj;
		return super.equals(obj)&&xSpeed==ball.getXSpeed()&&ySpeed==ball.getYSpeed();



		//return toString().equals(obj.toString());
	}   

   //add the get methods
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}

   //add a toString() method
	public String toString() {
		return super.toString() + " " + xSpeed + " " + ySpeed;
	}

	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getY()+getYSpeed()+getHeight()>=b.getY()&&getY()+getYSpeed()<=b.getY()+b.getHeight()
				&&getX()+getXSpeed()<b.getX()+b.getWidth()&&getX()>=b.getX()+b.getWidth()) {
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getY()+getYSpeed()+getHeight()>=b.getY()&&getY()+getYSpeed()<=b.getY()+b.getHeight()
				&&getX()+getXSpeed()+getWidth()>b.getX()&&getX()+getWidth()<=b.getX()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean didCollideTop(Object obj) {
		// TODO Auto-generated method stub
	
		Block b = (Block) obj;
		
		if (getX()+getXSpeed()+getWidth()>=b.getX()&&getX()+getXSpeed()<=b.getWidth()+b.getX()
				&&getY()+getYSpeed()<b.getY()+b.getHeight()&&getY()>=b.getY()+b.getHeight()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean didCollideBottom(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getX()+getXSpeed()+getWidth()>=b.getX()&&getX()+getXSpeed()<=b.getWidth()+b.getX()
				&&getY()+getYSpeed()+getHeight()>b.getY()&&getY()+getHeight()<=b.getY()) {
			return true;
		}
		
		return false;
	}


	
	public boolean didCollideLeft(Object obj, boolean l, boolean r, boolean u, boolean d) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		int x = b.getX();
		int y = b.getY();
		
		if (l) x+=b.getSpeed();
		if (r) x-=b.getSpeed();
		if (u) y+=b.getSpeed();
		if (d) y-=b.getSpeed();
		
		if (getY()+getYSpeed()+getHeight()>=y&&getY()+getYSpeed()<=y+b.getHeight()
				&&getX()+getXSpeed()<x+b.getWidth()&&getX()>=x+b.getWidth()) {
			return true;
		}
		
		return false;
	}
	
	
	
	public boolean didCollideRight(Object obj, boolean l, boolean r, boolean u, boolean d) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		int x = b.getX();
		int y = b.getY();
		
		if (l) x+=b.getSpeed();
		if (r) x-=b.getSpeed();
		if (u) y+=b.getSpeed();
		if (d) y-=b.getSpeed();
		
		if (getY()+getYSpeed()+getHeight()>=y&&getY()+getYSpeed()<=y+b.getHeight()
				&&getX()+getXSpeed()+getWidth()>x&&getX()+getWidth()<=x) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean didCollideTop(Object obj, boolean l, boolean r, boolean u, boolean d) {
		// TODO Auto-generated method stub
	
		Block b = (Block) obj;
		int x = b.getX();
		int y = b.getY();
		
		if (l) x+=b.getSpeed();
		if (r) x-=b.getSpeed();
		if (u) y+=b.getSpeed();
		if (d) y-=b.getSpeed();
		
		if (getX()+getXSpeed()+getWidth()>=x&&getX()+getXSpeed()<=b.getWidth()+x
				&&getY()+getYSpeed()<y+b.getHeight()&&getY()>=y+b.getHeight()) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean didCollideBottom(Object obj, boolean l, boolean r, boolean u, boolean d) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		int x = b.getX();
		int y = b.getY();
		
		if (l) x+=b.getSpeed();
		if (r) x-=b.getSpeed();
		if (u) y+=b.getSpeed();
		if (d) y-=b.getSpeed();
		
		if (getX()+getXSpeed()+getWidth()>=x&&getX()+getXSpeed()<=b.getWidth()+x
				&&getY()+getYSpeed()+getHeight()>y&&getY()+getHeight()<=y) {
			return true;
		}
		
		return false;
	}

}