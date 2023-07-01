package PruebaPersona;

import Maestros.CrudPerson;
import Modelos.ModeloPerson;

public class FiltradoPerson {

		public static void main(String[] args) {
			try {
				CrudPerson estudiante = new CrudPerson();
				ModeloPerson bean = estudiante.getForId("5");
				System.out.println(bean);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
