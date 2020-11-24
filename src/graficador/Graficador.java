/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

import clases.TiemposOrdenamiento;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author depot
 */
public class Graficador {
    
    private XYSeriesCollection coleccionDatos;
    private XYLineAndShapeRenderer render;
    private XYPlot plot;
    private JFreeChart freeChart;
    private ChartPanel panelGrafico;
    private DefaultCategoryDataset dataSet;

    public Graficador() {
        this.coleccionDatos = new XYSeriesCollection();
        this.render = new XYLineAndShapeRenderer();
        this.plot = new XYPlot();
        this.freeChart = new JFreeChart(plot);
        this.panelGrafico = null;
        this.dataSet = null;
    }
    
    public void agregarSerie(XYSeries serie){
        this.coleccionDatos.addSeries(serie);
    }
    
    public void agregarSerie(ArrayList<TiemposOrdenamiento> datos,ArrayList<TiemposOrdenamiento> datos2){
        //Aqui es cuando quieran con un area
        //Instanciamos el category set que tendrá los datos
        dataSet = new DefaultCategoryDataset();
        
        for(int i=0; i < datos.size() ; i++){
            dataSet.addValue(datos.get(i).getTiempo(),datos.get(i).getTipoOrdenamiento(), i+"");
            dataSet.addValue(datos2.get(i).getTiempo(),datos2.get(i).getTipoOrdenamiento(), i+"");
        }
    }
    
    public void setColorGrafico(Color color){
        
        for(int posicionSerie=0; posicionSerie < this.coleccionDatos.getSeriesCount(); posicionSerie++){
            this.render.setSeriesPaint(posicionSerie, color);
        }
       this.freeChart.getXYPlot().setRenderer(render);
    }
    
    public void generarGrafico(String tituloGrafico, String ejeX, String ejeY){
        this.freeChart = ChartFactory.createXYLineChart(tituloGrafico,ejeX, ejeY, this.coleccionDatos, PlotOrientation.VERTICAL,false,true,false);
    }
    
    public void generarGrafico(String ejeX, String ejeY){
        this.freeChart = ChartFactory.createAreaChart("Tiempos", 
                                                      ejeX, 
                                                      ejeY, 
                                                      this.dataSet);
    }
    
    public void mostrarGrafico(){
        this.panelGrafico = new ChartPanel(this.freeChart);
        JFrame ventana = new JFrame("Grafico");
        ventana.setLocationRelativeTo(null);
        ventana.setSize(400,600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(this.panelGrafico);
    }
    public JFreeChart getJFreeChart(){
        return this.freeChart;
    }

    public XYSeriesCollection getColeccionDatos() {
        return coleccionDatos;
    }

    public void setColeccionDatos(XYSeriesCollection coleccionDatos) {
        this.coleccionDatos = coleccionDatos;
    }

    public XYLineAndShapeRenderer getRender() {
        return render;
    }

    public void setRender(XYLineAndShapeRenderer render) {
        this.render = render;
    }

    public XYPlot getPlot() {
        return plot;
    }

    public void setPlot(XYPlot plot) {
        this.plot = plot;
    }

    public JFreeChart getFreeChart() {
        return freeChart;
    }

    public void setFreeChart(JFreeChart freeChart) {
        this.freeChart = freeChart;
    }
    
    
}
