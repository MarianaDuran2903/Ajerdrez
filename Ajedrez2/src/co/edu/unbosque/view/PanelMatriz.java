package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import co.edu.unbosque.model.Pieza;
import co.edu.unbosque.model.TableroAjedrez;

public class PanelMatriz extends JPanel{
	
	private JLabel [][] tablero; // creo la matriz del tablero 
	private TableroAjedrez tableroAjedrez; // crea el 8x8 q es donde se juega

	public PanelMatriz(TableroAjedrez tableroAjedrez) {
        setLayout(new GridLayout(9, 9));
        setBorder(new TitledBorder("Tablero de Ajedrez:"));
        this.tableroAjedrez = tableroAjedrez;
        inicializarComponentes();
    }
	
	public void inicializarComponentes() {
		String[] columnas = {"","A","B","C","D","E","F","G","H"};
		tablero = new JLabel[9][9];
		
		boolean isblue= true;
		for(int i=0; i<9; i++) {
			isblue = !isblue;
			for(int j=0; j<9; j++) {
				if (i!=0 && j!=0) {
					tablero[i][j] = new JLabel();
					tablero[i][j].setSize(50, 50);
					tablero[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
					tablero[i][j].setOpaque(true);
					if(isblue) {
						tablero[i][j].setBackground(Color.blue);
					}else {
						tablero[i][j].setBackground(Color.gray);
					}
					isblue = !isblue;
					
					if(tableroAjedrez.getPieza(j-1, i-1)!=null) {
						 dibujar(i, j, tableroAjedrez.getPieza(j-1, i-1)); //si en el tablero hay piezas dibuje
					}
					add(tablero[i][j]);

				}else {
					if(i==0) {
						tablero[i][j] = new JLabel(columnas[j], SwingConstants.CENTER);
					}else {
						tablero[i][j] = new JLabel(String.valueOf(i), SwingConstants.CENTER);
					}
					add(tablero[i][j]);
				} // fin if
			}// fin for(j)	
		}// fin for(i)		
	}// fin inicializar componentes
	
	public void borrar(int x, int y) {
		tablero[x][y].setIcon(null);
	}
	
	public void dibujar(int x, int y, Pieza pieza) {
		String clase = pieza.getClass().getSimpleName();
		switch(clase) {
		case "Peon":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/peonRojo.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/peonBlanco.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}
			break;
		case "Alfil":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/alfilRojo.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/alfilBlanco.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}break;
			
		case "Caballo":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/caballoRojo.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/caballoBlanco.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}break;
		
		case "Reina":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/reinaRoja.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/reinaBlanca.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}break;
		case "Rey":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/reyRojo.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/reyBlanco.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}break;
			
		case "Torre":
			if(!pieza.isWhite()) {
				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/torreRoja.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}else {

				ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/torreBlanca.png"));
				ImageIcon nueva = new ImageIcon(icono.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
				tablero[x][y].setIcon(nueva);
				tablero[x][y].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[x][y].setVerticalAlignment(SwingConstants.CENTER);
			}break;
			
		} // fin switch
	} // fin metodo dibujar	
}