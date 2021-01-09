/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_dinamica;

import clases_monedas.Monedas;
import java.util.ArrayList;
import java.util.Objects;
import ordenamiento.InsertSort;

/**
 *
 * @author depot
 */
public class CambioMonedasDinamico {
    
    private int cantidadACambiar;
    private ArrayList<Integer> monedasDisponibles;
    private final Monedas[] arregloCombinacionesMonedas;

    public CambioMonedasDinamico(int cantidadACambiar, ArrayList<Integer> monedasDisponibles) {
        this.cantidadACambiar = cantidadACambiar;
        this.monedasDisponibles = monedasDisponibles;
        this.arregloCombinacionesMonedas = new Monedas[cantidadACambiar];
    }
    
    public Monedas[] mejorCombinacion(){
        
        //Recorremos cada valor de cambio desde 1 hasta N
        //guardando las combinaciones en un arreglo para futuras operaciones
        for(int cantidadCambio = 1; cantidadCambio <= this.cantidadACambiar; cantidadCambio++){
            //En una variable auxiliar guardamos la cantidad de cambio a dar
            int cambioActual = cantidadCambio;
                            
            Monedas moneda = new Monedas();
                
            //Operamos para obtener las posibles combinaciones
            for(Integer denominacionMoneda : this.monedasDisponibles){
                ArrayList<Integer> combinaciones = new ArrayList<>();
                //Si la moneda es valida para el cambio
                if(cambioActual - denominacionMoneda >= 0){
                    cambioActual -= denominacionMoneda;
                    if(cambioActual != 0){
                        ArrayList<ArrayList<Integer>> combinacionesAnteriores = new ArrayList<>();
                        combinacionesAnteriores = this.arregloCombinacionesMonedas[cambioActual - 1].getCambio();
                               
                        for(ArrayList<Integer> combinacion : combinacionesAnteriores){
                            ArrayList<Integer> nuevaCombinacion = (ArrayList<Integer>) combinacion.clone();
                            nuevaCombinacion.add(denominacionMoneda);
                            
                            if(isRepetido(nuevaCombinacion, moneda.getCambio()) == false){
                                moneda.agregarOpcion(nuevaCombinacion);
                            }
                        }
                               
                    }else{
                        combinaciones.add(denominacionMoneda);
                        //En cada ciclo, agregamos una combinacion mas
                        moneda.agregarOpcion(combinaciones);
                    }
                }
                cambioActual = cantidadCambio;
            }
            //Guardamos el arreglo de números en la matriz
            this.arregloCombinacionesMonedas[cantidadCambio - 1] = (Monedas) moneda.clone();
        }
        
        return this.arregloCombinacionesMonedas;
    }
    
    private boolean isRepetido(ArrayList<Integer> lista_uno, ArrayList<ArrayList<Integer>> comparaciones){
        
        //ordenamos de menor a mayor
        InsertSort.ordenar(lista_uno);
        boolean repetido = false;
        
        for(ArrayList<Integer> lista : comparaciones){
            if(lista.size() == lista_uno.size()){
                for(int posicion = 0; posicion < lista_uno.size(); posicion++){
                    if(lista.get(posicion).compareTo(lista_uno.get(posicion)) == 0){
                       repetido = true;
                    }
                }
            }
        }
        
        return repetido;
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
