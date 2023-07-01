package Acceso;

import java.sql.Connection;

public class Acceso {

    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Se conecto correctamente a la Base de Datos BookHive");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}