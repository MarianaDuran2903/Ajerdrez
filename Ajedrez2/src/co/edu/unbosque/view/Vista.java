package co.edu.unbosque.view;

import co.edu.unbosque.model.TableroAjedrez;

public class Vista {
    private VentanaPrincipal ventana;
    private Mensaje mensaje;

    public Vista(TableroAjedrez tableroAjedrez) {
        ventana = new VentanaPrincipal(tableroAjedrez);
        mensaje = new Mensaje();
    }

    public VentanaPrincipal getVentana() {
        return ventana;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }
}