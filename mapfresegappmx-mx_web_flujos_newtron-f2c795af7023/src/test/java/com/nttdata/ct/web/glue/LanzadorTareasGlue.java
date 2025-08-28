package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;


public class LanzadorTareasGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Ir a Facturación")
    public void irAFacturación() {
        tasks.lanzadorTareasTask.irFacturacion();
    }

    @And("Ir a Tareas")
    public void consultaSiniestro() {
        tasks.lanzadorTareasTask.irTareas();
    }

    @And("CP001_Ejecución de tarea {string}")
    public void buscartarea(String nombretarea) {
        tasks.lanzadorTareasTask.busquedaTarea(nombretarea);
    }

    @And("Ingresar archivo .txt {string},{string}")
    public void ingresarArchivoTxt(String archivo, String nombreTarea) {
        tasks.lanzadorTareasTask.validarArchivo(archivo, nombreTarea);
    }

    @And("Validar situación del archivo .txt")
    public void validarArchivoTxt() {
        tasks.lanzadorTareasTask.validarSituacion();
    }

    @And("Validar situación del archivo")
    public void validarArchivo() {
        tasks.lanzadorTareasTask.validarSituacion();
    }


    @And("CP002_Descarga archivo de salida tarea")
    public void descargarReporte() {
        tasks.lanzadorTareasTask.descargar();
    }


    @And("Completar el formulario de atributos {string}")
    public void completarFormulario(String bloqueot) {
        tasks.lanzadorTareasTask.completarFormulario(bloqueot);
    }


    @And("Seleccionar y cargar archivo")
    public void seleccionarArchivo() {tasks.lanzadorTareasTask.cargarArchivo();}

    @And("Buscar tarea {string},{string},{string}")
    public void buscarTarea1(String archivo, String nombreTarea, String codArchivo) {
        tasks.lanzadorTareasTask.buscarTarea(archivo, nombreTarea, codArchivo);
    }

//    @And("Subir archivo {string}")
//    public void buscarTarea1(String nombreArchivo) {
//        tasks.lanzadorTareasTask.subirarchivo(nombreArchivo);
//    }


    @And("CP002_Descarga archivo {string} de salida tarea")
    public void cp_DescargaArchivoPrimaCobradaDeSalidaTarea(String primaCobrada) {
        tasks.lanzadorTareasTask.descargar2(primaCobrada);
    }
    @And("Salir Lanzador Tareas")
    public void salirLanzadorTareas() {
        tasks.lanzadorTareasTask.salirlanzadortarea();
    }

    @And("Completar el formulario de atributos Primero a Fin de Mes")
    public void completarElFormularioDeAtributosPrimeroAFinDeMes() {
        tasks.lanzadorTareasTask.completarformularioatributosprimeroafindemes();
    }

    @And("Completar el formulario de atributos Reportes")
    public void completarElFormularioDeAtributosReportes() {
        tasks.lanzadorTareasTask.completarformularioatributosreportes();
    }

    //Validar Reportes
    @And("Validar que se descargue el reporte {string}")
    public void validarQueSeDescargueElReporte(String reporte) {
        tasks.lanzadorTareasTask.validarreporte(reporte);
    }

    @Then("Validar que se descargue el reporte que comienza con {string} y termine en {string}")
    public void validarQueSeDescargueElReporteQueComienzaConYTermineEn(String reporte, String termina) {
        tasks.lanzadorTareasTask.validarreporteconterminacion(reporte, termina);
    }


    @And("Salir del reporte")
    public void salirDelReporte() {
        tasks.lanzadorTareasTask.salirreporte();
    }

    @And("Completar el formulario de atributos Primero a Fin de Mes con codigo de sector")
    public void completarElFormularioDeAtributosPrimeroAFinDeMesConCodigoDeSector() {
        tasks.lanzadorTareasTask.completarformularioatributosprimeroafindemescodigosector();
    }

    @And("Completar el formulario de atributos Validador de Asientos {string},{string},{string},{string},{string},{string},{string}")
    public void completarElFormularioDeAtributosValidadorDeAsientos(String codigoejercicio, String codigoasiento, String numeroasiento, String listarerrores, String borraasiento, String listadocampos, String nombrearchivo) {
        tasks.lanzadorTareasTask.completarformularioatributosvalidadorasientos(codigoejercicio, codigoasiento, numeroasiento, listarerrores, borraasiento, listadocampos,nombrearchivo);
    }

    @And("Actualizar el formulario de atributos Validador de Asientos {string},{string}")
    public void actualizarElFormularioDeAtributosValidadorDeAsientos(String codigoasiento, String nombrearchivo) {
        tasks.lanzadorTareasTask.actualizarformularioatributosvalidadorasientos(codigoasiento,nombrearchivo);
    }

    @And("Completar el formulario de atributos Interface Contable {string},{string},{string},{string},{string}")
    public void completarElFormularioDeAtributosInterfaceContable(String codigoejercicio, String codigoasiento, String moneda, String resumido, String reprocesar) {
        tasks.lanzadorTareasTask.completarformulariointerfacecontable(codigoejercicio,codigoasiento,moneda,resumido,reprocesar);
    }

    @And("Actualizar el formulario de atributos Interface Contable {string},{string}")
    public void actualizarElFormularioDeAtributosInterfaceContable(String codigoasiento, String moneda) {
        tasks.lanzadorTareasTask.lanzadorTareasTaskactualizarformulariointerfacecontable(codigoasiento,moneda);
    }


//    @And("Completar Atributos {string}")
//    public void completarAtributos(String archivo) {
//        tasks.lanzadorTareasTask.complearatributos(archivo);
//        tasks.lanzadorTareasTask.complearatributosfinalizar();
//    }

    @And("Completar Atributos {string}, {string} el valor {string}")
    public void completarAtributosElValor(String archivo, String campoId, String valor) {
        tasks.lanzadorTareasTask.complearatributos(archivo,campoId,valor);
        tasks.lanzadorTareasTask.complearatributosfinalizar();
    }

}