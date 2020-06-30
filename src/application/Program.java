package application;

import java.util.Scanner;

import checkers.CheckersMatch;
import checkers.CheckersPiece;
import checkers.CheckersPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CheckersMatch checkersMatch = new CheckersMatch();
		while (true) {
			UI.printBoard(checkersMatch.getPieces());
			System.out.println();
			System.out.print("Source: ");
			CheckersPosition source = UI.readCheckersPosition(sc);
			
			System.out.println();
			System.out.print("Target: ");
			CheckersPosition target = UI.readCheckersPosition(sc);
			
			CheckersPiece capturedPiece = checkersMatch.performCheckersMove(source, target);
		}
	}
}
