package co.edu.utp.misiontic2022.c2;

import co.edu.utp.misiontic2022.c2.model.Employees;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        /*
        String url = "jdbc:sqlite:grupo09.db";
        Connection conn = null;
        ResultSet resultSet = null;


        try {
            conn = DriverManager.getConnection(url);
            File file = new File("grupo09.db");
            if (file.length() == 0) {
                var statement = conn.createStatement();
                statement.execute("CREATE TABLE paises(pais_id INTEGER PRIMARY KEY ,nombre VARCHAR(50)NOT NULL );");
                statement.execute("CREATE TABLE dpto(dpto_id INTEGER PRIMARY KEY ,nombre VARCHAR(50)NOT NULL );");
            }

        } catch (SQLException e) {
            System.out.println("ErrorDB" + e);
        }*/

        String db = "C://Users/andia/Documents/MinTic/Ciclo 2-Programación Básica grupo 09/db_sqlite/hr.db";
        String url = "jdbc:sqlite:" + db;

        Connection conn = null;
        ResultSet resultSet = null;
        Statement stmt = null;
        var listaEmployees = new ArrayList<Employees>();

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            var sql = "SELECT employee_id,first_name,last_name,email " +
                    "FROM employees WHERE employee_id < 110 ;";
            resultSet = stmt.executeQuery(sql);
            while (resultSet.next()) {

                var employees = new Employees();

                int id = resultSet.getInt("employee_id");
                String nombre = resultSet.getString("first_name");
                String apellido = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                //System.out.println("ID:"+id+" - Nombre:"+nombre+" - Apellido:"+apellido+" - Email:"+email);

                employees.setEmployee_id(id);
                employees.setFirst_name(nombre);
                employees.setLast_name(apellido);
                employees.setEmail(email);

                listaEmployees.add(employees);

            }

        } catch (SQLException e) {
            System.out.println("ErrorDB" + e);
        } finally {
            try {

                if (resultSet != null) {
                    resultSet.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                System.out.println("Error Conexion Close!" + e);
            }

        }
/*
        for (Employees se : listaEmployees ) {
            System.out.println(se);

        }
  */
        listaEmployees.forEach(System.out::println);
    }
}
