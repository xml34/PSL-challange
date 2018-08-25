import java.util.Random;  
public class Board{    
    private String[][] board1,board2;
    private int[][] board3;
    private int rows,cols,mins,contRight,contFlags;
    private Random aleatorio = new Random(System.currentTimeMillis());
    
    public Board(){}

    public void newGame(String[] in){
        rows=parse(in[0]);
        cols=parse(in[1]);
        mins=parse(in[2]);
        board1 = new String[rows][cols];
        board2 = new String[rows][cols];
        board3 = new int[rows][cols];
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                board1[i][j]=" . ";
                board2[i][j]=" . ";
            }
        }
        setMines();
        calcBoardNumbers();
        //printBoard();
        printBoard2();
        printBoard3();
    }

    private int parse(String x){
        return Integer.parseInt(x);
    }
    
    private void setMines(){
          int cont=0,i,j;
          while(cont <mins){
              i=aleatorio.nextInt(rows);
              j=aleatorio.nextInt(cols);
              if(board2[i][j].equals(" . ")){
                  board2[i][j]=" * ";
                  cont ++;
              }           
          }
    }

    public boolean mark(String[] in){
        int row=parse(in[0]);
        int col=parse(in[1]);

        if(board1[row][col].equals(" . ")){
            board1[row][col] = " P ";
            contFlags ++;
            if(board2[row][col].equals(" * ")){
                contRight ++;
                return win();//?
            }          
        }else if(board1[row][col].equals(" P ")){
            board1[row][col] = " . ";
            contFlags --;
            if(board2[row][col].equals(" * "))contRight --;
            return win();//?
        }
        return true;
    }
    
    public boolean select(String[] in){
        int row=parse(in[0]);
        int col=parse(in[1]);
                
        if(board1[row][col].equals(" P ")){
            System.out.println("flag");
        }else if(board2[row][col].equals(" . ")){
            board1[row][col] = " - ";
            freeSpaces(row,col);
        }else if(board2[row][col].equals(" * ")){
            showMines();
            System.out.println("You lose °_°");
            return false;
        }
            return true;
    }
    
    private void calcBoardNumbers(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                if(board2[i][j].equals(" * ")){
                    plus(i-1,j-1); plus(i+1,j);  plus(i-1,j+1);
                    plus(i,j+1);  /*plus(i,j);*/ plus(i,j-1);
                    plus(i+1,j-1); plus(i-1,j);  plus(i+1,j+1);
                }
            }
        }
    }
    
    private void plus(int i,int j){
         if(i>=0 && j>=0 && i<rows && j<cols){
             board3[i][j]=board3[i][j]+1;
         }
    }
    
    private void freeSpaces(int i,int j){        
         /*mine(i-1,j-1);*/ mine(i-1,j); /*mine(i-1,j+1);*/
         mine(i,j-1);  /*mine(i,j);*/ mine(i,j+1);
         /*mine(i+1,j-1)*/; mine(i+1,j); /*mine(i+1,j+1);*/        
    }
    
    private void mine(int i,int j){
         if(i>=0 && j>=0 && i<rows && j<cols){
             if(board2[i][j].equals(" . ") && board1[i][j].equals(" . ")){
                 if(board3[i][j]==0){
                     board1[i][j]=" - ";
                 }else{
                     board1[i][j]=" "+board3[i][j]+" ";
                 }
                 if(board3[i][j]==0){
                     freeSpaces(i,j);
                 }              
             }
        }
    }

    public boolean win(){
        if(contRight == mins && contFlags == mins){
                    printBoard();
                    System.out.println("You won °u°");
                    return false;
        }
        return true;
    }
    
    private void showMines(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                if(board2[i][j].equals(" * ")){
                    board1[i][j]=" * ";
                }
            }
        }
        printBoard();
    }
    
    public void printBoard(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                System.out.print(board1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printBoard2(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                System.out.print(board2[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printBoard3(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                System.out.print(board3[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}