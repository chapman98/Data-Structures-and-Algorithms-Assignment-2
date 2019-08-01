
public class SolveNQueen {
	
	static boolean first = true;	
	static int userCol; 
	static int userRow;
	
	public void intialize() //sets the board up
	{
		int[][] box ={//chess board
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}
		};
		
		
		if(findsol(box,0)==false)//checks if a solution can be made and if not it prints "no solution exists"
		{
			System.out.println("no Solution exists");
		}
		printBox(box);

		
	}

	private boolean findsol(int[][] box, int col) {// this method is used to find a solution
		if(userCol > 0 && col == userCol)//skip column user inputed to if  it greater than 0
		{
		col++;
		}
		
		if(col >= 8)// check if at end
		{
			return true;
		}
		for(int i = 0; i < 8; i++)//main for loop
		{


		if(placeQueenorNot(box, i, col)== true)// checks if queen can be put down
		{ 
			if(first == true) //adds first queen
			{
				first = false;
				box[userRow][userCol] = 1;
				
				//if queen is in a any column but 1 minus the column to set it back to 0 later
				if(userCol > 0) 
				{
				col--;
				}
			}
			else //adds the rest of the queens
			{
				box[i][col] = 1;
			}
			
			
			
	
			if(findsol(box, col+1) == true)//adds next queen in the next column, if possible
			{

				return true;
			}
			box[i][col] = 0;//used to backtrack, if the program needs to
		}

		
		
		}
	
		return false;
		
	}


	private boolean placeQueenorNot(int[][] box, int row, int col) {//used to find if a queen can be placed
		//checks each part to make sure it can fit, if it returns false a queen can't be put, if it returns
		//true a queen can be place
		
		
		//check column
		for(int i = 0; i< 8; i++)
		{				
			if(box[row][i] == 1)
			{
				return false;
			}
		
		}

		//check up and left
		for(int i = row, j = col; i >= 0 && j >=0; i--, j--)
		{
			if(box[i][j] == 1)
			{
				return false;
			}
		}
		//check up and right
		for(int i = row, j = col; i < 0 && j >8; i--, j++)
		{
			if(box[i][j] == 1)
			{
				return false;
			}
		}
		//check left and down
		for(int i = row, j = col; i < 8 && j > 0; i++, j--)
		{
			if(box[i][j] == 1)
			{
				return false;
			}
		}
		//check right and down
		for(int i = row, j = col; i > 8 && j > 8; i++, j++)
		{
			if(box[i][j] == 1)
			{
				return false;
			}
		}
		return true;
	}

	private void printBox(int[][] box) {//used to print the board when done
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(box[i][j] == 0)
				{
					System.out.print("[] ");
				}
				else
				{
					System.out.print(" q ");
				}
			}
			System.out.println();
		}
		
	}

}
