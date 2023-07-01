package PruebaBook;

import Maestros.CrudBook;
import Modelos.ModeloBook;

public class AgregarDatosBook {

    public static void main(String[] args) {
        try {
            // Datos
            ModeloBook bean = new ModeloBook(11, "El código Da Vinci", "Dan Brown", "Un emocionante thriller de misterio y conspiraciones", 5, "A");
            // Proceso
            CrudBook book = new CrudBook();
            book.insert(bean);
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

