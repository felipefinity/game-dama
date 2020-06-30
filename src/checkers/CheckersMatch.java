package checkers;

import boardgame.Board;
import boardgame.Position;
import checkers.pieces.Lady;

public class CheckersMatch {

	private Board board;
	
	public CheckersMatch() {		
		board = new Board(8, 8);
		initialSetup();
	}
	
	public CheckersPiece[][] getPieces() {
		CheckersPiece[][] mat = new CheckersPiece[board.getRows()][board.getColumns()];
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (CheckersPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Lady(board, Color.BLUE), new Position(0, 1));
		board.placePiece(new Lady(board, Color.BLUE), new Position(0, 3));
		board.placePiece(new Lady(board, Color.BLUE), new Position(0, 5));
		board.placePiece(new Lady(board, Color.BLUE), new Position(0, 7));
		board.placePiece(new Lady(board, Color.BLUE), new Position(1, 0));
		board.placePiece(new Lady(board, Color.BLUE), new Position(1, 2));
		board.placePiece(new Lady(board, Color.BLUE), new Position(1, 4));
		board.placePiece(new Lady(board, Color.BLUE), new Position(1, 6));
		board.placePiece(new Lady(board, Color.BLUE), new Position(2, 1));
		board.placePiece(new Lady(board, Color.BLUE), new Position(2, 3));
		board.placePiece(new Lady(board, Color.BLUE), new Position(2, 5));
		board.placePiece(new Lady(board, Color.BLUE), new Position(2, 7));
		
		board.placePiece(new Lady(board, Color.RED), new Position(7, 0));
		board.placePiece(new Lady(board, Color.RED), new Position(7, 2));
		board.placePiece(new Lady(board, Color.RED), new Position(7, 4));
		board.placePiece(new Lady(board, Color.RED), new Position(7, 6));
		board.placePiece(new Lady(board, Color.RED), new Position(6, 1));
		board.placePiece(new Lady(board, Color.RED), new Position(6, 3));
		board.placePiece(new Lady(board, Color.RED), new Position(6, 5));
		board.placePiece(new Lady(board, Color.RED), new Position(6, 7));
		board.placePiece(new Lady(board, Color.RED), new Position(5, 0));
		board.placePiece(new Lady(board, Color.RED), new Position(5, 2));
		board.placePiece(new Lady(board, Color.RED), new Position(5, 4));
		board.placePiece(new Lady(board, Color.RED), new Position(5, 6));		
	}
}
