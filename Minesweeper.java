import java.util.Scanner;

public class Minesweeper{
	public static void main (String[] args){	
		String[] board, in;
		boolean playig=true;
		Scanner sc = new Scanner(System.in);

		//print rules
		System.out.println("Minesweeper");
		System.out.println("rules");

		System.out.println("Entre height, width and mines");
		in = sc.nextLine().split(" ");
		board.newGame(in);


		}
	}

}
/*
print (ingresa alto, ancho y # minas)
in = leerString.splir(" ")
board.newGame(in)

	do{
	borad.printBoard()
	print(ingrese row, column & action)
	in = leerString.split(" ")
	if(in[2].equals("M")){
		board.Mark(in)
	}else if(in[2].equals("U")){
		playing=board.select(in)
	}else if(in[0]==exit){	

	}else{
		print(error)
	} 
	}while(in[0] != "exit" & playing)
}
*/