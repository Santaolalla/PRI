package com.dam.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PnlPrestamos extends JPanel {
    private JTextField txtPrestamista;
    private JTextField txtCuantia;
    private JTextField txtInteres;
    private JTextField txtTiempo;
    private JComboBox<String> cbUnidadTiempo;
    private JTextField txtAsunto;
    private JComboBox<String> cbFrecuencia;
    private JTextField txtFechaInicio;
    private JButton btnRegistrar;

    public PnlPrestamos() {
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        txtPrestamista = new JTextField(20);
        txtCuantia = new JTextField(10);
        txtInteres = new JTextField(5);
        txtTiempo = new JTextField(5);
        
        cbUnidadTiempo = new JComboBox<>(new String[]{"Días", "Meses", "Años"});
        cbUnidadTiempo.setSelectedIndex(1); // Meses por defecto
        
        txtAsunto = new JTextField(20);
        
        cbFrecuencia = new JComboBox<>(new String[]{
            "Diario", "Semanal", "Quincenal", "Mensual", "Trimestral", "Anual"
        });
        cbFrecuencia.setSelectedIndex(3); // Mensual por defecto
        
        // Configurar campo de fecha con la fecha actual
        txtFechaInicio = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        txtFechaInicio.setEditable(false);
        
        btnRegistrar = new JButton("Registrar Préstamo");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Fila 0: Prestamista
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(createLabeledField("Prestamista:", txtPrestamista), gbc);

        // Fila 1: Cuantía e Interés
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(createLabeledField("Cuantía:", txtCuantia), gbc);
        
        gbc.gridx++;
        add(createLabeledField("Interés (%):", txtInteres), gbc);

        // Fila 2: Tiempo y Unidad de tiempo
        gbc.gridx = 0;
        gbc.gridy++;
        add(createLabeledField("Tiempo de devolución:", txtTiempo), gbc);
        
        gbc.gridx++;
        add(createLabeledField("Unidad de tiempo:", cbUnidadTiempo), gbc);

        // Fila 3: Asunto
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabeledField("Asunto:", txtAsunto), gbc);

        // Fila 4: Frecuencia y Fecha inicio
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(createLabeledField("Frecuencia de pago:", cbFrecuencia), gbc);
        
        gbc.gridx++;
        add(createLabeledField("Fecha de inicio:", txtFechaInicio), gbc);

        // Fila 5: Botón Registrar
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        add(btnRegistrar, gbc);
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    private void setupListeners() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarFormulario()) {
                    registrarPrestamo();
                }
            }
        });
    }

    private boolean validarFormulario() {
        // Validación básica - puedes expandir esto
        if (txtPrestamista.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del prestamista", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            double cuantia = Double.parseDouble(txtCuantia.getText());
            double interes = Double.parseDouble(txtInteres.getText());
            double tiempo = Double.parseDouble(txtTiempo.getText());
            
            if (cuantia <= 0 || interes < 0 || tiempo <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    private void registrarPrestamo() {
        // Obtener datos del formulario
        String prestamista = txtPrestamista.getText();
        double cuantia = Double.parseDouble(txtCuantia.getText());
        double interes = Double.parseDouble(txtInteres.getText());
        double tiempo = Double.parseDouble(txtTiempo.getText());
        String unidadTiempo = (String) cbUnidadTiempo.getSelectedItem();
        String asunto = txtAsunto.getText();
        String frecuencia = (String) cbFrecuencia.getSelectedItem();
        String fechaInicio = txtFechaInicio.getText();
        
        // Obtener usuario actual (ejemplo)
        //int usuarioId = Sesion.getUsuarioActual().getId();
        
        // Calcular cuota
        double cuota = calcularCuota(cuantia, interes, tiempo, unidadTiempo, frecuencia);
        
        // Mostrar resumen
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String mensaje = "Préstamo registrado:\n\n" +
                        "Prestamista: " + prestamista + "\n" +
                        "Cuantía: $" + df.format(cuantia) + "\n" +
                        "Interés: " + interes + "%\n" +
                        "Plazo: " + tiempo + " " + unidadTiempo + "\n" +
                        "Frecuencia de pago: " + frecuencia + "\n" +
                        "Cuota estimada: $" + df.format(cuota) + " por " + frecuencia.toLowerCase();
        
        JOptionPane.showMessageDialog(this, mensaje, "Préstamo Registrado", JOptionPane.INFORMATION_MESSAGE);
        
        // Guardar en BBDD
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String sql = "INSERT INTO Prestamos ("
                    + "usuario_id, prestamista, cuantia, tipo_interes, tasa_interes, "
                    + "concepto, plazo, unidad_plazo, es_frecuente, frecuencia_pago, fecha_inicio) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, usuarioId);
                pstmt.setString(2, prestamista);
                pstmt.setDouble(3, cuantia);
                pstmt.setString(4, "Fijo");  // Tipo de interés (fijo/variable)
                pstmt.setDouble(5, interes);
                pstmt.setString(6, asunto);
                pstmt.setDouble(7, tiempo);
                pstmt.setString(8, unidadTiempo);
                pstmt.setString(9, "S".equals(frecuencia) ? "S" : "N");
                pstmt.setString(10, frecuencia);
                pstmt.setString(11, fechaInicio);
                
                int affectedRows = pstmt.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Préstamo guardado en base de datos");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), 
                                        "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calcularCuota(double cuantia, double interes, double tiempo, String unidadTiempo, String frecuencia) {
        // Conversión simplificada a meses para el cálculo
        double plazoMeses = tiempo;
        if (unidadTiempo.equals("Años")) {
            plazoMeses = tiempo * 12;
        } else if (unidadTiempo.equals("Días")) {
            plazoMeses = tiempo / 30; // Aproximación
        }
        
        // Tasa de interés mensual
        double tasaMensual = interes / 100 / 12;
        
        // Cálculo de cuota mensual (fórmula de amortización)
        if (tasaMensual == 0) {
            return cuantia / plazoMeses;
        } else {
            return cuantia * tasaMensual * Math.pow(1 + tasaMensual, plazoMeses) / 
                   (Math.pow(1 + tasaMensual, plazoMeses) - 1);
        }
    }
}