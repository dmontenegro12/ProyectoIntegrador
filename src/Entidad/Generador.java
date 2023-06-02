package Entidad;

import java.util.ArrayList;
import java.util.List;

public class Generador {
    private float cargaMaxima;
    private float nivelBateria;
    private float capacidadBateria;
    private float potenciaReactor;
    private List<Armadura.ObjetoRadar> objetosRadar;

   /* public Generador() {
        this.cargaMaxima = Float.MAX_VALUE;
        this.nivelBateria = cargaMaxima;
    }*/
    public Generador() {
        this.nivelBateria = 100f;
        this.capacidadBateria = 100f;
        this.potenciaReactor = 500f;
        this.objetosRadar = new ArrayList<>();
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public float getNivelBateria() {
        return nivelBateria;
    }

    public void setNivelBateria(float nivelBateria) {
        this.nivelBateria = nivelBateria;
    }

    public float getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(float capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public float getPotenciaReactor() {
        return potenciaReactor;
    }

    public void setPotenciaReactor(float potenciaReactor) {
        this.potenciaReactor = potenciaReactor;
    }

    public void setObjetosRadar(List<Armadura.ObjetoRadar> objetosRadar) {
        this.objetosRadar = objetosRadar;
    }

    public float calcularPorcentajeBateria() {
        return (nivelBateria / capacidadBateria) * 100;
    }

    public float calcularPotenciaKW() {
        return potenciaReactor * nivelBateria;
    }

    public float calcularPotenciaBTU() {
        return calcularPotenciaKW() * 3412.14f;
    }

    public float calcularPotenciaJulios() {
        return calcularPotenciaKW() * 3600000;
    }
    public void consumirEnergia(float cantidad) {
        nivelBateria -= cantidad;
        if (nivelBateria < 0) {
            nivelBateria = 0;
        }
    }

    public void mostrarEstado() {
        System.out.println("Generador - Estado:");
        System.out.println("Carga máxima: " + cargaMaxima);
        System.out.println("Nivel de batería: " + nivelBateria);
    }

    public void mostrarEstadoBateria() {
        double porcentajeBateria = (nivelBateria / cargaMaxima) * 100;
        System.out.println("Nivel de batería: " + porcentajeBateria + "%");
    }

    public void mostrarInformacionReactor() {
        System.out.println("Nivel de batería: " + nivelBateria);
        System.out.println("Nivel de batería en voltios: " + nivelBateria * 12);
        System.out.println("Nivel de batería en julios: " + nivelBateria * 3600);
    }
    public void agregarObjetoRadar(Armadura.ObjetoRadar objeto) {
        objetosRadar.add(objeto);
    }

    public List<Armadura.ObjetoRadar> getObjetosRadar() {
        return objetosRadar;
    }
}

