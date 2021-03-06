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

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		//figure out what size is for
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a:aliens) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a: aliens) {
			
			if (a.getY()/a.getSpeed()%60==1&&a.getX()+a.getWidth()+a.getSpeed()<=783) {
				a.move("RIGHT");
			} else if (a.getY()/a.getSpeed()%60==31&&a.getX()-a.getSpeed()>0){
				a.move("LEFT");
			} else {
				a.move("DOWN");
			}
		}
	}

	public void removeDeadOnes(List<Ammo> shots)
	{
//		for (Alien a: aliens) {
//			for (Ammo s: shots) {
//				if (s.getX()<a.getX()+a.getWidth()&&s.getX()+s.getWidth()>a.getX()
//						&&s.getY()<a.getY()+a.getHeight()&&s.getY()+s.getHeight()>a.getY()) {
//					
//				}
//			}
//		}
		
		for (int i=0; i<aliens.size(); i++) {
			if (aliens.get(i).getY()>=510) {
				aliens.remove(i--);
			}
			
			for (int j=0; j<shots.size(); j++) {
				if (shots.get(j).getX()<aliens.get(i).getX()+aliens.get(i).getWidth()&&shots.get(j).getX()+shots.get(j).getWidth()>aliens.get(i).getX()
						&&shots.get(j).getY()<aliens.get(i).getY()+aliens.get(i).getHeight()&&shots.get(j).getY()+shots.get(j).getHeight()>aliens.get(i).getY()) {
					aliens.remove(i--);
					shots.remove(j);
					break;
				}
			}
		}
	}

	public String toString()
	{
		return "";
	}
}
