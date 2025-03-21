package co.edu.unbosque.model;

public class Rey extends Pieza {

	public Rey(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super(isAlive, posicionX, posicionY, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimiento(int x, int y, TableroAjedrez tablero) { // en x el movimiento es de izquierda-derecha, en y es de arriba-abajo
		if(x==getPosicionX() && y == getPosicionY()+1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}
			return false;
		}
		if(x==getPosicionX() && y == getPosicionY()-1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		
		if(x==getPosicionX()+1 && y == getPosicionY()) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		if(x==getPosicionX()-1 && y == getPosicionY()) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		
		// movimientos diagonales
		
		if(x==getPosicionX()+1 && y == getPosicionY()+1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}
			return false;
		}
		if(x==getPosicionX()+1 && y == getPosicionY()-1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		
		if(x==getPosicionX()-1 && y == getPosicionY()-1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		if(x==getPosicionX()-1 && y == getPosicionY()+1) {
			if(tablero.getPieza(x, y)==null) {
				return true;
			}else {
				if((tablero.getPieza(x, y).isWhite() && !isWhite()) || (!tablero.getPieza(x, y).isWhite() && isWhite())) {
					return true;
				}
			}return false;
		}
		return false;
	}

}
