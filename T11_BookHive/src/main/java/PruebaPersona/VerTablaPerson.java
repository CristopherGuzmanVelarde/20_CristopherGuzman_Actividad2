package PruebaPersona;

import java.util.List;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class VerTablaPerson {
    public static void main(String[] args) {
        try {
            CrudPerson persona = new CrudPerson();
            List<ModeloPerson> lista = persona.getAll();
            displayTable(lista);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static void displayTable(List<ModeloPerson> lista) {
        System.out.println("--------------------------------------------------");
        System.out.printf("| %-3s | %-20s | %-20s | %-15s |\n",
                "ID", "Nombre", "Apellido", "Documento");
        System.out.println("--------------------------------------------------");
        
        for (ModeloPerson modeloPerson : lista) {
            System.out.printf("| %-3s | %-20s | %-20s | %-15s |\n",
                    modeloPerson.getId(), modeloPerson.getFirst_name(), modeloPerson.getLast_name(),
                    modeloPerson.getIdentity_document());
        }
        
        System.out.println("--------------------------------------------------");
    }
}
