/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacion_dinamica;

import clases.ObjetoMochila;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;

/**
 *
 * @author depot
 */
public class MochilaDinamica {
    
    private ArrayList<ObjetoMochila>[][] matrizBeneficios;
    private final ArrayList<ObjetoMochila> pesoObjetos;
    private int capacidadMochila;

    public MochilaDinamica(int capacidad) {
        this.matrizBeneficios = null;
        this.pesoObjetos = new ArrayList<>();
        this.capacidadMochila = capacidad;
    }
    
    public void leerDatosPeso() throws FileNotFoundException, IOException{ 
            
            //Seleccionamos el archivo
            JFileChooser selector = new JFileChooser();
            selector.showOpenDialog(null);
            
            //Obtenemos la direccion del archivo
            FileReader archivo = new FileReader(selector.getSelectedFile().getAbsolutePath());
            BufferedReader buffer = new BufferedReader(archivo);
            
            //Ahora leemos el archivo
            String textoDataSetObjetos = "", textoComparar = "";
            while((textoComparar = buffer.readLine()) != null){
                textoDataSetObjetos += textoComparar+",";
            }
            //Separamos los datos que esten entre comas
            StringTokenizer tokenizador = new StringTokenizer(textoDataSetObjetos,",");
            
              //Ahora guardamos los datos en el ArrayList de Patrones
                int contadorDatos = 0;
                int cantidadObjetos = 0;
                int peso = 0;
                int beneficio = 0;
                
                while(tokenizador.hasMoreTokens()){
                    if(contadorDatos == 0){
                        peso = Integer.parseInt(tokenizador.nextToken());
                        contadorDatos++;
                    }else{
                        //Agregamos un nuevo objeto de tipo ObjetoMochila
                        beneficio = Integer.parseInt(tokenizador.nextToken());
                        this.pesoObjetos.add(new ObjetoMochila(peso, beneficio, "Objeto"+cantidadObjetos));
                        cantidadObjetos++;
                        contadorDatos = 0;
                    }
                }
            //Inicializamos la matriz
            this.matrizBeneficios = new ArrayList[this.pesoObjetos.size() + 1][this.capacidadMochila + 1];
            //Obtenemos el que pesa mas de todos
            ordenarObjetos();
    }
    
