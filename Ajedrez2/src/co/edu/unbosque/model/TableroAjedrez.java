package co.edu.unbosque.model;

import java.io.File;

import co.edu.unbosque.model.persistence.Archivo;

public class TableroAjedrez {
	
	private Pieza[][] tablero; // hecho 8x8
	private String texto;
	Archivo arch;
	
	public TableroAjedrez() {	
		arch = new Archivo();
		tablero = new Pieza[8][8];
	}
	
	public TableroAjedrez(File f) {
		arch = new Archivo(f);
	}
	
	public String actualizarArchivo(String frase) {
		texto = arch.leerArchivo();	
		return texto!=null? arch.escribirArchivo(texto + "\n"  + frase):arch.escribirArchivo(frase);
	}
	
	public boolean moverPieza(Pieza pieza, int x, int y) {
		tablero[pieza.getPosicionX()][pieza.getPosicionY()] = null;
		pieza.setPosicionX(x);
		pieza.setPosicionY(y);
		tablero[x][y] = pieza;
		return true;
	}
	
	public boolean crearPieza(Pieza pieza, int x, int y) {
		tablero[x][y] = pieza;
		return true;
	}
	
	public Pieza getPieza(int x,int y) {
		return tablero[x][y];
	}
}
