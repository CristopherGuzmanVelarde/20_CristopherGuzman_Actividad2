package PruebaPersona;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class ModificarPerson {
	public static void main(String[] args) {
		try {
			// Datos
			ModeloPerson bean = new ModeloPerson(10, "godoy","pro","87768950","2", "c", "A", "E", "984843217");
			// Proceso
			CrudPerson sucursal = new CrudPerson();
			sucursal.update(bean);
			System.out.println(bean);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
