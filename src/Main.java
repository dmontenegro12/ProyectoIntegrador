import Entidad.Armadura;

public class Main {
    public static void main(String[] args) {
        Armadura ironMan = new Armadura("Rojo", "Oro", 100, 100);

        ironMan.mostrarEstado();

        ironMan.caminar(10);
        ironMan.mostrarEstadoBateria();

        ironMan.volar(5);
        ironMan.mostrarEstadoBateria();

        ironMan.agregarObjetosRadar(3);
        ironMan.mostrarInformacionReactor();

        ironMan.destruirEnemigos();
        ironMan.mostrarEstadoBateria();

        ironMan.accionesEvasivas();
        ironMan.mostrarEstadoBateria();
    }

}