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
    private List <Cita> lista_citas_hospital;
    private Farmacia farmacia_hospital;
    
    //Constructor:
    public Hospital(String nombre_hospital, String direccion_hospital){
        this.nombre_hospital = nombre_hospital;
        this.direccion_hospital = direccion_hospital;
        this.lista_doctores = new ArrayList<>();
        this.lista_pacientes = new ArrayList<>();
        this.lista_derecho_habientes = new ArrayList<>();
        this.lista_citas_hospital = new ArrayList<>();
    }

    //getters y setters para los atributos
    public String getNombre_hospital(){
        return nombre_hospital;
    }

    public String getDireccion_hospital(){
        return direccion_hospital;
    }

    public List <Doctor> getLista_Doctores(){
        return lista_doctores;
    }

    public List <Paciente> getLista_Pacientes(){
        return lista_pacientes;
    }

    public List <Paciente> getLista_derecho_habientes(){
        return lista_derecho_habientes;
    }
    
    public List <Cita> getLista_citas_hospital(){
        return lista_citas_hospital;
    }

    public Farmacia getFarmacia(){
        return farmacia_hospital;
    }

    public void setNombre_hospital(String nombre_hospital){
        this.nombre_hospital = nombre_hospital;
    }

    public void setDireccion_hospital(String direccion_hospital){
        this.direccion_hospital = direccion_hospital;
    }

    public void setLista_Doctores(List lista_doctores){
        this.lista_doctores = lista_doctores;
    }

    public void setLista_pacientes(List lista_pacientes){
        this.lista_pacientes = lista_pacientes;
    }

    public void setlista_derecho_habientes(List lista_derecho_habientes){
        this.lista_derecho_habientes = lista_derecho_habientes;
    }

    public void setLista_citas_hospital(List lista_citas_hospital){
        this.lista_citas_hospital = lista_citas_hospital;
    }


    //Metodos para agregar personas a las listas:

    //metodo para agregar un doctor a la lista de doctores DEL HOSPITAL
    public void agregar_doctor(Doctor nuevo_doctor){
        lista_doctores.add(nuevo_doctor);
    }

    //Agregar un paciente, a la lista de Pacientes DEL HOSPITAL
    public void agregar_paciente(Paciente nuevo_paciente){
        lista_pacientes.add(nuevo_paciente);
    }

    //Agregar un paciente, Declarado como instancia paciente, a la lista de derecho habientes DEL HOSPITAL
    public void agregar_derecho_habiente(Paciente nuevo_derecho_habiente){
        lista_derecho_habientes.add(nuevo_derecho_habiente);
    }

    //Agregar una cita a la lista de citas del HOSPITAL
    public void agregar_cita(Cita nueva_cita){
        lista_citas_hospital.add(nueva_cita);
    }

    //Eliminar cita:
    public void eliminar_cita(Cita nueva_cita){
        lista_citas_hospital.remove(nueva_cita);
    }

    //METODOS PARA LA SELECCION
    //Seleccionar un doctor
    public Doctor seleccionar_doctor_especifico(int i){
        return lista_doctores.get(i);
    }
    
    //Seleccionar un derecho-habientes
    public Paciente seleccion_derecho_habiente(int i, Scanner sc){
        List<Paciente> lista_derecho_habientes = this.getLista_derecho_habientes();
        //Primero pedimos las credenciales de dicha persona:
        try {
            Paciente paciente_seleccionado = lista_derecho_habientes.get(i-1);
            long user_NSS; String password_NSS;
            //Pidiendo usuario
            System.out.print("Ingresa tu NSS: ");
            user_NSS = sc.nextLong();
            System.out.print("Ingresa tu contraseña: ");
            password_NSS = sc.nextLine();
            
            if(paciente_seleccionado.getNumero_seguro_social() == user_NSS && paciente_seleccionado.getPassword_seguro_social().equals(password_NSS)){
                return lista_derecho_habientes.get(i-1);
            }
            else{
                System.out.println("Numero de Seguro social o contraseña equivocados");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al capturar la contraseña...");
            e.printStackTrace();
            return null;
        }
    }
    
    //METODOS PARA LA VISUALIZACION
    //Metodo visualizar doctores, ya empleando metodo sobreescrito imprimir detalles
    public void visualizar_todos_doctores(){
        System.out.println("\nLista de doctores:");
        for(int i = 0; i < lista_doctores.size(); i++){
            System.out.println("Doctor [" + (i+1) + "]");
            //Aprovechamos la sobreescritura, y polimorfismo haciendo uso del metodo de la clase abstracta, y el como se reeuso para el doctor
            lista_doctores.get(i).imprimir_detalles();
            System.out.println();
        }
    }

    //Visualizar todos los pacientes en el hospital:
    public void visualizar_todos_pacientes(){
        if(lista_pacientes.size() > 0){
            System.out.println("Lista de pacientes en el hospital:");
            for(int i = 0; i < lista_pacientes.size(); i++){
                //Mostrando el nombre del pacienteaciente:
                System.out.print("\nPaciente: " + lista_pacientes.get(i).getNombre_persona());
                //Cita agendada por el paciente:
                List <Cita> cita_agendada_paciente = lista_pacientes.get(i).getCitas_agendadas();
                //Iterando por las citas del paciente
                for(int j = 0; j < cita_agendada_paciente.size(); j++){
                    //Iterando por la lista de citas mostrando detalles de cada una
                    cita_agendada_paciente.get(j).visualizar_cita(lista_doctores);
                }
            }
        }
        else{
            System.out.println("\nNO HAY NINGUN PACIENTE REGISTRADO");
        }
    }

    //Visualizar citas agendadas
    public void visualizar_cita_agendada_paciente(Paciente paciente_activo){
        if (paciente_activo.getCitas_agendadas().size() > 0){
            System.out.println("\nPaciente: " + paciente_activo.getNombre_persona());
            List <Cita> cita_agendada_paciente = paciente_activo.getCitas_agendadas();
            for(int j = 0; j < cita_agendada_paciente.size(); j++){
                System.out.print("Cita [" + (j+1) + "]");
                cita_agendada_paciente.get(j).visualizar_cita(lista_doctores);
            }
        }
        else{
            System.out.println(paciente_activo.getNombre_persona() + " no tiene citas agendadas!");
        }
    }

    //Visualizar todas las citas del hospital:
    public void visualizar_citas_hospital(Hospital hospital){
        if (lista_citas_hospital.size() > 0) {
            for(int j = 0; j < lista_citas_hospital.size(); j++){
                lista_citas_hospital.get(j).visualizar_cita(lista_doctores);
            }
        }
        else{
            System.out.println("\nNO EXISTEN CITAS AGENDADAS");
        }
    }

    //Derecho habientes, utilizando metodo imprimir detalles:
    public void visualizar_derecho_habientes(){
        if (lista_derecho_habientes.size() > 0) {
            System.out.println("Lista de derecho habientes en el hospital:");
            for(int i = 0; i < lista_derecho_habientes.size(); i++){
                System.out.println("\nDerecho habiente [" + (i+1) + "]");
                lista_derecho_habientes.get(i).imprimir_detalles();
            }
        }
        else{
            System.out.println("\nNO EXISTE NINGUN DERECHO-HABIENTE REGISTRADO EN EL HOSPITAL");
        }
    }

    //METODOS PARA LA CREACION DE INSTANCIAS
    //Metodo agregar un derecho habiente
    public Paciente agregar_derecho_habiente(Scanner sc){
        
        System.out.println("\nRegistrando una nueva persona:");
        
        // 1. Datos String (usando nextLine())
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombre = sc.nextLine();
        
        System.out.print("Ingrese la dirección: ");
        String direccion = sc.nextLine();
        
        System.out.print("Ingrese el CURP: ");
        String curp = sc.nextLine();
        
        long nss = (long)(0);

        while (nss == 0) {
        System.out.print("Ingrese el Número de Seguro Social (NSS): ");
        try {
            nss = sc.nextLong();
            sc.nextLine();
            
            if (nss <= 0) {
                System.out.println("Error: El NSS debe ser un número positivo.");
                nss = (long) 0;
            }
            
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un NSS correcto (solo números).");
            sc.nextLine(); //Limpiar el buffer
            nss = (long)(0);
        }
        }

        System.out.print("Ingrese la contraseña, para acceder a su sistema de Seguro Social: ");
        String password = sc.nextLine();

        //Falta agregar que el usuario pueda tener su contraseña
        
        //Datos numéricos (usando nextInt() con manejo de errores)
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

        long telefono = 0;
        while (telefono == 0) {
            System.out.print("Ingrese el número de teléfono: ");
            try {
                telefono = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número de teléfono correcto.");
                sc.nextLine(); // Limpiar buffer
            }
        }
        
        // 3. Crear el objeto Paciente con todos los datos
        Paciente nuevo_derecho_habiente = new Paciente(nombre, direccion, edad, telefono, curp, nss, password);
        
        //QUIERO AGREGAR FUNCIONALIDAD DE PODER CREAR UNA CONTRASEÑA PARA EL DERECHO HABIENTE Y ASI PODER INGRESAR A SU CUENTA
        
        
        System.out.println("\nDerecho Habiente " + nombre + " registrado con éxito.");
        return nuevo_derecho_habiente;
    }

    //METODOS PARA LAS CITAS:
    //Metodo agendar una cita:
    public Cita agendar_cita(Paciente paciente, Scanner scanner) {
        //Mostrar Doctores y Seleccionar uno
        visualizar_todos_doctores();
        
        int doctorIndex = -1;
        Doctor doctorSeleccionado = null;
        
        while (doctorSeleccionado == null) {
            System.out.print("\nIngrese el número (Opción) del doctor que desea seleccionar: ");
            try {
                doctorIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consumir el salto de línea
                
                doctorSeleccionado = seleccionar_doctor_especifico(doctorIndex);
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número para seleccionar al doctor.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        System.out.println("\nDoctor seleccionado: " + doctorSeleccionado.getNombre_persona());
        
        //Solicitar Fecha
        LocalDate fechaCita = null;
        while (fechaCita == null) {
            System.out.println("\nSelecciona la Fecha de la Cita");
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
        
        //Solicitar Hora
        LocalTime horaCita = null;
        while (horaCita == null) {
            System.out.println("\nSelecciona la Hora de la Cita");
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
        
        //Solicitar Motivo
        System.out.print("\nIngrese el motivo de la cita: ");
        String motivo = scanner.nextLine();
        
        //Crear la Cita
        //Aquí usamos el índice del doctor que el usuario selecciono
        Cita nueva_cita = new Cita(doctorIndex, paciente, fechaCita, horaCita, motivo);
        return nueva_cita;
    }

    //Metodo para modificar una cita:
    public Cita modificar_cita(Cita nueva_cita, Scanner scanner) {
        //Mostrar Doctores y Seleccionar uno
        visualizar_todos_doctores();
        
        int doctorIndex = -1;
        Doctor doctorSeleccionado = null;
        
        //Guardando el doctor a utlizar, mediante index
        while (doctorSeleccionado == null) {
            System.out.print("\nIngrese el número, Opción, del doctor al que desea cambiar/mantener: ");
            try {
                doctorIndex = scanner.nextInt() - 1;
                //Consumir el salto de línea
                scanner.nextLine();
                
                doctorSeleccionado = seleccionar_doctor_especifico(doctorIndex);
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número para seleccionar al doctor.");
                //Limpiar el buffer
                scanner.nextLine();
            }
        }

        System.out.println("\nDoctor seleccionado: " + doctorSeleccionado.getNombre_persona());
        
        //Solicitar Fecha y guardandola
        LocalDate fechaCita = null;
        while (fechaCita == null) {
            System.out.println("\nSelecciona la Fecha de la Cita");
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
        
        //Solicitar Hora
        LocalTime horaCita = null;
        while (horaCita == null) {
            System.out.println("\nSeleccione la Hora de la Cita");
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
        
        //Solicitar Motivo
        System.out.print("\nIngrese el motivo de la cita: ");
        String motivo = null;
        try {
            motivo = scanner.nextLine();
        } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números para la hora.");
                scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            scanner.nextLine();
        }
        
        // 5. Crear la Cita
        // Aquí usamos el índice del doctor que el usuario seleccionó (doctorIndex)
        Cita cita_modificada = new Cita(doctorIndex, nueva_cita.getPaciente_agendado(), fechaCita, horaCita, motivo);
        return cita_modificada;
    }
}