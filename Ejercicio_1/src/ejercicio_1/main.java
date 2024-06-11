
package ejercicio_1;



public class main {
    public static void main(String[] args) {
        // Crear instancia de manejadorViajero
        manejadorViajero manejador = new manejadorViajero();

        // Crear instancias de Viajero
        Viajero viajero1 = new Viajero(1, "12345678A", "Juan", "Perez", 1500);
        Viajero viajero2 = new Viajero(2, "87654321B", "Ana", "Gomez", 2000);
        Viajero viajero3 = new Viajero(3, "11223344C", "Luis", "Lopez", 2500);

        // Agregar viajeros al manejador
        manejador.agregaViajero(viajero1);
        manejador.agregaViajero(viajero2);
        manejador.agregaViajero(viajero3);
        
        manejador.acumularMillas(1000, "12345678A");
        manejador.canjearMillas(500, "12345678A");
        manejador.mejorViajero();

        // Imprimir total de millas de todos los viajeros
        manejador.cantidadTotaldeMillas();
        manejador.muestra2();
        // Probar otros métodos
        System.out.println("Viajero 1 - Nombre: " + viajero1.getNombre() + ", Millas: " + viajero1.getMillas());
        System.out.println("Viajero 2 - Nombre: " + viajero2.getNombre() + ", Millas: " + viajero2.getMillas());
        System.out.println("Viajero 3 - Nombre: " + viajero3.getNombre() + ", Millas: " + viajero3.getMillas());
    }
}
