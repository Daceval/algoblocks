package edu.fiuba.algo3;

public interface Bloque {
    void ejecutar(Personaje personaje, Tablero tablero);

    default void enlazar(Bloque bloque, Recorrido strategy){
        try {
            strategy.agregar(bloque);
        }
        catch (RuntimeException e){
            throw e;
        }

    }

    void siguiente(Bloque bloque);
}
