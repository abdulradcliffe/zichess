package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Piece;
import com.zichess.Position;

public class Knight implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece knight, Piece[][] board) {
		int fromX = knight.getPosition().x;
		int fromY = knight.getPosition().y;
		List<Position> positions = new LinkedList<Position>();
		// top right position
		if (fromX > 2 && fromY < 8) {
			int targetX = fromX - 2;
			int targetY = fromY + 1;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// right top position
		if (fromX > 1 && fromY < 7) {
			int targetX = fromX - 1;
			int targetY = fromY + 2;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// right bottom position
		if (fromX < 8 && fromY < 7) {
			int targetX = fromX + 1;
			int targetY = fromY + 2;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// bottom right position
		if (fromX < 7 && fromY < 8) {
			int targetX = fromX + 2;
			int targetY = fromY + 1;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// bottom left position
		if (fromX < 7 && fromY > 1) {
			int targetX = fromX + 2;
			int targetY = fromY - 1;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// left bottom position
		if (fromX < 8 && fromY > 2) {
			int targetX = fromX + 1;
			int targetY = fromY - 2;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// left top position
		if (fromX > 1 && fromY > 2) {
			int targetX = fromX - 1;
			int targetY = fromY - 2;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}

		// top left position
		if (fromX > 2 && fromY > 1) {
			int targetX = fromX - 2;
			int targetY = fromY - 1;
			if (board[targetX][targetY] == null) {
				positions.add(new Position(targetX, targetY));
			} else {
				if (board[targetX][targetY].getColor() != knight.getColor()) {
					positions.add(new Position(targetX, targetY));
				}
			}
		}
		return positions;
	}

}
