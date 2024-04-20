import java.util.*;
public class OthelloGame {

    public static void board(char[][] board, int size){
        
    }
    public static char[][] position(char[][] board, int size){
        board[size/2-1][size/2-1]= 'W';
        board[size/2][size/2-1]= 'B';
        board[size/2-1][size/2]= 'B';
        board[size/2][size/2]= 'W';

        return board;

    }
    public static void print(char[][] board){
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");

            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO OTHELLO ");
        int size = 8;
        char[][] board = new char[size][size];
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                board[i][j]='-';

            }
        }
        board = position(board, size);
        print(board);

    }
}

class game{
    Scanner sc = new Scanner(System.in);
        static char [][]board;
    static int x,y;
    public game(char[][]board,int x,int y){
        this.board = board;
        this.x = x;
        this.y = y;
    }

    public static void move(){

    }
}