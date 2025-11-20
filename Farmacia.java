import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private List <Farmaco> farmacos_disponibles;
    private EncargadaFarmacia encargada;

    Farmacia(EncargadaFarmacia encargada){
        this.encargada =encargada;
        //Iniciamos tambien la lista de farmacos como una ya definida
        this.farmacos_disponibles = new ArrayList<>();
        inicializarInventario();
    }

    //iniciando la farmacia
    private void inicializarInventario() {
        this.farmacos_disponibles.add(new Farmaco("Paracetamol", 45.00, "500mg", 300, 20));
        this.farmacos_disponibles.add(new Farmaco("Amoxicilina", 98.50, "500mg", 120, 45));
        this.farmacos_disponibles.add(new Farmaco("Ibuprofeno", 381.46, "600mg", 25, 20));
        this.farmacos_disponibles.add(new Farmaco("Diazepam", 150.00, "10mg", 50, 65));
        this.farmacos_disponibles.add(new Farmaco("Morfina", 550.90, "10mg/mL", 15, 250));
        this.farmacos_disponibles.add(new Farmaco("Clonazepam", 210.00, "2mg", 75, 90));
    }

    public EncargadaFarmacia getEncargadaFarmacia(){
        return this.encargada;
    }

    public List <Farmaco> getFarmacos_disponibles(){
        return farmacos_disponibles;
    }
}
