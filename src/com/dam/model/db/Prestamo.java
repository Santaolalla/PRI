package com.dam.model.db;

import java.sql.Date;

public class Prestamo {
    private int id;
    private double montoPrincipal;
    private Date fechaDesembolso;
    private Date fechaVencimiento;
    private String tipoInteres;
    private double tasaInteres;
    private String frecuenciaPago;
    private int numCuotas;
    private double valorCuota;
    private String tipoPrestamo;
    private String estado;
    
    // Constructor, getters y setters
    public Prestamo(int id, double montoPrincipal, Date fechaDesembolso, 
                   Date fechaVencimiento, String tipoInteres, double tasaInteres, 
                   String frecuenciaPago, int numCuotas, double valorCuota, 
                   String tipoPrestamo, String estado) {
        this.id = id;
        this.montoPrincipal = montoPrincipal;
        this.fechaDesembolso = fechaDesembolso;
        this.fechaVencimiento = fechaVencimiento;
        this.tipoInteres = tipoInteres;
        this.tasaInteres = tasaInteres;
        this.frecuenciaPago = frecuenciaPago;
        this.numCuotas = numCuotas;
        this.valorCuota = valorCuota;
        this.tipoPrestamo = tipoPrestamo;
        this.estado = estado;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMontoPrincipal() {
		return montoPrincipal;
	}

	public void setMontoPrincipal(double montoPrincipal) {
		this.montoPrincipal = montoPrincipal;
	}

	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getTipoInteres() {
		return tipoInteres;
	}

	public void setTipoInteres(String tipoInteres) {
		this.tipoInteres = tipoInteres;
	}

	public double getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	public int getNumCuotas() {
		return numCuotas;
	}

	public void setNumCuotas(int numCuotas) {
		this.numCuotas = numCuotas;
	}

	public double getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}

	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
   
}