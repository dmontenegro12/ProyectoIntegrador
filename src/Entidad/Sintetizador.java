package Entidad;

public class Sintetizador {
    private boolean danado;

    public Sintetizador() {
        this.danado = false;
    }

    public void mostrarEstado() {
        System.out.println("Sintetizador - Estado:");
        System.out.println("¿Está dañado? " + danado);
    }

    public boolean estaSano() {
        return !danado;
    }

    public void reparar() {
        danado = false;
    }

    public void destruir() {
        danado = true;
    }
}
