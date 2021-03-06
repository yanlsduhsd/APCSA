//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y,10,10,Color.BLACK,xSpd,ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,Color.BLACK,xSpd,ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col,xSpd,ySpd);
   }

   public void incrementSpeed()
   {
	   super.setXSpeed((int)(Math.signum(getXSpeed())*(Math.abs(getXSpeed())+Math.random()+0.6)));
	   super.setYSpeed((int)(Math.signum(getYSpeed())*(Math.abs(getYSpeed())+Math.random()+0.4)));
   }
	
	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		
		Block b = (Block) obj;
		
		if (getY()+getYSpeed()+getHeight()>=b.getY()&&getY()+getYSpeed()<=b.getY()+b.getHeight()
				&&getX()+getXSpeed()<b.getX()+b.getWidth()&&getX()>=b.getX()+b.getWidth()) {
			incrementSpeed();
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
			incrementSpeed();
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
			incrementSpeed();
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
			incrementSpeed();
			return true;
		}
		
		return false;
	}

}

