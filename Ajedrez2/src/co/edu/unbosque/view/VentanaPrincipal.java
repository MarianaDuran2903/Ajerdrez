package co.edu.unbosque.view;

import javax.swing.*;

import co.edu.unbosque.model.TableroAjedrez;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private PanelMatriz panelMatriz;
    private PanelJuego panelJuego;
    private TableroAjedrez tableroAjedrez;

    public VentanaPrincipal(TableroAjedrez tableroAjedrez) {
    	this.tableroAjedrez = tableroAjedrez;
        setTitle(" Juego de Ajedrez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        inicializarComponentes();

        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarComponentes() {
    	panelJuego = new PanelJuego();
    	panelJuego.setBounds(25, 25, 435, 200);
        getContentPane().add(panelJuego);

        panelMatriz = new PanelMatriz(tableroAjedrez);
        panelMatriz.setBounds(25, 255, 435, 375);
        getContentPane().add(panelMatriz);
    }


    public PanelMatriz getPanelMatriz() {
        return panelMatriz;
    }

	public PanelJuego getPanelJuego() {
		return panelJuego;
	}
    
    
}