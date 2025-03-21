package co.edu.unbosque.model;

public class Torre extends Pieza {

	public Torre(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super(isAlive, posicionX, posicionY, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimiento(int x, int y, TableroAjedrez tablero) { // en x el movimiento es de izquierda-derecha, en y es de arriba-abajo
		
			if(x==getPosicionX() && y!=getPosicionY()) {
				if(y<getPosicionY()) {
					for(int i = y; i<getPosicionY();i++) {
						if(tablero.getPieza(x, i)!=null) {
							return false;
						}
					}
				}else {
					for(int i = getPosicionY()+1; i<y;i++) {
						if(tablero.getPieza(x, i)!=null) {
							return false;
						}
					}
				}
				
				if(tablero.getPieza(x, y)!=null) {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}else {
						return false;
					}
				}else {
					return true;
				}
			}else {
				if(x!=getPosicionX() && y==getPosicionY()) {
					if(x<getPosicionX()) {
						for(int i = x; i<getPosicionX();i++) {
							if(tablero.getPieza(i, y)!=null) {
								return false;
							}
						}
					}else {
						for(int i = getPosicionX()+1; i<x;i++) {
							if(tablero.getPieza(i, y)!=null) {
								return false;
							}
						}
					}
					
					if(tablero.getPieza(x, y)!=null) {
						if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
							return true;
						}else {
							return false;
						}
					}else {
						return true;
					}
				}
			
			}
		return false;
	}

}
