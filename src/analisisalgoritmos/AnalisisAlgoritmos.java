/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisalgoritmos;

import Busquedas.BusquedaSecuencial;
import Busquedas.GeneradorDatos;
import java.awt.Color;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
        int[] aux;
        int limite = 1000;
        int[] tiempos = new int[limite];
        int valorTiempo = 0;
        boolean inicio = true;
        //XYSeriesCollection es la coleccion de todos esos puntos
        XYSeriesCollection dataSet = new XYSeriesCollection();
        
        BusquedaSecuencial b1 = new BusquedaSecuencial();
        
        for(j=1;j<limite;j++){
               aux = GeneradorDatos.generarArregloInt(6,j + 1, 100);
               int pos = b1.buscar(aux, 6);
               tiempos[j] = (int)b1.getTotal();
               //Creamos el siguiente elemento de la colección
               XYSeries seriesDatos = new XYSeries("t"+(j));
               if(inicio){
                   //Puntos de la serie
                   seriesDatos.add(0,tiempos[j]);
                   seriesDatos.add(j-1, tiempos[j]); 
                   //Para saber que ya pasó el primer dato
                   inicio = false;
               }else{
                   seriesDatos.add(j-1, tiempos[j]);
                   seriesDatos.add(j-2, valorTiempo);
               }
               //para tener el dato anterior en la serie
               valorTiempo = tiempos[j];
               //Agregamos el objeto XYSeries al arreglo
               dataSet.addSeries(seriesDatos);
        }
        
        JFreeChart grafico = ChartFactory.createXYLineChart("Graficador de tiempos"
                                                            ,"Tamaño"
                                                            , "Tiempo(ms)"
                                                            , dataSet
                                                            ,PlotOrientation.VERTICAL, false, true,false);
        XYPlot xyplot = grafico.getXYPlot();
                
        //Cambiamos el color del trazo
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
            for(int i=0;i<limite;i++){
                render.setSeriesPaint(i,Color.BLACK);
            }
        xyplot.setRenderer(render);
        
        ChartPanel panelGrafico = new ChartPanel(grafico);
        
        //Creamos la ventana para mostrarlo
        JFrame ventana = new JFrame("Grafico");
        ventana.setLocationRelativeTo(null);
        ventana.setSize(400,600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(panelGrafico);
    }
    
}