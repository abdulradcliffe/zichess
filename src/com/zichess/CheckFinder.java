package com.zichess;

import java.util.List;

import com.zichess.piecemover.PieceMover;
import com.zichess.piecemover.PieceMoverFactory;

public class CheckFinder {

	private static CheckFinder instance = new CheckFinder();

	public static CheckFinder getInstance() {
		return instance;
	}

	private PieceMoverFactory moverFactory;

	private CheckFinder() {
		moverFactory = PieceMoverFactory.getInstance();
	}

	/**
	 * 
	 * @param kingColor
	 * @param board
	 * @return
	 */
	public boolean isKingInCheck(Color kingColor, Piece[][] board) {
		// find the king position of the given Color
		Position kingPosition = null;
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (board[i][j] != null && board[i][j].getType() == PieceType.KING
						&& board[i][j].getColor() == kingColor) {
					kingPosition = new Position(i, j);
					break;
				}
			}
		}
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (board[i][j] != null && board[i][j].getColor() != kingColor) {
					// opposite color piece
					Piece oppositeColorPiece = board[i][j];
					// check if this piece can give me check
					PieceMover mover = moverFactory.getMover(oppositeColorPiece.getType());
					List<Position> availablePositions = mover.whereCanMove(oppositeColorPiece, board);
					for (Position p : availablePositions) {
						if (p.x == kingPosition.x && p.y == kingPosition.y) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param kingColor
	 * @param currentBoard
	 * @param piece
	 * @param targetX
	 * @param targetY
	 * @return
	 */
	public boolean isKingInCheckAfterMove(Color kingColor, Piece[][] currentBoard, Piece piece, int targetX,
			int targetY) {
		Piece[][] futureBoard = new Piece[9][9];
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (currentBoard[i][j] != null) {
					futureBoard[i][j] = new Piece(currentBoard[i][j]);
				}
			}
		}
		Piece pieceToMove = futureBoard[piece.getPosition().x][piece.getPosition().y];
		futureBoard[targetX][targetY] = pieceToMove;
		futureBoard[pieceToMove.getPosition().x][pieceToMove.getPosition().y] = null;
		return isKingInCheck(kingColor, futureBoard);
	}

	/**
	 * This method checks whether the king is in checkmate or not this is done by
	 * iterating over the pieces. and if all of the pices can not stop check from
	 * any position then its a checkmate
	 * 
	 * @param kingColor
	 * @param board
	 * @return
	 */
	public boolean isKingCheckMate(Color kingColor, Piece[][] board) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				if (board[i][j] != null && board[i][j].getColor() == kingColor) {
					Piece piece = board[i][j];
					PieceMover mover = moverFactory.getMover(piece.getType());
					List<Position> availablePositions = mover.whereCanMove(piece, board);
					for (Position p : availablePositions) {
						boolean kingWillBeInCheck = isKingInCheckAfterMove(piece.getColor(), board, piece, p.x, p.y);
						if (!kingWillBeInCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
