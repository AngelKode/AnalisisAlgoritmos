/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_monedas;

import java.util.ArrayList;

/**
 *
 * @author depot
 */
public class Monedas implements Cloneable{
    
    private ArrayList<ArrayList<Integer>> cambio;
    private int cantidadOpciones;

    public Monedas() {
        this.cambio = new ArrayList<>();
        this.cantidadOpciones = 0;
    }

    public ArrayList<ArrayList<Integer>> getCambio() {
        return cambio;
    }

    public void setCambio(ArrayList<ArrayList<Integer>> cambio) {
        this.cambio = cambio;
    }
    
    public void agregarVariasOpciones(ArrayList<ArrayList<Integer>> cambio){
        this.cambio = cambio;
        this.cantidadOpciones += cambio.size();
    }
    public void agregarOpcion(ArrayList<Integer> cambio){
        this.cambio.add(cambio);
        this.cantidadOpciones++;
    }
    
    @Override
    public Object clone(){
        try {
          return super.clone();   
        } catch (Exception e) {
            System.out.println("Error");
        }
       return null;
    }
    
}
