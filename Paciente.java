public class Paciente extends Persona{
    //Agregando atributos mas específicos:
    protected String CURP;
    protected String numero_seguro_social;

    Paciente(String nombre_persona, String direccion, int edad, int numero_telefono, String CURP, String numero_seguro_social) {
        super(nombre_persona, direccion, edad, numero_telefono);
        this.CURP = CURP;
        this.numero_seguro_social = numero_seguro_social;
    }

    //Getters y Setters:
    public String getCURP() {
        return CURP;
    }

    public String getNumero_seguro_social() {
        return numero_seguro_social;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public void setNumero_seguro_social(String numero_seguro_social) {
        this.numero_seguro_social = numero_seguro_social;
    }
}
