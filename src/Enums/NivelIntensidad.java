package Enums;

public enum NivelIntensidad {
    BASICO(1),
    NORMAL(2),
    INTENSIVO(3);

    private int factorIntensidad;

    NivelIntensidad(int factorIntensidad) {
        this.factorIntensidad = factorIntensidad;
    }

    public int getFactorIntensidad() {
        return factorIntensidad;
    }
}
