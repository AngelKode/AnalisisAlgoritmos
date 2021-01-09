/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenamiento;

import Busquedas.Busquedas;
import java.util.ArrayList;

/**
 *
 * @author depot
 */
public class InsertSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public InsertSort() {
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
        int size = datos.length; //1 operacion elemental

        for (int step = 1; step < size; step++) { //(1 + 3n) operaciones elementales
          int key = datos[step];                  //2 operaciones elementales
          int j = step - 1;                       //2 operaciones elementales
          
          while (j >= 0 && key < datos[j]) {      //5n operaciones elementales
            datos[j + 1] = datos[j];              //4 operaciones elementales
            --j;                                  //2 operaciones elementales
          }

          datos[j + 1] = key;                     //3 operaciones elementales
        }
    }
    
    static public void ordenar(ArrayList<Integer> lista){
        int size = lista.size(); //1 operacion elemental

        for (int step = 1; step < size; step++) {
          int key = lista.get(step);                 
          int j = step - 1;                       
          
          while (j >= 0 && key < lista.get(j)) {      
            lista.set(j+1, lista.get(j));              
            --j;                                  
          }

          lista.set(j+1, key);                     
        }
    }
}
