/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_caballo;

/**
 *
 * @author depot
 */
public class Casilla {
    
    private boolean visitada;

    public Casilla() {
        this.visitada = false;
    }

    public boolean isVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }
}
