public class Farmaco extends Objeto{
    private double precio;
    private String concentracion;
    private int stock_disponible;
    private int tabletas;

    //Constructor
    Farmaco(String nombre, double precio, String concentracion, int stock_disponible, int tabletas){
        super(nombre);
        this.precio = precio;
        this.concentracion = concentracion;
        this.stock_disponible = stock_disponible;
        this.tabletas = tabletas;
    }

    public double getPrecio(){
        return this.precio;
    }

    public String getConcentracion(){
        return this.concentracion;
    }

    public int getStock_disponible(){
        return this.stock_disponible;
    }

    public int getTabletas(){
        return this.tabletas;
    }

    public void setStock_disponible(int stock_disponible){
        this.stock_disponible = stock_disponible;
    }
    
    @Override
    public void ver_detalles_objeto(){
        System.out.println("Medicina: " + getNombre_objeto());
        System.out.println("Precio: " + getPrecio());
        System.out.println("Concentracion: " + getConcentracion());
        System.out.println("Cantidad de tabletas por caja: " + getTabletas());
        System.out.println("Stock disponible: " + getStock_disponible());
    }

    
}