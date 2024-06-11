/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_2;

/**
 *
 * @author Juani
 */
public class Deportista {


    private String nombre;
    private String dni;
    private Integer numeroJugador;
    
    public Deportista(String nombre, String dni) throws NombreVacioException, DNIVacioException {
        if (nombre == null || nombre.isEmpty()){
            throw new NombreVacioException("El nombre del deportista no puede estar vacio");
        }
        if (dni == null || dni.isEmpty()){
            throw new DNIVacioException("Dni no puede ser vacio");
        }
        this.nombre = nombre;
        this.dni = dni;
        this.numeroJugador = 0;
    }    
    
    
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Integer getNumeroJugador() {
        return numeroJugador;
    }

    public void setNombre(String nombre) throws NombreVacioException{
        if (nombre == null || nombre.isEmpty()){
            throw new NombreVacioException("El nombre del deportista no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public void setDni(String dni) throws DNIVacioException {
        if (dni == null || dni.isEmpty()){
            throw new DNIVacioException("DNI no puede ser vacio");
        }
        this.dni = dni;
    }

    public void setNumeroJugador(Integer numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    
    
    
}
