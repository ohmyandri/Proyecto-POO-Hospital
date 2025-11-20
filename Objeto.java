public abstract class Objeto {
    protected String nombre_objeto;

    Objeto(String nombre_objeto){
        this.nombre_objeto = nombre_objeto;
    }

    public String getNombre_objeto(){
        return this.nombre_objeto;
    }
    
    //Ver nombre del objeto
    public void ver_detalles_objeto(){
    }

}
