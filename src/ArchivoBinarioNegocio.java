/*
Práctica 3.1. Tienda
18/04/2021  
Vivar Olvera Marco Antonio
201958239
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.time.LocalDate;


public class ArchivoBinarioNegocio{
    //atributo
    private String nomArchivo;
    //metodo constructor
    public ArchivoBinarioNegocio(String nomArchivo){
        this.nomArchivo=nomArchivo;
    }
    //metodo para reescribir los Productos
    public boolean reescribirArchivo(ArrayList<Producto> listProduc){
        DataOutputStream salida;
        if (listProduc != null) {
        try{
            salida=new DataOutputStream(new FileOutputStream(nomArchivo)); 
        }
        catch(IOException e){
            return false;
            //System.exit(1);
        }
        ListIterator<Producto> listaIterador=listProduc.listIterator(0);
        
        Producto p;
        LocalDate f;
        while (listaIterador.hasNext()) {
           p=listaIterador.next();
           try{
                salida.writeUTF(p.getNombre());
                salida.writeDouble(p.getPrecio());
                salida.writeInt(p.getPorcentaje());
                if (p instanceof Perecedero) {
                    f=((Perecedero)p).getFechaCaducidad();
                    //algunos metodos de LocalDate
                    salida.writeInt(f.getDayOfMonth());
                    salida.writeInt(f.getMonthValue());
                    salida.writeInt(f.getYear());
                } else {
                    salida.writeInt(0);
                    salida.writeInt(0);
                    salida.writeInt(0);
                }
                salida.flush();
            }
            catch(IOException e){return false;}
        }
        try {
            salida.close();
        }
        catch(IOException e){return false;}
        return true;
        }
        return false;
    }


    public ArrayList<Producto> leerArchivo(){
        DataInputStream entrada;
        ArrayList<Producto> listProduc=new ArrayList<Producto>();
        try{
            entrada=new DataInputStream(new FileInputStream(nomArchivo));
        }
        catch(IOException e){
            return null;
        }

        String nom;
        Double pre;
        int porc, d, m, a;
        while(true){
            try{
                nom=entrada.readUTF();
                pre=entrada.readDouble();
                porc=entrada.readInt();
                d=entrada.readInt();
                m=entrada.readInt();
                a=entrada.readInt();
            }
            catch(IOException e){
                break;
            }
            if(d==0){
                listProduc.add(new NoPerecedero(nom, pre, porc));
            }
            else{
                listProduc.add(new Perecedero(nom, pre, porc, LocalDate.of(a,m,d)));
            }
        }
        try {
            entrada.close();
        } 
        catch (IOException e) {
            return null;
        }
        return listProduc;
    }
    
}