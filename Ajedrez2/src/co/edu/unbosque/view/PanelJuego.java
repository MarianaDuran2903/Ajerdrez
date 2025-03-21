package co.edu.unbosque.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelJuego extends JPanel {

    private JLabel txt1;
    private JTextField valor1;
    private JLabel txt2;
    private JTextField valor2;
    private JButton btnJuego;
    private JButton btnRendirse;

    public PanelJuego() {
        setLayout(null);
        inicializarComponentes();
        setBorder(new TitledBorder("Acciones durante el juego:"));
    }

    public void inicializarComponentes() {
        txt1 = new JLabel("Mueve ");
        txt1.setBounds(25, 10, 150, 25);
        add(txt1);

        valor1 = new JTextField();
        valor1.setBounds(25, 35, 280, 25);
        add(valor1);

        txt2 = new JLabel("Hacia ");
        txt2.setBounds(25, 65, 150, 25);
        add(txt2);

        valor2 = new JTextField();
        valor2.setBounds(25, 90, 280, 25);
        add(valor2);

        btnJuego = new JButton("Juega");
        btnJuego.setActionCommand("Juega");
        btnJuego.setBounds(100, 150, 100, 25);
        add(btnJuego);
        
        btnRendirse = new JButton("Rendirse");
        btnRendirse.setActionCommand("Rendirse");
        btnRendirse.setBounds(250, 150, 100, 25);
        add(btnRendirse);
        
    }

	public JLabel getTxt1() {
		return txt1;
	}

	public void setTxt1(JLabel txt1) {
		this.txt1 = txt1;
	}

	public String getValor1() {
		return valor1.getText();
	}

	public void setValor1(String valor1) {
	    this.valor1.setText(valor1);
	}

	public JLabel getTxt2() {
		return txt2;
	}

	public void setTxt2(JLabel txt2) {
		this.txt2 = txt2;
	}

	public String getValor2() {
		return valor2.getText();
	}

	public void setValor2(String valor2) {
	    this.valor2.setText(valor2);
	}

	public JButton getBtnJuego() {
		return btnJuego;
	}

	public void setBtnJuego(JButton btnJuego) {
		this.btnJuego = btnJuego;
	}

	public JButton getBtnRendirse() {
		return btnRendirse;
	}

	public void setBtnRendirse(JButton btnRendirse) {
		this.btnRendirse = btnRendirse;
	} 

	public void erase() {
		txt1.setText("");
		txt2.setText("");
	}
}
