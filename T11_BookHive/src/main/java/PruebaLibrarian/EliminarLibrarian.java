package PruebaLibrarian;

import Maestros.CrudLibrarian;

public class EliminarLibrarian {
    public static void main(String[] args) {
        try {
            // Datos
            int id = 11;
            // Proceso
            CrudLibrarian librarian = new CrudLibrarian();
            librarian.delete(id);
            System.out.println("Registro eliminado.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
