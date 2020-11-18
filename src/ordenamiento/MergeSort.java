
package ordenamiento;

import Busquedas.Busquedas;

/**
 *
 * @author depot
 */
public class MergeSort {
    
    public long tInicio;
    public long tFinal;
    public long tTotal;

    public MergeSort() {
        this.tFinal = 0;
        this.tInicio = 0;
        this.tTotal = 0 ;
    }
    
    public void buscar (int[] datos, int x){
       this.tInicio = System.currentTimeMillis();
       Busquedas.busquedaLineal(datos, x);
       this.tFinal = System.currentTimeMillis();
       this.tTotal = this.tFinal - this.tInicio;
    }

    public long getFinal() {
        return tFinal;
    }

    public long getInicio() {
        return tInicio;
    }

    public long getTotal() {
        return tTotal;
    }
    
    public void mergeSort(int[] datos, int lenghtDatos){
        //Si mide 1 o menos, no hacemos nada
        if(datos.length <= 1){
             return;
        }
        
        
        int mid = lenghtDatos / 2;
        int[] l = new int[mid];
        int[] r = new int[lenghtDatos - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = datos[i];
        }
        for (int i = mid; i < lenghtDatos; i++) {
            r[i - mid] = datos[i];
        }
        
        mergeSort(l, mid);
        mergeSort(r, lenghtDatos - mid);

        merge(datos, l, r, mid, lenghtDatos - mid);
        
    }
    
    private void merge(int[] a, int[] l, int[] r, int left, int right){
        
        int i = 0, j = 0, k = 0;
        
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        
    }
    
}
