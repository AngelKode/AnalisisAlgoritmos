/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases_caballo;

/**
 *
 * @author depot
 * R signifca right, U up, L left y D down, referentes a los movimientos del caballo
 */
public class Caballo {
    
    private int fila;
    private int columna;
    private int filaSiguiente;
    private int columnaSiguiente;
    private boolean isStuck;

    public Caballo(boolean isStuck) {
        this.fila = 0;
        this.columna = 0;
        this.isStuck = isStuck;
        this.filaSiguiente = 0;
        this.columnaSiguiente = 0;
    }
    
    public void setPosicionActual(int[] posicion){
        this.fila = posicion[0];
        this.columna = posicion[1];
    }
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFilaSiguiente() {
        return filaSiguiente;
    }

    public int getColumnaSiguiente() {
        return columnaSiguiente;
    }
    
    public boolean isIsStuck() {
        return isStuck;
    }

    public void setIsStuck(boolean isStuck) {
        this.isStuck = isStuck;
    }
    
    public void movimiento_2R_1U(){
       this.columnaSiguiente = this.columna + 2;
       this.filaSiguiente = this.fila - 1;
    }
    
    public void movimiento_2R_1D(){
       this.columnaSiguiente = this.columna + 2;
       this.filaSiguiente = this.fila + 1;
    }
    
    public void movimiento_1R_2U(){
        this.columnaSiguiente = this.columna + 1;
        this.filaSiguiente = this.fila - 2;
    }
    
    public void movimiento_1R_2D(){
        this.columnaSiguiente = this.columna + 1;
        this.filaSiguiente = this.fila + 2;
    }
    
    public void movimiento_1L_2U(){
        this.columnaSiguiente = this.columna - 1;
        this.filaSiguiente = this.fila - 2;
    }
    
    public void movimiento_1L_2D(){
        this.columnaSiguiente = this.columna - 1;
        this.filaSiguiente = this.fila + 2;
    }
    
    public void movimiento_2L_1U(){
        this.columnaSiguiente = this.columna - 2;
        this.filaSiguiente = this.fila - 1;
    }
    
    public void movimiento_2L_1D(){
        this.columnaSiguiente = this.columna - 2;
        this.filaSiguiente = this.fila + 1;
    }
}
