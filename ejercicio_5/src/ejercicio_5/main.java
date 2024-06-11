package ejercicio_5;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juani
 */
public class main {
    public static void main(String[] args){
    miHilo texto1 = new miHilo ("C:/Users/Juani/OneDrive/Documents/NetBeansProjects/ejercicio_5/src/ejercicio_5/Texto1.txt");
    miHilo texto2 = new miHilo("C:/Users/Juani/OneDrive/Documents/NetBeansProjects/ejercicio_5/src/ejercicio_5/Texto2.txt");
    texto1.leerArchivo();
    texto2.leerArchivo();
    miHilo texto3 = texto1.suma(texto2);
    System.out.println("Texto 1.");
    texto1.mostrar();
    System.out.println("Texto 2.");
    texto2.mostrar();
    System.out.println("Texto 1 y 2");
    texto3.mostrar();
    
    }
}
