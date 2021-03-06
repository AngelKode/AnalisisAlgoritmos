/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import Busquedas.Busquedas;

/**
 *
 * @author depot
 */
public class Burbuja {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public Burbuja() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
    
    public void buscar (int[] datos, int x){
        this.tInicio = System.currentTimeMillis();
        Busquedas.busquedaLineal(datos, x);
        this.tFinal = System.currentTimeMillis();
        this.tTotal = this.tFinal - this.tInicio;
    }

    public long getFinal() {
        return tFinal;
    }

    public long getInicio() {
        return tInicio;
    }

    public long getTotal() {
        return tTotal;
    }
    
    public void ordenar(int[] datos){
        //Ordenamos
        int[] ordenado = datos;
        //Usamos el ordenamiento burbuja
        for(int i = 0; i < ordenado.length-1;i++){
            for(int j = 0; j < ordenado.length-1; j++){
                 
                if(ordenado[j] > ordenado[j+1]){
                    int aux = ordenado[j];
                    ordenado[j] = ordenado[j+1];
                    ordenado[j+1] = aux;
                }
                
            }
        }
    }
    
}
