package PruebaBook;

import java.util.List;

import Maestros.CrudBook;
import Modelos.ModeloBook;

public class VerTablaBook {
    public static void main(String[] args) {
        try {
            CrudBook book = new CrudBook();
            List<ModeloBook> lista = book.getAll();
            displayTable(lista);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static void displayTable(List<ModeloBook> lista) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("| %-3s | %-25s | %-25s | %-45s | %-8s |\n",
                "ID", "Título", "Autor", "Descripción", "Cantidad");
        System.out.println("------------------------------------------------------------");
        
        for (ModeloBook modeloBook : lista) {
            System.out.printf("| %-3s | %-25s | %-25s | %-45s | %-8s |\n",
                    modeloBook.getId(), modeloBook.getNames(), modeloBook.getAuthor(),
                    modeloBook.getDescriptions(), modeloBook.getQuantity());
        }
        
        System.out.println("------------------------------------------------------------");
    }
}


