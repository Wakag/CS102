import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

	public static Scanner  scan = new Scanner(System.in);
	public static String [][] board = new String[3][3];
	public static String player1  = "X";
	public static String player2 = "O";

	
	public static void theBoard(){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = " _ ";
			}
		}
		
		for (int i = 0; i < 3; i++){
			System.out.print("|");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j]);
				System.out.print("|");
			}
			
		}
		
		System.out.println();
	}

	public static void player1Input(){

		while(true){
			System.out.println("Player 1's turn");
			System.out.println();

			System.out.print("Row");
			int row = scan.nextInt();

			System.out.print("Col");
			int col = scan.nextInt();
			

			if (board[row-1][col-1].equals(" _ ")){
				board[row-1][col-1] = " " + player1 + " ";
			}else{
				System.out.print("You cannot play there");
				continue;
			}

			for (int i = 0; i < 3; i++){
				System.out.print("|");
				for (int j = 0; j < 3; j++){
					System.out.print(board[i][j]);
					System.out.print("|");
				}
				
				System.out.println();
			}
			
			break;

		}

	}

	

	public static void player2Input(){

		while(true){
			System.out.println("Player 2's turn");
			System.out.println();

			System.out.print("Row");
			int row = scan.nextInt();

			System.out.print("Col");
			int col = scan.nextInt();
			

			if (board[row-1][col-1].equals(" _ ")){
				board[row-1][col-1] = " " + player2 + " ";
			}else{
				System.out.print("You cannot play there");
				continue;
			}

			for (int i = 0; i < 3; i++){
				System.out.print("|");
				for (int j = 0; j < 3; j++){
					System.out.print(board[i][j]);
					System.out.print("|");
				}
				
				System.out.println();
			}
			
			break;

		}


		
	}
	
	public static void main (String[] args){
	
		while (true){
			theBoard();
			player1Input();
			player2Input();
		}

		
	}
	


}