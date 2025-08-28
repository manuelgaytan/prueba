package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
@PageObject
public class BatchUI extends AbstractPage {
    @FindBy(xpath = "//*[contains(text(),'Mantenimientos') and @class='textoMenu ng-binding']")
    public WebElement mantenimiento;
    @FindBy(xpath = "//span[contains(text(),'Envío de Archivos al Servidor')]")
    public WebElement envioServidor;
    @FindBy(id = "fileUpload")
    public WebElement inputUpload;
    @FindBy(xpath = "//button[@ng-click='accept()']")
    public WebElement btnAceptar;
    @FindBy(xpath = "//*[contains(text(),'alir')]")
    public WebElement btnSalir;
    @FindBy(xpath = "//*[contains(text(),'Tareas') and @class='textoMenu ng-binding']")
    public WebElement tareas;
    @FindBy(xpath = "//*[contains(text(),'Lanzador de tareas') and @class='textSubmenu1 ng-binding']")
    public WebElement lanzadorTareas;
    @FindBy(xpath = "//*[@name='tskVal']")
    public WebElement inputTarea;
    @FindBy(xpath = "//*[@id='tskVal']/following::label[@class='textSm'][2]")
    public WebElement btnAceptarTarea;
    @FindBy(xpath = "//*[@name='JBFLE_GRL_NAM' and @required='required']")
    public WebElement inputGRL;
    @FindBy(xpath = "//*[@name='JBFLE_INT_NAM' and @required='required']")
    public WebElement inputINT;
    @FindBy(xpath = "//*[@name='JBFLE_RYC_NAM' and @required='required']")
    public WebElement inputRYC;
    @FindBy(xpath = "//*[@name='JBSTU_VAL' and @required='required']")
    public WebElement inputCodEstructura;
    @FindBy(xpath = "//textarea")
    public WebElement numCotizacionBatch;
    @FindBy(xpath = "//button[@id='btnAcp']")
    public WebElement btnAceptarCot;
    @FindBy(xpath = "//td[contains(@title, 'TERMINACION')]")
    public WebElement validacionTerminacion;
    @FindBy(xpath = "//body/descendant::input[@id='btcMvmTypVal'][1]")
    public WebElement inputTipoMovBatch;
    @FindBy(xpath = "//body/descendant::input[@id='lodDat'][1]")
    public WebElement inputFechaProcesoBatch;
    @FindBy(xpath = "//span[contains(text(),'Consultar proceso masivo')]")
    public WebElement consultarProcesoMasivo;
    @FindBy(xpath = "//body/descendant::span[@class='ng-binding'][1]")
    public WebElement btnBuscarProceso;
    @FindBy(xpath = "//body/descendant::td[text()='MMXEATEMPR'][1]")
    public WebElement selectProceso;
    @FindBy(xpath = "//span[contains(text(),'Emisión') and @class='textoMenu ng-binding']")
    public WebElement selectEmision;
    @FindBy(xpath = "//body/descendant::button[text()='Consultar Errores' and not(@disabled='disabled')][1]")
    public WebElement btnConsultarErrores;

    @Autowired
    public BatchUI(DriverManager driverManager){
        super(driverManager);
    }
}
