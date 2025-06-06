package com.dam.model.dao;

import com.dam.model.db.DatabaseConnection;
import com.dam.model.db.LoanContract;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {
    
    public List<Prestamo> obtenerTodosLosPrestamos() {
        List<Prestamo> prestamos = new ArrayList<>();
        String query = "SELECT * FROM " + LoanContract.TABLE_NAME;
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Prestamo prestamo = new Prestamo(
                    rs.getInt(LoanContract.COL_ID),
                    rs.getDouble(LoanContract.COL_PRINCIPAL),
                    rs.getDate(LoanContract.COL_FECHA_DESEMBOLSO),
                    rs.getDate(LoanContract.COL_FECHA_VENCIMIENTO),
                    rs.getString(LoanContract.COL_TIPO_INTERES),
                    rs.getDouble(LoanContract.COL_TASA_INTERES),
                    rs.getString(LoanContract.COL_FRECUENCIA_PAGO),
                    rs.getInt(LoanContract.COL_NUM_CUOTAS),
                    rs.getDouble(LoanContract.COL_CUOTA),
                    rs.getString(LoanContract.COL_TIPO_PRESTAMO),
                    rs.getString(LoanContract.COL_ESTADO)
                );
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }
}