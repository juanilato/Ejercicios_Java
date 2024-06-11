package ejercicio_2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    try {
        List<Deportista> datosFutbol = Campeonato.leerArchivo("C:\\Users\\Juani\\OneDrive\\Documents\\NetBeansProjects\\Ejercicio_2\\src\\ejercicio_2\\inscriptosFutbol.csv");
        List<Deportista> datosPinPon = Campeonato.leerArchivo("C:\\Users\\Juani\\OneDrive\\Documents\\NetBeansProjects\\Ejercicio_2\\src\\ejercicio_2\\inscriptosPinPon.csv");

        List<IDeporte> equiposFutbol = Campeonato.creaEquipos(datosFutbol);
        List<IDeporte> parejasPinPon = Campeonato.creaParejas(datosPinPon);

        Campeonato.numerar(equiposFutbol);
        Campeonato.numerar(parejasPinPon);

        System.out.println("Equipos de Futbol:");
        Campeonato.mostrar(equiposFutbol);

        System.out.println("\nParejas de Ping Pong:");
        Campeonato.mostrar(parejasPinPon);
        
        
    }catch(NombreVacioException | DNIVacioException e){
          System.err.println("Error al crear deportista: " + e.getMessage());
    }catch(CantidadInsuficienteException e){
        System.err.println("Error al crear equipo/pareja: " + e.getMessage());
    }catch (IOException e){
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    }
}
