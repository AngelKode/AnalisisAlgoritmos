/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

/**
 *
 * @author depot
 * Esta clase sirve como "Nodo" de cada ciudad, teniendo el nombre, los puntos en el plano donde
 * se encuentra ubicado y un identificador que nos sirve para hacer la programación dinámica
 */
public class Ciudad {
    
    private PuntosXY puntos;
    private String nombreCiudad;
    private int id;

    public Ciudad(String nombre,PuntosXY puntos,int id) {
        this.nombreCiudad = nombre;
        this.puntos = puntos;
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public PuntosXY getPuntos() {
        return puntos;
    }

    public void setPuntos(PuntosXY puntos) {
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int identificador) {
        this.id = identificador;
    }
    
}
