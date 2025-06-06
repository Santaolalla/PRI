package com.dam.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;

public class PnlAhorro extends JPanel {
    private JTextField txtConcepto;
    private JFormattedTextField txtCuantia;
    private JTextField txtCuenta;
    private JRadioButton rbtnFrecuenteSi;
    private JRadioButton rbtnFrecuenteNo;
    private JComboBox<String> cmbFrecuencia;
    private JSpinner spnFechaInicio;

    public PnlAhorro() {
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        // Formato para la cuantía (moneda)
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setParseBigDecimal(true);

        // Componentes
        txtConcepto = new JTextField(20);
        txtCuantia = new JFormattedTextField(decimalFormat);
        txtCuantia.setColumns(10);
        txtCuenta = new JTextField(20);
        
        // Radio buttons para ahorro frecuente
        rbtnFrecuenteSi = new JRadioButton("Sí");
        rbtnFrecuenteNo = new JRadioButton("No", true);
        ButtonGroup frecuenteGroup = new ButtonGroup();
        frecuenteGroup.add(rbtnFrecuenteSi);
        frecuenteGroup.add(rbtnFrecuenteNo);
        
        // Combo box para frecuencia
        cmbFrecuencia = new JComboBox<>(new String[]{"Diaria", "Semanal", "Mensual", "Trimestral", "Anual"});
        cmbFrecuencia.setEnabled(false);
        
        // Spinner para fecha de inicio
        SpinnerDateModel dateModel = new SpinnerDateModel();
        spnFechaInicio = new JSpinner(dateModel);
        spnFechaInicio.setEditor(new JSpinner.DateEditor(spnFechaInicio, "dd/MM/yyyy"));
        JSpinner.DateEditor dateEditor = (JSpinner.DateEditor) spnFechaInicio.getEditor();
        dateEditor.getTextField().setEditable(false);
        
        // Establecer fecha actual
        spnFechaInicio.setValue(java.sql.Date.valueOf(LocalDate.now()));
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Panel principal con título
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createTitledBorder("Registro de Ahorro"));
        
        // Panel de formulario
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Concepto
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Concepto:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtConcepto, gbc);
        
        // Cuantía
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Cuantía:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCuantia, gbc);
        
        // Cuenta
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Número de cuenta:"), gbc);
        gbc.gridx = 1;
        formPanel.add(txtCuenta, gbc);
        
        // Ahorro frecuente
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Ahorro Frecuente:"), gbc);
        gbc.gridx = 1;
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(rbtnFrecuenteSi);
        radioPanel.add(rbtnFrecuenteNo);
        formPanel.add(radioPanel, gbc);
        
        // Frecuencia (inicialmente oculto)
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Frecuencia:"), gbc);
        gbc.gridx = 1;
        cmbFrecuencia.setVisible(false);
        formPanel.add(cmbFrecuencia, gbc);
        
        // Fecha inicio
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(new JLabel("Fecha Inicio:"), gbc);
        gbc.gridx = 1;
        formPanel.add(spnFechaInicio, gbc);
        
        // Botón de guardar
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        JButton btnGuardar = new JButton("Guardar Ahorro");
        formPanel.add(btnGuardar, gbc);
        
        mainPanel.add(formPanel);
        add(mainPanel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        // Mostrar/ocultar frecuencia según selección
        rbtnFrecuenteSi.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cmbFrecuencia.setVisible(e.getStateChange() == ItemEvent.SELECTED);
                cmbFrecuencia.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
            }
        });
        
        // Acción del botón guardar
        for (Component c : getComponents()) {
            if (c instanceof JButton) {
                ((JButton) c).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        guardarAhorro();
                    }
                });
            }
        }
    }

    private void guardarAhorro() {
        try {
            // Validar campos
            if (txtConcepto.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce un concepto", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (txtCuantia.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce una cuantía", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if (txtCuenta.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, introduce un número de cuenta", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener valores
            String concepto = txtConcepto.getText();
            double cuantia = ((Number) txtCuantia.getValue()).doubleValue();
            String cuenta = txtCuenta.getText();
            boolean esFrecuente = rbtnFrecuenteSi.isSelected();
            String frecuencia = esFrecuente ? (String) cmbFrecuencia.getSelectedItem() : "No aplica";
            java.util.Date fecha = (java.util.Date) spnFechaInicio.getValue();
            
            // Mostrar resumen (aquí normalmente enviarías los datos a tu lógica de negocio)
            String mensaje = String.format(
                "Ahorro registrado:\n\n" +
                "Concepto: %s\n" +
                "Cuantía: %.2f\n" +
                "Cuenta: %s\n" +
                "Ahorro frecuente: %s\n" +
                "Frecuencia: %s\n" +
                "Fecha inicio: %tF",
                concepto, cuantia, cuenta, esFrecuente ? "Sí" : "No", frecuencia, fecha
            );
            
            JOptionPane.showMessageDialog(this, mensaje, "Ahorro registrado", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar formulario
            limpiarFormulario();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtConcepto.setText("");
        txtCuantia.setValue(0.0);
        txtCuenta.setText("");
        rbtnFrecuenteNo.setSelected(true);
        cmbFrecuencia.setVisible(false);
        spnFechaInicio.setValue(java.sql.Date.valueOf(LocalDate.now()));
    }
}