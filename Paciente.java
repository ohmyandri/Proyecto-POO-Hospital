import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Paciente extends Persona{
    //Agregando atributos mas específicos:
    private String CURP;
    private long numero_seguro_social;
    private String password_seguro_social;
    private List <Cita> citas_agendadas;


    //Constructor utilizando super para aprovechar lo ya creado con la clase abstracta persona
    Paciente(String nombre_persona, String direccion, int edad, long numero_telefono, String CURP, long numero_seguro_social, String password_seguro_social) {
        super(nombre_persona, direccion, edad, numero_telefono);
        this.CURP = CURP;
        this.numero_seguro_social = numero_seguro_social;
        this.citas_agendadas = new ArrayList<>();
        this.password_seguro_social = password_seguro_social;
    }

    //Getters y Setters:
    public String getCURP() {
        return CURP;
    }

    public long getNumero_seguro_social() {
        return numero_seguro_social;
    }

    public String getPassword_seguro_social(){
        return password_seguro_social;
    }

    public List <Cita> getCitas_agendadas(){
        return citas_agendadas;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public void setNumero_seguro_social(long numero_seguro_social) {
        this.numero_seguro_social = numero_seguro_social;
    }

    public void setPassword_seguro_social(String password_seguro_social){
            this.password_seguro_social = password_seguro_social;
        }
    
    //Metodos relacionados a las citas del paciente:
    //Agregando una cita:
    public void agregar_cita(Cita cita_agendada){
        citas_agendadas.add(cita_agendada);
    }

    public void eliminar_cita(Cita cita_agendada){
        citas_agendadas.remove(cita_agendada);
    }

    //Sobre escribiendo el metodo de la clase abstracta Persona para ver sus detalles
    @Override
    public void imprimir_detalles() {
        super.imprimir_detalles(); 
        // Agregando los detalles específicos del Paciente
        System.out.println("CURP: " + getCURP());
        System.out.println("Número de Seguro Social (NSS): " + getNumero_seguro_social());
        System.out.println("Citas Agendadas: " + getCitas_agendadas().size());
    }

    //Sobre escribiendo el metodo de la clase abstracta persona para ver el monedero
    @Override
    public void visualizarMonedero(){
        System.out.println("\nMonto disponible: " + getDinero());
    }

    //Sobre escribiendo el metodo de la clase abstracta persona para ver el inventario
    @Override
    public void visualizarInventario(){
        // Verificar si el mapa contiene elementos (entry sets)
        if (this.inventario.isEmpty() != true){
            
            System.out.println("\nInventario: ");
            
            int contador = 1;
            
            //Iterar sobre los pares de clave (Farmaco) y valor (Cantidad)
            for (Map.Entry<Farmaco, Integer> entry : this.inventario.entrySet()) {
                Farmaco farmaco = entry.getKey();
                int cantidad = entry.getValue();
                
                // Solo mostramos productos con cantidad mayor a cero, por si acaso.
                if (cantidad > 0) {
                    System.out.println("Objeto [" + contador + "] ---");
                    System.out.println("Nombre: " + farmaco.getNombre_objeto());
                    System.out.println("Cantidad: " + cantidad + " unidades");
                    // Opcional: Mostrar detalles adicionales del fármaco si lo deseas
                    // System.out.println("Dosis: " + farmaco.getDosis()); 
                    contador++;
                }
            }
        } else {
            System.out.println("No tienes objetos guardados en tu inventario.");
        }
    }
}
