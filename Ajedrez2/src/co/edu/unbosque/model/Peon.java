package co.edu.unbosque.model;

public class Peon extends Pieza {

	public Peon(boolean isAlive, int posicionX, int posicionY, boolean isWhite) {
		super(isAlive, posicionX, posicionY, isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean movimiento(int x, int y, TableroAjedrez tablero) {  // en x el movimiento es de izquierda-derecha, en y es de arriba-abajo
		if(isWhite()) {
			if(y==getPosicionY()-1 && tablero.getPieza(x, y)==null && x==getPosicionX()) {
				return true;
			}
			if(y==getPosicionY()-2 && getPosicionY()==6 && tablero.getPieza(x, y)==null && tablero.getPieza(x, y+1)==null && x==getPosicionX() ) {
				return true;
			}
			if(y==getPosicionY()-1 && tablero.getPieza(x, y)!=null && x==getPosicionX()-1) {
				if(!tablero.getPieza(x, y).isWhite()) {
					return true;
				}
			}
			if(y==getPosicionY()-1 && tablero.getPieza(x, y)!=null && x==getPosicionX()+1) {
				if(!tablero.getPieza(x, y).isWhite()) {
					return true;
				}
			}
		}else {
			if(y==getPosicionY()+1 && tablero.getPieza(x, y)==null && x==getPosicionX()) {
				return true;
			}
			if(y==getPosicionY()+2 && getPosicionY()==1 && tablero.getPieza(x, y)==null && tablero.getPieza(x, y-1)==null && x==getPosicionX()) {
				return true;
			}
			if(y==getPosicionY()+1 && tablero.getPieza(x, y)!=null && x==getPosicionX()+1) {
				if(tablero.getPieza(x, y).isWhite()) {
					return true;
				}
			}
			if(y==getPosicionY()+1 && tablero.getPieza(x, y)!=null && x==getPosicionX()-1) {
				if(tablero.getPieza(x, y).isWhite()) {
					return true;
				}
			}
		}
		
		return false;
	}

	

	
	
}
