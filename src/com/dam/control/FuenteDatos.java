package com.dam.model.data;

import java.sql.Date;

public class FuenteDatos 
{
	public static final String[] UNIDAD_TMP = {"Días", "Meses", "Años"};
	
	public static final String[] FREC_PAGO = {"Diario", "Semanal", "Quincenal", "Mensual", "Trimestral", "Anual"};
	
	private String prestamista;
	private boolean cuantia;
	private boolean interes;
	private int tmp_devol;
	private String u_tmp;
	private String asunto;
	private String fr_pago;
	private Date fecha_inicio;
	private String empresa;
	private boolean cuantia_inv;
	private boolean interes_inv;
	private boolean interes_esp;
	private String asunto_inv;
	private String frec_pago;
	private Date fecha_inicio_inv;
	private String concepto;
	private boolean cuantia_saves;
    private String cuenta;
    private String frecuente_si;
    private String frecuente_no;
    private String frecuencia;
    private String fecha_inicio_gastos;
	
    public FuenteDatos(String prestamista, boolean cuantia, boolean interes, int tmp_devol, String u_tmp, String asunto,
			String fr_pago, Date fecha_inicio, String empresa, boolean cuantia_inv, boolean interes_inv,
			boolean interes_esp, String asunto_inv, String frec_pago, Date fecha_inicio_inv, String concepto,
			boolean cuantia_saves, String cuenta, String frecuente_si, String frecuente_no, String frecuencia,
			String fecha_inicio_gastos) {
		super();
		this.prestamista = prestamista;
		this.cuantia = cuantia;
		this.interes = interes;
		this.tmp_devol = tmp_devol;
		this.u_tmp = u_tmp;
		this.asunto = asunto;
		this.fr_pago = fr_pago;
		this.fecha_inicio = fecha_inicio;
		this.empresa = empresa;
		this.cuantia_inv = cuantia_inv;
		this.interes_inv = interes_inv;
		this.interes_esp = interes_esp;
		this.asunto_inv = asunto_inv;
		this.frec_pago = frec_pago;
		this.fecha_inicio_inv = fecha_inicio_inv;
		this.concepto = concepto;
		this.cuantia_saves = cuantia_saves;
		this.cuenta = cuenta;
		this.frecuente_si = frecuente_si;
		this.frecuente_no = frecuente_no;
		this.frecuencia = frecuencia;
		this.fecha_inicio_gastos = fecha_inicio_gastos;
	}

	public String getPrestamista() {
		return prestamista;
	}

	public boolean isCuantia() {
		return cuantia;
	}

	public boolean isInteres() {
		return interes;
	}

	public int getTmp_devol() {
		return tmp_devol;
	}

	public String getU_tmp() {
		return u_tmp;
	}

	public String getAsunto() {
		return asunto;
	}

	public String getFr_pago() {
		return fr_pago;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public String getEmpresa() {
		return empresa;
	}

	public boolean isCuantia_inv() {
		return cuantia_inv;
	}

	public boolean isInteres_inv() {
		return interes_inv;
	}

	public boolean isInteres_esp() {
		return interes_esp;
	}

	public String getAsunto_inv() {
		return asunto_inv;
	}

	public String getFrec_pago() {
		return frec_pago;
	}

	public Date getFecha_inicio_inv() {
		return fecha_inicio_inv;
	}

	public String getConcepto() {
		return concepto;
	}

	public boolean isCuantia_saves() {
		return cuantia_saves;
	}

	public String getCuenta() {
		return cuenta;
	}

	public String getFrecuente_si() {
		return frecuente_si;
	}

	public String getFrecuente_no() {
		return frecuente_no;
	}

	public String getFrecuencia() {
		return frecuencia;
	}

	public String getFecha_inicio_gastos() {
		return fecha_inicio_gastos;
	}
}

