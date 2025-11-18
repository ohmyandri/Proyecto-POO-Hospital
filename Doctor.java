import java.util.ArrayList;
import java.util.List;

public class Doctor extends Persona{
    //Como se está usando clase abstracta persona, se agregaran datos más específicos del doctor
    private String especialidad_medicina;
    private int experiencia_medicina;
    private List <Paciente> lista_pacientes;
    private List <Cita> lista_citas;

    public Doctor(String nombre_persona, String direccion, int edad, String numero_telefono, String especialidad_medicina, int experiencia_medicina) {
        super(nombre_persona, direccion, edad, numero_telefono);
        this.especialidad_medicina = especialidad_medicina;
        this.experiencia_medicina = experiencia_medicina;
        this.lista_pacientes = new ArrayList<>();
        this.lista_citas = new ArrayList<>();
    }
    
    //Verificando si el doctor esta disponible en x horario
    

    //Getters y Setters:
    public String getEspecialidad_medicina() {
        return especialidad_medicina;
    }

    public int getExperiencia_medicina() {
        return experiencia_medicina;
    }

    public void setEspecialidad_medicina(String especialidad_medicina) {
        this.especialidad_medicina = especialidad_medicina;
    }

    public void setExperiencia_medicina(int experiencia_medicina) {
        this.experiencia_medicina = experiencia_medicina;
    }

    public void agregar_paciente(Paciente nuevo_paciente){
        lista_pacientes.add(nuevo_paciente);
    }

    public void agregar_cita(Cita nueva_cita){
        lista_citas.add(nueva_cita);
    }
}
