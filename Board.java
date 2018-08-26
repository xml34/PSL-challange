import java.util.Random;  
public class Board{    
    private String[][] board1,board2;
    private int[][] board3;
    private int rows,cols,mins,contRight,contFlags,contLeftingCells;
    private Random aleatorio = new Random(System.currentTimeMillis());
    
    public Board(){}
    
    /**Create a new game by the user specifications 
     *And fill the borads1 and 2, with " . " 
     */
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
        System.out.println("Ignore this if you're not a cheat or tester");
        printBoard2();
    }
    
    /**
    * just parses an it
    */
    private int parse(String x){
        return Integer.parseInt(x);
    }
    
    /**
    * maps the mines randomly in board2
    */
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
    
    /**
    * mark or unmark the cell an check if all the mines are already marked
    * and if it's true, finish the game
    */
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
    
    /**
    * selec a cell, if it has a mine the program ends but if it doesn't,
    * print " - " an col the freeSpaces methods to continue releasing cells
    */
    public boolean select(String[] in){
        int row=parse(in[0]);
        int col=parse(in[1]);
                
        if(board1[row][col].equals(" P ")){
            System.out.println("flag");
        }else if(board2[row][col].equals(" . ")&& board1[row][col]==" . "){
            if(board3[row][col]==0){
                board1[row][col] = " - ";
            }else{
                board1[row][col] = " "+board3[row][col]+" ";
            }
            
            contLeftingCells++;
            freeSpaces(row,col);
        }else if(board2[row][col].equals(" * ")){
            showMines();
            System.out.println("You lose °_°");
            return false;
        }
        return true;
    }
    
    /**
    * this method is who calcules the matrix numbers. 
    * numbers that indicate where are the mines located
    * this method is suported by plus method
    */
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
    
    /**
    * board ij ++
    */
    private void plus(int i,int j){
         if(i>=0 && j>=0 && i<rows && j<cols){
             board3[i][j]=board3[i][j]+1;
         }
    }
    
    /**
    * arter select a cell, this method search for numers and black spaces
    * close to the selected cell
    * this one is suported by mine who work with recursivity
    */
    private void freeSpaces(int i,int j){        
         /*mine(i-1,j-1);*/ mine(i-1,j); /*mine(i-1,j+1);*/
         mine(i,j-1);  /*mine(i,j);*/ mine(i,j+1);
         /*mine(i+1,j-1)*/; mine(i+1,j); /*mine(i+1,j+1);*/        
    }
    
    /**
    * this create a recursive loop by calling freeSpaces
    * print a numbre o " - " in chosen cells
    */
    private void mine(int i,int j){
         if(i>=0 && j>=0 && i<rows && j<cols){
             if(board2[i][j].equals(" . ") && board1[i][j].equals(" . ")){
                 if(board3[i][j]==0){
                     board1[i][j]=" - ";
                     contLeftingCells++;
                 }else{
                     board1[i][j]=" "+board3[i][j]+" ";
                     contLeftingCells++;
                 }
                 if(board3[i][j]==0){
                     freeSpaces(i,j);
                 }
             }
        }
    }
    
    /**
    * this methos check if user has won
    */
    public boolean win(){
        if((contRight == mins && contFlags == mins) ||contLeftingCells == rows*cols-mins){
            printBoard();
            System.out.println("You won °u°");
            return false;
        }
        return true;
    }
    
    /**
    * print mines after lose
    */
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
    
    /**
    * print actual board
    */
    public void printBoard(){
        System.out.print("  ");
        for(int k =0;k< cols;k++){
            System.out.print(" "+k+" ");
        }
        System.out.println();
        for(int i =0; i < rows;i++){
            System.out.print(i+" ");
            for(int j =0; j < cols;j++){
                System.out.print(board1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /**
    * is to cheat
    * just for developer and tester ¬¬ ojo 
    */
    public void printBoard2(){
        for(int i =0; i < rows;i++){
            for(int j =0; j < cols;j++){
                System.out.print(board2[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}