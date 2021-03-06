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
	private int lf;

	private Color color;

	public Block()
	{
		setPos(100, 150);
		setWidth(10);
		setHeight(10);
		setColor(Color.RED);
		setLf(0);

	}

	//add other Block constructors - x , y , width, height, color
	
	public Block( int x, int y, int w, int h) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(Color.RED);
		setLf(0);
	}
	
	public Block( int x, int y, int w, int h, Color c) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(c);
		setLf(0);
	}
	
	public Block( int x, int y, int w, int h, Color c, int l) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setColor(c);
		setLf(l);
	}
	public Block( int x, int y, int w, int h, int l) {
		setPos(x, y);
		setWidth(w);
		setHeight(h);
		setLf(l);
		checkColor();
	}
	
	
	public void dec() {
		lf--;
	}
	public void dec(int a) {
		lf-=a;
	}
	
	public void setLf(int a) {
		lf=a;
	}
	public int getLf() {
		return lf;
	}
	public void checkColor() {
		if (lf==1) {
			color=Color.RED;
		} else if (lf==2) {
			color=Color.ORANGE;
		} else if (lf==3) {
			color=Color.YELLOW;
		} else if (lf==4) {
			color=Color.GREEN;
		} else if (lf==5) {
			color=Color.CYAN;
		} else if (lf==6) {
			color=Color.BLUE;
		} else if (lf==7) {
			color=Color.MAGENTA;
		} else if (lf==8) {
			color=Color.PINK;
		} else if (lf==9) {
			color=Color.GRAY;
		} else if (lf==10) {
			color=Color.DARK_GRAY;
		} else if (lf>10){
			color=Color.BLACK;
		}
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
      if (lf!=0) {
	      window.setColor(Color.BLACK);
		  window.drawRect(getX(), getY(), getWidth(), getHeight());
      }
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
	
	public int getSpeed() {
		return 0;
	}


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