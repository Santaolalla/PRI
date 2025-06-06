package com.dam.model.db;

// Clase de constantes con los nombres de las columnas y la tabla de INVERSIONES
public class InvContract {

    // Nombre de la tabla
    public static final String TABLE_NAME = "INVERSIONES";
    
    // Columnas de la tabla
    public static final String COL_ID = "ID";
    public static final String COL_CANTIDAD = "CANTIDAD";
    public static final String COL_FECHA_INICIO = "FECHA_INICIO";
    public static final String COL_FECHA_VENCIMIENTO = "FECHA_VENCIMIENTO";
    public static final String COL_TIPO_INTERES = "TIPO_INTERES";
    public static final String COL_TASA_INTERES = "TASA_INTERES";
    public static final String COL_PERIODO_CAPITALIZACION = "PERIODO_CAPITALIZACION";
    public static final String COL_RIESGO = "NIVEL_RIESGO";
    public static final String COL_ESTADO = "ESTADO";
    public static final String COL_DESCRIPCION = "DESCRIPCION";
    public static final String COL_TIPO_INVERSION = "TIPO_INVERSION";
    public static final String COL_RENTABILIDAD_ESPERADA = "RENTABILIDAD_ESPERADA";
    public static final String COL_MONEDA = "MONEDA";
    
    // Valores constantes para algunos campos
    public static final String[] TIPOS_INTERES = {"Fijo", "Variable", "Mixto"};
    public static final String[] PERIODOS_CAPITALIZACION = {"Diario", "Mensual", "Trimestral", "Semestral", "Anual"};
    public static final String[] NIVELES_RIESGO = {"Bajo", "Medio", "Alto"};
    public static final String[] ESTADOS_INVERSION = {"Activa", "Vencida", "Liquidada", "Cancelada"};
    public static final String[] TIPOS_INVERSION = {"Depósito", "Fondos", "Bonos", "Acciones", "Planes pensiones"};
    public static final String[] MONEDAS = {"EUR", "USD", "GBP", "JPY", "CHF"};
}