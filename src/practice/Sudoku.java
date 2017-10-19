package practice;

import java.util.HashSet;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] board=new char[9][9];
		char [] board0={'.' , '.' , '.' , '.' , '7' , '.' , '.' , '.' , '.'};
		char [] board1={'6' , '.' , '.' , '1' , '9' , '5' , '.' , '.' , '.'};
		char [] board2={'.' , '9' , '8' , '.' , '.' , '.' , '.' , '6' , '.'};
		char [] board3={'8' , '.' , '.' , '.' , '6' , '.' , '.' , '.' , '3'};
		char [] board4={'4' , '.' , '.' , '8' , '.' , '3' , '.' , '.' , '1'};
		char [] board5={'7' , '.' , '.' , '.' , '2' , '.' , '.' , '.' , '6'};
		char [] board6={'.' , '6' , '.' , '.' , '.' , '.' , '2' , '8' , '.'};
		char [] board7={'.' , '.' , '.' , '4' , '1' , '9' , '.' , '.' , '5'};
		char [] board8={'.' , '.' , '.' , '.' , '8' , '.' , '.' , '7' , '9'};
		board[0]=board0;
		board[1]=board1;
		board[2]=board2;
		board[3]=board3;
		board[4]=board4;
		board[5]=board5;
		board[6]=board6;
		board[7]=board7;
		board[8]=board8;
		solveSudoku(board);
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
		
		
		
	}
	 public static void solveSudoku(char[][] board){
	        solve(board);
	    }

	    public static boolean solve(char[][] board) {
	        for(int i = 0; i < 9; i++) {
	            for(int j = 0; j < 9; j++){
	                if(board[i][j] != '.'){
	                    continue;
	                }
	                for(int k = 1; k <= 9; k++){
	                    board[i][j] = (char) (k + '0');
	                    if (isValid(board, i, j) && solve(board)){
	                        return true;
	                    }
	                    board[i][j] = '.';
	                }
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    
	     public static boolean isValid(char[][] board, int a, int b){
	        HashSet<Character> contained = new HashSet<Character>();
	        for(int j=0;j<9;j++){
	            if(contained.contains(board[a][j])) return false;
	            if(board[a][j]>'0' && board[a][j]<='9')
	                contained.add(board[a][j]);
	        }
	            
	        
	    
	        contained = new HashSet<Character>();
	        for(int j=0;j<9;j++){
	            if (contained.contains(board[j][b])) {
	                return false;
	            }
	            if (board[j][b]>'0' && board[j][b]<='9') {
	                contained.add(board[j][b]);
	            }
	        }
	        
	    
	        contained = new HashSet<Character>();
	        for (int m = 0; m < 3; m++) {
	            for (int n = 0; n < 3; n++){
	                int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
	                if (contained.contains(board[x][y])) {
	                    return false;
	                }
	                if (board[x][y] > '0' && board[x][y] <= '9') {
	                        contained.add(board[x][y]);
	                }
	            } 
	        }
	    
	        return true;
	    }

}
