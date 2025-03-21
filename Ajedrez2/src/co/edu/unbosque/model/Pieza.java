package co.edu.unbosque.model;

public abstract class Pieza {
	
	private boolean isAlive;
	private int posicionX;
	private int posicionY;
	private boolean isWhite;

	public Pieza(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super();
		this.isAlive = isAlive;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.isWhite = isWhite;
	}

	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getPosicionX() {
		return posicionX;
	}

	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public int getPosicionY() {
		return posicionY;
	}

	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	
	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean movimiento(int x, int y, TableroAjedrez tablero); // devuelve si el movimiento es permitido o no 
}
