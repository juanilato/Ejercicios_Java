


package ejercicio_2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Lee los archivos correspondientes y devuelve una lista de los datos.
public class Campeonato {
    public static final String SEPARADOR = ",";
	
    public static List<Deportista>leerArchivo(String nombreArchivo)throws IOException, NombreVacioException, DNIVacioException{
        BufferedReader bufferLectura = null;
        List<Deportista> datos = new ArrayList<>();
        try {
            bufferLectura = new BufferedReader(new FileReader(nombreArchivo));
            String linea;                  

            while ((linea=bufferLectura.readLine()) != null) {
             // Sepapar la linea leída con el separador definido previamente
             String[] campos = linea.split(SEPARADOR); 
            if (campos.length < 2) {
                    throw new IOException("Datos incompletos en el archivo.");
                }
             Deportista d = new Deportista(campos[0],campos[1]);
             datos.add(d);           
            }
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
         // Cierro el buffer de lectura
         if (bufferLectura != null) {
             bufferLectura.close();
         }
        }
        return datos;
    }
    /**
    * Crea los equipos con los datos pasados como parámetro
    * @param datos lista con todos los deportistas inscriptoss
     * @return una lista de equipos
    */
    public static List<IDeporte> creaEquipos(List<Deportista> datos)throws CantidadInsuficienteException {
        List<IDeporte> equipos = new ArrayList<>();
        for(int i = 0; i < datos.size(); i+= 5){
            List<Deportista> integrantes = datos.subList(i, Math.min(i+5, datos.size()));
            if (integrantes.size() < 5) {
                throw new CantidadInsuficienteException("No hay suficientes deportistas para formar un equipo.");
            }
            Equipo equipo = new Equipo();
            if (equipo.conformar(integrantes)){
                equipos.add(equipo);
            }
        }
        return equipos;
    }
    /**
    Crea los equipos con los datos pasados como parámetro
     * @param datos es una lista con todos los deportitas inscriptos
     * @return una lista de Parejas formadas
    */
    public static List<IDeporte> creaParejas(List<Deportista> datos)throws CantidadInsuficienteException{
        List<IDeporte> parejas = new ArrayList<>();
        for (int i = 0; i < datos.size(); i += 2) {
            List<Deportista> integrantes = datos.subList(i, Math.min(i + 2, datos.size()));
            if (integrantes.size() < 2) {
                throw new CantidadInsuficienteException("No hay suficientes deportistas para formar una pareja.");
            }
            Pareja pareja = new Pareja();
            if (pareja.conformar(integrantes)) {
                parejas.add(pareja);
            }
        }
        return parejas;
    }
    /**
    * Numera cada integrante del equipo o de la pareja
     * @param datos 
    */
    public static void numerar(List<IDeporte> datos){
         for (IDeporte i: datos){
             i.numerarDeportista();
         }
    }
    /**
    * Muestra los datos de cada equipo o de cada pareja
     * @param datos
    */
    public static void mostrar(List<IDeporte> datos){
        for (IDeporte e: datos){
            e.mostrar();
        }
    }
}

