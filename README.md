== PSL-challange
'Daniel Morales Londoño - dmoral12@eafit.edu.co
	this is Minesweeper, in this program you can
	interact with the game, it has the same rules 
==Rules: 
* _Paso 1:_you've to enter the size of the board and
	the nomber of mines.

*you've to enter the position of the cell
	you want to select or mark

*if you select a mine you're dead

*if you find all mines and you mark them
	with flags you win

*if you open all wite spaces depiring mines
	you win

*you've to gess where're the mines located
	suporting you in the cell with numbers,
	numbres tells you how many mines
	does the cell is touching
	
*if wanna end the game just enter exit.	

==Requeriments
	this proyec needs had intaled the java jdk
	and needs JUnit to run the test

==Usefull commands(Ubuntu 16)
	after installing Junit run
	javac -cp /usr/share/java/junit4.jar ErrorsTest.java Errors.java
	java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore ErrorsTest	
