//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Paddle extends Block implements Collidable
{
   //instance variables
   private int speed;

   public Paddle()
   {
		super(10, 10, 10, 10);
      speed =5;
   }


   //add the other Paddle constructors
   
   public Paddle(int x, int y) {
	   super(x, y, 10, 10);
	   setSpeed(5);
   }
   public Paddle(int x, int y, int s) {
	   super(x, y, 10, 10);
	   setSpeed(s);
   }
   public Paddle(int x, int y, int w, int h, int s) {
	   super(x, y, w, h);
	   setSpeed(s);
   }
   public Paddle(int x, int y, int w, int h, Color c, int s) {
	   super(x, y, w, h, c);
	   setSpeed(s);
   }








   public void setSpeed(int s) {
	   speed = s;
   }

   public void moveUpAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);

	   setY(getY()-getSpeed());

	   super.draw(window);

   }

   public void moveDownAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);

	   setY(getY()+getSpeed());

	   super.draw(window);

   }
   
   public void moveLeftAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);

	   setX(getX()-getSpeed());

	   super.draw(window);

   }
   
   public void moveRightAndDraw(Graphics window)
   {
	   super.draw(window, Color.WHITE);

	   setX(getX()+getSpeed());

	   super.draw(window);

   }
   
   public boolean equals(Object obj)
	{
		Paddle paddle = (Paddle) obj;
		return super.equals(obj)&&speed==paddle.getSpeed();



		//return toString().equals(obj.toString());
	}

   //add get methods
   public int getSpeed() {
	   return speed;
   }
   
   //add a toString() method
   public String toString() {
	   return super.toString() + " " + speed;
   }
   
   public boolean clearLeft(ArrayList<Block> arr) {
	   for (Block b: arr) {
		   if (didCollideLeft(b)) {
			   return false;
		   }
	   }
	   return true;
   }
   public boolean clearRight(ArrayList<Block> arr) {
	   for (Block b: arr) {
		   if (didCollideRight(b)) {
			   return false;
		   }
	   }
	   return true;
   }
   public boolean clearTop(ArrayList<Block> arr) {
	   for (Block b: arr) {
		   if (didCollideTop(b)) {
			   return false;
		   }
	   }
	   return true;
   }
   public boolean clearBottom(ArrayList<Block> arr) {
	   for (Block b: arr) {
		   if (didCollideBottom(b)) {
			   return false;
		   }
	   }
	   return true;
   }
   
   
   public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getY()+getHeight()>b.getY()&&getY()<b.getY()+b.getHeight()
				&&getX()-getSpeed()<b.getX()+b.getWidth()&&getX()>=b.getX()+b.getWidth()) {
			return true;
		}
		
		return false;
	}
	
	
	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getY()+getHeight()>b.getY()&&getY()<b.getY()+b.getHeight()
				&&getX()+getSpeed()+getWidth()>b.getX()&&getX()+getWidth()<=b.getX()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean didCollideTop(Object obj) {
		// TODO Auto-generated method stub
	
		Block b = (Block) obj;
		
		if (getX()+getWidth()>b.getX()&&getX()<b.getWidth()+b.getX()
				&&getY()-getSpeed()<b.getY()+b.getHeight()&&getY()>=b.getY()+b.getHeight()) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean didCollideBottom(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getX()+getWidth()>b.getX()&&getX()<b.getWidth()+b.getX()
				&&getY()+getSpeed()+getHeight()>b.getY()&&getY()+getHeight()<=b.getY()) {
			return true;
		}
		
		return false;
	}
}