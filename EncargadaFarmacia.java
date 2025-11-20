public class EncargadaFarmacia extends Persona {
    EncargadaFarmacia(String nombre_persona, String direccion, int edad, long numero_telefono) {
        super(nombre_persona, direccion, edad, numero_telefono);
    }
    
    @Override
    public void bienvenida(){
        System.out.println("Bienvenido a la farmacia, que le podemos ofrecer?");
    }

    //Metodos extra de la encargada
    //Metodo para solicitar farmaco

    public void ver_todos_detalles_objetos(Hospital hospital){
        for(int i = 0; i < hospital.getFarmacia().getFarmacos_disponibles().size(); i++){
            System.out.println("\nFarmaco [" + (i+1) + "]");
            hospital.getFarmacia().getFarmacos_disponibles().get(i).ver_detalles_objeto();
        }
    }
}
