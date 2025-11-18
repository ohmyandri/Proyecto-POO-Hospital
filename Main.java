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
                        System.out.println("\nERROR: Ingrese un número válido.");
                        sc.nextLine(); //Limpiando Buffer
                        continue;
                    }
                
                    //switch Case:
                    switch (eleccion_exterior) {
                        case 1:
                            //Los metodos cuentan con su try-catch
                            //Agregando derecho habiente al hospital
                            Paciente nueva_persona = hospital.agregar_derecho_habiente(sc);
                            //Agregando derecho habiente a la lista de derecho habientes del hospital
                            hospital.agregar_derecho_habiente(nueva_persona);
                            break;

                        
                        case 2:
                        //Try catch para seleccionar derecho habiente, esto evitando errores, y manejandolos correctamente
                        Paciente derecho_habiente_temporal = null;
                        try {
                            hospital.visualizar_derecho_habientes();
                            if(hospital.getLista_derecho_habientes().size() > 0) {
                                System.out.print("Selecciona tu derecho habiente: ");
                                int seleccion_derecho_habiente = sc.nextInt();
                                sc.nextLine();
                                derecho_habiente_temporal = hospital.seleccion_derecho_habiente(seleccion_derecho_habiente, sc);
                            }

                            //Menu Interno => PACIENTE
                            int eleccion = 0;
                            while (eleccion != 5 && derecho_habiente_temporal != null) {
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
                                
                                //Switch case para las opciones del paciente
                                switch (eleccion) {
                                    //Crear y agendar una nueva cita
                                    case 1:
                                        //Agendando cita
                                        Cita nueva_cita = hospital.agendar_cita(derecho_habiente_temporal, sc);
                                        //Obteniendo indice del doctor seleccionado
                                        int i = nueva_cita.getDoctor_seleccionado();

                                        //Verificando si el doctor seleccionado esta disponible
                                        Doctor doctor_temporal = hospital.doctor_especifico(i);
                                        if(doctor_temporal.estaDisponible(nueva_cita.getFecha(), nueva_cita.getHora()) == true){
                                            //Agregando la cita a la agenda del doctor:
                                            hospital.doctor_especifico(i).agregar_cita(nueva_cita);
                                            //Agregando la cita a la agenda del paciente:
                                            derecho_habiente_temporal.agregar_cita(nueva_cita);
                                            //Agregando la cita a la agenda del hospital:
                                            hospital.agregar_cita(nueva_cita);
                                            //Agregando el paciente, a la lista del hospital:
                                            hospital.agregar_paciente(derecho_habiente_temporal);
                                        }
                                        else{
                                            System.out.println("\nEl doctor no se encuentra disponible en esa fecha y hora, por favor seleccione otro horario");
                                        }
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
                                        derecho_habiente_temporal = null;

                                    default:
                                        break;
                                }
                            }
                        }

                        //Catch para manejar la excepcion
                        catch (Exception e) {
                            System.out.println("Hubo un error al seleccionar y/o visualizar derecho habiente");
                        }
                            
                        break;

                        //Para el caso de panel de administrador
                        case 3:
                            //Verificando que sea un administrador quien esta utilizando los servicios:
                            try {
                                String user_temporal, password_temporal;
                                //Pidiendo usuario:
                                System.out.print("Ingresa el usuario: ");
                                user_temporal = sc.nextLine();
                                System.out.print("Ingresa la contraseña: ");
                                password_temporal = sc.nextLine();

                                //Verificando sea correcta la contraseña:
                                if (user_temporal.equals("admin") && password_temporal.equals("0000")) {
                                    //El administrador podra tener para ver sus doctores, pacientes, y todas las citas agendadas:
                                    int eleccion_admin = 0;
                                    while (eleccion_admin != 5) {
                                        System.out.println("\nPanel de administrador:");
                                        System.out.println("1. Visualizar Doctores");
                                        System.out.println("2. Visualizar Derecho-Habientes");
                                        System.out.println("3. Visualizar Pacientes");
                                        System.out.println("4. Visualizar Citas Agendadas");
                                        System.out.println("5. Salir del panel de adminisitrador");
                                        System.out.print("Elige una opcion: ");
                                        eleccion_admin = sc.nextInt();

                                        switch (eleccion_admin) {
                                            case 1:
                                                hospital.visualizar_todos_doctores();
                                                break;
                                            case 2:
                                                hospital.visualizar_derecho_habientes();
                                                break;
                                            
                                            case 3:
                                                hospital.visualizar_todos_pacientes();
                                                break;

                                            case 4:
                                                hospital.visualizar_citas_hospital(hospital);
                                                break;

                                            case 5:
                                                eleccion_admin = 5;
                                                break;

                                            default:
                                                break;
                                        }
                                    }
                                } else {
                                    System.out.println("\nUsuario y/o contraseña INCORRECTA, pruebe de nuevo");
                                }
                            }
                            catch (Exception e) {
                                System.out.println("Ha habido un error al capturar la contraseña...");
                                e.printStackTrace();
                            }

                            break;

                        //caso para salir del sistema
                        case 4:
                            eleccion_exterior = 4;
                            break;
                        
                        //Caso default 
                        default:
                            System.out.println("Intentaste acceder a algo incorrecto, prueba de nuevo");
                            break;
                    }
            }
        }
    
    }
}