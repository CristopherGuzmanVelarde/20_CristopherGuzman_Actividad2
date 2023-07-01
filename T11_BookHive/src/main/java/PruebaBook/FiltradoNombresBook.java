package PruebaBook;

import java.util.List;

import Maestros.CrudBook;
import Modelos.ModeloBook;

public class FiltradoNombresBook {
    public static void main(String[] args) {
        try {
            // Datos
            ModeloBook bean = new ModeloBook();
            bean.setNames("b");
            
            // Proceso
            CrudBook crudBook = new CrudBook();
            List<ModeloBook> listaLibros = crudBook.get(bean);
            
            if (listaLibros != null) {
                for (ModeloBook libro : listaLibros) {
                    System.out.println(libro);
                }
            } else {
                System.out.println("La lista de libros es nula.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
