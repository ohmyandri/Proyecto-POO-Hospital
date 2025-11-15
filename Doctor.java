public class Doctor extends Persona{
    //Como se está usando clase abstracta persona, se agregaran datos más específicos del doctor
    private String especialidad_medicina;
    private int experiencia_medicina;
    /* editar:
    Tengo pensado agregar una lista, un array, de sus citas agendadas para verificar su disponibilidad
        private List<Cita> citasAgendadas;
     */

    //Constructor del doctor
    public Doctor(String nombre_persona, String direccion, int edad, int numero_telefono, String especialidad_medicina, int experiencia_medicina) {
        super(nombre_persona, direccion, edad, numero_telefono);
        this.especialidad_medicina = especialidad_medicina;
        this.experiencia_medicina = experiencia_medicina;
        //Para la lista de citas del doctor
        //this.citasAgendadas = new ArrayList<>();
    }

    //Getters y Setters:
    public String getEspecialidad_medicina() {
        return especialidad_medicina;
    }

    public int getExperiencia_medicina() {
        return experiencia_medicina;
    }

    /*
    public List<Cita> getCitasAgendadas() {
        return citasAgendadas;
    }*/


    public void setEspecialidad_medicina(String especialidad_medicina) {
        this.especialidad_medicina = especialidad_medicina;
    }

    public void setExperiencia_medicina(int experiencia_medicina) {
        this.experiencia_medicina = experiencia_medicina;
    }

    /*
    public void agregarCita(Cita nuevaCita) {
        this.citasAgendadas.add(nuevaCita);
    }
    */

    //Metodo presentarse sobre escrito
    @Override
    public void presentarse(){
        System.out.println("Buenos dias, soy " + getNombre_persona());
        System.out.println("Cuento con la especialidad de " + getEspecialidad_medicina() + ", y tengo una experiencia de "+ getExperiencia_medicina() + " años en ella");
    }

}
