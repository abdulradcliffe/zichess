package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Color;
import com.zichess.Piece;
import com.zichess.Position;

public class Pawn implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece pawn, Piece[][] board) {
		int fromX = pawn.getPosition().x;
		int fromY = pawn.getPosition().y;
		List<Position> positions = new LinkedList<Position>();
		if (pawn.getColor() == Color.WHITE) {
			if (board[fromX - 1][fromY] == null) {
				Position p = new Position(fromX - 1, fromY);
				positions.add(p);
			}
			int targetX = fromX - 1;
			int targetY = fromY - 1;
			if (targetX >= 1 && board[targetX][targetY] != null && board[targetX][targetY].getColor() == Color.BLACK) {
				Position p = new Position(fromX - 1, fromY - 1);
				positions.add(p);
			}
			targetX = fromX - 1;
			targetY = fromY + 1;
			if (targetY <= 8 && board[targetX][targetY] != null && board[targetX][targetY].getColor() == Color.BLACK) {
				Position p = new Position(fromX - 1, fromY + 1);
				positions.add(p);
			}
			if (fromX == 7) {
				if (board[fromX - 1][fromY] == null && board[fromX - 2][fromY] == null) {
					Position p = new Position(fromX - 2, fromY);
					positions.add(p);
				}
			}
		} else {
			int targetX = fromX + 1;
			int targetY = fromY;
			if (board[targetX][targetY] == null) {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetX = fromX + 1;
			targetY = fromY - 1;
			if (targetY >= 1 && board[targetX][targetY] != null && board[targetX][targetY].getColor() == Color.WHITE) {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			targetX = fromX + 1;
			targetY = fromY + 1;
			if (targetY <= 8 && board[targetX][targetY] != null && board[targetX][targetY].getColor() == Color.WHITE) {
				Position p = new Position(targetX, targetY);
				positions.add(p);
			}
			if (fromX == 2) {
				if (board[fromX + 1][fromY] == null && board[fromX + 2][fromY] == null) {
					Position p = new Position(fromX + 2, fromY);
					positions.add(p);
				}
			}
		}
		return positions;
	}
}
