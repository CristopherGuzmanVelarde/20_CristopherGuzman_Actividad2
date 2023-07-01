package PruebaBook;

import Maestros.CrudBook;
import Modelos.ModeloBook;

public class ModificarBook {
    public static void main(String[] args) {
        try {
            // Datos
            ModeloBook bean = new ModeloBook(10, "El Principito", "Antoine de Saint-Exupéry", "Un cuento filosófico sobre la amistad y la vida", 6, "A");
            // Proceso
            CrudBook libro = new CrudBook();
            libro.update(bean);
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

