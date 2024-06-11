

package ejercicio_1;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class manejadorViajero {
    private List <Viajero> lista;
    
    public manejadorViajero(){
        lista = new ArrayList<>();
    }
    
    // Agregar viajeros al gestor.
    public void agregaViajero (Viajero persona){
        lista.add(persona);
    }
    public void cantidadTotaldeMillas(){
        float total = 0;
        for (Viajero persona: lista){
            total += persona.getMillas();
        }
        System.out.println("Total de millas de todos los viajeros es: " + total);
    }
    public void acumularMillas (Integer millas, String dni){
        Integer i = 0;
               
        while (i < lista.size() && lista.get(i).getDni() != dni){
           i++;
       }
       if (i < lista.size()){
           lista.get(i).acumularMillas(millas);
       }else{
           System.out.println("No se encontró la persona buscada");
       }
    }
    public void muestra(Integer numero){
        Integer i = 0;
        while (i < lista.size() && lista.get(i).getNumero() != numero){
            i++;
        }
        if (i < lista.size()){
            System.out.println(lista.get(i));
        }else{
            System.out.println("No se encontro la persona");
        }
    }
    public void canjearMillas (Integer millas, String dni){
        Integer i = 0;
        
        while (i < lista.size() && lista.get(i).getDni() != dni){
            i++;
        }
        if (i < lista.size()){
 
                lista.get(i).canjearMillas(millas);
          
        }else{
            System.out.println("No se encontró la persona buscada");
        }
    
    }
    
    public void consultaMillas(String dni){
        Integer i = 0;
        while (i < lista.size() && lista.get(i).getDni() != dni){
            i++;
        }
        if (i < lista.size()){
            System.out.println(lista.get(i).getMillas());
        }else{
            System.out.println("No se encontró la persona");
        }
        
    }
    public void mejorViajero (){
        Integer i = 0;
        Integer max = 0;
        Integer viajeroMax = 0;
        while (i < lista.size()){
            
            if (lista.get(i).getMillas()> max){
                max = lista.get(i).getMillas();
                viajeroMax = lista.get(i).getNumero();
            }
            i++;
        }
        muestra(viajeroMax);
    }
    
   
    
    //Mostrar los datos de los viajeros ordenados por la cantidad de millas.
    public void muestraOrdenado(){
        lista.stream()
                .sorted(Comparator.comparingInt(Viajero::getMillas).reversed())
                .forEach(System.out::println);
    }
    //Mostrar los nombres de los viajeros que tienen más de 200 millas.
    public void muestra2(){
        lista.stream()
            .filter(persona -> persona.getMillas()> 200)
            .map(Viajero::getNombre)
            .forEach(System.out::println);
    }
    //Obtener el viajero que tiene más millas.
    public void masMillas(){
        lista.stream()
                .max(Comparator.comparingInt(Viajero::getMillas))
                .ifPresent(System.out::println);
    }

    
}
