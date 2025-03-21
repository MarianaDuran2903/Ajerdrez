package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Alfil;
import co.edu.unbosque.model.Caballo;
import co.edu.unbosque.model.Peon;
import co.edu.unbosque.model.Pieza;
import co.edu.unbosque.model.Reina;
import co.edu.unbosque.model.Rey;
import co.edu.unbosque.model.TableroAjedrez;
import co.edu.unbosque.model.Torre;
import co.edu.unbosque.view.VentanaPrincipal;
import co.edu.unbosque.view.Vista;

public class Controller implements ActionListener {

    private Vista vista;
    private TableroAjedrez tablero; // hecho 8x8
    private long tiempoPartida;
    private long tiempoInicio;
    

    public Controller() {
    	inicializar();
    }

    private void inicializar() {

		tablero = new TableroAjedrez();
		piezasTablero();
        vista = new Vista(tablero);
        asignarOyentes();
        tiempoInicio = System.currentTimeMillis();
		
	}
    
    private void piezasTablero() { 
		for(int i=0; i<2; i++) { // aqui "i" se mueve en y (arriba-abajo)
			for(int j=0; j<8; j++) { // aqui "j" se mueve en x (izquierda-derecha)
				if(i==1) {
					Peon peonRojas = new Peon(true, j, i, false);
					tablero.crearPieza(peonRojas, j, i);
					
					Peon peonBlancas = new Peon(true, j, 6, true);
					tablero.crearPieza(peonBlancas, j, 6);
				}else {
					switch(j) {
					case 0:
						Torre torreRojas = new Torre(true, j, i, false);
						tablero.crearPieza(torreRojas, j, i);
						
						Torre torreBlancas = new Torre(true, j, 7, true);
						tablero.crearPieza(torreBlancas, j, 7);
						
						break;
						
					case 1:
						Caballo caballoRojos = new Caballo(true, j, i, false);
						tablero.crearPieza(caballoRojos, j, i);
						
						Caballo caballoBlancos = new Caballo(true, j, 7, true);
						tablero.crearPieza(caballoBlancos, j, 7);
						
						break;
					
					case 2:
						Alfil alfilRojos = new Alfil(true, j, i, false);
						tablero.crearPieza(alfilRojos, j, i);
						
						Alfil alfilBlancos = new Alfil(true, j, 7, true);
						tablero.crearPieza(alfilBlancos, j, 7);
						
						break;
						
					case 3:
						Reina reinaRoja = new Reina(true, j, i, false);
						tablero.crearPieza(reinaRoja, j, i);
						
						Reina reinaBlanca = new Reina(true, j, 7, true);
						tablero.crearPieza(reinaBlanca, j, 7);
						
						break;
						
					case 4:
						Rey reyRoja = new Rey(true, j, i, false);
						tablero.crearPieza(reyRoja, j, i);
						
						Rey reyBlanca = new Rey(true, j, 7, true);
						tablero.crearPieza(reyBlanca, j, 7);
						
						break;
						
					case 5:
						Alfil alfilRojos2 = new Alfil(true, j, i, false);
						tablero.crearPieza(alfilRojos2, j, i);
						
						Alfil alfilBlancos2 = new Alfil(true, j, 7, true);
						tablero.crearPieza(alfilBlancos2, j, 7);
						
						break;
						
					case 6:
						Caballo caballoRojos2 = new Caballo(true, j, i, false);
						tablero.crearPieza(caballoRojos2, j, i);
						
						Caballo caballoBlancos2 = new Caballo(true, j, 7, true);
						tablero.crearPieza(caballoBlancos2, j, 7);
						
						break;
						
					case 7:
						Torre torreRojas2 = new Torre(true, j, i, false);
						tablero.crearPieza(torreRojas2, j, i);
						
						Torre torreBlancas2 = new Torre(true, j, 7, true);
						tablero.crearPieza(torreBlancas2, j, 7);
						
						break;
					
					
					}
				}
			}
		}
    }

