package co.edu.unbosque.model;

public class Caballo extends Pieza{

	public Caballo(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super(isAlive, posicionX, posicionY, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimiento(int x, int y, TableroAjedrez tablero) { // en x el movimiento es de izquierda-derecha, en y es de arriba-abajo

		if(getPosicionX()+2==x || getPosicionX()-2==x) {
			if(getPosicionY()+1==y || getPosicionY()-1==y) {
				if(tablero.getPieza(x, y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}

				}
			}
		}
		
		if(getPosicionY()-2==y || getPosicionY()+2==y) {
			if(getPosicionX()+1==x || getPosicionX()-1==x) {
				if(tablero.getPieza(x, y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}

				}
			}
		}
		
		return false;
	}

}
