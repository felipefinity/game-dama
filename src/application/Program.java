package application;

import checkers.CheckersMatch;

public class Program {

	public static void main(String[] args) {
		
		CheckersMatch checkersMatch = new CheckersMatch();
		UI.printBoard(checkersMatch.getPieces());
	}
}
