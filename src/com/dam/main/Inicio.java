package com.dam.main;

import java.awt.EventQueue;
import com.dam.control.ColeccionFinanzasListener;
import com.dam.view.VPFinanzas;
import com.dam.view.PnlPrestamos;
import com.dam.view.PnlInversion;
import com.dam.view.PnlAhorro;
import com.dam.view.PnlGastos;

public class Inicio {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                VPFinanzas vpf = new VPFinanzas();
                
                // Crear instancias de los paneles
                PnlPrestamos pp = new PnlPrestamos();
                PnlInversion pi = new PnlInversion();
                PnlAhorro pa = new PnlAhorro();
                PnlGastos pg = new PnlGastos();
                
                // Crear el listener con las dependencias
                ColeccionFinanzasListener l = new ColeccionFinanzasListener(vpf, pp, pi, pa, pg);
                
                // Configurar el listener
                vpf.setListener(l);
                
                // Mostrar la ventana con el primer panel por defecto
                vpf.cargarPanel(pp);
                vpf.hacerVisible();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}