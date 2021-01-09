/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos_avidos;

import clases_monedas.Monedas;
import java.util.ArrayList;
import ordenamiento.InsertSort;

/**
 *
 * @author depot
 */
public class CambioMonedasAvido {
    
    private int cantidadACambiar;
    private ArrayList<Integer> monedasDisponibles;

    public CambioMonedasAvido(int cantidadACambiar, ArrayList<Integer> monedasDisponibles) {
        this.cantidadACambiar = cantidadACambiar;
        this.monedasDisponibles = monedasDisponibles;
    }
    
    public ArrayList<ArrayList<Integer>> combinaciones(){
        
        ArrayList<ArrayList<Integer>> combinacionesCambio = new ArrayList<>();
        
        
        return combinacionesCambio;
    }

    public int getCantidadACambiar() {
        return cantidadACambiar;
    }

    public void setCantidadACambiar(int cantidadACambiar) {
        this.cantidadACambiar = cantidadACambiar;
    }

    public ArrayList<Integer> getMonedasDisponibles() {
        return monedasDisponibles;
    }

    public void setMonedasDisponibles(ArrayList<Integer> monedasDisponibles) {
        this.monedasDisponibles = monedasDisponibles;
    }
    
    
}
