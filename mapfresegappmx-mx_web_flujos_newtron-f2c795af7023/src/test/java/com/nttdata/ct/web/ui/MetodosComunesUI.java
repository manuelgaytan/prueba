package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class MetodosComunesUI extends AbstractPage {

    /** Formulario  **/
    @FindBy(xpath = "(//span[@class='ng-binding'])[2]")
    public WebElement btnAceptar;
    @FindBy(xpath = "//*[contains(text(),'alir')]")
    public WebElement btnSalir;

    /** xpath Imput módulo Tareas  **/
    @FindBy(xpath = "//input[@id='tskVal']")
    public WebElement inputTarea;
    @FindBy(xpath = "//*[contains(text(),'Cancelar')][1]")
    public WebElement btnCancelar;
    @FindBy(xpath = "//*[contains(text(), 'Tiene errores')]")
    public WebElement ventanaError;
    @FindBy(xpath = "//li[@ng-repeat='e in error.errors']")
    public WebElement detalleError;

    /** xpath Carga de archivos  **/
    @FindBy(xpath = "//input[@id='fileUpload']")
    public WebElement inputArchivo;
    @FindBy(xpath = "//*[@id=\"formData\"]/div[2]/button")
    public WebElement btnAceptarCarga;




    @Autowired
    public MetodosComunesUI(DriverManager driverManager) {
        super(driverManager);
    }

}