/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_5;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.text.Normalizer;


/**
 *
 * @author Juani
 */
public class miHilo {
    private String rutaArchivo;
    private ConjuntoPalabras conjunto;
    public miHilo(String ruta){
        rutaArchivo = ruta;
        conjunto = new ConjuntoPalabras();
    }
    public static final String SEPARADOR = " ";
	
  
    public String limpiarSignos(String texto) {
      String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
    
      return textoNormalizado.replaceAll("[^\\p{IsAlphabetic}\\s]", "").toLowerCase();
    //return texto.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑi]", "").toLowerCase();
    }

    public String[] limpiarStopWords(String[] palabras, Set<String> stopWords) {
        return Arrays.stream(palabras)
                .filter(palabra -> !stopWords.contains(palabra))
                .toArray(String[]::new);
    }

    public void leerArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            Set<String> stopWords = new HashSet<>(Arrays.asList(
                "y", "e", "o", "u", "a", "ante", "bajo", "cabe", "con", "contra",
                "de", "desde", "en", "entre", "hacia", "hasta", "para", "por", 
                "según", "sin", "so", "sobre", "tras", "el", "la", "los", "las",
                "un", "una", "unos", "unas", "lo", "que", "al", "del"
            ));

            while ((linea = br.readLine()) != null) {
                // Limpiar signos de puntuación y comillas
                linea = limpiarSignos(linea);
                // Dividir en palabras
                String[] palabras = linea.split("\\s+");
                // Eliminar stopwords
                palabras = limpiarStopWords(palabras, stopWords);

                // Añadir palabras al objeto ConjuntoPalabras
                for (String palabra : palabras) {
                    if (conjunto.buscarPalabra(palabra) != null) {
                        conjunto.incrementa(palabra);
                    } else {
                        conjunto.agregaPalabra(palabra);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public ConjuntoPalabras getConjunto() {
        return conjunto;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public void setConjunto(ConjuntoPalabras conjunto) {
        this.conjunto = conjunto;
    }
    public void mostrar(){
        conjunto.mostrar();
    }
    
    public miHilo suma(miHilo hilo2){
        ConjuntoPalabras c1 = this.getConjunto();
        ConjuntoPalabras c2 = hilo2.getConjunto();
        ConjuntoPalabras conjuntoFinal = new ConjuntoPalabras();
        
        for (palabra p: c1.getLista()){
            conjuntoFinal.agregaPalabraConCantidad(p.getPalabra(), p.getCantidadVeces());
        }
        
        for(palabra p: c2.getLista()){
            conjuntoFinal.agregaPalabraConCantidad(p.getPalabra(), p.getCantidadVeces());
        }
    miHilo hilo = new miHilo(" ");
    hilo.setConjunto(conjuntoFinal);
    return hilo;
    
    }
    
}

