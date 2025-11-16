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
            Doctor doctor_1 = new Doctor("Dr. Dominguez", "Avenida Central 101", 32, "552233445", "Medicina interna", 15);
            Doctor doctor_2 = new Doctor("Dra. Ramírez", "Calle Falsa 123", 35, "551234567", "Pediatría", 8);
            Doctor doctor_3 = new Doctor("Dr. Pérez", "Avenida Siempre Viva 742", 45, "557654321", "Cardiología", 20);        
            
            //Agregando doctores a la lista de doctores del hospital
            hospital.agregar_doctor(doctor_1);
            hospital.agregar_doctor(doctor_2);
            hospital.agregar_doctor(doctor_3);

            //Menu externo, para registrar a un paciente
            int eleccion_exterior = 0;
            while (eleccion_exterior != 4) {
                System.out.println("\nBienvenido al hospital");
                System.out.println("1. Agregar derecho habientes al hospital");
                System.out.println("2. Seleccionar derecho habiente a usar");
                System.out.println("3. Panel de Administrador");
                System.out.println("4. Salir del sistema");
                System.out.print("Ingrese su opción: ");
                if (sc.hasNextInt()) {
                        eleccion_exterior = sc.nextInt();
                        sc.nextLine(); //Limpiando Buffer
                    } else {
                        System.out.println("Error: Ingrese un número válido.");
                        sc.nextLine(); //Limpiando Buffer
                        continue;
                    }
                
                    //switch Case:
                    switch (eleccion_exterior) {
                        case 1:
                            Paciente nueva_persona = hospital.agregar_derecho_habiente(sc);
                            try {
                                hospital.agregar_derecho_habiente(nueva_persona);
                            } catch (Exception e) {
                                System.out.println("Hubo un error al agregar al derecho habiente");
                            }
                            break;

                        case 2:
                            try {
                                hospital.visualizar_derecho_habientes();
                                System.out.print("Selecciona tu derecho habiente: ");
                                int seleccion_derecho_habiente = sc.nextInt();
                                sc.nextLine();
                                Paciente derecho_habiente_temporal = hospital.seleccion_derecho_habiente(seleccion_derecho_habiente);
                                
                                //Menu Interno => PACIENTE
                                int eleccion = 0;
                                while (eleccion != 5) {
                                    System.out.println("\nMENÚ PRINCIPAL");
                                    System.out.println("1. Crear y agendar una nueva cita");
                                    System.out.println("2. Visualizar mis citas agendadas");
                                    System.out.println("3. Modificar una cita agendada");
                                    System.out.println("4. Cancelar una cita agendada");
                                    System.out.println("5. Salir del sistema");
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
                                            Cita nueva_cita = hospital.agendar_cita(derecho_habiente_temporal, sc);
                                            int i = nueva_cita.getDoctor_seleccionado();
                                            //Agregando la cita a la agenda del doctor:
                                            hospital.doctor_especifico(i).agregar_cita(nueva_cita);
                                            //Agregando la cita a la agenda del paciente:
                                            derecho_habiente_temporal.agregar_cita(nueva_cita);
                                            //Agregando la cita a la agenda del hospital:
                                            hospital.agregar_paciente(derecho_habiente_temporal);
                                            break;
                                        
                                        //Visualizar citas agendadas de un paciente
                                        case 2:
                                            hospital.visualizar_cita_agendada_paciente(derecho_habiente_temporal);
                                            break;
                                        
                                        //Modificar una cita agendada:
                                        case 3:
                                            break;
                                        
                                        //Cancelar una cita
                                        case 4:
                                            break;

                                        case 5:
                                            eleccion = 5;

                                        default:
                                            break;
                                    }
                                }

                            } catch (Exception e) {
                                System.out.println("Hubo un error al seleccionar y/o visualizar derecho habiente");
                            }
                            
                            break;

                        case 3:
                            break;
                        
                        case 4:
                            eleccion_exterior = 4;
                            break;
                        
                        //Caso default 
                        default:
                            System.out.println("Intentaste acceder a algo incorrecto, prueba de nuevo");
                            break;
                    }
            }


            //Implementar posibilidad de administrador del hospital para verlo, TODO
        }
    
    }
}