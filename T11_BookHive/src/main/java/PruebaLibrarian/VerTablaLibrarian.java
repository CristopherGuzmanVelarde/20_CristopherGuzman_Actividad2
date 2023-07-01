package PruebaLibrarian;

import java.util.List;

import Maestros.CrudLibrarian;
import Modelos.ModeloLibrarian;

public class VerTablaLibrarian {
    public static void main(String[] args) {
        try {
            CrudLibrarian librarian = new CrudLibrarian();
            List<ModeloLibrarian> lista = librarian.getAll();
            // Imprimir encabezados de la tabla
            System.out.println("ID\t\tFirst Name\tLast Name\tIdentity Document\tCellphone\tStates");
            System.out.println("-------------------------------------------------------------------------------");
            // Imprimir cada registro en formato de tabla
            for (ModeloLibrarian modeloLibrarian : lista) {
                System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
                        modeloLibrarian.getId(),
                        modeloLibrarian.getFirst_name(),
                        modeloLibrarian.getLast_name(),
                        modeloLibrarian.getIdentity_document(),
                        modeloLibrarian.getCellphone_librarian(),
                        modeloLibrarian.getStates());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}