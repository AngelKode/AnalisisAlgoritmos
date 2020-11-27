/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_dinamica;

import TSP.Ciudad;
import TSP.PuntosXY;
import java.util.ArrayList;

/**
 *
 * @author depot
 */
public class TSPDinamico {
    
    final private Double acceso_distancias[][];
    private int ciudadesRecorridas;
    private double distancia;
    final private int finCamino;

    public TSPDinamico(Ciudad ciudades[]) {
        this.acceso_distancias = new Double[ciudades.length + 1][ciudades.length + 1];
        this.ciudadesRecorridas = 0;
        this.distancia = 0;
        this.finCamino = 0;
    }
    
    public double recorrerCaminos(Ciudad raiz,Ciudad[] hijos,Ciudad inicio,double distanciaRecorrida){
        if(hijos.length > 1){
            for(int i=0;i<hijos.length;i++){
                //Creamos los nuevos hijos
                
                Ciudad[] nuevosHijos = new Ciudad[hijos.length - 1];
                int posicion = 0;
                for(int j=0;j<hijos.length;j++){
                    if(hijos[i] != hijos[j]){
                        nuevosHijos[posicion] = hijos[j];
                        posicion++;
                    }
                }
                double resultado = 0;
                //Obtenemos la distancia entre el nodo raiz y el siguiente y le sumamos
                //la distancia que llevamos recorrida hasta ahorita
                try {
                    resultado = this.acceso_distancias[raiz.getId()][hijos[i].getId()];
                } catch (Exception e) {
                    resultado = getDistancia(raiz.getPuntos(), hijos[i].getPuntos()) + distanciaRecorrida;
                   this.acceso_distancias[raiz.getId()][hijos[i].getId()] = resultado;
                   this.acceso_distancias[hijos[i].getId()][raiz.getId()] = resultado;
                }
                
                ciudadesRecorridas++;
                //Hacemos recursividad para recorrer los demas caminos faltantes
                recorrerCaminos(hijos[i], nuevosHijos,inicio,resultado);
            }
        }else{
           double resultado = 0;
           ciudadesRecorridas++;
           
           //Si la posicion en la tabla ya ha sido calculado, obtenemos ese dato de la tabla,
           //si no, calculamos la distancia y la guardamos en la tabla, y lo guardamos
            
            //Obtenemos la distancia entre el ultimo nodo y el anterior
            try {
                resultado += this.acceso_distancias[raiz.getId()][hijos[0].getId()];
            } catch (Exception e) {
                resultado += getDistancia(raiz.getPuntos(), hijos[0].getPuntos());
                this.acceso_distancias[raiz.getId()][hijos[0].getId()] = resultado;
                this.acceso_distancias[hijos[0].getId()][raiz.getId()] = resultado;
            }
            
            //Obtenemos la distancia entre el ultimo nodo y el inicio
            try {
                resultado +=  this.acceso_distancias[raiz.getId()][hijos[0].getId()]; 
            } catch (Exception e) {
                resultado += getDistancia(inicio.getPuntos(), hijos[0].getPuntos());
                this.acceso_distancias[raiz.getId()][inicio.getId()] = resultado;
                this.acceso_distancias[inicio.getId()][raiz.getId()] = resultado;
            }      
           //Le sumamos la distancia que llevamos recorriendo
           resultado += distanciaRecorrida;
           
           //Guardamos la distancia recorrida, si es menor que la actual, actualizamos el valor
            if(this.finCamino == 0){
                this.distancia = resultado;
            }else{
                if(resultado < this.distancia){
                    this.distancia = resultado;
                }
            }  
           return resultado;
        }
       return 0;   
    }
    
    private double getDistancia(PuntosXY punto1, PuntosXY punto2){
        double resultado = 0;
        
        resultado = Math.sqrt(Math.pow((punto2.getPunto_X() - punto1.getPunto_X()),2) + 
                              Math.pow((punto2.getPunto_Y() - punto1.getPunto_Y()),2));
        
        return resultado;
    }

    public int getCiudadesRecorridas() {
        return ciudadesRecorridas;
    }

    public void setCiudadesRecorridas(int ciudadesRecorridas) {
        this.ciudadesRecorridas = ciudadesRecorridas;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
}
