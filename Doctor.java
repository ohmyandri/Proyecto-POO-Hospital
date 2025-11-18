import java.time.LocalDate;
import java.time.LocalTime;
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
     public boolean estaDisponible(LocalDate fechaSolicitada, LocalTime horaSolicitada) {
        //Itera sobre todas las citas agendadas del doctor, es tipo for each, de python
        for (Cita cita_existente : this.lista_citas) {
            
            //Verificando si es la misma fecha
            boolean misma_fecha = cita_existente.getFecha().equals(fechaSolicitada);
            
            //verificando si la fecha es la misma en ambas, si es correcto, entonces procederemos a verificar horario, teniendo en cuenta el margen de 1 hora entre citas
            if (misma_fecha) {
                LocalTime hora_registrada = cita_existente.getHora();
                
                //Definiendo el rango de tiempo de una hora
                LocalTime hora_inicio = hora_registrada;
                LocalTime hora_fin = hora_registrada.plusMinutes(59);
                
                // 2. Comprobar si la hora solicitada CAE DENTRO O COINCIDE con el slot ocupado.
                
                // Check 1: ¿La nueva hora solicitada es la hora EXACTA de una cita existente? (10:00 vs 10:00)
                boolean coincideExactamente = horaSolicitada.equals(hora_registrada);
                
                // Check 2: ¿La nueva hora está entre el inicio y el fin del slot existente? (Ej: Cita 10:00-10:59, solicita 10:30)
                boolean estaDentro = horaSolicitada.isAfter(hora_inicio) && horaSolicitada.isBefore(hora_fin.plusMinutes(1));
                
                //Si coincide o cae dentro del rango de 60 minutos
                //Verificamos que si alguno de los dos es true, solo decimos false
                if (coincideExactamente || estaDentro) {
                    return false; // No está disponible
                }
            }
        }
        //Si el bucle termina, no se encontró ninguna coincidencia, pt: esta disponible
        return true;
    }

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

    //Detalles del Doctor
    @Override
    public void imprimir_detalles() {
        super.imprimir_detalles();
        System.out.println("Especialidad: " + getEspecialidad_medicina());
        System.out.println("Años de experiencia: " + getExperiencia_medicina());
    }

}
