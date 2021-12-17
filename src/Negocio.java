

import java.util.ArrayList;

public class Negocio {
    //atributos
    public ArrayList<Producto> productos=new ArrayList<Producto>();
    private ArrayList<Double> ganancias = new ArrayList<Double>();
    //metodo constructor
    public Negocio(){

    }
    //metodos
    public void altaProducto(Producto p){
        productos.add(p);
    }
    
    public boolean bajaProducto(String nombre){
        //validamos que el array list tenga elementos
        if(productos == null || productos.size() == 0){
            // el arraylist no tiene elementos
            return false;
        }
        else{
            // el arraylist tiene elementos
            for(int i=0;i<productos.size();i++){
                if(nombre.equals(productos.get(i).getNombre())){
                    productos.remove(i);
                    return true;
                }
            }
            return false;
        }  
    }
    
    public ArrayList<Producto> listarPerecederos(){
        ArrayList<Producto> aux=new ArrayList<Producto>();
        //validamos que el array list tenga elementos
        if(productos == null || productos.size() == 0){
            // el arraylist no tiene elementos
            return null;
        }
        else{
            // el arraylist tiene elementos
            for(int i=0;i<productos.size();i++){
                //verificamos que un producto es instanciado se Perecedero
                if(productos.get(i) instanceof Perecedero){
                    aux.add(productos.get(i));
                }
            }
        }  
        return aux;
    }
    
    public ArrayList<Producto> listarNoPerecederos(){
        ArrayList<Producto> aux=new ArrayList<Producto>();
        //validamos que el array list tenga elementos
        if(productos == null || productos.size() == 0){
            // el arraylist no tiene elementos
            return null;
        }
        else{
            // el arraylist tiene elementos
            for(int i=0;i<productos.size();i++){
                //verificamos que un producto es instanciado se Perecedero
                if(productos.get(i) instanceof NoPerecedero){
                    aux.add(productos.get(i));
                }
            }
        }  
        return aux;
    }

    public double ventaDeProducto(String nombre){
        double precio=0;
        double ganancia;
        double porcent;
        //validamos que hayan productos
        if(productos == null || productos.size() == 0){
            // el arraylist no tiene elementos, se retorna precio=0
            return precio;
        }
        else{
            // el arraylist tiene elementos
            for(int i=0;i<productos.size();i++){
                if(nombre.equals(productos.get(i).getNombre())){
                    precio=productos.get(i).getPrecio();
                    //sacaremos el promedio de la venta
                    porcent=productos.get(i).getPorcentaje()*precio;
                    ganancia=porcent/100;
                    ganancias.add(ganancia);
                    //se elimina el producto del array list ya que se vendio
                    productos.remove(i);
                    return precio;
                }
            }
            return precio;
        }
    }

    public ArrayList<Double> gananciasDelDia(){
        return ganancias;
    }
    
    
    
    
}






