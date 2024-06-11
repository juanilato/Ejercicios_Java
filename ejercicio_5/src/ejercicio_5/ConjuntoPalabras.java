/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_5;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Juani
 */
public class ConjuntoPalabras {
    private List <palabra> lista;
    
    public ConjuntoPalabras(){
        lista = new ArrayList<>();
    }
    
    public List<palabra> getLista() {
        return lista;
    }

    public void setLista(List<palabra> lista) {
        this.lista = lista;
    }
    
    // poseia ambos en una sola funcion, de modo que cuando le ingrese una palabra
    // se fije si existia en la lista previa o no, y tome la decision en cada caso
    public void incrementa(String p){
        Optional <palabra> resultado = lista.stream()
            .filter(palabra -> palabra.getPalabra().equals(p))
            .findFirst();
        if (resultado.isPresent()){
            palabra a = resultado.get();
            a.setCantidadVeces(a.getCantidadVeces()+1);
        }
            
    }
    public void agregaPalabra(String p){
        palabra a = new palabra(p, 1);
            lista.add(a);
    }
    
    
    public palabra buscarPalabra(String p){

     Optional<palabra> resultado = lista.stream()
                .filter(palabra -> palabra.getPalabra().equals(p))
                .findFirst(); 
      if (resultado.isPresent()){
          return resultado.get();
      }else{
          return null;
      }
    }
    public void mostrar(){
        lista.stream()
                .sorted(Comparator.comparingInt(palabra::getCantidadVeces).reversed())
                .forEach(System.out::println);
    }    
    public void agregaPalabraConCantidad(String palabra, int cantidad){
        palabra existente = buscarPalabra(palabra);
        if (existente != null) {
            // Si la palabra ya existe en la lista, simplemente actualiza su cantidad
            existente.setCantidadVeces(existente.getCantidadVeces() + cantidad);
        } else {
            // Si la palabra no existe, agrégala a la lista con la cantidad especificada
            lista.add(new palabra(palabra, cantidad));
        }
    }
}
