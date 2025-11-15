public abstract class Persona {
    protected String nombre_persona;
    protected String direccion;
    protected int edad;
    protected int numero_telefono;

    //Constructor
    Persona(String nombre_persona, String direccion, int edad, int numero_telefono){
        this.nombre_persona = nombre_persona;
        this.direccion = direccion;
        this.edad = edad;
        this.numero_telefono = numero_telefono;
    }

    //Getters y Setters
    public String getNombre_persona() {
        return nombre_persona;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public int getNumero_telefono() {
        return numero_telefono;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNumero_telefono(int numero_telefono) {
        this.numero_telefono = numero_telefono;
    }


    //Metodo para presentarse:
    public void presentarse(){
        System.out.println("Hola!, soy " + getNombre_persona());
    }
}
