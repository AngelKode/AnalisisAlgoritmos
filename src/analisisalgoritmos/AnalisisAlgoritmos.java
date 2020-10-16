/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisalgoritmos;

import Busquedas.BusquedaSecuencial;
import Busquedas.GeneradorDatos;
import graficador.Graficador;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author working
 */
public class AnalisisAlgoritmos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int j = 0;
        
        int limite = 100000;
        int[] tiemposMejorCaso = new int[limite];
        int[] tiemposPeorCaso = new int[limite];
        int[] tiemposCasoPromedio = new int[limite];
        int valorTiempoMejor = 0;
        int valorTiempoPromedio = 0;
        int valorTiempoPeor = 0;
        boolean inicio = true;
        //XYSeriesCollection es la coleccion de todos esos puntos
        Graficador grafica = new Graficador();
        
        BusquedaSecuencial b1 = new BusquedaSecuencial();

        for(j=1;j<limite;j++){
               System.out.println(j);
               int[] auxMejorCaso = new int[j];
               int[] auxPeorCaso = new int[j];
               int[] auxCasoPromedio = new int[j];
               
               auxMejorCaso = GeneradorDatos.generarArregloMejorCasoInt(6,j + 1, 100);
               auxPeorCaso = GeneradorDatos.generarArregloPeorCasoInt(6,j + 1, 100);
               auxCasoPromedio = GeneradorDatos.generarArregloCasoPromedioInt(6,j + 1, 100);
               
               b1.buscar(auxMejorCaso, 6);
                tiemposMejorCaso[j] = (int)b1.getTotal();
               b1.buscar(auxPeorCaso, 6);
                 tiemposPeorCaso[j] = (int)b1.getTotal();
               b1.buscar(auxCasoPromedio, 6);
                 tiemposCasoPromedio[j] = (int)b1.getTotal();
        
              
               //Creamos el siguiente elemento de la colección
               XYSeries seriesDatosMejor = new XYSeries("t"+(j)+1);
               XYSeries seriesDatosPeor = new XYSeries("t"+(j)+2);
               XYSeries seriesDatosPromedio = new XYSeries("t"+(j)+3);
               if(inicio){
                   //Puntos de la serie
                   //Mejor
                   seriesDatosMejor.add(0,tiemposMejorCaso[j]);
                   seriesDatosMejor.add(j-1, tiemposMejorCaso[j]);
                   //Peor
                   seriesDatosPeor.add(0,tiemposPeorCaso[j]);
                   seriesDatosPeor.add(j-1, tiemposPeorCaso[j]);
                   //Promedio
                   seriesDatosPromedio.add(0,tiemposCasoPromedio[j]);
                   seriesDatosPromedio.add(j-1, tiemposCasoPromedio[j]); 
                   //Para saber que ya pasó el primer dato
                   inicio = false;
               }else{
                   //Mejor
                   seriesDatosMejor.add(j-1, tiemposMejorCaso[j]);
                   seriesDatosMejor.add(j-2, valorTiempoMejor);
                   //Peor
                   seriesDatosPeor.add(j-1,tiemposPeorCaso[j]);
                   seriesDatosPeor.add(j-2,valorTiempoPeor);
                   //Promedio
                   seriesDatosPromedio.add(j-1,tiemposCasoPromedio[j]);
                   seriesDatosPromedio.add(j-2, valorTiempoPromedio); 
               }
               //para tener el dato anterior en la serie
               valorTiempoMejor = tiemposMejorCaso[j];
               valorTiempoPeor = tiemposPeorCaso[j];
               valorTiempoPromedio = tiemposCasoPromedio[j];
               //Agregamos el objeto XYSeries al arreglo

               grafica.agregarSerie(seriesDatosMejor);
               grafica.agregarSerie(seriesDatosPromedio);
               grafica.agregarSerie(seriesDatosPeor);
        }
        
        grafica.generarGrafico("Grafica Tiempos", "N", "Tiempo(ms)");
        //Creamos la ventana para mostrarlo
        grafica.mostrarGrafico();
                
    }
    
}