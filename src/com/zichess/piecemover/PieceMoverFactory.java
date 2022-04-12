package com.zichess.piecemover;

import java.util.HashMap;

import com.zichess.PieceType;

public class PieceMoverFactory {

	private static PieceMoverFactory instance = new PieceMoverFactory();

	private PieceMoverFactory() {
		map = new HashMap<PieceType, PieceMover>();
		map.put(PieceType.PAWN, new Pawn());
		map.put(PieceType.BISHOP, new Bishop());
		map.put(PieceType.KING, new King());
		map.put(PieceType.KNIGHT, new Knight());
		map.put(PieceType.QUEEN, new Queen());
		map.put(PieceType.ROOK, new Rook());
	}

	private HashMap<PieceType, PieceMover> map;

	public static PieceMoverFactory getInstance() {
		return instance;
	}

	public PieceMover getMover(PieceType type) {
		return map.get(type);
	}
}
