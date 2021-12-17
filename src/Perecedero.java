/*
Práctica 3.1. Tienda
18/04/2021  
Vivar Olvera Marco Antonio
201958239
*/

import java.time.LocalDate;


public class Perecedero extends Producto {
    //atributo
    private LocalDate fechaCaducidad;
    
    //metodo constructor
    public Perecedero(String n, double pre, int porc, LocalDate f) {
        super(n, pre, porc);
        fechaCaducidad=f;
    }
    public LocalDate getFechaCaducidad(){
        return fechaCaducidad;
    }
    
}
