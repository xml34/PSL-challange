import java.util.Scanner;

public class Minesweeper{
    public static void main (String[] args){    
        String[] in;
        boolean playing=true;
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        //print rules
        System.out.println("Minesweeper");
        System.out.println("rules");
        System.out.println("Entre height, width and mines");
        in = sc.nextLine().split(" ");
        board.newGame(in);

        do{
            board.printBoard();
            System.out.println("enter row, column and an action");
            in = sc.nextLine().split(" ");
            
            if(in[0].equals("exit")){
                    playing=false;
            }else if(in[2].equals("M")){
                playing=board.mark(in);
            }else if(in[2].equals("U")){
                playing=board.select(in);
            }else{
                System.out.println("command no found");
            }
        }while(playing);
    }
}