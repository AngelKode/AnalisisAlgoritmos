/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisalgoritmos;

import Busquedas.GeneradorDatos;
import TSP.Ciudad;
import TSP.PuntosXY;
import clases.TiemposOrdenamiento;
import graficador.Graficador;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import ordenamiento.Burbuja;
import ordenamiento.BurbujaOptimizada;
import ordenamiento.InsertSort;
import ordenamiento.MergeSort;
import ordenamiento.QuickSort;
import org.jfree.data.xy.XYSeries;
import programacion_dinamica.TSPDinamico;
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
        /*
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
            /*
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
        */
        
        //Fibonacci
        
        /*
        Fibonacci fibo = new Fibonacci();
        
        int N = 50;
        
        Graficador grafica = new Graficador();
        ArrayList<TiemposOrdenamiento> datosIterativo = new ArrayList<>();
        ArrayList<TiemposOrdenamiento> datosIterativoDinamico = new ArrayList<>(); 
        ArrayList<TiemposOrdenamiento> datosRecursivo = new ArrayList<>();
        ArrayList<TiemposOrdenamiento> datosRecursivoDinamico = new ArrayList<>();
        
        long tiempoInicial = 0;
        long tiempoFinal = 0;
        long tiempoTotal = 0;
        
        
        for(int i=1; i < N; i++){
            tiempoInicial = System.currentTimeMillis();
            int n = fibo.ejecutarFibonacciIterativoDinamico(i);
            tiempoFinal = System.currentTimeMillis();
            tiempoTotal = tiempoFinal - tiempoInicial;

            datosIterativo.add(new TiemposOrdenamiento(tiempoTotal, "Iterativo dinámico"));
            
            tiempoInicial = 0;
            tiempoFinal = 0;
            tiempoTotal = 0;
            
            tiempoInicial = System.currentTimeMillis();
            int s = fibo.ejecutarFibonacciRecursivoDinamico(i);
            tiempoFinal = System.currentTimeMillis();
            tiempoTotal = tiempoFinal - tiempoInicial;
            
            datosRecursivo.add(new TiemposOrdenamiento(tiempoTotal, "Recursivo dinámico"));
            
        }
        
        grafica.agregarSerie(datosRecursivo,datosIterativo);
        grafica.generarGrafico("N", "Tiempo(ms)");
        grafica.mostrarGrafico();
        */
        
        //Grafos TSP
        /*
        Grafo s = new Grafo();
        
        s.crearNuevoGrafo();
        
        for (Iterator<Ciudad> it = s.getCiudades().iterator(); it.hasNext();) {
            Ciudad ciudad = it.next();
            System.out.println(ciudad.getNombreCiudad());
            
            ciudad.getCiudadesConectadas().forEach((k,v)->{
                System.out.println("Ciudad:"+k.getNombreCiudad()+",Distancia:"+v);
            });
            System.out.println("");
        }
        */
        /*
        PuntosXY[] puntos = new PuntosXY[3];
        puntos[0] = new PuntosXY(2, 1);
        puntos[1] = new PuntosXY(5, 3);
        puntos[2] = new PuntosXY(6, 19);
        
        TSPDinamico tsp = new TSPDinamico(puntos);
        tsp.resolverProblema();
        */
        Ciudad ciudadInicial = new Ciudad("A",new PuntosXY(2, 3),0);

        Ciudad[] ciudades = new Ciudad[10];
        
        for(int i=0;i<ciudades.length;i++){
            Random random = new Random();
            char nombreCiudad = (char)(i+66);
            ciudades[i] = new Ciudad(Character.toString(nombreCiudad), 
                                     new PuntosXY(random.nextInt(100), 
                                     random.nextInt(100)), i+1);
        }
        double d = 0;
        TSPDinamico tsp = new TSPDinamico(ciudades);
        
        long inicio = System.currentTimeMillis();
        tsp.recorrerCaminos(ciudadInicial, ciudades,ciudadInicial,0.0);
        long finalTiempo = System.currentTimeMillis() - inicio;
        System.out.println("Tiempo de Ejecucion: " + finalTiempo);
        System.out.println("Ciudades recorridas:"+ tsp.getCiudadesRecorridas());
        System.out.println("Distancia mínima: "+tsp.getDistancia());
        //System.out.println(finalTiempo);
    }   
       
               
}