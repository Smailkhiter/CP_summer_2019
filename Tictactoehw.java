	 package src.pl.waw.sgh;
	 import java.io.File;
	 import java.io.FileNotFoundException;
	 import java.util.Scanner;


	 public class HomeworkTicTacToe {
	     public static void main(String[] args) throws FileNotFoundException {
	         int n=3;
	         boolean finish = false;
	         boolean empty = false;
	         int diag1 = 0;
	         int diag2 = 0;
	         String path = "C:/Users/Smail/Code/SGH/tictactoe.csv";
	         File file = new File(path);

	         int[][] game = new int[n][n];

	         Scanner fileScanner = new Scanner(file);
	         while (fileScanner.hasNext()) {
	             for(int i=0;i<=(n-1);i++){
	             String line = fileScanner.nextLine();
	             String[] cells = line.split(";");

	                 for (int j=0;j<=(n-1);j++){
	                     String res = cells[j];
	                     if (res.equals("X")){
	                         game[j][i] = 1;
	                     }
	                     else if (res.equals("O")){
	                         game[j][i] = -1;
	                     }
	                     else if (res.equals("") || res.equals(" ") || res.equals(0)) {
	                         game[j][i] = 0;
	                         System.out.println("keep playing, the game isn't over");
	                         break;
	                     }
	                     else {
	                         System.out.println("There's an error in the filling of the board");
	                         break;
	                     }

	                 }
	             }

	         }

	         outerloop:
	         for (int i = 0; i <= (n-1); i++) {
	             int row = 0;
	             int col = 0;

	             for (int j = 0; j <= (n-1); j++) {
	                 if (game[i][j] == 0) {
	                     empty = true;
	                     break;
	                 }
	             }
	             if (empty == true) {
	                 System.out.println("keep playing, the game isn't over");
	                 break;
	             }
	             else {
	                 for (int j = 0; j <= (n-1); j++) {

	                     row = row + game[i][j];
	                     col = col + game[j][i];
	                     if (row == n || col == n) {
	                         System.out.println("Player 1 wins");
	                         finish=true;
	                         break outerloop;

	                     } else if (row == -n || col == -n) {
	                         System.out.println("Player 2 wins");
	                         finish = true;
	                         break outerloop;
	                     }
	                                     }
	                 diag1 = diag1 + game[i][i];
	                 diag2 = diag2 + game[i][(n-1-i)];
	             }

	             }
	         if (finish == false) {
	             if (diag1 == n || diag2 == n) {
	                 System.out.println("Player 1 wins");
	             } else if (diag1 == -n || diag2 == -n) {
	                 System.out.println("Player 2 wins");
	             } else {           
	                 System.out.println("Draw");
	             }
	         }

	     }

}
