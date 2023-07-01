package PruebaLibrarian;

import Maestros.CrudLibrarian;
import Modelos.ModeloLibrarian;

public class AgregarDatosLibrarian {

    public static void main(String[] args) {
        try {
            // Datos
            ModeloLibrarian bean = new ModeloLibrarian(4, "57824639", "Hector", "López", "981857321", "A");
            // Proceso
            CrudLibrarian librarian = new CrudLibrarian();
            librarian.insert(bean);
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
