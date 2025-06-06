package com.dam.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PnlInversion extends JPanel {
    private JTextField txtEmpresa;
    private JTextField txtCuantia;
    private JTextField txtTipoInteres;
    private JTextField txtInteresEsperado;
    private JTextField txtAsunto;
    private JComboBox<String> cbFrecuenciaPago;
    private JTextField txtFechaInicio;
    private JButton btnGuardar;

    public PnlInversion() {
        initComponents();
        setupLayout();
        setupListeners();
    }

    private void initComponents() {
        txtEmpresa = new JTextField(20);
        txtCuantia = new JTextField(10);
        txtTipoInteres = new JTextField(5);
        txtInteresEsperado = new JTextField(5);
        txtAsunto = new JTextField(20);
        
        cbFrecuenciaPago = new JComboBox<>(new String[]{
            "", "Mensual", "Trimestral", "Semestral", "Anual", "Otro"
        });
        
        // Configurar campo de fecha con la fecha actual
        txtFechaInicio = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        txtFechaInicio.setEditable(false);
        
        btnGuardar = new JButton("Guardar Inversión");
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel titulo = new JLabel("Formulario de Inversión");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titulo, gbc);

        // Fila 1: Empresa
        gbc.gridy++;
        add(createLabeledField("Empresa:", txtEmpresa), gbc);

        // Fila 2: Cuantía
        gbc.gridy++;
        add(createLabeledField("Cuantía:", txtCuantia), gbc);

        // Fila 3: Tipo de interés e Interés esperado
        gbc.gridwidth = 1;
        gbc.gridy++;
        add(createLabeledField("Tipo de interés (%):", txtTipoInteres), gbc);
        
        gbc.gridx++;
        add(createLabeledField("Interés esperado:", txtInteresEsperado), gbc);

        // Fila 4: Asunto
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(createLabeledField("Asunto:", txtAsunto), gbc);

        // Fila 5: Frecuencia de pago
        gbc.gridy++;
        JPanel frecuenciaPanel = createLabeledField("Frecuencia de Pago:", cbFrecuenciaPago);
        JLabel optionalLabel = new JLabel("(Opcional)");
        optionalLabel.setFont(new Font("Arial", Font.ITALIC, 10));
        optionalLabel.setForeground(Color.GRAY);
        frecuenciaPanel.add(optionalLabel, BorderLayout.EAST);
        add(frecuenciaPanel, gbc);

        // Fila 6: Fecha inicio
        gbc.gridy++;
        add(createLabeledField("Fecha de Inicio:", txtFechaInicio), gbc);

        // Fila 7: Botón Guardar
        gbc.gridy++;
        gbc.fill = GridBagConstraints.CENTER;
        add(btnGuardar, gbc);
    }

    private JPanel createLabeledField(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 0));
        panel.add(new JLabel(labelText), BorderLayout.WEST);
        panel.add(field, BorderLayout.CENTER);
        return panel;
    }

    private void setupListeners() {
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarFormulario()) {
                    guardarInversion();
                }
            }
        });
    }

    private boolean validarFormulario() {
        if (txtEmpresa.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre de la empresa", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        try {
            double cuantia = Double.parseDouble(txtCuantia.getText());
            double tipoInteres = Double.parseDouble(txtTipoInteres.getText());
            double interesEsperado = Double.parseDouble(txtInteresEsperado.getText());
            
            if (cuantia <= 0 || tipoInteres < 0 || interesEsperado < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    private void guardarInversion() {
        // Obtener datos del formulario
        String empresa = txtEmpresa.getText();
        double cuantia = Double.parseDouble(txtCuantia.getText());
        double tipoInteres = Double.parseDouble(txtTipoInteres.getText());
        double interesEsperado = Double.parseDouble(txtInteresEsperado.getText());
        String asunto = txtAsunto.getText();
        String frecuenciaPago = (String) cbFrecuenciaPago.getSelectedItem();
        String fechaInicio = txtFechaInicio.getText();
        
        // Calcular rendimiento esperado (ejemplo simplificado)
        double rendimientoEsperado = cuantia * (interesEsperado / 100);
        
        // Mostrar resumen
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String mensaje = "Inversión registrada:\n\n" +
                        "Empresa: " + empresa + "\n" +
                        "Cuantía: $" + df.format(cuantia) + "\n" +
                        "Tipo de interés: " + tipoInteres + "%\n" +
                        "Interés esperado: " + interesEsperado + "%\n" +
                        "Rendimiento esperado: $" + df.format(rendimientoEsperado) + "\n" +
                        "Frecuencia de pago: " + (frecuenciaPago.isEmpty() ? "No especificada" : frecuenciaPago);
        
        JOptionPane.showMessageDialog(this, mensaje, "Inversión Registrada", JOptionPane.INFORMATION_MESSAGE);
        
        // Aquí podrías agregar código para guardar en una base de datos
    }
}