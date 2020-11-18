/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busquedas;

import java.util.Random;

/**
 *
 * @author working
 */
public class GeneradorDatos {
    
    public static int[] generarArregloPeorCasoInt(int dim){
        int[] arreglo = new int[dim];//1 operacion elemental
        Random ran = new Random();//1 operacion elemental
       
        for(int y=0; y < dim; y++){//1 + 3n operaciones elementales
            arreglo[y] = dim - y;// //3 operaciones elementales
        }
        
        
       return arreglo;
    }
    
    public static int[] generarArregloMejorCasoInt(int dim){
        int[] arreglo = new int[dim];//1 operacion elemental
       
        for(int y=0; y < dim; y++){//1 + 3n operaciones elementales
            arreglo[y] =y;         //2 operaciones elementales
        }
       
       return arreglo;
    }
    
    public static int[] generarArregloCasoPromedioInt(int dim, int bound){
        int[] arreglo = new int[dim];
        Random ran = new Random();
       
        for(int y=0; y < dim; y++){
            arreglo[y] =ran.nextInt(bound);
        }
        
       return arreglo;
    }
    
    public static int[] generarArregloInt(int x, int dim){
        int[] arreglo = new int[dim];
        Random ran = new Random();
        
        for(int i=0; i < dim; i++){
            arreglo[i] = ran.nextInt(x);
        }
        
        return arreglo;
    }
    
    public static int[] generarArregloPeorCasoIntBurbuja(int dim){
        
        int[] arreglo = new int[dim];
        int contador = 0;
        for(int i = dim; i > 0; i--){
            arreglo[contador] = i;
            contador++;
        }
        
        return arreglo;
    }
    
}