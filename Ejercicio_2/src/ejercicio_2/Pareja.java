/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

import java.util.List;


/**
 *
 * @author Juani
 */
public class Pareja implements IDeporte{
    private Integer CANTIDAD_MINIMA = 2;
    private List <Deportista> lista;
    @Override
    public boolean conformar(List <Deportista> integrantes) throws CantidadInsuficienteException{
        if (integrantes.size() < CANTIDAD_MINIMA){
            throw new CantidadInsuficienteException("Cantidad de integrantes insuficientes para pareja");
        }

        lista = integrantes.subList(0, CANTIDAD_MINIMA);
        
        return true;
    }
    @Override
    public void mostrar(){
        if (lista != null && !lista.isEmpty()) {
            System.out.println("Pareja conformada por:");
            for (Deportista d : lista) {
                System.out.println(d.getNombre() + " " + d.getNumeroJugador());
                
            }
        } else {
            System.out.println("La pareja no está conformada.");
        }

    }
    @Override
    public void numerarDeportista(){
        int i = 1;
        for (Deportista d: lista){
            d.setNumeroJugador(i);
            i++;
        }
    }
    
}
