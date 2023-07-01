package PruebaLibrarian;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class FiltradoLibrarian {

    public static void main(String[] args) {
        try {
            CrudPerson librarian = new CrudPerson();
            ModeloPerson bean = librarian.getForId("5");
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
