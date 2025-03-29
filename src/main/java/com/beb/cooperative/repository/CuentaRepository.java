package com.beb.cooperative.repository;

import com.beb.cooperative.model.CuentaAhorro;
import com.beb.cooperative.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaRepository {
    public void saveCuentaAhorro(CuentaAhorro cuenta) {
        String sql = "INSERT INTO cuenta (tipo, saldo, tasa_interes, cliente_id) VALUES ('ahorro', ?, ?, ?)";
        try (
                Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setBigDecimal(1, cuenta.getSaldo());
            pstmt.setBigDecimal(2, cuenta.getTasaInteres());
            pstmt.setInt(3, cuenta.getClienteId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al guardar cuenta de ahorro: " + e.getMessage());
        }
    }

    public CuentaAhorro findCuentaAhorroById(int id) {
        String sql = "SELECT * FROM cuenta WHERE id = ? AND tipo = 'ahorro'";
        CuentaAhorro cuenta = null;
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cuenta = new CuentaAhorro(
                    rs.getInt("id"),
                    rs.getBigDecimal("saldo"),
                    rs.getBigDecimal("tasa_interes"),
                    rs.getInt("cliente_id")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar cuenta de ahorro: " + e.getMessage());
        }
        return cuenta;
    }
    
    public CuentaAhorro actualizarCuenta(CuentaAhorro cuenta) {
        //TODO: Implementar actualización de la entidad
        return cuenta;
    }
}
