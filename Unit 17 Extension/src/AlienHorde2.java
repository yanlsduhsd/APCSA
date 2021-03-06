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

public class AlienHorde2
{
	private List<Alien1> aliens;

	public AlienHorde2()
	{
		aliens = new ArrayList<Alien1>();

	}

	public void add(Alien1 al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien1 a:aliens) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien1 a: aliens) {
			
			a.move();

		}
	}

	public int removeDeadOnes(List<Ammo> shots)
	{
		int counter = 0;
		
		for (int i=0; i<aliens.size(); i++) {
			if (aliens.get(i).getY()>=510||aliens.get(i).getLf()<1
					||(aliens.get(i).getHeight()>50&&aliens.get(i).getY()+aliens.get(i).getHeight()>550)) {
				if (aliens.get(i).getY()>=510||(aliens.get(i).getHeight()>50&&aliens.get(i).getY()+aliens.get(i).getHeight()>550)) {
					counter-=2;
					if (aliens.get(i).getHeight()>50) counter-=99;
				}
				
				if (aliens.get(i).getLf()<1) {
					counter++;
					if (aliens.get(i).getHeight()>50) counter+=99;
				}
				
				aliens.remove(i--);
				break;
			}
			
			for (int j=0; j<shots.size(); j++) {
				if (shots.get(j).getX()<aliens.get(i).getX()+aliens.get(i).getWidth()&&shots.get(j).getX()+shots.get(j).getWidth()>aliens.get(i).getX()
						&&shots.get(j).getY()<aliens.get(i).getY()+aliens.get(i).getHeight()&&shots.get(j).getY()+shots.get(j).getHeight()>aliens.get(i).getY()) {
					aliens.get(i).dec(shots.get(j).getD());
					shots.remove(j);
				}
			}
		}
		return counter;
	}

	public String toString()
	{
		return "";
	}
}
