package com.beb.cooperative.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection = null;

    // Constructor privado para evitar instancias
    private DatabaseConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Cargar driver y parámetros desde Config
                Class.forName(Config.getDriver());
                connection = DriverManager.getConnection(
                    Config.getDbUrl(),
                    Config.getDbUser(),
                    Config.getDbPassword()
                );
                System.out.println("Conexión exitosa a Oracle");
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Error conectando a la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.err.println("Error cerrando conexión: " + e.getMessage());
            }
        }
    }
}
