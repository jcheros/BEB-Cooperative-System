package com.beb.cooperative.repository;

import com.beb.cooperative.model.Transaccion;
import com.beb.cooperative.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransaccionRepository {
    public void save(Transaccion transaccion) {
        String sql = "INSERT INTO transaccion (monto, tipo, fecha, cuenta_id) VALUES (?, ?, ?, ?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setBigDecimal(1, transaccion.getMonto());
            pstmt.setString(2, transaccion.getTipo());
            pstmt.setTimestamp(3, Timestamp.valueOf(transaccion.getFecha()));
            pstmt.setInt(4, transaccion.getCuentaId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar transacción: " + e.getMessage());
        }
    }

    public List<Transaccion> findByCuentaId(int cuentaId) {
        String sql = "SELECT * FROM transaccion WHERE cuenta_id = ?";
        List<Transaccion> transacciones = new ArrayList<>();
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, cuentaId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transacciones.add(new Transaccion(
                    rs.getInt("id"),
                    rs.getBigDecimal("monto"),
                    rs.getString("tipo"),
                    rs.getTimestamp("fecha").toLocalDateTime(),
                    rs.getInt("cuenta_id")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar transacciones: " + e.getMessage());
        }
        return transacciones;
    }
    
    public List<Transaccion> findByClienteAndDate(int clienteId, LocalDate fechaInicio, LocalDate fechaFin) {
        //TODO: Implementar búsqueda de transacciones con filtro de cliente y rango de fechas
        return Collections.EMPTY_LIST;
    }
}
