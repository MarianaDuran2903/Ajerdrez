package co.edu.unbosque.model;

public class Alfil extends Pieza {

	public Alfil(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super(isAlive, posicionX, posicionY, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimiento(int x, int y, TableroAjedrez tablero) { // en x el movimiento es de izquierda-derecha, en y es de arriba-abajo
		
		int n = Math.abs(getPosicionX() - x); // resta entre posicion actual y la nueva
		
		if(getPosicionY()+n==y || getPosicionY()-n==y) {
			if(getPosicionY()>y && getPosicionX()>x) {
				for(int i = 1; i<n; i++) {
					if(tablero.getPieza(x+i, y+i)!=null) {
						return false;
					}
				}
				if(tablero.getPieza(x,y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}else {
						return false;
					}
				}
			}
			
			if(getPosicionY()<y && getPosicionX()<x) {
				for(int i = 1; i<n; i++) {
					if(tablero.getPieza(x-i, y-i)!=null) {
						return false;
					}
				}
				if(tablero.getPieza(x,y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}else {
						return false;
					}
				}
			}
			
			if(getPosicionY()>y && getPosicionX()<x) {
				for(int i = 1; i<n; i++) {
					if(tablero.getPieza(x-i, y+i)!=null) {
						return false;
					}
				}
				if(tablero.getPieza(x,y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}else {
						return false;
					}
				}
			}
			
			if(getPosicionY()<y && getPosicionX()>x) {
				for(int i = 1; i<n; i++) {
					if(tablero.getPieza(x+i, y-i)!=null) {
						return false;
					}
				}
				if(tablero.getPieza(x,y)==null) {
					return true;
				}else {
					if((!tablero.getPieza(x, y).isWhite() && isWhite()) || (tablero.getPieza(x, y).isWhite() && !isWhite())) {
						return true;
					}else {
						return false;
					}
				}
			}
		} // fin del if que indica que el movimiento es diagonal 
		else {return false;} // si no es diagonal es falso
		
		return false;
	}

}
