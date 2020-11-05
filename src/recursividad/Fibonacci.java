/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursividad;

/**
 *
 * @author depot
 */
public class Fibonacci {
    
    private int numeroFibonacci;
    private long tiempoEjecucionIterativo;
    private long tiempoEjecucionRecursivo;

    public Fibonacci() {
        this.numeroFibonacci = 0;
        this.tiempoEjecucionIterativo = 0;
        this.tiempoEjecucionRecursivo = 0;
    }
    
    public int calcularRecursivo(int posicion){
        
         if (posicion>1){
            return calcularRecursivo(posicion-1) + calcularRecursivo(posicion-2);  
         }
         else if (posicion==1) {  // caso base
             return 1;
         }
         else if (posicion==0){  // caso base
             return 0;
         }
         else{ //error
             return -1; 
         }
    }
    
    public int calcularIterativo(int posicion){
        this.numeroFibonacci = 0;
        int numeroAnterior = 0;
        int numeroSiguiente = 1;

        for(int i=1;i<posicion;i++){
           this.numeroFibonacci = numeroAnterior + numeroSiguiente;
           numeroAnterior = numeroSiguiente;
           numeroSiguiente = this.numeroFibonacci;
        }
            
        return this.numeroFibonacci;
    }
    
    public void tiempoEjecucionIterataivo(int N){
        
        long tiempoInicio = System.currentTimeMillis();
        System.out.println(tiempoInicio);
        //Calculamos el número
        int numero = calcularIterativo(N);
        this.tiempoEjecucionIterativo = System.currentTimeMillis() - tiempoInicio;
    }
    
    public void tiempoEjecucionRecursivo(int N){
        long tiempoInicio = System.currentTimeMillis();
        //Calculamos el número
        int numero = calcularRecursivo(N);
        System.out.println(numero);
        this.tiempoEjecucionRecursivo = System.currentTimeMillis() - tiempoInicio;
    }   
    
    public long getTiempoIterativo(){
        return this.tiempoEjecucionIterativo;
    }
    public long getTiempoRecursivo(){
        return this.tiempoEjecucionRecursivo;
    }
}
