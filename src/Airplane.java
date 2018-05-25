import java.util.ArrayList;

public class Airplane {

	private ArrayList<int[][]> mSeats;
	private int mMaxRows; // number of rows in matrix which have max rows
	private int mNumberOfPassengers;
	private static int count=0;
	
	public Airplane(ArrayList<int[][]> mSeats, int mMaxRows, int mNumberOfPassengers) {
		super();
		this.mSeats = mSeats;
		this.mMaxRows = mMaxRows;
		this.mNumberOfPassengers= mNumberOfPassengers;
	}
	
	
	public ArrayList<int[][]> getmSeats() {
		return mSeats;
	}
	public void setmSeats(ArrayList<int[][]> mSeats) {
		this.mSeats = mSeats;
	}
	public int getmMaxRows() {
		return mMaxRows;
	}
	public void setmMaxRows(int mMaxRows) {
		this.mMaxRows = mMaxRows;
	}
	
	
	public void fillAisleSeats(){
		if(mSeats.size() > 1){
		for(int a=0; a < mMaxRows; a ++){
			for(int ltIndex=0; ltIndex < mSeats.size(); ltIndex++ ){
				int temp[][]= mSeats.get(ltIndex);
				if(ltIndex == 0){
					//fill the last column
					if(a < temp.length){
						count++;
						if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
							return;
						temp[a][temp[0].length-1]= count;
					}
				}else if(ltIndex == mSeats.size()-1){
					if(a < temp.length){
					//fill the first column
						count++;
						if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
							return;
						temp[a][0]= count;
					}
				}
				else{
					//fill first and last
					if(a < temp.length){
						count++;
						if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
							return;
						//first
						temp[a][0]= count;
						count++;
						if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
							return;
						//last
						temp[a][temp[0].length-1]= count;
					}
				}
			}
		}
		}
	}
	
	public void fillWindowSeats(){
		for(int w=0; w < mMaxRows; w++){
			int[][] temp1= mSeats.get(0);
			int[][] temp2= mSeats.get(mSeats.size()-1);
			//fill first column
			if(w < temp1.length){
				count++;
				if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
					return;
				temp1[w][0]= count;
			}
			//fill last column
			if(w < temp2.length){
				count++;
				if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
					return;
				temp2[w][temp2[0].length -1]= count;
			}
		}
	}
	
	public void fillMiddleSeats(){
		for(int m=0; m < mMaxRows; m++){
			//iterate and check to see it any zero is available
				for(int listIndex=0; listIndex < mSeats.size(); listIndex++){
					int[][] aux= mSeats.get(listIndex);
					for(int c=0; c < aux[0].length; c++){
						if(m < aux.length){
							if(aux[m][c] == 0){
							count++;
							if(checkIfAllPassengerOnBoard(count, mNumberOfPassengers, mSeats))
								return;
							aux[m][c]= count;
						}
					}
				}
			}
		}
	}
	
	private static boolean checkIfAllPassengerOnBoard(int count, int n, ArrayList<int[][]> seats){
		if(count > n){
			for(int[][] arr: seats){
				SeatingArrangement.printElements(arr);
			}
			return true;
		}
		return false;
	}
}
