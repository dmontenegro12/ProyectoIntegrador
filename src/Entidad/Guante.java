package Entidad;

import Enums.NivelIntensidad;

public class Guante {
    private int consumoEnergia;
    private boolean danado;

    public Guante() {
        this.consumoEnergia = consumoEnergia;
        this.danado = false;
    }

    public int usar(NivelIntensidad nivelIntensidad, int tiempo) {
        if (!danado) {
            int consumoTotal = consumoEnergia * nivelIntensidad.getFactorIntensidad() * tiempo;
            return consumoTotal;
        }
        return 0;
    }

    public void mostrarEstado() {
        System.out.println("Guante - Estado:");
        System.out.println("Consumo de energía: " + consumoEnergia);
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



