import java.util.Scanner;

public class Minesweeper{ 
    /** 
     * This is the main Minesweeper class
     * here the programs interac with the user by the console
     */
    public static void main(String[] args){    
        String[] in;
        boolean playing=true;
        int height, width;
        Scanner sc = new Scanner(System.in);
        Errors err = new Errors();
        Board board = new Board();

        System.out.println("Minesweeper");
        System.out.println("Enter height, width and mines");
        
        /** while the user doesn't enter a right imput program doesn't continue*/
        do{    
           in = sc.nextLine().split(" "); 
        }while(!err.sizeSintaxCheck(in) || !err.sizeLogicCheck(in));      
        height=Integer.parseInt(in[0]);
        width=Integer.parseInt(in[1]);
        board.newGame(in);

        System.out.println("enter exit to finish");
        do{
            board.printBoard();
            System.out.println("enter row, column and an action");
            do{
                in = sc.nextLine().split(" ");
                if(in[0].equals("exit")){
                    System.exit(0);
                }
            }while(!err.inputSintaxCheck(in) || !err.inputLogicCheck(in,height,width));
            
            if(in[2].equals("M")){
                playing=board.mark(in);
            }else if(in[2].equals("U")){
                playing=board.select(in);
            }else{
                System.out.println("command no found");
            }
            playing = board.win()&playing;
        }while(playing);
    }
}