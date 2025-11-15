//Agregue estos para tener un seguimiento de fecha y hora
import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    //Agendar cita, en sí, tendrá datos como;
    private int doctor_seleccionado; //Sera el index del doctor en una lista
    private Paciente paciente_agendado;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo_cita;

    //Constructor:
    public Cita(int doctor_seleccionado, Paciente paciente_agendado, LocalDate fecha, LocalTime hora, String motivo_cita) {
        this.doctor_seleccionado = doctor_seleccionado;
        this.paciente_agendado = paciente_agendado;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo_cita = motivo_cita;
    }

    //Getters y Setter:
    public int getDoctor_seleccionado() {
        return doctor_seleccionado;
    }

    public void setDoctor_seleccionado(int doctor_seleccionado) {
        this.doctor_seleccionado = doctor_seleccionado;
    }

    public Paciente getPaciente_agendado() {
        return paciente_agendado;
    }

    public void setPaciente_agendado(Paciente paciente_agendado) {
        this.paciente_agendado = paciente_agendado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo_cita() {
        return motivo_cita;
    }

    public void setMotivo_cita(String motivo_cita) {
        this.motivo_cita = motivo_cita;
    }

    //Ver cita:
    public void visualizar_cita(){
        //Mostrando al doctor:
        System.out.println("Doctor: " );
        System.out.println("Fecha: " + this.fecha);
        System.out.println("Hora: " + this.hora);
        System.out.println("Motivo de la cita: " + this.motivo_cita);
    }

}
