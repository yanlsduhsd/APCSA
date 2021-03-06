//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
	private List<Ammo> ammo;
	private List<Integer> circles;

	public Bullets()
	{
		ammo=new ArrayList<Ammo>();
		circles=new ArrayList<Integer>();
		
		for (int i=0; i<9; i++) circles.add(i);
	}

	public int getRandomCircleId() {
		if (circles.size()==0) return -1;
		int id, rand;
		rand=(int)(Math.random()*circles.size());
		id=circles.get(rand);
		circles.remove(rand);
		return id;
	}
	
	public void add(Ammo al)
	{
		ammo.add(al);
	}

	//post - draw each Ammo
	public void drawEmAll( Graphics window )
	{
		for (Ammo a: ammo) {
			a.draw(window);
		}
	}

	public void moveEmAll(int shipX, int shipY, int radius)
	{
		circles.clear();
		for (int i=0; i<9; i++) circles.add(i); //who cares about efficiency
		
		for (Ammo a: ammo) {
			a.move(shipX, shipY, radius);
			if (circles.contains(a.getId())) circles.remove(circles.indexOf(a.getId()));
		}
	}

	public void cleanEmUp()
	{
		for (int i=0; i<ammo.size(); i++) {
			if (ammo.get(i).getY()-1<=0
					||ammo.get(i).getY()+ammo.get(i).getHeight()+1>=560
					||ammo.get(i).getX()-1<=0
					||ammo.get(i).getX()+ammo.get(i).getWidth()+1>=783) {
				ammo.remove(i--);
			}
		}
	}

	public List<Ammo> getList()
	{
		return ammo;
	}

	public String toString()
	{
		return "";
	}
}
