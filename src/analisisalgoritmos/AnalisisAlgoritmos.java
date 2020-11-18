/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisalgoritmos;

import Busquedas.GeneradorDatos;
import clases.TiemposOrdenamiento;
import graficador.Graficador;
import java.awt.Color;
import java.util.ArrayList;
import ordenamiento.Burbuja;
import ordenamiento.BurbujaOptimizada;
import ordenamiento.InsertSort;
import ordenamiento.MergeSort;
import ordenamiento.QuickSort;
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
        
        /* 
        ---------------------------------Fibonacci------------------------------------------
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
        ---------------------------------Fibonacci------------------------------------------
         */
        
        //MergeSort
        MergeSort merge = new MergeSort();
        
        int N = 10000;
        Graficador grafica = new Graficador();

        ArrayList<TiemposOrdenamiento> datosMerge = new ArrayList<>();
        ArrayList<TiemposOrdenamiento> datosQuick = new ArrayList<>();
        
        //ArrayList<TiemposOrdenamiento> datosSort = new ArrayList<>();
        //ArrayList<TiemposOrdenamiento> datosBurbuja = new ArrayList<>();
        //ArrayList<TiemposOrdenamiento> datosBurbujaOptimizada = new ArrayList<>();
        
        for(int i=1; i < N; i++){
            //MergeSort
            
            int[] numeros = GeneradorDatos.generarArregloPeorCasoInt(i);
            System.out.println(i);
            //System.out.println(numeros.length);
            long tiempoInicio = System.currentTimeMillis();
            merge.mergeSort(numeros,numeros.length);
            long tiempoFinal = System.currentTimeMillis();
            long tiempoTotal = tiempoFinal - tiempoInicio;
            
            
            datosMerge.add(new TiemposOrdenamiento(tiempoTotal, "MergeSort"));
            
            //Burbuja
            /*
            numeros = GeneradorDatos.generarArregloPeorCasoInt(i);
            Burbuja burbuja = new Burbuja();
            long tiempoInicioBurbuja = System.currentTimeMillis();
            burbuja.ordenar(numeros);
            long tiempoFinalBurbuja = System.currentTimeMillis();
            long tiempoTotalBurbuja = tiempoFinalBurbuja - tiempoInicioBurbuja;
            
            datosBurbuja.add(new TiemposOrdenamiento(tiempoTotalBurbuja, "Burbuja"));
            */
            
            
             //Burbuja optimizada
            /*
             numeros = GeneradorDatos.generarArregloPeorCasoInt(i);
            BurbujaOptimizada burbujaOp = new BurbujaOptimizada();
            long tiempoInicioBurbujaOp = System.currentTimeMillis();
            burbujaOp.ordenar(numeros);
            long tiempoFinalBurbujaOp = System.currentTimeMillis();
            long tiempoTotalBurbujaOp = tiempoFinalBurbujaOp - tiempoInicioBurbujaOp;

            datosBurbujaOptimizada.add(new TiemposOrdenamiento(tiempoTotalBurbujaOp, "Burbuja Optimizada"));
            */
            
            //InsertSort
            /*
            numeros = GeneradorDatos.generarArregloPeorCasoInt(i);
            InsertSort sort = new InsertSort();

            long tiempoInicioInsert = System.currentTimeMillis();
            sort.ordenar(numeros);
            long tiempoFinalInsert = System.currentTimeMillis();
            long tiempoTotalInsert = tiempoFinalInsert - tiempoInicioInsert;
            
            datosSort.add(new TiemposOrdenamiento(tiempoTotalInsert, "InsertSort"));
            */
            
            //QuickSort
            numeros = GeneradorDatos.generarArregloPeorCasoInt(i);
            QuickSort quick = new QuickSort();

            long tiempoInicioInsert = System.currentTimeMillis();
            quick.ordenar(numeros,0,i-1);
            long tiempoFinalInsert = System.currentTimeMillis();
            long tiempoTotalInsert = tiempoFinalInsert - tiempoInicioInsert;
            
            datosQuick.add(new TiemposOrdenamiento(tiempoTotalInsert, "QuickSort"));
             
        }
        
        grafica.agregarSerie(datosQuick,datosMerge);
        grafica.generarGrafico("N", "Tiempo(ms)");
        grafica.mostrarGrafico();
    }
    
}