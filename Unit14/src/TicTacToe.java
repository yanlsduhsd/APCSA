//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{


	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		for (int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				mat[i][j]=game.charAt(3*i+j);
			}
		}



	}

	public String getWinner()
	{
		for (int i=0; i<mat.length; i++) {
			if (mat[i][0]==mat[i][1]&&mat[i][0]==mat[i][2]) {
				return mat[i][0]+" wins horizontally!";
			} else if (mat[0][i]==mat[1][i]&&mat[0][i]==mat[2][i]) {
				return mat[0][i]+" wins vertically!";
			}
		}
		if (mat[0][0]==mat[1][1]&&mat[0][0]==mat[2][2]||mat[2][0]==mat[1][1]&&mat[2][0]==mat[0][2]) {
			return mat[1][1]+" wins diagonally!";
		} else {
			return "cat's game - no winner!";
		}
	}

	public String toString()
	{
		String output="";

		for (int i = 0; i<mat.length; i++) {
			for (int j = 0; j<mat.length; j++) {
				output+=mat[i][j]+" ";
			}
			output+="\n";
		}
		output+=getWinner();
		
		
		return output+"\n\n";
	}
}