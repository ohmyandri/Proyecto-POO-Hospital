import java.util.ArrayList;
import java.util.List;

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

    //Agregando una cita:
    public void agregar_cita(Cita cita_agendada){
        citas_agendadas.add(cita_agendada);
    }

    public void eliminar_cita(Cita cita_agendada){
        citas_agendadas.remove(cita_agendada);
    }

    public void setPassword_seguro_social(String password_seguro_social){
        this.password_seguro_social = password_seguro_social;
    }

    //Sobre escribiendo el metodo de la clase abstracta Persona
    @Override
    public void imprimir_detalles() {
        super.imprimir_detalles(); 
        // Agregando los detalles específicos del Paciente
        System.out.println("CURP: " + getCURP());
        System.out.println("Número de Seguro Social (NSS): " + getNumero_seguro_social());
        System.out.println("Citas Agendadas: " + getCitas_agendadas().size());
    }

    @Override
    public void ver_inventario(){
        try {
            for(int i = 0; i < inventario.size(); i++){
                inventario.get(i).ver_detalles_objeto();;
            }
        } catch (Exception e) {
            System.out.println("Error inesperado, pruebe de nuevo");
        }
    }
}
