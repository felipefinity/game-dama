package checkers;

import boardgame.BoardException;

public class CheckersException extends BoardException {
	private static final long serialVersionUID = 1L;

	public CheckersException(String msg) {
		super(msg);
	}
}
