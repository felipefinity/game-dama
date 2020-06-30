package checkers.pieces;

import boardgame.Board;
import checkers.CheckersPiece;
import checkers.Color;

public class Lady extends CheckersPiece {

	public Lady(Board board, Color color) {
		super(board, color);		
	}

	@Override
	public String toString() {
		return "@";
	}	
}
