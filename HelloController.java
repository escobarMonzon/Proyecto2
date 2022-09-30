package com.example.proyecto2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {
    @FXML
    private Pane formEncuesta, formNuevaEncuesta, formDetallesEncuesta,formNuevaPregunta ;
    @FXML
     TableView tablaCuestionarios, tablaPreguntas;
    @FXML
     TableColumn indiceCuestionario,PinCuestionario, nombrecuestionario, descripcioncuestionario, indicePregunta,nombrePregunta, duracion, puntos;
    @FXML
    TextArea inTituloCuestionario, inDescripcionCuestionario, inNombrePregunta, inLimitePregunta, inPuntosPregunta;
    @FXML
    Label labelTituloCuestionario, labelDescripcionCuestionario, notifiacionEncuesta, notifiacionGrabado, random;
    ArrayList<preguntas> fraccion = new ArrayList<>();
    int resultado=0, AgregarEditar, indiceModificarPregunta, borrarPregunta;
    String pin = "";
    preguntas borrar;

    public void initialize(){
        cuestionario nuevocuestionario=new cuestionario(0,"Base de Datos","Una base de datos es un conjunto de datos pertenecientes a un mismo contexto y almacenados sistemáticamente para su posterior uso","REGISTRADO");
        generales.Cuestionarios.add(nuevocuestionario);
        cuestionario nuevocuestionario1=new cuestionario(123456,"Lenguajes de Programacion","Los lenguajes de programación más utilizados a nivel mundial son Python, C, Java, C++ y C#","ACTIVADO");
        generales.Cuestionarios.add(nuevocuestionario1);
        cuestionario nuevocuestionario2=new cuestionario(0,"Sistemas Operativos","Como gestor de recursos, el sistema operativo administra: La unidad central de procesamiento (donde está alojado el microprocesador)","REGISTRADO");
        generales.Cuestionarios.add(nuevocuestionario2);
        indiceCuestionario.setCellValueFactory(new PropertyValueFactory<cuestionario, Integer>("idcuestionario"));
        PinCuestionario.setCellValueFactory(new PropertyValueFactory<cuestionario, Integer>("PinCuestionario"));
        nombrecuestionario.setCellValueFactory(new PropertyValueFactory<cuestionario, String>("nombrecuestionario"));
        descripcioncuestionario.setCellValueFactory(new PropertyValueFactory<cuestionario, String>("descripcioncuestionario"));
        ObservableList<cuestionario> infoCuestionarios = FXCollections.observableArrayList(generales.Cuestionarios);
        tablaCuestionarios.setItems(infoCuestionarios);

        preguntas nuevapregunta= new preguntas(1,15,10,"pregunta 1 cuestionario 1");
        preguntas nuevapregunta2=new preguntas(1,15,10,"pregunta 2 cuestionario 1");
        preguntas nuevapregunta3=new preguntas(1,15,10,"pregunta 3 cuestionario 1");
        generales.Preguntas.add(nuevapregunta);
        generales.Preguntas.add(nuevapregunta2);
        generales.Preguntas.add(nuevapregunta3);
        preguntas nuevapregunta4=new preguntas(2,15,10,"pregunta 1 cuestionario 2");
        preguntas nuevapregunta5=new preguntas(2,15,10,"pregunta 2 cuestionario 2");
        preguntas nuevapregunta6=new preguntas(2,15,10,"pregunta 3 cuestionario 2");
        generales.Preguntas.add(nuevapregunta4);
        generales.Preguntas.add(nuevapregunta5);
        generales.Preguntas.add(nuevapregunta6);
        preguntas nuevapregunta7=new preguntas(3,15,10,"pregunta 1 cuestionario 3");
        preguntas nuevapregunta8=new preguntas(3,15,10,"pregunta 2 cuestionario 3");
        preguntas nuevapregunta9=new preguntas(3,15,10,"pregunta 3 cuestionario 3");
        generales.Preguntas.add(nuevapregunta7);
        generales.Preguntas.add(nuevapregunta8);
        generales.Preguntas.add(nuevapregunta9);
        indicePregunta.setCellValueFactory(new PropertyValueFactory<preguntas, Integer>("idPregunta"));
        nombrePregunta.setCellValueFactory(new PropertyValueFactory<preguntas, String>("nombrePregunta"));
        duracion.setCellValueFactory(new PropertyValueFactory<preguntas, Integer>("duracion"));
        puntos.setCellValueFactory(new PropertyValueFactory<preguntas, Integer>("puntos"));



    }
    @FXML
    protected void MostrarAgregarCuestionarioNuevo() {
        formEncuesta.setVisible(false);
        formNuevaEncuesta.setVisible(true);
        inTituloCuestionario.requestFocus();
        LimpiarItems();
        nostrarTablaPreguntas();
    }
    @FXML
    protected void CancelarAgregarCuestionarioNuevo() {
        formNuevaEncuesta.setVisible(false);
        formEncuesta.setVisible(true);
        LimpiarItems();
        nostrarTablaPreguntas();
    }
    @FXML
    protected void MostrarDetallesCuestionario() {
        if (inTituloCuestionario.getText()=="" || inDescripcionCuestionario.getText()==""){
            notifiacionEncuesta.setText("Los campos deben de estar llenos para continuar");
        }else {
            cuestionario nuevocuestionario=new cuestionario(0,inTituloCuestionario.getText(),inDescripcionCuestionario.getText(),"REGISTRADO");
            generales.Cuestionarios.add(nuevocuestionario);

            for (cuestionario consulta: generales.Cuestionarios) {
                if (consulta.getNombrecuestionario()==inTituloCuestionario.getText()){
                    resultado= consulta.getIdcuestionario();
                }
            }
            nostrarTablaPreguntas();
            formNuevaEncuesta.setVisible(false);
            formDetallesEncuesta.setVisible(true);
            labelTituloCuestionario.setText(String.valueOf(inTituloCuestionario.getText()));
            labelDescripcionCuestionario.setText(inDescripcionCuestionario.getText());
            LimpiarItems();
        }
    }
    @FXML
    protected void CancelarDetallesCuestionario() {
        formDetallesEncuesta.setVisible(false);
        formEncuesta.setVisible(true);
        ObservableList<cuestionario> infoCuestionarios = FXCollections.observableArrayList(generales.Cuestionarios);
        tablaCuestionarios.setItems(infoCuestionarios);
        LimpiarItems();
    }
    @FXML
    protected void MostrarAgregarnuevaPregunta() {
        LimpiarItems();
        AgregarEditar=1;
        formDetallesEncuesta.setVisible(false);
        formNuevaPregunta.setVisible(true);
        inNombrePregunta.requestFocus();
        nostrarTablaPreguntas();
    }
    @FXML
    protected void CancelarAgregarnuevaPregunta() {
        formNuevaPregunta.setVisible(false);
        formDetallesEncuesta.setVisible(true);
        LimpiarItems();
        nostrarTablaPreguntas();
    }
    @FXML
    protected void CrearNuevaPregunta() {

        if (AgregarEditar==1){
            if (inNombrePregunta.getText()=="" || inLimitePregunta.getText()==""|| inPuntosPregunta.getText()==""){
                notifiacionGrabado.setText("Los campos deben de estar llenos para continuar");
            }else {
            String inputNombrePregunta=inNombrePregunta.getText();
            int inputLimitePregunta= Integer.parseInt(inLimitePregunta.getText());
            int inputPuntosPregunta= Integer.parseInt(inPuntosPregunta.getText());

            preguntas nuevoPregunta=new preguntas(resultado,inputLimitePregunta,inputPuntosPregunta,inputNombrePregunta);
            generales.Preguntas.add(nuevoPregunta);
            nostrarTablaPreguntas();
                formNuevaPregunta.setVisible(false);
                formDetallesEncuesta.setVisible(true);
                LimpiarItems();
                notifiacionGrabado.setText("");
            }
        } else if (AgregarEditar==2) {

            String inputNombrePregunta=inNombrePregunta.getText();
            int inputLimitePregunta= Integer.parseInt(inLimitePregunta.getText());
            int inputPuntosPregunta= Integer.parseInt(inPuntosPregunta.getText());

            for (preguntas consultarCoincidencia:generales.Preguntas){
                if (consultarCoincidencia.getIdPregunta()==indiceModificarPregunta){
                    consultarCoincidencia.setNombrePregunta(inputNombrePregunta);
                    consultarCoincidencia.setDuracion(inputLimitePregunta);
                    consultarCoincidencia.setPuntos(inputPuntosPregunta);
                }
            }
            nostrarTablaPreguntas();
            formNuevaPregunta.setVisible(false);
            formDetallesEncuesta.setVisible(true);
            LimpiarItems();
            notifiacionGrabado.setText("");

        }


    }
    @FXML
    protected void modificarPregunta() {
        LimpiarItems();
        nostrarTablaPreguntas();
        preguntas  seleccion= (preguntas) this.tablaPreguntas.getSelectionModel().getSelectedItem();
        if (seleccion==null){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una pregunta de la lista");
        }else{
            inNombrePregunta.setText(seleccion.getNombrePregunta());
            inLimitePregunta.setText(String.valueOf(seleccion.getDuracion()));
            inPuntosPregunta.setText(String.valueOf(seleccion.getPuntos()));
            indiceModificarPregunta=seleccion.getIdPregunta();
            AgregarEditar=2;
            formDetallesEncuesta.setVisible(false);
            formNuevaPregunta.setVisible(true);
            inNombrePregunta.requestFocus();
        }
    }

    @FXML
    protected void BorrarPreguntas() {
        LimpiarItems();
        preguntas  seleccion= (preguntas) this.tablaPreguntas.getSelectionModel().getSelectedItem();
        if (seleccion==null){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una pregunta de la tabla");
        }else{
            for (preguntas consultarCoincidencia: generales.Preguntas){
                if (consultarCoincidencia.getIdPregunta()==seleccion.getIdPregunta()){
                    generales.Preguntas.remove(consultarCoincidencia);
                }
            }
            nostrarTablaPreguntas();
        }
    }
    @FXML
    protected void ActivarFormulario() {
        LimpiarItems();
        cuestionario  seleccion= (cuestionario) this.tablaCuestionarios.getSelectionModel().getSelectedItem();
        if (seleccion==null){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar un CUESTIONARIO de la tabla");
        }else{
            for (cuestionario consultarCoincidencia: generales.Cuestionarios){
                if (consultarCoincidencia.getIdcuestionario()==seleccion.getIdcuestionario()){
                    String estado= consultarCoincidencia.getEstado();
                    if (estado=="ACTIVADO"){
                        JOptionPane.showMessageDialog(null, "El CUESTIONARIO ya esta ACTIVADO");
                    }else{
                        String Aleatorios = "0123456789";
                        Random codigo = new Random();
                        for(int i=0;i<6;i++)
                        {
                            pin += Aleatorios.charAt(Math.abs(codigo.nextInt())%Aleatorios.length());
                        }
                        consultarCoincidencia.setEstado("ACTIVADO");
                        consultarCoincidencia.setPinCuestionario(Integer.parseInt(pin));
                        JOptionPane.showMessageDialog(null, "cuestionario Activado con el Pin: "+pin);
                        ObservableList<cuestionario> infoCuestionarios = FXCollections.observableArrayList(generales.Cuestionarios);
                        tablaCuestionarios.setItems(infoCuestionarios);
                    }
                }
            }
        }
        ObservableList<cuestionario> infoCuestionarios = FXCollections.observableArrayList(generales.Cuestionarios);
        tablaCuestionarios.setItems(infoCuestionarios);
    }
    @FXML
    protected void ClonarPreguntas() {
        LimpiarItems();
        cuestionario  seleccion= (cuestionario) this.tablaCuestionarios.getSelectionModel().getSelectedItem();
        if (seleccion==null){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una pregunta de la tabla");
        }else{
            for (preguntas consultarCoincidencia: generales.Preguntas){
                if (consultarCoincidencia.getIdPregunta()==seleccion.getIdcuestionario())
                    generales.Preguntas.clone();
            }
            nostrarTablaPreguntas();
        }
    }
    @FXML
    protected void LimpiarItems() {
        inNombrePregunta.clear();
        inLimitePregunta.clear();
        inPuntosPregunta.clear();
        inTituloCuestionario.clear();
        inDescripcionCuestionario.clear();
        notifiacionEncuesta.setText("");
    }
    @FXML
    protected void nostrarTablaPreguntas() {
        fraccion.clear();
        for (preguntas consultaPreguntaIngresadas: generales.Preguntas) {
            if (consultaPreguntaIngresadas.getIdcuestionario()==resultado){
                fraccion.add(consultaPreguntaIngresadas);
            }
        }
        ObservableList<preguntas> infoPreguntas = FXCollections.observableArrayList(fraccion);
        tablaPreguntas.setItems(infoPreguntas);

    }

}