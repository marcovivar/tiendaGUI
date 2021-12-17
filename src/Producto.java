/*
Práctica 3.1. Tienda
18/04/2021  
Vivar Olvera Marco Antonio
201958239
*/


public abstract class Producto {
    
    //atributos
    private String nombre;
    private double precio;
    private int porcentaje;
    
    //metodo constructor
    public Producto(String n, double pr, int por ){
        nombre=n;
        precio=pr;
        porcentaje=por;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
