/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos_avidos;

import clases_caballo.Caballo;
import clases_caballo.Casilla;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author depot
 */
//todo: checar error linea 42
public class CaballoTablero {
    
    private final Casilla[][] tablero;
    private final Caballo caballo;
    private final ArrayList<int[]> caminos;
    
    
    public CaballoTablero() {
        tablero = new Casilla[8][8];
        for(int fila = 0;fila < 8;fila++){
            for(int columna = 0; columna < 8;columna++){
                this.tablero[fila][columna] = new Casilla();
            }
        }
        caminos = new ArrayList<>();
        this.caballo = new Caballo(false);
    }
    
    public void recorrerCasillas(){
        //Obtenemos una posicion aleatoria de inicio
        this.caballo.setPosicionActual(obtenerPosicionAleatoria()); 
        //Hacemos el ciclo mientras aun se pueda mover el caballo
        do{
           //agregamos el camino al arreglo
           this.caminos.add(new int[]{this.caballo.getFila(),this.caballo.getColumna()});
           //marcamos esa posicion como ya visitada
           this.tablero[this.caballo.getFila()][this.caballo.getColumna()].setVisitada(true);
           //Obtenemos la mejor siguiente posicion del caballo
           this.caballo.setPosicionActual(obtenerMejorPosicion());
        }while(!this.caballo.isIsStuck());
    }
    
    private int[] obtenerPosicionAleatoria(){
        Random numeroAleatorio = new Random();
        return new int[]{numeroAleatorio.nextInt(7),numeroAleatorio.nextInt(7)};
    }
    
    private int[] obtenerMejorPosicion(){
        int posiblidadActual = 0,posiblidadAnterior = 0,caminosPosibles = 8;
        int[] siguienteCamino = new int[2];
        boolean caminosDisponibles = false;//Nunca cambia si el siguiente movimiento es falso
        
        //Checamos todos los posibles casos unicamente para obtener el que tenga mas opciones de camino
        for(int movimiento = 0;movimiento < 8;movimiento++){
            switch(movimiento){
                case 0:{
                    this.caballo.movimiento_2R_1U();
                    posiblidadAnterior = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadAnterior == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si el movimiento está dentro del tablero
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        siguienteCamino[0] = this.caballo.getFilaSiguiente();
                        siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        caminosDisponibles = true;
                    }
                    
                    break;
                }
                case 1:{
                    this.caballo.movimiento_2R_1D();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
                case 2:{
                    this.caballo.movimiento_1R_2U();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    }
                    
                    break;
                }
                case 3:{
                    this.caballo.movimiento_1R_2D();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
                case 4:{
                    this.caballo.movimiento_1L_2U();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
                case 5:{
                    this.caballo.movimiento_1L_2D();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
                case 6:{
                    this.caballo.movimiento_2L_1U();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
                case 7:{
                    this.caballo.movimiento_2L_1D();
                    posiblidadActual = siguientesPosibilidades();
                    //Disminuimos la cantidad de caminos posibles 
                    if(posiblidadActual == -1){
                        caminosPosibles--;
                    }
                    
                    //Verificamos si es un movimiento valido
                    if(isValid(this.caballo.getColumnaSiguiente(), this.caballo.getFilaSiguiente())){
                        caminosDisponibles = true;
                        //Si hay mas posibilidades que el camino anterior
                        if(posiblidadActual > posiblidadAnterior){
                            posiblidadAnterior = posiblidadActual;
                            siguienteCamino[0] = this.caballo.getFilaSiguiente();
                            siguienteCamino[1] = this.caballo.getColumnaSiguiente();
                        }
                    } 
                    
                    break;
                }
            }
        }
        //Si caminos posibles es igual a 0, ya no se puede mover el caballo
        if(caminosPosibles == 0){
            this.caballo.setIsStuck(true);
        }
        //Si niingún camino es valido
        if(!caminosDisponibles){
           this.caballo.setIsStuck(true);
        }
        
        return siguienteCamino;
    }

    private int siguientesPosibilidades() {
        //Si el siguiente movimiento es invalido, regresamos -1
        if(this.caballo.getColumnaSiguiente() > 7 || this.caballo.getFilaSiguiente() > 7 ||
           this.caballo.getColumnaSiguiente() < 0 || this.caballo.getFilaSiguiente() < 0){
           return -1;
        }
        
        int caminosPosibles = 0,fila,columna;
        //Creamos un objeto de tipo caballo para checar las posiblidades del siguiente movimiento
        Caballo caballoSiguiente = new Caballo(false);
        caballoSiguiente.setColumna(this.caballo.getColumnaSiguiente());
        caballoSiguiente.setFila(this.caballo.getFilaSiguiente());
        
        //Si cumple con las condiciones de la posicion no estar visitada anteriormente
        if(!this.tablero[caballoSiguiente.getFila()][caballoSiguiente.getColumna()].isVisitada()){
            for(int movimiento = 0;movimiento < 8;movimiento++){
                switch(movimiento){
                    case 0:{
                        caballoSiguiente.movimiento_2R_1U();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 1:{
                        caballoSiguiente.movimiento_2R_1D();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 2:{
                        caballoSiguiente.movimiento_1R_2U();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 3:{
                        caballoSiguiente.movimiento_1R_2D();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 4:{
                        caballoSiguiente.movimiento_1L_2U();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 5:{
                        caballoSiguiente.movimiento_1L_2D();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 6:{
                        caballoSiguiente.movimiento_2L_1U();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                        //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                    case 7:{
                        caballoSiguiente.movimiento_2L_1D();
                        columna = caballoSiguiente.getColumnaSiguiente();
                        fila = caballoSiguiente.getFilaSiguiente();
                        
                         //Verificamos si la posicion es válida
                        if(isValid(columna, fila)){
                            //Checamos si esa posicion aun no ha sido visitada
                            //si hay un error, la posicion sale del tablero
                            try {
                                if(!this.tablero[fila][columna].isVisitada()){
                                    caminosPosibles++;
                                }
                            }catch (Exception e) {}   
                        }
                        
                        break;
                    }
                }
            }
            return caminosPosibles;
        }
        return -1;
    }
    
    private boolean isValid(int columna, int fila){
        if(columna < 8 && fila < 8 && columna >= 0 && fila >= 0){
            return true;
        }
        return false;
    }
    
    public ArrayList<int[]> obtenerCaminos(){
        return this.caminos;
    }
}
