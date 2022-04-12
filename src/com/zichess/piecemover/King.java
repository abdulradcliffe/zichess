package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Piece;
import com.zichess.Position;

public class King implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece king, Piece[][] board) {
		List<Position> positions = new LinkedList<Position>();
		int fromX = king.getPosition().x;
		int fromY = king.getPosition().y;

		// check top left corner
		if (fromX > 1 && fromY > 1) {
			if (board[fromX - 1][fromY - 1] == null) {
				positions.add(new Position(fromX - 1, fromY - 1));
			} else {
				Piece existingPiece = board[fromX - 1][fromY - 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX - 1, fromY - 1));
				}
			}
		}

		// check the top square
		if (fromX > 1) {
			if (board[fromX - 1][fromY] == null) {
				positions.add(new Position(fromX - 1, fromY));
			} else {
				Piece existingPiece = board[fromX - 1][fromY];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX - 1, fromY));
				}
			}
		}

		// check top right corner
		if (fromX > 1 && fromY < 8) {
			if (board[fromX - 1][fromY + 1] == null) {
				positions.add(new Position(fromX - 1, fromY + 1));
			} else {
				Piece existingPiece = board[fromX - 1][fromY + 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX - 1, fromY + 1));
				}
			}
		}
		// check the right square
		if (fromY < 8) {
			if (board[fromX][fromY + 1] == null) {
				positions.add(new Position(fromX, fromY + 1));
			} else {
				Piece existingPiece = board[fromX][fromY + 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX, fromY + 1));
				}
			}
		}

		// check bottom right corner
		if (fromX < 8 && fromY < 8) {
			if (board[fromX + 1][fromY + 1] == null) {
				positions.add(new Position(fromX + 1, fromY + 1));
			} else {
				Piece existingPiece = board[fromX + 1][fromY + 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX + 1, fromY + 1));
				}
			}
		}

		// check the bottom square
		if (fromX < 8) {
			if (board[fromX + 1][fromY] == null) {
				positions.add(new Position(fromX + 1, fromY));
			} else {
				Piece existingPiece = board[fromX + 1][fromY];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX + 1, fromY));
				}
			}
		}

		// check bottom left corner
		if (fromX < 8 && fromY > 1) {
			if (board[fromX + 1][fromY - 1] == null) {
				positions.add(new Position(fromX + 1, fromY - 1));
			} else {
				Piece existingPiece = board[fromX + 1][fromY - 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX + 1, fromY - 1));
				}
			}
		}

		// check the left square
		if (fromY > 1) {
			if (board[fromX][fromY - 1] == null) {
				positions.add(new Position(fromX, fromY - 1));
			} else {
				Piece existingPiece = board[fromX][fromY - 1];
				if (existingPiece.getColor() != king.getColor()) {
					positions.add(new Position(fromX, fromY - 1));
				}
			}
		}

		return positions;
	}

}
