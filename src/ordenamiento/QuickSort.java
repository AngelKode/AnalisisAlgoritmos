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
public class QuickSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public QuickSort() {
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
    
    public void ordenar(int[] datos,int izq,int der){
        
       int pivote=datos[izq]; // tomamos primer elemento como pivote
       int i=izq;         // i realiza la búsqueda de izquierda a derecha
       int j=der;         // j realiza la búsqueda de derecha a izquierda
       int aux;

           while(i < j){                          // mientras no se crucen las búsquedas                                   
             while(datos[i] <= pivote && i < j) i++; // busca elemento mayor que pivote
             while(datos[j] > pivote) j--;           // busca elemento menor que pivote
             if (i < j) {                        // si no se han cruzado                      
                 aux= datos[i];                      // los intercambia
                 datos[i]=datos[j];
                 datos[j]=aux;
             }
           }

           datos[izq]=datos[j];      // se coloca el pivote en su lugar de forma que tendremos                                    
           datos[j]=pivote;      // los menores a su izquierda y los mayores a su derecha

           if(izq < j-1)
              ordenar(datos,izq,j-1);          // ordenamos subarray izquierdo
           if(j+1 < der)
              ordenar(datos,j+1,der);          // ordenamos subarray derecho
           
    }
    
}
