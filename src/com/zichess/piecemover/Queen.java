package com.zichess.piecemover;

import java.util.LinkedList;
import java.util.List;

import com.zichess.Piece;
import com.zichess.PieceType;
import com.zichess.Position;

public class Queen implements PieceMover {

	@Override
	public List<Position> whereCanMove(Piece queen, Piece[][] board) {
		PieceMover rook = PieceMoverFactory.getInstance().getMover(PieceType.ROOK);
		PieceMover bishop = PieceMoverFactory.getInstance().getMover(PieceType.BISHOP);
		List<Position> positions = new LinkedList<Position>();
		positions.addAll(rook.whereCanMove(queen, board));
		positions.addAll(bishop.whereCanMove(queen, board));
		return positions;
	}

}
