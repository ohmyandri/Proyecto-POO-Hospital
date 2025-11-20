import java.util.ArrayList;
import java.util.List;

public abstract class Persona {
    protected String nombre_persona;
    protected String direccion;
    protected int edad;
    protected long numero_telefono;
    protected List <Objeto> inventario;
    protected double dinero = 10000;

    //Constructor
    Persona(String nombre_persona, String direccion, int edad, long numero_telefono){
        this.nombre_persona = nombre_persona;
        this.direccion = direccion;
        this.edad = edad;
        this.numero_telefono = numero_telefono;
        //Iniciando el inventario de la persona
        this.inventario = new ArrayList<>();
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

    public long getNumero_telefono() {
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

    public void setNumero_telefono(long numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    //Metodo que se podra sobreescribir:
    public void imprimir_detalles(){
        System.out.println("Nombre: " + nombre_persona);
        System.out.println("Direccion: " + direccion);
        System.out.println("Edad: " + edad);
        System.out.println("Numero de telefono: " + numero_telefono);
    }

    public void bienvenida(){
    }

    public void ver_inventario(){
    }
}