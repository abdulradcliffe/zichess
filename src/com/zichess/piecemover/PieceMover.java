package com.zichess.piecemover;

import java.util.List;

import com.zichess.Piece;
import com.zichess.Position;

public interface PieceMover {

	List<Position> whereCanMove(Piece piece, Piece[][] board);
}
