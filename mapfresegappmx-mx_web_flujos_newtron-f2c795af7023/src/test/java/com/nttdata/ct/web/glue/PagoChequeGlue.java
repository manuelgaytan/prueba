package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class PagoChequeGlue {

    @Autowired
    private Tasks tasks;

    @When("Ir apertura de Tesorería")
    public void irTesoreria() {
        tasks.pagoChequeTask.irTesoreria();
    }

    @When("Ingreso Pagos masivos Opción Gestión pagos batch")
    public void ingresoPagosMasivosGetionPagosBatch() {
        tasks.pagoChequeTask.ingresoPagosMasivosGetionPagosBatch();
    }

    @When("CP001_Generar alta de la orden \\(Añadir fila)")
    public void generarAltaOrdenAnadirFila() {
        tasks.pagoChequeTask.generarAltaOrdenAnadirFila();
    }

    @When("Introducir datos {string},{string}")
    public void introducirDatos(String tipoProceso, String formaPago){
        tasks.pagoChequeTask.introducirDatos(tipoProceso,formaPago);}

    @When("Clic botón Guardar")
    public void clicBtnSave(){
        tasks.pagoChequeTask.clicBtnSave();
    }

    @When("Clic botón Aceptar")
    public void clicBtnAceptar(){
        tasks.pagoChequeTask.clicBtnAceptar();
    }

    @When("CP002_Cargar Batch")
    public void cargarBatch(){
        tasks.pagoChequeTask.modalAlert();
        tasks.pagoChequeTask.cargarBatch();
        tasks.pagoChequeTask.modalAlert();
    }

    @When("CP003_Gestion detalle")
    public void gestionDetalle(){tasks.pagoChequeTask.gestionDetalle();}

    @When("CP004_Procesar Excepciones")
    public void procesarExcepciones(){tasks.pagoChequeTask.procesarExcepciones();}

}
