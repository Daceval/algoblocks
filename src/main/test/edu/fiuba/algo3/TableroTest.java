package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
    private Boolean compararArrays(ArrayList<Posicion2D>array1, ArrayList<Posicion2D>array2){
        int i = 0;
        if(array1.size() != array2.size()) return false;

        for (Posicion posicion: array1) {
            Posicion2D posicion2 = array2.get(i);
            if(!posicion.esLaMismaQue(posicion2)) return false;
            i++;
        }

        return true;
    }

    @Test
    public void test01AlInicializarElTableroElDibujoEstaVacio(){
        Tablero tablero = new Tablero();
        
        ArrayList<Posicion2D> dibujoVacio = tablero.obtenerDibujo();
        tablero.ejecutarAlgoritmo(new ArrayList<Bloque>());

        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test02SinUtilizarElBloqueBajarLapizElDibujoEsVacio(){
        Tablero tablero = new Tablero();
        ArrayList <Bloque> algoritmo = new ArrayList<Bloque>();

        algoritmo.add(new MoverALaDerecha());
        algoritmo.add(new MoverHaciaAbajo());
        algoritmo.add(new MoverALaDerecha());

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoVacio = tablero.obtenerDibujo();
        assertTrue(dibujoVacio.isEmpty());
    }

    @Test
    public void test03AlBajarElLapizElDibujoEsElEsperado(){
        Tablero tablero = new Tablero();
        ArrayList <Posicion2D> dibujoEsperado = new ArrayList<Posicion2D>();
        ArrayList <Bloque> algoritmo = new ArrayList<Bloque>();

        algoritmo.add(new BajarLapiz()); //(0,0)
        dibujoEsperado.add(new Posicion2D(0,0));

        algoritmo.add(new MoverALaDerecha()); //(1,0)
        dibujoEsperado.add(new Posicion2D(1,0));

        algoritmo.add(new MoverHaciaAbajo()); //(1,-1)
        dibujoEsperado.add(new Posicion2D(1,-1));

        algoritmo.add(new MoverALaDerecha()); //(2,-1)
        dibujoEsperado.add(new Posicion2D(2,-1));

        tablero.ejecutarAlgoritmo(algoritmo);

        ArrayList<Posicion2D> dibujoLogrado = tablero.obtenerDibujo();

        assertTrue(compararArrays(dibujoEsperado, dibujoLogrado));
    }
}
