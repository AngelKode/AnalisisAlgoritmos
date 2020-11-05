/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisalgoritmos;

import Busquedas.GeneradorDatos;
import graficador.Graficador;
import java.awt.Color;
import ordenamiento.InsertSort;
import org.jfree.data.xy.XYSeries;
import recursividad.Fibonacci;

/**
 *
 * @author working
 */
public class AnalisisAlgoritmos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        Fibonacci fibonacci = new Fibonacci();
        
        int N = 45;
        Graficador grafica = new Graficador();
        
        for(int i=0; i < N; i++){
            
            XYSeries seriesDatos = new XYSeries("t"+(i)+1);
            //Obtenemos el de iterativo
            fibonacci.tiempoEjecucionIterataivo(i);
            long tiempoTotal = fibonacci.getTiempoIterativo();
            
            seriesDatos.add(i,0);
            seriesDatos.add(i, tiempoTotal);
            
            grafica.agregarSerie(seriesDatos);
        }
        
         grafica.generarGrafico("Grafica Tiempos Iterativo", "N", "Tiempo(ms)");
         grafica.mostrarGrafico();
    }
    
}