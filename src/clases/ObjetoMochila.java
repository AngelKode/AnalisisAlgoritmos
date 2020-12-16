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
public class ObjetoMochila {
    
    private int peso;
    private int beneficio;
    private String nombre;
    boolean adentro;

    public ObjetoMochila(int peso, int beneficio,String nombre) {
        this.peso = peso;
        this.beneficio = beneficio;
        this.nombre = nombre;
        this.adentro = false;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public boolean isAdentro() {
        return this.adentro;
    }

    public void setIsTaken(boolean isAdentro) {
        this.adentro = isAdentro;
    }
    
    
}
