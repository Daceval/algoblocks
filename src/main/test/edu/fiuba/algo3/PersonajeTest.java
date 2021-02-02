package edu.fiuba.algo3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    @Test
    public void test01alCrearseUnPersonajeSuLapizEstaArriba() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test02elLapizDelPersonajeSeBajaAlUsarUnBloqueBajarLapiz() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test03elLapizDelPersonajeSeLevantaAlUsarUnBloqueSubirLapiz() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueBajar.ejecutar(personaje, new Tablero());
        bloqueSubir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test04subirElLapizDelPersonajeNoTieneEfectoSiYaEstaSubido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        SubirLapiz bloqueSubir = new SubirLapiz();

        bloqueSubir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test05bajarElLapizDelPersonajeNoTieneEfectoSiYaEstaBajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloque = new BajarLapiz();

        bloque.ejecutar(personaje, new Tablero());
        assertFalse(personaje.lapizEstaArriba());
        bloque.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test06elPersonajeSeCreaEnLaPosicionInicial00() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        Posicion2D posicion = new Posicion2D(0, 0);

        assertTrue(personaje.estaEn(posicion));
    }

    @Test
    public void test07elPersonajeSeMueveALaDerechaAlUsarElBloqueMoverDerecha() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverALaDerecha bloque = new MoverALaDerecha();
        Posicion2D posicionEsperada = new Posicion2D(1, 0);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test08elPersonajeSeMueveALaIzquierdaAlUsarElBloqueMoverIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverALaIzquierda bloque = new MoverALaIzquierda();
        Posicion2D posicionEsperada = new Posicion2D(-1, 0);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test09elPersonajeSeMueveHaciaArribaAlUsarElBloqueMoverArriba() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaArriba bloque = new MoverHaciaArriba();
        Posicion2D posicionEsperada = new Posicion2D(0, 1);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test10elPersonajeSeMueveHaciaAbajoAlUsarElBloqueMoverAbajo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        MoverHaciaAbajo bloque = new MoverHaciaAbajo();
        Posicion2D posicionEsperada = new Posicion2D(0, -1);

        bloque.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test11elPersonajeSeMueveDosVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test12elPersonajeSeMueveDosVecesALaIzquierdaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(-2, 0);

        bloqueRepetir.siguiente(new MoverALaIzquierda());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test13elPersonajeQuedaEnElMismoLugarAlMoverseDosVecesALaDerechaYDosALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.siguiente(new MoverALaIzquierda());
        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test14elPersonajeSeMueveDosALaIzquierdaYArribaAlUsarBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(-2, 2);

        bloqueRepetir.siguiente(new MoverALaIzquierda());
        bloqueRepetir.siguiente(new MoverHaciaArriba());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test15elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(2, 0);

        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.siguiente(new BajarLapiz());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test16sePuedeAgregarUnBloqueDeRepeticionEnOtroDelMismoTipo() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(2);
        BloqueDeRepeticion otroBloqueRepetir = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(4, 0);

        bloqueRepetir.siguiente(new MoverALaDerecha());
        otroBloqueRepetir.siguiente(bloqueRepetir);
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test17elPersonajeSeMueveTresVecesALaDerechaAlUsarUnBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test18elPersonajeQuedaEnElMismoLugarAlMoverseTresVecesALaDerechaYTresALaIzquierda() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetir.siguiente(new MoverALaIzquierda());
        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test19elPersonajeSeMueveALADerechaYBajaElLapizUsandoBloqueDeRepeticion() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetir = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(3, 0);

        bloqueRepetir.siguiente(new MoverALaDerecha());
        bloqueRepetir.siguiente(new BajarLapiz());
        bloqueRepetir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
        assertFalse(personaje.lapizEstaArriba());
    }

    @Test
    public void test20sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTriple() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetirDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueRepetirTriple = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirDoble.siguiente(new MoverALaDerecha());
        bloqueRepetirTriple.siguiente(bloqueRepetirDoble);
        bloqueRepetirTriple.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test21sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDoble() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetirTriple = new BloqueDeRepeticion(3);
        BloqueDeRepeticion bloqueRepetirDoble = new BloqueDeRepeticion(2);
        Posicion2D posicionEsperada = new Posicion2D(6, 0);

        bloqueRepetirTriple.siguiente(new MoverALaDerecha());
        bloqueRepetirDoble.siguiente(bloqueRepetirTriple);
        bloqueRepetirDoble.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test22sePuedeAgregarUnBloqueDeRepeticionDobleEnUnoTripleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetirDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueRepetirTriple = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirDoble.siguiente(new MoverALaDerecha());
        bloqueRepetirTriple.siguiente(new MoverALaIzquierda());
        bloqueRepetirTriple.siguiente(bloqueRepetirDoble);
        bloqueRepetirTriple.siguiente(new MoverALaIzquierda());
        bloqueRepetirTriple.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test23sePuedeAgregarUnBloqueDeRepeticionTripleEnUnoDobleConOtrosBloques() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BloqueDeRepeticion bloqueRepetirDoble = new BloqueDeRepeticion(2);
        BloqueDeRepeticion bloqueRepetirTriple = new BloqueDeRepeticion(3);
        Posicion2D posicionEsperada = new Posicion2D(0, 0);

        bloqueRepetirTriple.siguiente(new MoverALaDerecha());
        bloqueRepetirDoble.siguiente(new MoverALaIzquierda());
        bloqueRepetirDoble.siguiente(bloqueRepetirTriple);
        bloqueRepetirDoble.siguiente(new MoverALaIzquierda());
        bloqueRepetirDoble.ejecutar(personaje, new Tablero());

        assertTrue(personaje.estaEn(posicionEsperada));
    }

    @Test
    public void test24elLapizQuedaSubidoLuegoDeSubirYBajarUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        bloqueInvertir.siguiente(new SubirLapiz());
        bloqueInvertir.siguiente(new BajarLapiz());
        bloqueInvertir.ejecutar(personaje, new Tablero());

        assertTrue(personaje.lapizEstaArriba());
    }

    @Test
    public void test25elLapizQuedaBajoLuegoDeBajarYSubirUsandoBloqueInvertido() {
        Personaje personaje = new Personaje(new Posicion2D(0, 0));
        BajarLapiz bloqueBajar = new BajarLapiz();
        SubirLapiz bloqueSubir = new SubirLapiz();
        InvertirComportamiento bloqueInvertir = new InvertirComportamiento();

        bloqueInvertir.siguiente(new BajarLapiz());
        bloqueInvertir.siguiente(new SubirLapiz());
        bloqueInvertir.ejecutar(personaje, new Tablero());

        assertFalse(personaje.lapizEstaArriba());
    }
}
