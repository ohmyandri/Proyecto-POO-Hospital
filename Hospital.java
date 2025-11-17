import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Hospital {
    private String nombre_hospital;
    private String direccion_hospital;
    private List <Doctor> lista_doctores;
    private List <Paciente> lista_pacientes;
    private List <Paciente> lista_derecho_habientes;
    
    //Constructor:
    public Hospital(String nombre_hospital, String direccion_hospital){
        this.nombre_hospital = nombre_hospital;
        this.direccion_hospital = direccion_hospital;
        this.lista_doctores = new ArrayList<>();
        this.lista_pacientes = new ArrayList<>();
        this.lista_derecho_habientes = new ArrayList<>();
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
    public void agregar_doctor(Doctor nuevo_doctor){
        lista_doctores.add(nuevo_doctor);
    }

    public void agregar_paciente(Paciente nuevo_paciente){
        lista_pacientes.add(nuevo_paciente);
    }

    public void agregar_derecho_habiente(Paciente nuevo_derecho_habiente){
        lista_derecho_habientes.add(nuevo_derecho_habiente);
    }

    //Metodos para visualizar personas:
    public void visualizar_todos_doctores(){
        System.out.println("\nLista de doctores:");
        for(int i = 0; i < lista_doctores.size(); i++){
            System.out.println("Doctor [" + (i+1) + "]");
            System.out.println("Nombre: " + lista_doctores.get(i).nombre_persona);
            System.out.println("Especialidad: " + lista_doctores.get(i).getEspecialidad_medicina());
            System.out.println("Años de experiencia: " + lista_doctores.get(i).getExperiencia_medicina());
            System.out.println();
        }
    }

    //Seleccionar un doctor en especifico:
    public Doctor doctor_especifico(int i){
        return lista_doctores.get(i);
    }

    //Visualizar todos los pacientes en el hospital:
    public void visualizar_todos_pacientes(){
        System.out.println("Lista de pacientes en el hospital:");
        for(int i = 0; i < lista_pacientes.size(); i++){
            //Paciente:
            System.out.println("Paciente: " + lista_pacientes.get(i).getNombre_persona());
            //Cita agendada por el paciente:
            List <Cita> cita_agendada_paciente = lista_pacientes.get(i).getCitas_agendadas();
            //Iterando por las citas del paciente
            for(int j = 0; j < cita_agendada_paciente.size(); j++){
                //Falta buscar que doctor le atiende:
                //int ind_doctor = cita_agendada_paciente.get;
                cita_agendada_paciente.get(j).visualizar_cita(lista_doctores);
            }
        }
    }

    //Metodos para la creacion de objetos
    public Paciente agregar_derecho_habiente(Scanner sc){
        
        System.out.println("\nRegistrando una nueva persona:");
        
        // 1. Datos String (usando nextLine())
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese la dirección: ");
        String direccion = sc.nextLine();
        
        System.out.print("Ingrese el CURP: ");
        String curp = sc.nextLine();
        
        System.out.print("Ingrese el Número de Seguro Social (NSS): ");
        String nss = sc.nextLine();

        //Falta agregar que el usuario pueda tener su contraseña
        
        // 2. Datos numéricos (usando nextInt() con manejo de errores)
        int edad = -1;
        while (edad < 0 || edad > 120) {
            System.out.print("Ingrese la edad: ");
            try {
                edad = sc.nextInt();
                sc.nextLine(); // Limpiar buffer
                if (edad < 0 || edad > 120) {
                    System.out.println("Error: Edad no válida. Debe estar entre 0 y 120.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número para la edad.");
                sc.nextLine(); // Limpiar buffer
            }
        }

        String telefono = null;
        while (telefono == null) {
            System.out.print("Ingrese el número de teléfono: ");
            try {
                telefono = sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número correcto de el teléfono.");
                sc.nextLine(); // Limpiar buffer
            }
        }
        
        // 3. Crear el objeto Paciente con todos los datos
        Paciente nuevo_derecho_habiente = new Paciente(nombre, direccion, edad, telefono, curp, nss);
        
        //QUIERO AGREGAR FUNCIONALIDAD DE PODER CREAR UNA CONTRASEÑA PARA EL DERECHO HABIENTE Y ASI PODER INGRESAR A SU CUENTA
        
        
        System.out.println("\nDerecho Habiente " + nombre + " registrado con éxito.");
        return nuevo_derecho_habiente;
    }

    public Cita agendar_cita(Paciente paciente, Scanner scanner) {
        // 1. Mostrar Doctores y Seleccionar uno
        visualizar_todos_doctores();
        
        int doctorIndex = -1;
        Doctor doctorSeleccionado = null;
        
        while (doctorSeleccionado == null) {
            System.out.print("\nIngrese el número (Opción) del doctor que desea seleccionar: ");
            try {
                doctorIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consumir el salto de línea
                
                doctorSeleccionado = doctor_especifico(doctorIndex);
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número para seleccionar al doctor.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        System.out.println("\nDoctor seleccionado: " + doctorSeleccionado.getNombre_persona());
        
        // 2. Solicitar Fecha
        LocalDate fechaCita = null;
        while (fechaCita == null) {
            System.out.println("\n--- Seleccione la Fecha de la Cita ---");
            try {
                System.out.print("Ingrese el año (Ej: 2025): ");
                int anio = scanner.nextInt();
                System.out.print("Ingrese el mes (1-12): ");
                int mes = scanner.nextInt();
                System.out.print("Ingrese el día: ");
                int dia = scanner.nextInt();
                scanner.nextLine();
                
                fechaCita = LocalDate.of(anio, mes, dia);
                
                if (fechaCita.isBefore(LocalDate.now())) {
                    System.out.println("Error: No se puede agendar una cita en el pasado.");
                    fechaCita = null;
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números para la fecha.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: La fecha es inválida (ej: 30 de febrero). Intente de nuevo.");
                scanner.nextLine();
            }
        }
        
        // 3. Solicitar Hora
        LocalTime horaCita = null;
        while (horaCita == null) {
            System.out.println("\n--- Seleccione la Hora de la Cita ---");
            try {
                System.out.print("Ingrese la hora (formato 24h, Ej: 14 para 2 PM): ");
                int horaInt = scanner.nextInt();
                System.out.print("Ingrese los minutos (Ej: 00, 30): ");
                int minutoInt = scanner.nextInt();
                scanner.nextLine();
                
                horaCita = LocalTime.of(horaInt, minutoInt);
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números para la hora.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error: La hora es inválida (ej: 25 horas). Intente de nuevo.");
                scanner.nextLine();
            }
        }
        
        // 4. Solicitar Motivo
        System.out.print("\nIngrese el motivo de la cita: ");
        String motivo = scanner.nextLine();
        
        // 5. Crear la Cita
        // Aquí usamos el índice del doctor que el usuario seleccionó (doctorIndex)
        Cita nuevaCita = new Cita(doctorIndex, paciente, fechaCita, horaCita, motivo);
        return nuevaCita;
    }

    //Visualizar citas agendadas
    public void visualizar_cita_agendada_paciente(Paciente paciente_activo){
        System.out.println("Paciente: " + paciente_activo.getNombre_persona());
        List <Cita> cita_agendada_paciente = paciente_activo.getCitas_agendadas();
        for(int j = 0; j < cita_agendada_paciente.size(); j++){
            cita_agendada_paciente.get(j).visualizar_cita(lista_doctores);
        }
    }

    //Derecho habientes metodos:
    public void visualizar_derecho_habientes(){
        if (lista_derecho_habientes.size() > 0) {
            System.out.println("Lista de derecho habientes en el hospital:");
            for(int i = 0; i < lista_derecho_habientes.size(); i++){
                System.out.println("\nDerecho habiente [" + (i+1) + "]");
                System.out.println("Nombre : " + lista_derecho_habientes.get(i).getNombre_persona());
                //System.out.println("Direccion : " + lista_derecho_habientes.get(i).getDireccion());
                System.out.println("Edad : " + lista_derecho_habientes.get(i).getEdad());
                System.out.println("Numero de telefono : " + lista_derecho_habientes.get(i).getNumero_telefono());
                //System.out.println("CURP : " + lista_derecho_habientes.get(i).getCURP());
                //Pienso dejar esto como comentario para usarlo al debuggear la funcionalidad de inicio sesion con NSS como username
                //System.out.println("NSS : " + lista_derecho_habientes.get(i).getNumero_seguro_social());
                System.out.println("N. Citas agendadas : " + lista_derecho_habientes.get(i).getCitas_agendadas().size());
            }
        }
        else{
            System.out.println("No existe ningun derecho habiente registrado en el hospital, por favor ingrese alguno");
        }
    }

    //Seleccionar un derecho-habientes
    public Paciente seleccion_derecho_habiente(int i, Scanner sc){
        //Primero pedimos las credenciales de dicha persona:
        String user_NSS, password_NSS;
        //Pidiendo usuario
        System.out.print("Ingresa tu NSS: ");
        user_NSS = sc.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        password_NSS = sc.nextLine();
        //VerificadorDeUsuarios(user_NSS, password_NSS);
        //Paso i--, ya que se trabaja index 0 based al mostrarlos a todos, por tanto hay que restar
        return lista_derecho_habientes.get(i-1);
    }
}
