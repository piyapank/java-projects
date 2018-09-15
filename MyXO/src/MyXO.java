// Created by Piyapan K. (15/09/2018) // 
// Copyright policy: Do what ever you want :) //
/*
 * MyXO program consists of 3 java classes
 * 
 * 	1. MyXO.java
 *  2. RunXO.java
 *  3. XORules.java
 * 
 * How to run this program:
 * 
 *  - Use terminal or command line for best result.
 *  	if you run this on Eclipse IDE, it may cause an error
 *  	on clearScreen function (you can edit this function
 *  	and improve it in anyway you like.) To run this program, 
 *		open any terminal and type 
 *
 *			 'javac MyXO.java RunXO.java XORules.java' 
 *		
 *		to compile the program, and then type 
 *			
 *						  'java MyXO' 
 *
 *		to run the MyXO file.
 *  
 *  	Enjoy \^_^/
 */

import java.util.Scanner;

public class MyXO {	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{	
		RunXO xo = new RunXO(0);
		String s = "";
		Scanner st = new Scanner(System.in);	
		while(!s.matches("exit"))
		{					
			clearScreen();
			System.out.println("Welcome to simple Tic-Tac-Toe game.");
			xo.displayBoardGraphics();
			xo.setAvailablePosition();
			xo.getTurn();		
			s = st.nextLine();					
			// Exit the program. //
			if(s.matches("exit"))
			{
				System.out.println("Exit Program");
				break;
			}
			// Clear the board. //
			else if(s.matches("clear"))
			{
				System.out.println("Board Cleared!");
				xo.clearBoard();
			}	
			else if(s.matches("[a-z?][A-Z?]\t"))
			{
				System.out.println("Insert the following values or type 'clear' to reset the board  or 'exit' to exit the program.");
			}
			
			// Player takes turn. //		
			if(s.length() > 1 || 
					Integer.parseInt(s) <= 0 || 
					Integer.parseInt(s) > 9  
					)
			{
				System.out.println("Insert the following values.");
			}			
			else
			{							
				xo.setTurn(Integer.parseInt(s));									
			}
						
		}
	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
		
}