    public ArrayList<ObjetoMochila>[][] obtenerMaximoBeneficioDinamico(){
        
        int beneficio = 0, beneficioMaximoRestante = 0,beneficioMaximoAnterior = 0,pesoObjeto;
        //Arraylist de los objetos de mayor beneficio
        
        //Recorremos todas las etapas, y vamos llenando la matriz de beneficios
        for(int etapa = 0;etapa <= this.pesoObjetos.size();etapa++){
            //Ceros en la primer columna
            ArrayList<ObjetoMochila> cero = new ArrayList<>();
            cero.add(new ObjetoMochila(0, 0, null));
            this.matrizBeneficios[etapa][0] = cero;
            
            if(etapa == 0){
                //Ceros en la primer fila
                for(int fila=1;fila<=this.capacidadMochila;fila++){
                    ArrayList<ObjetoMochila> ceros = new ArrayList<>();
                    ceros.add(new ObjetoMochila(0, 0, null));
                    this.matrizBeneficios[etapa][fila] = ceros;
                }
            }else{
                //Insertamos al inicio un arraylist con peso = 0
                ArrayList<ObjetoMochila> ceros = new ArrayList<>();
                ceros.add(new ObjetoMochila(0, 0, null));
                this.matrizBeneficios[etapa][0] = ceros;
                
                //Obtenemos el peso del objeto actual y el beneficio
                pesoObjeto = this.pesoObjetos.get(etapa - 1).getPeso();
                beneficio = this.pesoObjetos.get(etapa - 1).getBeneficio();
                
                //Recorremos las distintas opciones de volumen hasta llegar al límite
                for(int cantidadVolumen = 1;cantidadVolumen <= this.capacidadMochila;cantidadVolumen++){
                   //Checamos si el peso actual no rebasa el limite
                    if(pesoObjeto <= cantidadVolumen){
                        //Aqui el objeto de peso 'cantidadVolumen' puede ser la opcion con mas beneficio
                        //Y agregamos lo que tenga mas beneficio del peso restante ya calculado anteriormente
                        //y checamos si tiene mayor beneficio, si no, no cambia nada
                        beneficioMaximoRestante = obtenerBeneficio(this.matrizBeneficios[etapa - 1][cantidadVolumen - 
                                                                                                    pesoObjeto]);
                        beneficioMaximoAnterior = obtenerBeneficio(this.matrizBeneficios[etapa - 1][cantidadVolumen]);
                        if(beneficio + beneficioMaximoRestante > beneficioMaximoAnterior){
                            //Es mayor que el beneficio anterior
                            ArrayList<ObjetoMochila> nuevo = new ArrayList<>();
                            //agregamos el objeto actual
                            nuevo.add(this.pesoObjetos.get(etapa - 1));
                            //agregamos los objetos de mayor beneficio del peso restante al arraylist 'nuevo'
                            agregarObjetos(this.matrizBeneficios[etapa - 1][cantidadVolumen - pesoObjeto], nuevo);
                            //agregamos los objetos a la tabla de beneficios
                            this.matrizBeneficios[etapa][cantidadVolumen] = nuevo;
                        }else{
                            //No es mayor que el beneficio anterior
                            //Agregamos los objetos que tienen mayor beneficio en la etapa anterior
                            ArrayList<ObjetoMochila> nuevo = this.matrizBeneficios[etapa - 1][cantidadVolumen];
                            //agregamos los objetos a la tabla de beneficios
                            this.matrizBeneficios[etapa][cantidadVolumen] = nuevo; 
                        }
                    }else{
                        //Aqui el objeto no es parte de la solución
                        ArrayList<ObjetoMochila> nuevo = this.matrizBeneficios[etapa - 1][cantidadVolumen];
                        //agregamos los objetos a la tabla de beneficios
                        this.matrizBeneficios[etapa][cantidadVolumen] = nuevo;
                    }
                }
            }
        }
        
        return this.matrizBeneficios;
    }
    
    public void setCapacidad(int nuevaCapacidad){
        this.capacidadMochila = nuevaCapacidad;
    }
    
    public int getCapacidad(){
        return this.capacidadMochila;
    }
    
    public int getCantidadObjetos(){
        return this.pesoObjetos.size();
    }
    private void ordenarObjetos(){
        //Lo ordenamos por inserción
        int tamanioObjetos = this.pesoObjetos.size();

        for (int step = 1; step < tamanioObjetos; step++) { 
          ObjetoMochila key = this.pesoObjetos.get(step);                  
          int j = step - 1;                       
          
          while (j >= 0 && key.getPeso() < this.pesoObjetos.get(j).getPeso()){
            this.pesoObjetos.set(j+1, this.pesoObjetos.get(j));              
            --j;                                 
          }
          this.pesoObjetos.set(j+1,key);                    
        }
    }

    public int obtenerBeneficio(ArrayList<ObjetoMochila> matrizBeneficio) {
        //regresamos el beneficio del arraylist
        //sumando los beneficios de cada objeto
        int sumaBeneficio = 0;
        for(ObjetoMochila objeto : matrizBeneficio){
            sumaBeneficio += objeto.getBeneficio();
        }
        return sumaBeneficio;
    }

    private void agregarObjetos(ArrayList<ObjetoMochila> mayorBeneficioAnterior, ArrayList<ObjetoMochila> nuevo) {
        //agregamos los objetos de 'mayorBeneficioAnterior' a 'nuevo'
        for(ObjetoMochila objeto : mayorBeneficioAnterior){
            nuevo.add(objeto);
        }
    }
}
