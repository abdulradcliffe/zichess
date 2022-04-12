package com.zichess;

public class Piece implements Cloneable {

	private Color color;
	private String name;
	private Position position;
	private PieceType type;

	public Piece(String name, Color color, Position initialPosition, PieceType type) {
		this.name = name;
		this.color = color;
		this.position = initialPosition;
		this.type = type;
	}

	public Piece(Piece original) {
		this.name = original.name;
		this.color = original.color;
		this.position = new Position(original.getPosition().x, original.getPosition().y);
		this.type = original.getType();
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public Position getPosition() {
		return position;
	}

	public PieceType getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}
}
