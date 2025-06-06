package com.dam.model.db;

// Clase de constantes con los nombres de las columnas y la tabla de PRÉSTAMOS
public class PrestContract {

    // Nombre de la tabla
    public static final String TABLE_NAME = "PRESTAMOS";
    
    // Columnas básicas
    public static final String COL_ID = "ID";
    public static final String COL_PRINCIPAL = "MONTO_PRINCIPAL";
    public static final String COL_FECHA_DESEMBOLSO = "FECHA_DESEMBOLSO";
    public static final String COL_FECHA_VENCIMIENTO = "FECHA_VENCIMIENTO";
    public static final String COL_TIPO_INTERES = "TIPO_INTERES";
    public static final String COL_TASA_INTERES = "TASA_INTERES";
    public static final String COL_FRECUENCIA_PAGO = "FRECUENCIA_PAGO";
    public static final String COL_NUM_CUOTAS = "NUMERO_CUOTAS";
    public static final String COL_CUOTA = "VALOR_CUOTA";
    public static final String COL_SALDO_PENDIENTE = "SALDO_PENDIENTE";
    
    // Columnas específicas de préstamos
    public static final String COL_TIPO_PRESTAMO = "TIPO_PRESTAMO";
    public static final String COL_ESTADO = "ESTADO";
    public static final String COL_DESTINO = "DESTINO";
    public static final String COL_GARANTIA = "GARANTIA";
    public static final String COL_DEUDOR = "ID_DEUDOR";
    public static final String COL_AVAL = "ID_AVAL";
    public static final String COL_MOROSIDAD = "DIAS_MOROSIDAD";
    public static final String COL_SCORE_CREDITICIO = "SCORE_CREDITICIO";
    
    // Valores constantes para campos enumerados
    public static final String[] TIPOS_INTERES = {"Fijo", "Variable", "Mixto"};
    public static final String[] FRECUENCIAS_PAGO = {"Diario", "Semanal", "Quincenal", "Mensual", "Bimestral", "Trimestral", "Semestral", "Anual"};
    public static final String[] TIPOS_PRESTAMO = {"Personal", "Hipotecario", "Automotriz", "Educativo", "Comercial", "De consumo", "Prendario"};
    public static final String[] ESTADOS_PRESTAMO = {"Solicitado", "Aprobado", "Desembolsado", "En mora", "Refinanciado", "Pagado", "Incumplido"};
    public static final String[] DESTINOS_PRESTAMO = {"Vivienda", "Educación", "Salud", "Vehiculo", "Consumo", "Negocio", "Refinanciamiento", "Otros"};
    public static final String[] TIPOS_GARANTIA = {"Sin garantía", "Hipoteca", "Prendaria", "Aval", "Personal", "Mixta"};
    
    // Rangos comunes
    public static final double MIN_TASA_INTERES = 0.0;
    public static final double MAX_TASA_INTERES = 50.0; // 50%
    public static final int MIN_PLAZO_MESES = 1;
    public static final int MAX_PLAZO_MESES = 360; // 30 años
}