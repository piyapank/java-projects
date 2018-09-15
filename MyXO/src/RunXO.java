import java.util.ArrayList;

public class RunXO {
	private char[] board = new char[9];
	private ArrayList<Integer> availablePos = new ArrayList<>();
	// O = 0, X = 1, Tie = 2 //
	private int playerTurn = 1;
	// O wins = 0, X wins = 1, Tie = 2, Playing = 3 //
	private int whoWins = 3;
	
	public RunXO(int playerTurn)
	{
		System.out.println("Initiate XO game!");		
		InitiateBoard();
	}
	
	private void GameStatus()
	{
		XORules rules = new XORules(this.board);
		this.whoWins = rules.CheckWin();
				
		if(whoWins == 0)
		{
			System.out.println("O won the match! \n Type 'clear' to reset the board or 'exit' to exit the game.");
		}
		else if(whoWins == 1)
		{
			System.out.println("X won the match! \n Type 'clear' to reset the board or 'exit' to exit the game.");
		}
		else if(whoWins == 2)
		{
			System.out.println("Tie! \n Type 'clear' to reset the board or 'exit' to exit the game.");
		}
		else
		{
			System.out.println("Keep playing!");
		}
	}
	
	public int getBoardSize()
	{
		return this.board.length;
	}
	
	public void setX(int pos)
	{
		this.board[pos - 1] = 'X';
	}
	
	public void setY(int pos)
	{		
		this.board[pos - 1] = 'O';
	}
	
	public void setTurn(char player)
	{		
		if(player == 'X')
		{
			playerTurn = 1;
		}
		if(player == 'O')
		{
			playerTurn = 0;
		}		
	}
	
	public void displayBoardGraphics()
	{
		int i = 0;
		System.out.println( " _" +  " _ " + "_" );
		for(i = 0; i <= this.board.length - 1; i++)
		{
			if( (i+1) % 3 == 0)
			{
				System.out.println( board[i] + "|");
			}
			else if ((i+1) % 3 == 1)
			{
				System.out.print("|" + board[i] + "|");
			}
			else if ((i+1) % 3 == 2)
			{
				System.out.print(board[i] + "|");
			}
		}
		System.out.println("");
		GameStatus();	
		System.out.println("");
	}
	
	public void clearBoard()
	{
		this.board = new char[9];
		this.whoWins = 3;
		InitiateBoard();
	}
	
	private void takesTurn()
	{
		if(this.playerTurn == 1)
		{
			this.playerTurn = 0;
			return;
		}
		else if(this.playerTurn == 0)
		{
			this.playerTurn = 1;
			return;
		}	
	}
	
	public void setTurn(int pos)
	{
		int player = this.playerTurn;
		if(this.checkIfValidPos(pos) == 1)
		{							
			if(player == 1)
			{
				setX(pos);
			}
			if(player == 0)
			{
				setY(pos);
			}		
			takesTurn();
		}
	}
	
	public void getTurn()
	{
		int player = this.playerTurn;		
		if(player == 1)
		{
			System.out.print("Set X at: ");
		}
		if(player == 0)
		{
			System.out.print("Set O at: ");
		}		
	}

	private void InitiateBoard()
	{
		for(int i = 0 ; i <= this.board.length - 1; i ++)
		{
			// Display digits. //
			// board[i] = Character.forDigit(i+1, 10);
			// Display underscore. //
			   this.board[i] = '_';
		}
	}
	
	public void setAvailablePosition()
	{ 		
		System.out.print("Available positions: ");
		for(int i = 0; i <= this.board.length - 1; i ++)
		{
			if(this.board[i] == '_')
			{	
				this.availablePos.add((i+1));			
				//System.out.print( (i+1) + ", ");
			}			
		}
		
		for(int i = 0; i <= this.availablePos.size() - 1; i ++)
		{
			if(i == this.availablePos.size() - 1)
				System.out.print(this.availablePos.get(i));
			else
				System.out.print(this.availablePos.get(i) + ",");
		}	
		this.availablePos = new ArrayList<>();
		System.out.println("");
	}
	
	public int checkIfValidPos(int pos)
	{	
		int flag = 0;
		for(int i = 0; i <= this.board.length - 1; i ++)
		{
			if(this.board[i] == '_')
			{	
				this.availablePos.add((i+1));			
				//System.out.print( (i+1) + ", ");
			}			
		}
		
		for(int i = 0 ; i <= this.availablePos.size() - 1; i ++)
		{
			if(this.availablePos.get(i) == pos)
			{
				flag = 1;
			}
		}
		this.availablePos = new ArrayList<>();
		return flag;
	}
	
}
