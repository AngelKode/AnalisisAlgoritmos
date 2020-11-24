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
    public int[] serieFibonacci;

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
    
    public int ejecutarFibonacciRecursivoDinamico(int n){
        int v=0;
        
        serieFibonacci = new int[n];
        for(int x = 0; x<serieFibonacci.length; x++){
            serieFibonacci[x] = -1;
        }
        
        serieFibonacci[0] = 0;
        if(n>1){
            serieFibonacci[1] = 1;
        }
        
        v = FibonacciRecursivoDinamico(n);
        return v;
    }
    
    public int FibonacciRecursivoDinamico(int n){
        int desN1 = 0;
        int desN2 = 0;
        
        if(n == 0){
            return 0;
        }
        else if(n == 1){
            return 1;
        }
        else{
            if(serieFibonacci[n-1] != -1){
                desN1 = serieFibonacci[n-1];
            }
            else{
                desN1 = FibonacciRecursivoDinamico(n-1);
                serieFibonacci[n-1] = desN1;
            }

            if(serieFibonacci[n-2] != -1){
                desN2 = serieFibonacci[n-2];
            }
            else{
                desN2 = FibonacciRecursivoDinamico(n-2);
                serieFibonacci[n-2] = desN2;
            }
            return desN1 + desN2;
        }
    }
    
    
    public int ejecutarFibonacciIterativoDinamico(int x){
        this.serieFibonacci = new int[x+1];
	this.serieFibonacci[0] = 0;
	this.serieFibonacci[1] = 1;
	for(int i = 2; i <= x; i++) {
		this.serieFibonacci[i] = this.serieFibonacci[i-1] + this.serieFibonacci[i-2];
	}
	return this.serieFibonacci[x];
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
