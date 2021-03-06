//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		setPos(100, 150);
		setWidth(10);
		setHeight(10);
		setColor(Color.BLACK);

	}

	//add other Block constructors - x , y , width, height, color
	
	public Block( int x, int y, int w, int h) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(Color.BLACK);
	}
	
	public Block( int x, int y, int w, int h, Color c) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
	
	
	
	
	
	
	
	
	
   //add the other set methods
	public void set(int x, int y, int w, int h, Color c) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(c);
	}
	
	@Override
	public void setX(int x)
	{
		   xPos = x;

	}
	@Override
	public void setY(int y)
	{
		   yPos = y;

	}
	@Override
	public void setPos(int x, int y)
	{
		   setX(x);
		   setY(y);

	}
	public void setWidth(int w)
	{
		   width = w;

	}
	public void setHeight(int h)
	{
		   height = h;

	}

   public void setColor(Color col)
   {
	   color = col;

   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block block = (Block) obj;
		return xPos==block.getX()&&yPos==block.getY()&&width==block.getWidth()&&height==block.getHeight()&&color.equals(block.getColor());




		//return toString().equals(obj.toString());
	}   

   //add the other get methods
	@Override
	public int getX()
	{
		   return xPos;

	}
	@Override
	public int getY()
	{
		   return yPos;

	}
	public int getWidth()
	{
		   return width;

	}
	public int getHeight()
	{
		   return height;

	}
	public Color getColor()
	{
		   return color;

	}

   //add a toString() method  - x , y , width, height, color
	
	public String toString()
	{
		   return String.format("%s %s %s %s %s", xPos, yPos, width, height, color);

	}
}