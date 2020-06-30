package checkers;

import boardgame.Board;
import boardgame.Piece;

public abstract class CheckersPiece extends Piece {

	private Color color;
	
	public CheckersPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}	
}
