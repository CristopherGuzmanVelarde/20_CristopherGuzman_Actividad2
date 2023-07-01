package PruebaPersona;

import java.util.List;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class FiltradoNombresPerson {
    public static void main(String[] args) {
        try {
            // Datos
            ModeloPerson bean = new ModeloPerson();
            bean.setFirst_name("b");
            
            // Proceso
            CrudPerson crudPerson = new CrudPerson();
            List<ModeloPerson> listaPerson = crudPerson.get(bean);
            
            if (listaPerson != null) {
                for (ModeloPerson person : listaPerson) {
                    System.out.println(person);
                }
            } else {
                System.out.println("La lista de personas es nula.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
