import java.util.ArrayList;

public class XORules {
	 /*
	  * 1 2 3
	  * 4 5 6
	  * 7 8 9
	  * 
	  * Winning conditions:
	  * 
	  * 0 = [1,2,3]
	  * 1 = [4,5,6]
	  * 2 = [7,8,9]
	  * 
	  * 3 = [1,4,7]
	  * 4 = [2,5,8]
	  * 5 = [3,6,9]
	  * 
	  * 6 = [1,5,9]
	  * 7 = [3,5,7]
	  * 
	  */
	private int[][] conditions = new int[8][3];	
	private ArrayList<Integer> xVals = new ArrayList<>();
	private ArrayList<Integer> yVals = new ArrayList<>();
	private char[] board;
	
	public XORules(char[] board)
	{
		this.board = board;
		for(int i = 0; i <= board.length - 1; i ++)
		{
			if(board[i] == 'X')
			{
				xVals.add(i+1);
			}
			if(board[i] == 'O')
			{
				yVals.add(i+1);
			}
		}
				
			// Horizontal. //
		this.conditions[0][0] = 1;
		this.conditions[0][1] = 2;
		this.conditions[0][2] = 3;
		
		this.conditions[1][0] = 4;
		this.conditions[1][1] = 5;
		this.conditions[1][2] = 6;
		
		this.conditions[2][0] = 7;
		this.conditions[2][1] = 8;
		this.conditions[2][2] = 9;
		
			// Vertical. //
		this.conditions[3][0] = 1;
		this.conditions[3][1] = 4;
		this.conditions[3][2] = 7;
		
		this.conditions[4][0] = 2;
		this.conditions[4][1] = 5;
		this.conditions[4][2] = 8;
		
		this.conditions[5][0] = 3;
		this.conditions[5][1] = 6;
		this.conditions[5][2] = 9;
		
			// Diagonal. //
		this.conditions[6][0] = 1;
		this.conditions[6][1] = 5;
		this.conditions[6][2] = 9;
		
		this.conditions[7][0] = 3;
		this.conditions[7][1] = 5;
		this.conditions[7][2] = 7;
	}
	
	// O wins = 0, X wins = 1, Tie = 2, Playing = 3 //
	public int CheckWin()
	{		
		int winner = 3;
		// This is for testing user's input values. //
		/*System.out.print("X: ");
		for(int i = 0; i <= this.xVals.size() - 1; i++)
		{
			System.out.print(this.xVals.get(i) + ",");
		}
		System.out.println("");
		System.out.print("O: ");
		for(int i = 0; i <= this.yVals.size() - 1; i++)
		{
			System.out.print(this.yVals.get(i) + ",");
		}*/
		int space = 0;
		for(int i = 0; i <= this.board.length - 1; i ++)
		{
			if(this.board[i] == '_')
			{	
				space++;
			}			
		}
		if(space == 0)
		{
			return 2;
		}
		
		for(int j = 0; j <= this.conditions.length - 1; j++)
		{
			int uno = this.conditions[j][0];
			int dos = conditions[j][1];
			int tre = conditions[j][2];
			
			boolean xFirst  = false;
			boolean xSecond = false;
			boolean xThird  = false;
			for(int k = 0; k <= this.xVals.size() - 1; k++)
			{
				if(uno == this.xVals.get(k))
				{
					xFirst = true;
				}
				if(dos == this.xVals.get(k))
				{
					xSecond = true;
				}
				if(tre == this.xVals.get(k))
				{
					xThird = true;
				}
			}
			
			if(xFirst == true && xSecond == true && xThird == true)
			{
				//System.out.println("X is the winner!");
				return 1;			
			}
			
			boolean yFirst  = false;
			boolean ySecond = false;
			boolean yThird  = false;
			
			for(int k = 0; k <= this.yVals.size() - 1; k++)
			{
				if(uno == this.yVals.get(k))
				{
					yFirst = true;
				}
				if(dos == this.yVals.get(k))
				{
					ySecond = true;
				}
				if(tre == this.yVals.get(k))
				{
					yThird = true;
				}
			}
			
			if(yFirst == true && ySecond == true && yThird == true)
			{
				//System.out.println("O is the winner!");
				return 0;
			}
		}
		
		
		return winner;
	}
}
