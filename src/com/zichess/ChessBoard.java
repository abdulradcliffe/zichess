package com.zichess;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.zichess.piecemover.PieceMover;
import com.zichess.piecemover.PieceMoverFactory;

public class ChessBoard {

	private Piece[][] board;

	private Color turn;

	public ChessBoard() {
		board = new Piece[9][9];
		Piece whiteAPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 1), PieceType.PAWN);
		Piece whiteBPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 2), PieceType.PAWN);
		Piece whiteCPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 3), PieceType.PAWN);
		Piece whiteDPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 4), PieceType.PAWN);
		Piece whiteEPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 5), PieceType.PAWN);
		Piece whiteFPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 6), PieceType.PAWN);
		Piece whiteGPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 7), PieceType.PAWN);
		Piece whiteHPawn = new Piece(" pawn ", Color.WHITE, new Position(7, 8), PieceType.PAWN);

		Piece whiteARook = new Piece(" rook ", Color.WHITE, new Position(8, 1), PieceType.ROOK);
		Piece whiteHRook = new Piece(" rook ", Color.WHITE, new Position(8, 8), PieceType.ROOK);

		Piece whiteAKNight = new Piece("knight", Color.WHITE, new Position(8, 2), PieceType.KNIGHT);
		Piece whiteBKnight = new Piece("knight", Color.WHITE, new Position(8, 7), PieceType.KNIGHT);

		Piece whiteBishopOnDark = new Piece("bishop", Color.WHITE, new Position(8, 3), PieceType.BISHOP);
		Piece whiteBishopOnLight = new Piece("bishop", Color.WHITE, new Position(8, 6), PieceType.BISHOP);

		Piece whiteQueen = new Piece("Queen ", Color.WHITE, new Position(8, 4), PieceType.QUEEN);
		Piece whiteKing = new Piece(" king ", Color.WHITE, new Position(8, 5), PieceType.KING);

		// black pieces initialization
		Piece blackAPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 1), PieceType.PAWN);
		Piece blackBPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 2), PieceType.PAWN);
		Piece blackCPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 3), PieceType.PAWN);
		Piece blackDPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 4), PieceType.PAWN);
		Piece blackEPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 5), PieceType.PAWN);
		Piece blackFPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 6), PieceType.PAWN);
		Piece blackGPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 7), PieceType.PAWN);
		Piece blackHPawn = new Piece(" pawn ", Color.BLACK, new Position(2, 8), PieceType.PAWN);

		Piece blackARook = new Piece(" rook ", Color.BLACK, new Position(1, 1), PieceType.ROOK);
		Piece blackHRook = new Piece(" rook ", Color.BLACK, new Position(1, 8), PieceType.ROOK);

		Piece blackAKNight = new Piece("knight", Color.BLACK, new Position(1, 2), PieceType.KNIGHT);
		Piece blackBKnight = new Piece("knight", Color.BLACK, new Position(1, 7), PieceType.KNIGHT);

		Piece blackBishopOnDark = new Piece("bishop", Color.BLACK, new Position(1, 6), PieceType.BISHOP);
		Piece blackBishopOnLight = new Piece("bishop", Color.BLACK, new Position(1, 3), PieceType.BISHOP);

		Piece blackQueen = new Piece("Queen ", Color.BLACK, new Position(1, 4), PieceType.QUEEN);
		Piece blackKing = new Piece(" King ", Color.BLACK, new Position(1, 5), PieceType.KING);

		// setting up back pieces
		board[1][1] = blackARook;
		board[1][2] = blackAKNight;
		board[1][3] = blackBishopOnLight;
		board[1][4] = blackQueen;
		board[1][5] = blackKing;
		board[1][6] = blackBishopOnDark;
		board[1][7] = blackBKnight;
		board[1][8] = blackHRook;
		board[2][1] = blackAPawn;
		board[2][2] = blackBPawn;
		board[2][3] = blackCPawn;
		board[2][4] = blackDPawn;
		board[2][5] = blackEPawn;
		board[2][6] = blackFPawn;
		board[2][7] = blackGPawn;
		board[2][8] = blackHPawn;

		// setting up white pieces
		board[8][1] = whiteARook;
		board[8][2] = whiteAKNight;
		board[8][3] = whiteBishopOnDark;
		board[8][4] = whiteQueen;
		board[8][5] = whiteKing;
		board[8][6] = whiteBishopOnLight;
		board[8][7] = whiteBKnight;
		board[8][8] = whiteHRook;
		board[7][1] = whiteAPawn;
		board[7][2] = whiteBPawn;
		board[7][3] = whiteCPawn;
		board[7][4] = whiteDPawn;
		board[7][5] = whiteEPawn;
		board[7][6] = whiteFPawn;
		board[7][7] = whiteGPawn;
		board[7][8] = whiteHPawn;
		turn = Color.WHITE;
	}

	/**
	 * This is the main function which is responsible for actually moving a
	 * particular piece to a target position which is selected by the user
	 * 
	 * @param piece
	 * @param toX
	 * @param toY
	 * @return it returns one of the possible values of {@link MoveResult}
	 * @throws WrongPositionSelectedException in case the selected piece can not
	 *                                        move to the selected position
	 */
	public MoveResult play(Piece piece, int toX, int toY) throws WrongPositionSelectedException {
		if (piece.getColor() != turn) {
			System.err.println("can not move. its not your turn as of now");
			return MoveResult.IN_PROGRESS;
		}
		if (!canMove(piece, toX, toY)) {
			throw new WrongPositionSelectedException("wrong position selected. can not move the piece");
		}
		board[piece.getPosition().x][piece.getPosition().y] = null;
		piece.getPosition().x = toX;
		piece.getPosition().y = toY;
		board[toX][toY] = piece;
		System.out.println(piece.getName() + " moved to : [" + toX + ", " + toY + "]");

		// check if a white/black pawn is promoted to Queen
		Color color = piece.getColor();
		boolean whitePawnPromoted = color.equals(Color.WHITE) && piece.getType().equals(PieceType.PAWN) && toX == 1;
		boolean blackPawnPromoted = color.equals(Color.BLACK) && piece.getType().equals(PieceType.PAWN) && toX == 8;
		if (whitePawnPromoted) {
			Piece newWhiteQueen = new Piece("Queen ", Color.WHITE, new Position(toX, toY), PieceType.QUEEN);
			board[toX][toY] = newWhiteQueen;
		} else if (blackPawnPromoted) {
			Piece newBlackQueen = new Piece("Queen ", Color.BLACK, new Position(toX, toY), PieceType.QUEEN);
			board[toX][toY] = newBlackQueen;
		}
		Color oppositeKingColor = null;
		if (turn == Color.WHITE) {
			oppositeKingColor = Color.BLACK;
		} else {
			oppositeKingColor = Color.WHITE;
		}

		if (turn == Color.BLACK) {
			turn = Color.WHITE;
		} else {
			turn = Color.BLACK;
		}

		// now check if the opposite king is in check
		boolean checkStatus = CheckFinder.getInstance().isKingInCheck(oppositeKingColor, board);
		if (checkStatus) {
			// if in check then check if it is mate
			boolean checkMate = CheckFinder.getInstance().isKingCheckMate(oppositeKingColor, board);
			if (checkMate) {
				switch (oppositeKingColor) {
				case WHITE: {
					return MoveResult.BLACK_WON_CHECKMATE;
				}
				case BLACK: {
					return MoveResult.WHITE_WON_CHECKMATE;
				}
				}
			} else {
				switch (oppositeKingColor) {
				case WHITE: {
					return MoveResult.WHITE_IN_CHECK;
				}
				case BLACK: {
					return MoveResult.BLACK_IN_CHECK;
				}
				}
			}
		} else {
			// if not in check, then validate if it is stalemate
			boolean staleMate = CheckFinder.getInstance().isKingCheckMate(oppositeKingColor, board);
			if (staleMate) {
				switch (oppositeKingColor) {
				case WHITE: {
					return MoveResult.WHITE_STALEMATE;
				}
				case BLACK: {
					return MoveResult.BLACK_STALEMATE;
				}
				}
			}
		}

		return MoveResult.IN_PROGRESS;

	}

	private boolean canMove(Piece piece, int toX, int toY) {
		List<Position> positions = availablePositionFor(piece);
		for (Position p : positions) {
			if (toX == p.x && toY == p.y) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the possible squares where a piece can move in a certain position
	 * 
	 * @param piece
	 * @return
	 */
	public List<Position> availablePositionFor(Piece piece) {
		// check the turn of the piece
		if (piece.getColor() != turn) {
			// if the chosen piece is of different color.
			// example chosen piece is white and its blacks turn
			// then simply return empty list
			return Collections.emptyList();
		}

		PieceMoverFactory moverFactory = PieceMoverFactory.getInstance();
		// check if the played piece is available on board or not

		// get the current position of the piece

		// check if the target square or if the target piece can be captured
		PieceMover mover = moverFactory.getMover(piece.getType());
		List<Position> availablePositions = mover.whereCanMove(piece, board);
		CheckFinder checkFinder = CheckFinder.getInstance();

		// if my king is already in check then I can move on
		// my piece only to those squares where it stops the check
		List<Position> nonCheckPositions = new LinkedList<Position>();
		for (Position p : availablePositions) {
			boolean kingWillBeInCheck = checkFinder.isKingInCheckAfterMove(piece.getColor(), board, piece, p.x, p.y);
			if (!kingWillBeInCheck) {
				nonCheckPositions.add(p);
			}
		}
		return nonCheckPositions;
	}

	public Piece getPiece(int x, int y) {
		if (board[x][y] == null) {
			return null;
		}
		return board[x][y];
	}
}
