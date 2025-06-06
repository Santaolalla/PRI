package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.dam.view.VPFinanzas;
import com.dam.view.PnlPrestamos;
import com.dam.view.PnlInversion;
import com.dam.view.PnlAhorro;
import com.dam.view.PnlGastos;

public class ColeccionFinanzasListener implements ActionListener {
    
    private VPFinanzas vpf;
    private PnlPrestamos pp;
    private PnlInversion pi;
    private PnlAhorro pa;
    private PnlGastos pg;
    private FuenteDatos datos;
    
    public ColeccionFinanzasListener(VPFinanzas vpf, PnlPrestamos pp, 
                                   PnlInversion pi, PnlAhorro pa, 
                                   PnlGastos pg) {
        this.vpf = vpf;
        this.pp = pp;
        this.pi = pi;
        this.pa = pa;
        this.pg = pg;
        this.datos = new FuenteDatos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        switch(command) {
            case VPFinanzas.ACT_CMN_MNTM_PRESTAMOS:
                vpf.cargarPanel(pp);
                break;
            case VPFinanzas.ACT_CMN_MNTM_INVERSION:
                vpf.cargarPanel(pi);
                break;
            case VPFinanzas.ACT_CMN_MNTM_AHORRO:
                vpf.cargarPanel(pa);
                break;
            case VPFinanzas.ACT_CMN_MNTM_GASTOS:
                vpf.cargarPanel(pg);
                break;
            case VPFinanzas.ACT_CMN_MNTM_SALIR:
                System.exit(0);
                break;
            default:
                System.out.println("Acción no reconocida: " + command);
        }
    }
}