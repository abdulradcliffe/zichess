package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Piece;
import com.zichess.Position;

public class Rook implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece rook, Piece[][] board) {
		List<Position> positions = new LinkedList<Position>();
		int fromX = rook.getPosition().x;
		int fromY = rook.getPosition().y;

		// check for top diagonal
		int targetX = fromX - 1;
		int targetY = fromY;
		while (targetX >= 1) {
			if (board[targetX][targetY] != null) {
				if (board[targetX][targetY].getColor() != rook.getColor()) {
					Position p = new Position(targetX, targetY);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetX--;
		}

		// check for right diagonal
		targetX = fromX;
		targetY = fromY + 1;
		while (targetY <= 8) {
			if (board[targetX][targetY] != null) {
				if (board[targetX][targetY].getColor() != rook.getColor()) {
					Position p = new Position(targetX, targetY);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetY++;
		}

		// check for bottom diagonal
		targetX = fromX + 1;
		targetY = fromY;
		while (targetX <= 8) {
			if (board[targetX][targetY] != null) {
				if (board[targetX][targetY].getColor() != rook.getColor()) {
					Position p = new Position(targetX, targetY);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetX++;
		}

		// check for left diagonal
		targetX = fromX;
		targetY = fromY - 1;
		while (targetY >= 1) {
			if (board[targetX][targetY] != null) {
				if (board[targetX][targetY].getColor() != rook.getColor()) {
					Position p = new Position(targetX, targetY);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetY--;
		}
		return positions;
	}

}
