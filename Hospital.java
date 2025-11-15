import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre_hospital;
    private String direccion_hospital;
    private List <Doctor> lista_doctores;
    private List <Cita> lista_citas;
    private List <Paciente> lista_pacientes;
    
    //Constructor:
    public Hospital(String nombre_hospital, String direccion_hospital){
        this.nombre_hospital = nombre_hospital;
        this.direccion_hospital = direccion_hospital;
        this.lista_doctores = new ArrayList<>();
        this.lista_citas = new ArrayList<>();
        this.lista_pacientes = new ArrayList<>();
    }

    //getters y setters para los atributos
    public String getNombre_hospital(){
        return nombre_hospital;
    }

    public String getDireccion_hospital(){
        return direccion_hospital;
    }

    public void setNombre_hospital(String nombre_hospital){
        this.nombre_hospital = nombre_hospital;
    }

    public void setDireccion_hospital(String direccion_hospital){
        this.direccion_hospital = direccion_hospital;
    }

    //Metodos para agregar personas a las listas:
    public void agregar_paciente(Paciente nuevo_paciente){
        lista_pacientes.add(nuevo_paciente);
    }

    public void agregar_doctor(Doctor nuevo_doctor){
        lista_doctores.add(nuevo_doctor);
    }

    public void agregar_cita(Cita nueva_cita){
        lista_citas.add(nueva_cita);
    }

    //Metodos para visualizar personas:
    public void visualizar_todos_doctores(){
        for(int i = 0; i < lista_doctores.size(); i++){
            System.out.println("Nombre: " + lista_doctores.get(i).nombre_persona);
            System.out.println("Especialidad: " + lista_doctores.get(i).getExperiencia_medicina());
            System.out.println("Años de experiencias: " + lista_doctores.get(i).getEspecialidad_medicina());
            System.out.println();
        }
    }


}
