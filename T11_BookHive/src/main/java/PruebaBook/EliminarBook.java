package PruebaBook;

import Maestros.CrudBook;

public class EliminarBook {
    public static void main(String[] args) {
        try {
            // Datos
            String id = "11";
            // Proceso
            CrudBook book = new CrudBook();
            book.delete(id);
            System.out.println("Registro eliminado.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
