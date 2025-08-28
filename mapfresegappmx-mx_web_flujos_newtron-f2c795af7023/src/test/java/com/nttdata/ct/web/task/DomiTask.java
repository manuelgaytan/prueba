package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.runner.Runner;
import com.nttdata.ct.web.ui.BatchUI;
import com.nttdata.ct.web.ui.DomiUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.fail;

@Task
public class DomiTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public DomiUI domiUI;
    Logger logger = Logger.getLogger(Runner.class.getName());

    @ShotAfter(evidenceName = "Agregar Carga Batch - Agregar Fila")
    public void agregarprocesoagregarfila() {
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.btnAñadirFila);
        Util.explicitWait(2);
        this.domiUI.btnAñadirFila.click();

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.txtTipoProceso);
        this.domiUI.txtTipoProceso.sendKeys("30");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        //Util.scrollToElement(manager.getDriver(), "//*[@id=\"rccMndShwMndSetW\"]/div/fieldset/div/div[4]/div[3]/div[2]/label");
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Guardar')]");  // Se hace scroll down hasta el texto del botón guardar
        Util.explicitWait(2);
        }

    @ShotAfter(evidenceName = "Agregar Carga Batch - Guardar Agregar Fila")
    public void agregarprocesoagregarfilaguardar() {
        this.domiUI.btnGuardar.click();
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'ceptar')]");  // Se hace scroll down hasta el texto del botón guardar
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.btnAceptar);
        this.domiUI.btnAceptar.click();
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.txtMensajeEjecucion);  //7:57 Alta del proceso
        Util.explicitWait(2);
    }



    @ShotAfter(evidenceName = "Agregar Carga Batch - Cargar Batch")
    public void agregarprocesoagregarcargabatch() {
        this.domiUI.btnAceptarMensaje.click();
        Util.explicitWait(2);

        this.domiUI.opcCobrosDomiciliados.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.btnCargarBatch);
        this.domiUI.btnCargarBatch.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.txtMensajeCarga);

        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Agregar Carga Batch - Estatus Cargar Batch")
    public void agregarprocesoagregarestatuscargabatch() {
        this.domiUI.btnAceptarMensaje.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtMensajeCargabatch);
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Validar situación de carga")
    public void estatuscarga(){

        if(Util.webElementIsEnabled(6,manager.getDriver(),this.domiUI.txtMensajeCargabatchCorrecto)) {
            logger.log(Level.INFO, "Se cargo correctamente: " +this.domiUI.txtMensajeCargabatchCorrecto.getText());
            this.domiUI.btnAceptarMensaje.click();
        }else{
            logger.log(Level.INFO, "Ya se ha cargado: " +this.domiUI.txtMensajeCargabatchError.getText());
            this.domiUI.btnCerrarMensajeError.click();
        }

        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Consultar situacion de proceso 2")
    public void consultarsituacion2() {
        Util.explicitWait(2);
        this.domiUI.txtTipoProcesoConsulta.sendKeys("30");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        this.domiUI.txtSituacionProceso.sendKeys("2");
        Util.explicitWait(1);
        this.domiUI.btnConsultar.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.opcCobrosDomiciliadosDetalleFiltrado);
        this.domiUI.opcCobrosDomiciliadosDetalleFiltrado.click();
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Gestionardetalle")
    public void gestionardetalle() {

        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.btnGestionDetalle);
        this.domiUI.btnGestionDetalle.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtResultadosConsulta);
        Util.explicitWait(2);

    }
    @ShotAfter(evidenceName = "Procesar Excepciones")
    public void procesarexcepciones() {

        this.domiUI.btnProcesarExcepciones.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtMensajeProcesarExcepciones);
        this.domiUI.btnAceptarMensaje.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtMensajeEstatusProcesarExcepciones);
        Util.explicitWait(1);
        this.domiUI.btnAceptarMensaje.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "Filtrar Recibos")
    public void filtrarrecibos() {
        //Se filtran recibos
        Util.waitWebElementIsEnabled(10, manager.getDriver(), this.domiUI.btnFiltrarRecibos);
        this.domiUI.btnFiltrarRecibos.click();
        Util.explicitWait(2);

    }
    @ShotAfter(evidenceName = "Filtrar Recibos por DB")
    public void filtrarrecibospor(String gestorcobro) {
        WebElement iframe = manager.getDriver().findElement(By.tagName("iframe"));
        manager.getDriver().switchTo().frame(iframe);
        Util.explicitWait(2);

        if(!gestorcobro.equals("DB")){//TA
            this.domiUI.txtImputGestorCobro.clear();
            Util.explicitWait(1);
            this.domiUI.txtImputGestorCobro.sendKeys(gestorcobro);
            Util.explicitWait(2);
        }

        Util.waitWebElementIsEnabled(10, manager.getDriver(), this.domiUI.btnProcesarFiltros);
        this.domiUI.btnProcesarFiltros.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtMensajebtnProcesarFiltros);

    }

    @ShotAfter(evidenceName = "Importe")
    public void importe() {

        Util.explicitWait(1);
        this.domiUI.btnSi.click();
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtImporte);
        this.domiUI.btnAceptar.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.txtGestorCobro);
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Gestion de archivos")
    public void gestionarchivos() {
        Util.pageStatus(manager.getDriver());

        manager.getDriver().switchTo().defaultContent();
        manager.getDriver().switchTo().frame(manager.getDriver().findElement(By.xpath("(//iframe[@frameborder=\"0\"])[2]")));

        Util.waitWebElementIsEnabled(5, manager.getDriver(), this.domiUI.cbGestorCobro);
        this.domiUI.cbGestorCobro.click();
        Util.explicitWait(1);
        this.domiUI.cbBBVA.click();

        Util.explicitWait(1);
        this.domiUI.txtXCodigoGestor.sendKeys("00120012");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.domiUI.btnActualizar.click();
        Util.explicitWait(1);

        if (Util.webElementIsEnabled(3, manager.getDriver(), this.domiUI.ventanaError)) {
            // Obtener los textos de los elementos de error
            this.domiUI.btnCerrarMensajeError.click();
        }

        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.domiUI.opcAviso);
        String Aviso = this.domiUI.opcAviso.getText();

        // Extraemos los ultimos 4 digitos
        String numeroAviso = Aviso.substring(Aviso.length() - 4);
        System.out.println("El número de aviso es:"+numeroAviso);

        this.domiUI.opcAviso.click();

        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Generar Archivo')]");
        Util.explicitWait(1);
        this.domiUI.btnGenerarArchivo.click();
        Util.explicitWait(1);
        Util.waitWebElementIsEnabled(6, manager.getDriver(), this.domiUI.btnSi);
        this.domiUI.btnSi.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.waitWebElementIsEnabled(6, manager.getDriver(), this.domiUI.btnAceptar2);
        this.domiUI.btnAceptar2.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.explicitWait(2);

    }

    @ShotAfter(evidenceName = "Consultar Excepcionado")
    public void consultaryaexcepcionado() {
        Util.explicitWait(2);
        this.domiUI.txtTipoProcesoConsulta.sendKeys("30");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        this.domiUI.txtSituacionProceso.sendKeys("4");
        Util.explicitWait(1);
        this.domiUI.btnConsultar.click();
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//*[contains(text(),'Estamos cargando la página')]");
        Util.waitWebElementIsEnabled(15, manager.getDriver(), this.domiUI.opcCobrosDomiciliadoExcepcionado);
        this.domiUI.opcCobrosDomiciliadoExcepcionado.click();
        Util.explicitWait(2);
    }
}

