package PruebaPersona;

import Maestros.CrudPerson;

public class EliminarPerson {
	public static void main(String[] args) {
		try {
			// Datos
			String id = "11";
			// Proceso
			CrudPerson sucursal = new CrudPerson();
			sucursal.delete(id);
			System.out.println("Registro eliminado.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
