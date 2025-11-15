public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("La Raza", "Azcapotzalco");
        //Dando una bienvenida al sistema de agendar citas:
        System.out.println("Sistema agendar citas del hospital: " + hospital.getNombre_hospital());
        System.out.println("Ubicacion: " + hospital.getDireccion_hospital());

        //Creando un doc
        Doctor doctor_1 = new Doctor("Dr. Dominguez", "Avenida Central 101", 32, 552233445, "Medicina interna", 15);
        Doctor doctor_2 = new Doctor("Dra. Ramírez", "Calle Falsa 123", 35, 551234567, "Pediatría", 8);
        Doctor doctor_3 = new Doctor("Dr. Pérez", "Avenida Siempre Viva 742", 45, 557654321, "Cardiología", 20);        
        
        hospital.agregar_doctor(doctor_1);
        hospital.agregar_doctor(doctor_2);
        hospital.agregar_doctor(doctor_3);
    
        hospital.visualizar_todos_doctores();
    
        // Prueba!
    }
}