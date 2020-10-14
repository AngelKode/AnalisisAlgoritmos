/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Busquedas;

/**
 *
 * @author depot
 */
public class Busquedas {
    
     public static int busquedaLineal (int[] datos, int x){
        
        for(int i=0;i<datos.length;i++){
            if(datos[i] == x){
                return i;
            }
        }
    
       return -1;
       
    }
}
