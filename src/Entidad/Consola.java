package Entidad;

import Enums.NivelIntensidad;

public class Consola {
    private int consumoEnergia;
    private boolean danado;

    public Consola() {
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
        System.out.println("Consola - Estado:");
        System.out.println("Consumo de energía: " + consumoEnergia);
        System.out.println("¿Está dañada? " + danado);
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
