package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Algoblocks;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonReiniciarHandler implements EventHandler {


    @Override
    public void handle(Event event) {
        Algoblocks.getInstance().reiniciarAlgoritmo();
    }
}
