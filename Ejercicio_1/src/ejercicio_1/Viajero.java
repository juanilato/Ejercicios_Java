

package ejercicio_1;





public class Viajero{

    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer millas;
    

    public Viajero (Integer numero, String dni, String nombre, String apellido, Integer millas){
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.millas = millas;
    }
        public void setNumero(Integer numero) {
            this.numero = numero;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public void setMillas(Integer millas) {
            this.millas = millas;
        }


    public Integer getNumero() {
        return numero;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getMillas() {
        return millas;
    }
    
    public void acumularMillas(Integer millas_1){
        millas += millas_1;
    }
    
    public void canjearMillas(Integer millas_1){
        if (millas >= millas_1){
            millas -= millas_1;
        }else{
            System.out.println("No se puede realizar la operación deseada");
        }
    }
    
    @Override
    public String toString(){
        return "Viajero num:" + numero + " " +
                "Millas: " + millas;
                
    }
}



