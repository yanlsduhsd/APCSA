//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  - 

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	public MadLib()
	{

	}

	public MadLib(String fileName)
	{
		//load stuff
		
		loadNouns();
		loadVerbs();
		loadAdjectives();

		
		try{
			Scanner file = new Scanner(new File(fileName));
			
			while (file.hasNext()) {
				String thing = file.next();
				if (thing.equals("#")) {
					System.out.print(getRandomNoun()+" ");
				} else if (thing.equals("@")) {
					System.out.print(getRandomVerb()+" ");
				} else if (thing.equals("&")) {
					System.out.print(getRandomAdjective()+" ");
				} else {
					System.out.print(thing+" ");
				}
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		nouns=new ArrayList<String>();
		try{
			
			String noun="";
			Scanner chopper = new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit10\\src\\nouns.dat"));
			
			while (chopper.hasNext()) {
				noun=chopper.next();
				nouns.add(noun);
			}
			
		}
		catch(Exception e)
		{
			out.println("Not working 1.");
		}	
		
	}
	
	public void loadVerbs()
	{
		verbs=new ArrayList<String>();
		try{
			
			String verb="";
			Scanner chopper = new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit10\\src\\verbs.dat"));
			
			while (chopper.hasNext()) {
				verb=chopper.next();
				verbs.add(verb);
			}
			
		}
		catch(Exception e)
		{
			out.println("Not working 2.");
		}	
		
	}

	public void loadAdjectives()
	{
		adjectives=new ArrayList<String>();
		try{
			
			String adj="";
			Scanner chopper = new Scanner(new File("H:\\APCSA_github\\APCSA\\Unit10\\src\\adjectives.dat"));
			
			while (chopper.hasNext()) {
				adj=chopper.next();
				adjectives.add(adj);
			}
			
		}
		catch(Exception e)
		{
			out.println("Not working 3.");
		}	
		
	}

	public String getRandomVerb()
	{
		return verbs.get((int)(Math.random()*verbs.size()));
	}
	
	public String getRandomNoun()
	{
		return nouns.get((int)(Math.random()*nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		return adjectives.get((int)(Math.random()*adjectives.size()));
	}		

	public String toString()
	{
		return "\n\n\n";
		
		/* 
		 * return "The " + getRandomNoun() + " " + getRandomVerb() + " after the " + getRandomAdjective() + " " + getRandomAdjective()
		 * + " " + getRandomNoun() + " while the " + getRandomNoun() + " " + getRandomVerb() + " the " + getRandomNoun();
		 */
	}
}