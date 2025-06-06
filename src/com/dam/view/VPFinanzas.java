package com.dam.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import com.dam.control.ColeccionFinanzasListener;

public class VPFinanzas extends JFrame {
    public static final String ACT_CMN_MNTM_PRESTAMOS = "PRESTAMOS";
    public static final String ACT_CMN_MNTM_INVERSION = "INVERSION";
    public static final String ACT_CMN_MNTM_AHORRO = "AHORRO";
    public static final String ACT_CMN_MNTM_GASTOS = "GASTO";
    public static final String ACT_CMN_MNTM_SALIR = "Salir";
    private static final int ANCHO = 630;
    private static final int ALTO = 450;
    
    private JScrollPane scrpContenedor;
    private JMenuItem mntmPrestamos;
    private JMenuItem mntmInversion;
    private JMenuItem mntmAhorro;
    private JMenuItem mntmGastos;
    private JMenuItem mntmSalir;
    
    public VPFinanzas() {
        super("Ventana Principal Finanzas");
        
        configurarFrame();
        
        crearMenu();
        
        crearComponentes();
    }

    private void configurarFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(ANCHO, ALTO);
        
        // Centrar la ventana
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
        setLocation((pantalla.width - this.getSize().width) / 2,  
                   (pantalla.height - this.getSize().height) / 2); 
    }

    private void crearComponentes() {
        scrpContenedor = new JScrollPane();
        getContentPane().add(scrpContenedor, BorderLayout.CENTER);
    }

    private void crearMenu() {
        JMenuBar mnbCollecion = new JMenuBar();
        setJMenuBar(mnbCollecion);
        
        mntmPrestamos = new JMenuItem(ACT_CMN_MNTM_PRESTAMOS);
        mnbCollecion.add(mntmPrestamos);
        
        mntmInversion = new JMenuItem(ACT_CMN_MNTM_INVERSION);
        mnbCollecion.add(mntmInversion);
        
        mntmAhorro = new JMenuItem(ACT_CMN_MNTM_AHORRO);
        mnbCollecion.add(mntmAhorro);
        
        mntmGastos = new JMenuItem(ACT_CMN_MNTM_GASTOS);
        mnbCollecion.add(mntmGastos);
        
        mntmSalir = new JMenuItem(ACT_CMN_MNTM_SALIR);
        mnbCollecion.add(mntmSalir);
    }
    
    public void hacerVisible() {
        setVisible(true);
    }

    public void cargarPanel(JPanel panel) {
        scrpContenedor.setViewportView(panel);
    }

    public void setListener(ColeccionFinanzasListener l) {
        if (mntmPrestamos != null) mntmPrestamos.addActionListener(l);
        if (mntmInversion != null) mntmInversion.addActionListener(l);
        if (mntmAhorro != null) mntmAhorro.addActionListener(l);
        if (mntmGastos != null) mntmGastos.addActionListener(l);
        if (mntmSalir != null) mntmSalir.addActionListener(l);
    }
}