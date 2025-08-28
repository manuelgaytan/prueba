package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.EmisionBatchTask;
import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

public class EmisionBatchGlue {

    @Autowired
    private EmisionBatchTask emisionBatchTask;

    @And("Ingresar a Envio de Archivos al Servidor")
    public void ingresarEnvioArchivosServidor() {
        emisionBatchTask.ingresarEnvioArchivosServidor();
    }

    @And ("Cargar archivo Emision NE {string}")
    public void cargarArchivoEmisionNE(String archivo){
        emisionBatchTask.cargarArchivosBatch(archivo);
        emisionBatchTask.regresarCargaArchivo();
    }


    @And("Cargar Atributos del Archivo {string} y {string}, {string}")
    public void cargaAtributosdelArchivo(String nombreFichero, String codigoEstructura, String proceso){
        emisionBatchTask.AtributosFichero(nombreFichero,codigoEstructura,proceso);
    }

    @And("Ingresar Atributos Tarea Batch {string}")
    public void ingresarAtributosTareaBatch(String proceso){
        emisionBatchTask.AtributosBatch(proceso);
    }

    @Then("Ingresar Datos Orden {string}")
    public void ingresarDatosOrden(String proceso){
        emisionBatchTask.ingresarDatosOrden(proceso);
    }

    @And("Validar informacion de poliza")
    public void validarInfoPoliza(){
        emisionBatchTask.validarInfoPoliza();

    }

    @And ("Cargar archivo Cancelacion Batch {string}")
    public void cargarArchivoCarcelarBatch(String archivo){
        emisionBatchTask.cargarArchivosBatch(archivo);
        emisionBatchTask.regresarCargaArchivo();
    }

    @And ("Cargar archivos Emision Batch {string}, {string}, {string}")
    public void cargarArchivosEmisionBatch(String archivoGRL, String archivoINT, String archivoRYC){
        emisionBatchTask.cargarArchivosBatch(archivoGRL);
        emisionBatchTask.cargarArchivosBatch(archivoINT);
        emisionBatchTask.cargarArchivosBatch(archivoRYC);
        emisionBatchTask.regresarCargaArchivo();
    }

    @And("Ingresar a menu Consultar Proceso Masivo")
    public void menuConsultarProcesoMasivo(){
        emisionBatchTask.menuConsultaProcesoMasivo();

    }

    @And ("Ingresar atributos Batch General {string}, {string}, {string}")
    public void atributosBatchGeneral(String general, String interveniente, String riesgoCobertura){
        emisionBatchTask.atributosFicheros(general,interveniente,riesgoCobertura);
    }

    @And ("Ingresar atributos Proceso Masivo")
    public void atributosProcesoMasivo(){
        emisionBatchTask.atributosProcesoMasivo();
    }

    @And ("Obtener numero orden emision general")
    public void numeroOrdenGral(){
        emisionBatchTask.obtenerNumOrdenGeneral();
    }

    @And("Ingresar al Lanzador de Tareas")
    public void ingresarLanzadorTareas() {
        emisionBatchTask.LanzadorDeTareas();
    }


}
