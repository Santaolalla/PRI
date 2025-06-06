package com.dam.view;

import com.dam.model.Prestamo;
import com.dam.model.dao.PrestamoDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrestamoView extends Application {
    
    private TableView<Prestamo> table = new TableView<>();
    private final PrestamoDAO prestamoDAO = new PrestamoDAO();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Préstamos");
        
        // Crear columnas para la tabla
        TableColumn<Prestamo, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn<Prestamo, Double> montoCol = new TableColumn<>("Monto");
        montoCol.setCellValueFactory(new PropertyValueFactory<>("montoPrincipal"));
        
        TableColumn<Prestamo, String> tipoCol = new TableColumn<>("Tipo");
        tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoPrestamo"));
        
        TableColumn<Prestamo, String> estadoCol = new TableColumn<>("Estado");
        estadoCol.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        TableColumn<Prestamo, Double> tasaCol = new TableColumn<>("Tasa Interés");
        tasaCol.setCellValueFactory(new PropertyValueFactory<>("tasaInteres"));
        
        TableColumn<Prestamo, Double> cuotaCol = new TableColumn<>("Valor Cuota");
        cuotaCol.setCellValueFactory(new PropertyValueFactory<>("valorCuota"));
        
        // Añadir columnas a la tabla
        table.getColumns().addAll(idCol, montoCol, tipoCol, estadoCol, tasaCol, cuotaCol);
        
        // Botón para cargar datos
        Button loadButton = new Button("Cargar Préstamos");
        loadButton.setOnAction(e -> cargarDatos());
        
        // Diseño de la interfaz
        VBox vbox = new VBox(10, loadButton, table);
        Scene scene = new Scene(vbox, 800, 600);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void cargarDatos() {
        ObservableList<Prestamo> data = FXCollections.observableArrayList(
            prestamoDAO.obtenerTodosLosPrestamos()
        );
        table.setItems(data);
    }
}