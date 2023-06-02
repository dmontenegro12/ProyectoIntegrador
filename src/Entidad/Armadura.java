package Entidad;

import Enums.NivelIntensidad;

import java.util.Random;

public class Armadura {
    private String colorPrimario;
    private String colorSecundario;
    private int nivelResistencia;
    private int nivelSalud;
    private Generador generador;
    private Bota botaIzquierda;
    private Bota botaDerecha;
    private Guante guanteIzquierdo;
    private Guante guanteDerecho;
    private Consola consola;
    private Sintetizador sintetizador;

    // Constructor
    public Armadura(String colorPrimario, String colorSecundario, int nivelResistencia, int nivelSalud) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.nivelResistencia = nivelResistencia;
        this.nivelSalud = nivelSalud;
        this.generador = new Generador();
        this.botaIzquierda = new Bota();
        this.botaDerecha = new Bota();
        this.guanteIzquierdo = new Guante();
        this.guanteDerecho = new Guante();
        this.consola = new Consola();
        this.sintetizador = new Sintetizador();
    }

    // Métodos para realizar acciones con la armadura
    public void caminar(int tiempo) {
        int energiaConsumida = botaIzquierda.usar(NivelIntensidad.BASICO, tiempo) +
                botaDerecha.usar(NivelIntensidad.BASICO, tiempo);
                generador.consumirEnergia(energiaConsumida);
    }

    public void correr(int tiempo) {
        int energiaConsumida = botaIzquierda.usar(NivelIntensidad.NORMAL, tiempo) +
                botaDerecha.usar(NivelIntensidad.NORMAL, tiempo);
                 generador.consumirEnergia(energiaConsumida);
    }

    public void propulsar(int tiempo) {
        int energiaConsumida = botaIzquierda.usar(NivelIntensidad.INTENSIVO, tiempo * 3) +
                botaDerecha.usar(NivelIntensidad.INTENSIVO, tiempo * 3);
                generador.consumirEnergia(energiaConsumida);
    }

    public void volar(int tiempo) {
        int energiaConsumida = botaIzquierda.usar(NivelIntensidad.INTENSIVO, tiempo * 3) +
                botaDerecha.usar(NivelIntensidad.INTENSIVO, tiempo * 3) +
                guanteIzquierdo.usar(NivelIntensidad.NORMAL, tiempo * 2) +
                guanteDerecho.usar(NivelIntensidad.NORMAL, tiempo * 2);
                generador.consumirEnergia(energiaConsumida);
    }

    public void disparar() {
        if (guanteIzquierdo.estaSano() && guanteDerecho.estaSano()) {
            int energiaConsumida = guanteIzquierdo.usar(NivelIntensidad.INTENSIVO, 1) +
                    guanteDerecho.usar(NivelIntensidad.INTENSIVO, 1);
                    generador.consumirEnergia(energiaConsumida);
        }
    }

    public void escribir(String mensaje) {
        int energiaConsumida = consola.usar(NivelIntensidad.BASICO, mensaje.length());
        generador.consumirEnergia(energiaConsumida);
    }

    public void leer() {
        int energiaConsumida = consola.usar(NivelIntensidad.BASICO, 1);
        generador.consumirEnergia(energiaConsumida);
    }

    // Otros métodos

    public void mostrarEstado() {
        System.out.println("Estado de la armadura:");
        System.out.println("Color primario: " + colorPrimario);
        System.out.println("Color secundario: " + colorSecundario);
        System.out.println("Nivel de resistencia: " + nivelResistencia);
        System.out.println("Nivel de salud: " + nivelSalud);
        generador.mostrarEstado();
        botaIzquierda.mostrarEstado();
        botaDerecha.mostrarEstado();
        guanteIzquierdo.mostrarEstado();
        guanteDerecho.mostrarEstado();
        consola.mostrarEstado();
        sintetizador.mostrarEstado();
    }

    public void mostrarEstadoBateria() {
        generador.mostrarEstadoBateria();
    }

    /*public void mostrarInformacionReactor() {
        generador.mostrarInformacionReactor();
    }*/
    public void mostrarInformacionReactor() {
        float potenciaKW = generador.calcularPotenciaKW();
        float potenciaBTU = generador.calcularPotenciaBTU();
        float potenciaJulios = generador.calcularPotenciaJulios();
        System.out.println("Información del Reactor:");
        System.out.println("Potencia (KW): " + potenciaKW);
        System.out.println("Potencia (BTU): " + potenciaBTU);
        System.out.println("Potencia (Julios): " + potenciaJulios);
    }
    public void revisarDispositivos() {
        Random random = new Random();
        boolean hayDispositivoDanado = true;

        while (hayDispositivoDanado) {
            hayDispositivoDanado = false;

            if (!botaIzquierda.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    botaIzquierda.reparar();
                } else {
                    botaIzquierda.destruir();
                    hayDispositivoDanado = true;
                }
            }

            if (!botaDerecha.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    botaDerecha.reparar();
                } else {
                    botaDerecha.destruir();
                    hayDispositivoDanado = true;
                }
            }

            if (!guanteIzquierdo.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    guanteIzquierdo.reparar();
                } else {
                    guanteIzquierdo.destruir();
                    hayDispositivoDanado = true;
                }
            }

            if (!guanteDerecho.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    guanteDerecho.reparar();
                } else {
                    guanteDerecho.destruir();
                    hayDispositivoDanado = true;
                }
            }

            if (!consola.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    consola.reparar();
                } else {
                    consola.destruir();
                    hayDispositivoDanado = true;
                }
            }

            if (!sintetizador.estaSano()) {
                if (random.nextDouble() <= 0.4) {
                    sintetizador.reparar();
                } else {
                    sintetizador.destruir();
                    hayDispositivoDanado = true;
                }
            }
        }
    }
    public void agregarObjetosRadar(int cantidad) {
        Random random = new Random();
        for (int i = 0; i < cantidad; i++) {
            boolean esHostil = random.nextBoolean();
            int resistenciaObjeto = random.nextInt(100);
            int x = random.nextInt(1000);
            int y = random.nextInt(1000);
            int z = random.nextInt(1000);
            ObjetoRadar objeto = new ObjetoRadar(esHostil, resistenciaObjeto, x, y, z);
            generador.agregarObjetoRadar(objeto);
        }
    }
    public void destruirEnemigos() {
        for (ObjetoRadar objeto : generador.getObjetosRadar()) {
            if (objeto.esHostil() && objeto.getDistancia() <= 5000) {
                while (objeto.getResistencia() > 0 && generador.getNivelBateria() >= 0.1) {
                    float potenciaDisparo = 5000f / objeto.getDistancia();
                    objeto.recibirDanio(potenciaDisparo);
                    generador.consumirEnergia(0.1f);
                }
            }
        }
    }

    public void accionesEvasivas() {
        if (generador.calcularPorcentajeBateria() < 10) {
            float distanciaMinima = 10 * 1000; // 10 km en metros
            float tiempoVuelo = distanciaMinima / 300; // Velocidad de vuelo promedio: 300 km/h
            propulsar((int) tiempoVuelo);
        }
    }
    class ObjetoRadar {
        private boolean esHostil;
        private int resistencia;
        private int x;
        private int y;
        private int z;

        public ObjetoRadar(boolean esHostil, int resistencia, int x, int y, int z) {
            this.esHostil = esHostil;
            this.resistencia = resistencia;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public boolean esHostil() {
            return esHostil;
        }

        public int getResistencia() {
            return resistencia;
        }

        public void recibirDanio(float danio) {
            resistencia -= danio;
            if (resistencia < 0) {
                resistencia = 0;
            }
        }

        public float getDistancia() {
            return (float) Math.sqrt(x * x + y * y + z * z);
        }
    }
}

