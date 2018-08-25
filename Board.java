import java.util.Random;  
public class Board{
    
	private String[][] board1,board2;
	private int rows,cols,mins;
	private int[][] board3;
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
		printBoard();
		printBoard2();
	}

	public static int parse(String x){
		return Integer.parseInt(x);
	}
	
	public void setMines(){
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

	public void mark(String[] in){
	    int row=parse(in[0]);
	    int col=parse(in[1]);

		if(board1[row][col].equals(" . ")){
			board1[row][col] = " P ";
		}else if(board1[row][col].equals(" P ")){
			board1[row][col] = " . ";
		}
	}
	
	public boolean select(String[] in){
	    int row=parse(in[0]);
	    int col=parse(in[1]);
	    	    
	    if(board1[row][col].equals(" P ")){
	                System.out.println("flag");
            }else if(board2[row][col].equals(" . ")){
			board1[row][col] = " - ";
			//setNumbers();
            }else if(board2[row][col].equals(" * ")){
                        System.out.println("You lose °_°");
                        return false;
            }
            return true;
	}
	
	public void setBoardNumbers(){
	    //esquinas
	    checkCorners();
	}
	
	public void checkCorners(){
	    if(board2[0][0].equals(" * ")){
	        board3[0][1]=board3[0][1]+1; board3[1][0]=board3[1][0]+1; board3[1][1]=board3[1][1]+1;
	    }
	    if(board2[0][cols-1].equals(" * ")){
	        board3[0][cols-2]=board3[0][cols-2]+1; board3[1][cols-1]=board3[1][cols-1]+1; board3[1][cols-2]=board3[1][cols-2]+1;
	    }
	    if(board2[rows-1][0].equals(" * ")){
	        board3[rows-2][0]=board3[rows-2][0]+1; board3[rows-2][1]=board3[rows-2][1]+1; board3[rows-1][1]=board3[rows-1][1]+1;
	    }
	    if(board2[rows-1][cols-1].equals(" * ")){
	        board3[rows-2][cols-1]=board3[rows-2][cols-1]+1; board3[rows-2][cols-2]=board3[rows-2][cols-2]+1;
	        board3[rows-1][cols-2]=board3[rows-1][cols-2]+1;
	    }
	}
	
	public void checkSides(){
	    for(int j =1; j < cols-1;j++){
	        if(board2[0][j].equals(" * ")){
	            board2[0][j-1]=board2[0][j-1]+1;  
	        }
	    }
	}
	
	public void printBoard(){
	    for(int i =0; i < rows;i++){
		    for(int j =0; j < cols;j++){
		        System.out.print(board1[i][j]);
		    }
		    System.out.println();
		}
	}
	
	public void printBoard2(){
	    for(int i =0; i < rows;i++){
		    for(int j =0; j < cols;j++){
		        System.out.print(board2[i][j]);
		    }
		    System.out.println();
		}
	}
}