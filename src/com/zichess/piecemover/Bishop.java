package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Color;
import com.zichess.Piece;
import com.zichess.Position;

public class Bishop implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece bishop, Piece[][] board) {
		List<Position> positions = new LinkedList<Position>();
		int fromX = bishop.getPosition().x;
		int fromY = bishop.getPosition().y;
		if (bishop.getColor() == Color.WHITE) {
			// check if the white king is in check
		} else {
			// check if the black king is in check
		}

		// check for top right diagonal
		int x = fromX - 1;
		int y = fromY + 1;
		while (x >= 1 && y <= 8) {
			if (board[x][y] != null) {
				if (board[x][y].getColor() != bishop.getColor()) {
					Position p = new Position(x, y);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(x, y);
				positions.add(p);
			}
			y++;
			x--;
		}

		// check for bottom right diagonal
		x = fromX + 1;
		y = fromY + 1;
		while (x <= 8 && y <= 8) {
			if (board[x][y] != null) {
				if (board[x][y].getColor() != bishop.getColor()) {
					Position p = new Position(x, y);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(x, y);
				positions.add(p);
			}
			y++;
			x++;
		}

		// check for bottom left diagonal
		x = fromX + 1;
		y = fromY - 1;
		while (x <= 8 && y >= 1) {
			if (board[x][y] != null) {
				if (board[x][y].getColor() != bishop.getColor()) {
					Position p = new Position(x, y);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(x, y);
				positions.add(p);
			}
			y--;
			x++;
		}

		// check for top left diagonal
		x = fromX - 1;
		y = fromY - 1;
		while (x >= 1 && y >= 1) {
			if (board[x][y] != null) {
				if (board[x][y].getColor() != bishop.getColor()) {
					Position p = new Position(x, y);
					positions.add(p);
				}
				break;
			} else {
				Position p = new Position(x, y);
				positions.add(p);
			}
			y--;
			x--;
		}
		return positions;
	}

}
