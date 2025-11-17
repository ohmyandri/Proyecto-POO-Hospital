import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona{
    //Agregando atributos mas específicos:
    private String CURP;
    private String numero_seguro_social;
    private String password_seguro_social;
    private List <Cita> citas_agendadas;


    Paciente(String nombre_persona, String direccion, int edad, String numero_telefono, String CURP, String numero_seguro_social, String password_seguro_social) {
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

    public String getNumero_seguro_social() {
        return numero_seguro_social;
    }

    public String getPassword_seguro_social(){
        return password_seguro_social;
    }

    public List getCitas_agendadas(){
        return citas_agendadas;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public void setNumero_seguro_social(String numero_seguro_social) {
        this.numero_seguro_social = numero_seguro_social;
    }

    //Agregando una cita:
    public void agregar_cita(Cita cita_agendada){
        citas_agendadas.add(cita_agendada);
    }

    public void setPassword_seguro_social(String password_seguro_social){
        this.password_seguro_social = password_seguro_social;
    }
}
