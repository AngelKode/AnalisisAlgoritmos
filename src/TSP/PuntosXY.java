/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

/**
 *
 * @author depot
 */
public class PuntosXY {
    
    private double punto_X;
    private double punto_Y;

    public PuntosXY(double x, double y) {
        this.punto_X = x;
        this.punto_Y = y;
    }

    public double getPunto_X() {
        return punto_X;
    }

    public void setPunto_X(double punto_X) {
        this.punto_X = punto_X;
    }

    public double getPunto_Y() {
        return punto_Y;
    }

    public void setPunto_Y(double punto_Y) {
        this.punto_Y = punto_Y;
    }
    
}
