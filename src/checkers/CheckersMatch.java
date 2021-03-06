package checkers;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import checkers.pieces.Lady;

public class CheckersMatch {

	private int turn;
	private Color currentPlayer;
	private Board board;
	
	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();
	
	public CheckersMatch() {		
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.RED;
		initialSetup();
	}
	
	public int getTurn() {
		return turn;
	}
	
	public Color getCurrentPlayer() {
		return currentPlayer;
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
	
	public boolean[][] possibleMoves(CheckersPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		validateSourcePosition(position);
		return board.piece(position).possibleMoves();
	}
	
	public CheckersPiece performCheckersMove(CheckersPosition sourcePosition, CheckersPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		validateTargetPosition(source, target);
		Piece capturedPiece = makeMove(source,target);	
		nextTurn();
		return (CheckersPiece)capturedPiece;
	}
	
	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(target);
		board.placePiece(p, target);
		
		if (capturedPiece != null) {
			piecesOnTheBoard.remove(capturedPiece);
			capturedPieces.add(capturedPiece);
		}
		
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new CheckersException("There is no piece on source position");
		}
		if (currentPlayer != ((CheckersPiece)board.piece(position)).getColor()) {
			throw new CheckersException("The chosen piece is not yours");
		}
		if (!board.piece(position).isThereAnyPossibleMove()) {
			throw new CheckersException("There is no possible moves for the chosen piece");
		}
	}
	
	private void validateTargetPosition(Position source, Position target) {
		if (!board.piece(source).possibleMove(target)) {
			throw new CheckersException("The chosen piece can�t move to target position");
		}
	}
	
	private void nextTurn() {
		turn++;
		currentPlayer = (currentPlayer == Color.RED) ? Color.BLUE : Color.RED;
	}
	
	private void placeNewPiece(char column, int row, CheckersPiece piece) {
		board.placePiece(piece, new CheckersPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPiece('b', 8, new Lady(board, Color.BLUE));
		placeNewPiece('d', 8, new Lady(board, Color.BLUE));
		placeNewPiece('f', 8, new Lady(board, Color.BLUE));
		placeNewPiece('h', 8, new Lady(board, Color.BLUE));
		placeNewPiece('a', 7, new Lady(board, Color.BLUE));
		placeNewPiece('c', 7, new Lady(board, Color.BLUE));
		placeNewPiece('e', 7, new Lady(board, Color.BLUE));
		placeNewPiece('g', 7, new Lady(board, Color.BLUE));
		placeNewPiece('b', 6, new Lady(board, Color.BLUE));
		placeNewPiece('d', 6, new Lady(board, Color.BLUE));
		placeNewPiece('f', 6, new Lady(board, Color.BLUE));
		placeNewPiece('h', 6, new Lady(board, Color.BLUE));
		
		placeNewPiece('a', 1, new Lady(board, Color.RED));
		placeNewPiece('c', 1, new Lady(board, Color.RED));
		placeNewPiece('e', 1, new Lady(board, Color.RED));
		placeNewPiece('g', 1, new Lady(board, Color.RED));
		placeNewPiece('b', 2, new Lady(board, Color.RED));
		placeNewPiece('d', 2, new Lady(board, Color.RED));
		placeNewPiece('f', 2, new Lady(board, Color.RED));
		placeNewPiece('h', 2, new Lady(board, Color.RED));
		placeNewPiece('a', 3, new Lady(board, Color.RED));
		placeNewPiece('c', 3, new Lady(board, Color.RED));
		placeNewPiece('e', 3, new Lady(board, Color.RED));
		placeNewPiece('g', 3, new Lady(board, Color.RED));
	}
}
