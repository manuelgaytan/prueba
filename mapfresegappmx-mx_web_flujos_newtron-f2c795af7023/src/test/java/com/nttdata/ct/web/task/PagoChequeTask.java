package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.PagoChequeUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Task
public class PagoChequeTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public PagoChequeUI pagoChequeUI ;

    @ShotAfter(evidenceName = "Ir apertura de Tesorería")
    public void irTesoreria() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.btnTesoreria.click();
    }

    @ShotAfter(evidenceName = "Ingreso Pagos masivos Opción Gestión pagos batch")
    public void ingresoPagosMasivosGetionPagosBatch() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.linkPagoBatch.click();
    }

    @ShotAfter(evidenceName = "CP001_Generar alta de la orden (Añadir fila)")
    public void generarAltaOrdenAnadirFila() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.clicBtnAddFile.click();
    }

    @ShotAfter(evidenceName = "CP002_Cargar Batch")
    public void introducirDatos(String tipoProceso, String formaPago) {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h2[contains(text(), 'Introducción de datos:')])[2]");
        this.pagoChequeUI.getInputTipoProceso.sendKeys(tipoProceso);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.pagoChequeUI.getInputFormaPago.sendKeys(formaPago);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Clic botón Guardar")
    public void clicBtnSave() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.clicBtnSave.click();
    }

    @ShotAfter(evidenceName = "Clic botón Aceptar")
    public void clicBtnAceptar() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h2[contains(text(), 'Introducción de datos:')])[2]");
        Util.explicitWait(5);
        this.pagoChequeUI.clicBtnAceptar.click();
    }

    public void modalAlert() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.clicBtnAceptarModal.click();
    }

    @ShotAfter(evidenceName = "CP002_Cargar Batch")
    public void cargarBatch(){
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.firtFileDetalle.click();
        Util.explicitWait(2);
        this.pagoChequeUI.clicBtnBatch.click();
        Util.explicitWait(2);
        this.pagoChequeUI.clicBtnAceptarModal.click();
        Util.explicitWait(2);
        Util.waitSpinner(manager.getDriver(),5);
        if (Util.isElementVisible(manager.getDriver(), pagoChequeUI.detalleBatch, 10)) {
            System.out.println("El texto del detalle está visible.");
        } else {
            System.out.println("El texto del detalle no está visible.");
        }

    }

    @ShotAfter(evidenceName = "CP003_Gestion detalle")
    public void gestionDetalle() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.pagoChequeUI.firtFileDetalle.click();
        Util.explicitWait(2);
        this.pagoChequeUI.clicGestionDetalle.click();
    }

    @ShotAfter(evidenceName = "P004_Procesar Excepciones")
    public void procesarExcepciones() {
        WebDriverWait wait = Util.wait(manager.getDriver());

    }


}
