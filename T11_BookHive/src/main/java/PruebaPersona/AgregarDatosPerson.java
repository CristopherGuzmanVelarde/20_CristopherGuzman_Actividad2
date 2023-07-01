package PruebaPersona;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class AgregarDatosPerson {

    public static void main(String[] args) {
        try {
            // Datos
            ModeloPerson bean = new ModeloPerson(11, "frank", "gallo", "88767656","1", "b", "A", "E", "987654321");
            // Proceso
            CrudPerson Person = new CrudPerson();
            Person.insert(bean);
            System.out.println(bean);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
