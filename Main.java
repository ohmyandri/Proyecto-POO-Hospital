import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            //Creando objeto hospital con su constructor.
            Hospital hospital = new Hospital("La Raza", "Azcapotzalco");
            //Dando una bienvenida al sistema de agendar citas:
            System.out.println("Sistema agendar citas del hospital: " + hospital.getNombre_hospital());
            System.out.println("Ubicacion: " + hospital.getDireccion_hospital());

            //Creando doctores
            Doctor doctor_1 = new Doctor("Dr. Dominguez", "Avenida Central 101", 32, 552233445, "Medicina interna", 15);
            Doctor doctor_2 = new Doctor("Dra. Ramírez", "Calle Falsa 123", 35, 551234567, "Pediatría", 8);
            Doctor doctor_3 = new Doctor("Dr. Pérez", "Avenida Siempre Viva 742", 45, 557654321, "Cardiología", 20);        
            
            //Agregando doctores a la lista de doctores del hospital
            hospital.agregar_doctor(doctor_1);
            hospital.agregar_doctor(doctor_2);
            hospital.agregar_doctor(doctor_3);
            
            //MENU:

            //Creando a una persona, que sera el paciente:
            Paciente paciente_1 = new Paciente("Andrick Avila Villaseñor", "Ignacio Sierra 67", 20, 12345, "AIVA051108HDFVLNA2", "1234");

            //Pero antes, se debe crear al paciente:

            //Requiero el paciente pueda escoger una cita:
            int eleccion = 0;
            while (eleccion != 3) {
                System.out.println("\nMENÚ PRINCIPAL");
                System.out.println("1. Crear y agendar una nueva cita");
                System.out.println("2. Visualizar mis citas agendadas");
                System.out.println("3. Salir del sistema");
                System.out.print("Ingrese su opción: ");
                
                //Leyendo entrada del usuario
                if (sc.hasNextInt()) {
                    eleccion = sc.nextInt();
                    sc.nextLine(); //Limpiando Buffer
                } else {
                    System.out.println("Error: Ingrese un número válido.");
                    sc.nextLine(); //Limpiando Buffer
                    continue;
                }

                switch (eleccion) {
                    case 1:
                        Cita nueva_cita = hospital.agendarCita(paciente_1, sc);
                        int i = nueva_cita.getDoctor_seleccionado();
                        //Agregando la cita a la agenda del doctor:
                        hospital.doctor_especifico(i).agregar_cita(nueva_cita);
                        //Agregando la cita a la agenda del paciente:
                        paciente_1.agregar_cita(nueva_cita);
                        //Agregando la cita a la agenda del hospital:
                        hospital.agregar_paciente(paciente_1);
                        break;

                    case 2:
                        break;
                    
                    case 3:
                        break;
                
                    default:
                        break;
                }
            }

            //Pruebas de ver la cita:
            hospital.visualizar_todos_pacientes();

        }
    
    }
}