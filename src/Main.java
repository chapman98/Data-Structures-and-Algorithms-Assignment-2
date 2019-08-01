
public class Main {

	public static void main(String[] args) {

		SolveNQueen SNQ = new SolveNQueen(); 						//create new object for Solving N Queen
		System.out.println("#Enter row number between 1 and 8");
		SolveNQueen.userRow = BIO.getInt();						//input for row
		System.out.println("#Enter row number between 1 and 8");
		SolveNQueen.userCol = BIO.getInt();						//input for column
		while(SolveNQueen.userRow >= 9 || SolveNQueen.userRow <= 0 || SolveNQueen.userCol >= 9 || SolveNQueen.userCol <= 0 )
		{ //error loop if user puts in
			System.out.println("#Error number entered was higher than 8 or lower than 1, Enter row number between 1 and 8");
			SolveNQueen.userRow = BIO.getInt();						//input for row
			System.out.println("#Enter row number between 1 and 8");
			SolveNQueen.userCol = BIO.getInt();		
		}
		SolveNQueen.userRow = SolveNQueen.userRow -1;
		SolveNQueen.userCol = SolveNQueen.userCol - 1;
		SNQ.intialize();											//run program
		System.out.println("#run again to put another input in");

	}

}
