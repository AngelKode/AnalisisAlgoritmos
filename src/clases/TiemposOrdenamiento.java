/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author depot
 */
public class TiemposOrdenamiento {
    
    private long tiempo;
    private String tipoOrdenamiento;

    public TiemposOrdenamiento() {
        this.tiempo = 0;
        this.tipoOrdenamiento = "";
    }
    
    public TiemposOrdenamiento(long tiempo, String tipo){
        this.tiempo = tiempo;
        this.tipoOrdenamiento = tipo;
    }
    
    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipoOrdenamiento() {
        return tipoOrdenamiento;
    }

    public void setTipoOrdenamiento(String tipoOrdenamiento) {
        this.tipoOrdenamiento = tipoOrdenamiento;
    }
    
    
}
