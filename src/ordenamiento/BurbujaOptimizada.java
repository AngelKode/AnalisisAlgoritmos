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
public class BurbujaOptimizada {
     public long tInicio;
    public long tFinal;
    public long tTotal;

    public BurbujaOptimizada() {
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
        int AUX;
        int N = datos.length;
        int bandera=1;

        for(int paso=0;paso<N-1&&bandera==1;paso++){
        /* si en el paso anterior no hubo cambios se detiene ciclo */
                bandera=0;
                for(int j=0;j<N-paso-1;j++){
                /* las comparaciones van dismuyendo
                a medida que se efectuan los pasos */
                        if(datos[j]>datos[j+1]){
                                bandera=1; /* indica si se han realizados cambios o no */
                                AUX=datos[j];
                                datos[j]=datos[j+1];
                                datos[j+1] = AUX;
                          }
                  }
          }
    }
}
