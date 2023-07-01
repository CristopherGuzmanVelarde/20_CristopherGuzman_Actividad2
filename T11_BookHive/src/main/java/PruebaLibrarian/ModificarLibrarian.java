package PruebaLibrarian;

import java.util.List;

import Maestros.CrudLibrarian;
import Modelos.ModeloLibrarian;

public class ModificarLibrarian {
    public static void main(String[] args) {
        try {
            // Datos
            ModeloLibrarian bean = new ModeloLibrarian();
            bean.setFirst_name("b");
            
            // Proceso
            CrudLibrarian crudLibrarian = new CrudLibrarian();
            List<ModeloLibrarian> listaLibrarian = crudLibrarian.get(bean);
            
            if (listaLibrarian != null) {
                for (ModeloLibrarian librarian : listaLibrarian) {
                    System.out.println(librarian);
                }
            } else {
                System.out.println("La lista de bibliotecarios es nula.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