	private void asignarOyentes() {
        vista.getVentana().getPanelJuego().getBtnJuego().addActionListener(this);
        vista.getVentana().getPanelJuego().getBtnRendirse().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	String comando = e.getActionCommand();
		if(comando.equals("Juega")) {
			try{
				
				ArrayList<String> letras = new ArrayList<String>(Arrays.asList("a","b","c","d","e","f","g","h")) ;
			
				String valor1 = vista.getVentana().getPanelJuego().getValor1();
				String valorJugador1 = valor1.toLowerCase().replaceAll("\\s+", "");
				String[] valorlesJugador1 = valorJugador1.split("");                // toma posicion inicial de la pieza 
				
				String valor2 = vista.getVentana().getPanelJuego().getValor2();
				String valorJugador2 = valor2.toLowerCase().replaceAll("\\s+", "");
				String[] valoresJugador2 = valorJugador2.split("");                 // toma posicion final de la pieza 
							
				int iV1 = Integer.parseInt(valorlesJugador1[1]); //horizontal y; toma el valor de la casilla Mueve 
				int jV1 = letras.indexOf(valorlesJugador1[0]); // vertical x (ej; de "b" a "f")
				
				int iV2 = Integer.parseInt(valoresJugador2[1])-1; // toma el valor de la casilla Hacia 
				int jV2 = letras.indexOf(valoresJugador2[0]);
				
				
				Pieza pieza = tablero.getPieza(jV1, iV1-1);// (x,y) 
				if(pieza.isWhite()) {
					//System.out.println(jV1 + " " + (iV1-1));
					if(pieza.movimiento(jV2, iV2, tablero)) {
						tablero.moverPieza(pieza, jV2, iV2);
						//System.out.println(jV2 + " " + iV2);
						vista.getVentana().getPanelMatriz().borrar(iV1, jV1+1); // 
						vista.getVentana().getPanelMatriz().dibujar(iV2+1, jV2+1, pieza);
						
						String ganador = jaque();
						if(ganador.equals("Continua jugando.")) {
							
							moverPiezaRoja();
							ganador = jaque();
							if(ganador.equals("Continua jugando.")) {
							}else {
								vista.getMensaje().mostrarMensaje(ganador);
								Archivo(ganador);
								vista.getVentana().dispose();
							}							
						}else {
							vista.getMensaje().mostrarMensaje(ganador);
							Archivo(ganador);
							vista.getVentana().dispose();
						}										
					}else {
						vista.getMensaje().mostrarMensaje("Movimiento invalido. Esta pieza no puede realizar este movimiento segun las reglas del ajedrez.");
					}
				}else {
					vista.getMensaje().mostrarMensaje("Movimiento invalido.No puedes mover piezas rojas.");
				}
			}catch (Exception error) {
				vista.getMensaje().mostrarMensaje("Movimiento invalido." ); //  + error
			}
			 vista.getVentana().getPanelJuego().erase();
		}
		else if (comando.equals("Rendirse")) {
			vista.getMensaje().mostrarMensaje("Te has rendido. Pierdes el juego.");
			Archivo("Blancas se rindieron. Ganan rojas.");
			vista.getVentana().dispose();
		}
		
		vista.getVentana().getPanelJuego().setValor1("");
		vista.getVentana().getPanelJuego().setValor2("");
		
    }
 
    private void moverPiezaRoja() {
    	
        Random random = new Random();
        int nuevoX = random.nextInt(8);
        int nuevoY = random.nextInt(8);
        
        while(true) {
        if(tablero.getPieza(nuevoX, nuevoY) !=null ){
        	if(!(tablero.getPieza(nuevoX, nuevoY).isWhite())) {
        		break; 		
        	}else {
        		 nuevoX = random.nextInt(8);
        	     nuevoY = random.nextInt(8);
        	}
        }else {
        	 nuevoX = random.nextInt(8);
             nuevoY = random.nextInt(8);
        }
        
    }	
     
        int nuevaCoordenadaX = random.nextInt(8);
        int nuevaCoordenadaY = random.nextInt(8);
        
        int count = 0;
        
        while(count<20) {
        if(tablero.getPieza(nuevoX, nuevoY).movimiento(nuevaCoordenadaX, nuevaCoordenadaY, tablero) ){
        	
        	//System.out.println( nuevoX + " " + nuevoY + "-" + nuevaCoordenadaX + " " + nuevaCoordenadaY);
        	//System.out.println( tablero.getPieza(nuevoX, nuevoY).getClass());
        	tablero.moverPieza(tablero.getPieza(nuevoX, nuevoY),nuevaCoordenadaX,nuevaCoordenadaY);
        	vista.getVentana().getPanelMatriz().borrar(nuevoY+1,nuevoX+1); 
        
			vista.getVentana().getPanelMatriz().dibujar(nuevaCoordenadaY+1,nuevaCoordenadaX+1,  tablero.getPieza(nuevaCoordenadaX, nuevaCoordenadaY));
        	
        	break;
        }else {
        	nuevaCoordenadaX = random.nextInt(8);
        	nuevaCoordenadaY = random.nextInt(8);
        	count ++;
        }
        
    }if(count==20) {
    	moverPiezaRoja();
    }
        
   }
    
    private String jaque() {
    	boolean reyBlancoVivo = false;
    	boolean reyRojoVivo = false;
    	for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(tablero.getPieza(j, i)!=null) {
					if(tablero.getPieza(j, i).getClass().getSimpleName().equals("Rey")) {
						if(tablero.getPieza(j, i).isWhite()) {
							reyBlancoVivo = true;
						}else {
							reyRojoVivo = true;
						}
					}
					
				}
			}
    	}
    	if(reyRojoVivo && reyBlancoVivo) {
    		return "Continua jugando.";
    	}else {
    		if(reyRojoVivo) {
    			return "Ganan Rojas.";	
    		}else {
    			return "Ganan Blancas.";		
    		}
    	}
    	
    }
    
    public void Archivo(String frase) {
    	tiempoPartida =  (System.currentTimeMillis() - tiempoInicio);
    	double tiempoSegundos = tiempoPartida/1000.0;
    	
    	frase = frase + "  Tiempo de Partida: " + String.format("%.2f",tiempoSegundos) + " segundos.";
    	String texto = "";
		texto = tablero.actualizarArchivo(frase);
		
    }
}
