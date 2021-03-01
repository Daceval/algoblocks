package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class RecorridoNormal {
    ArrayList<Bloque> bloques = new ArrayList<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void agregarBloque(Bloque bloque){
        this.bloques.add(bloque);
        support.firePropertyChange("bloques", bloques, bloques);
    }

    public RecorridoNormal invertir() {
        bloques.forEach(Bloque::invertir);
        support.firePropertyChange("bloques", bloques, bloques);
        return this;
    }

    public RecorridoNormal clonar() {
        RecorridoNormal recorridoClonado = new RecorridoNormal();
        recorridoClonado.clonar(bloques);
        return recorridoClonado;
    }

    private void clonar(List<Bloque> bloques){
        this.bloques = new ArrayList<>();
        bloques.forEach(bloque -> this.bloques.add(bloque.clonar()));
        support.firePropertyChange("bloques", bloques, bloques);
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.bloques.forEach(bloque -> bloque.ejecutar(personaje, dibujo));
    }

    void reiniciar(){
        this.bloques = new ArrayList<>();
        support.firePropertyChange("bloques", bloques, bloques);
    }

    void removerUltimo(){
        if(!bloques.isEmpty()) {
            bloques.remove(bloques.size() - 1);
            support.firePropertyChange("bloques", bloques, bloques);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }
}
