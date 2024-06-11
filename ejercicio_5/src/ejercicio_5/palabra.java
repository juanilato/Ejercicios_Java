/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_5;

/**
 *
 * @author Juani
 */
public class palabra {
    private String palabra;
    private Integer cantidadVeces;
    
    public palabra(String palabra, Integer cantidadVeces) {
        this.palabra = palabra;
        this.cantidadVeces = cantidadVeces;
    }
    public String getPalabra() {
        return palabra;
    }

    public Integer getCantidadVeces() {
        return cantidadVeces;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setCantidadVeces(Integer cantidadVeces) {
        this.cantidadVeces = cantidadVeces;
    }
    @Override
    public String toString(){
        return palabra + " " + cantidadVeces;
    }
   
}
