
import java.util.*;
import java.lang.*;
import java.io.*;

public class SeatingArrangement {
	/* package whatever; // don't place package name! */

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt(); // number of passengers
		int k = scan.nextInt(); // number of matrices
		int[][] input= new int[k][2];
		
		for(int u=0; u < k; u++){
			input[u][1]= scan.nextInt();
			input[u][0]= scan.nextInt();
		}
		int l= input.length;

		ArrayList<int[][]> list= new ArrayList<>();
		for(int y=0; y < l; y++){
			int r= input[y][0];
			int c= input[y][1];
			list.add(new int[r][c]);
		}

		//finding the maximum rows
		int MAX_ROWS= Integer.MIN_VALUE;
		for(int i=0; i< l; i++){
			if(input[i][0] > MAX_ROWS){
				MAX_ROWS= input[i][0];
			}
		}
		
		//create an airplane object
		Airplane airplane= new Airplane(list, MAX_ROWS, n);
		
		//start filling aisle seats
		airplane.fillAisleSeats();
		
		//start filling window seats
		airplane.fillWindowSeats();
		
		//start filling middle rows
		airplane.fillMiddleSeats();
		
	}

		static void printElements(int[][] a){
			for(int row=0; row < a.length; row++){
				for(int col=0; col < a[0].length; col++){
					System.out.print(a[row][col] + " ");
				}
			}
			System.out.println();
		}
}
