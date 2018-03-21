//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;

	public Maze()
	{


	}

	public Maze(int size, String line)
	{
		maze = new int[size][size];
		Scanner chopper = new Scanner(line);
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				maze[i][j]=chopper.nextInt();
			}
		}

	}

	public boolean hasExitPath(int r, int c)
	{
		if (c>=0&&r>=0&&c<maze.length&&r<maze[c].length&&maze[r][c]==1) {
			maze[r][c]=2;
			if (c==maze[r].length-1) {
				return true;
			}
			return hasExitPath(r+1,c)||hasExitPath(r-1,c)||hasExitPath(r,c+1)||hasExitPath(r,c-1);
		}
		return false;
	}

	public String toString()
	{
		String output="";
		for (int i = 0; i<maze.length; i++) {
			for (int j = 0; j<maze.length; j++) {
				output+=maze[i][j]+" ";
			}
			output+="\n";
		}
		if (hasExitPath(0,0)) {
			output+="exit found";
		} else {
			output+="exit not found";
		}




		return output;
	}
}