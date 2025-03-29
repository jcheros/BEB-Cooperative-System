package com.beb.cooperative.repository;

import com.beb.cooperative.model.Asesor;
import com.beb.cooperative.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsesorRepository {
    public List<Asesor> findAll() {
        String sql = "SELECT * FROM asesor";
        List<Asesor> asesores = new ArrayList<>();
        try (
                Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            while (rs.next()) {
                asesores.add(new Asesor(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("especializacion")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar asesores: " + e.getMessage());
        }
        return asesores;
    }
}
