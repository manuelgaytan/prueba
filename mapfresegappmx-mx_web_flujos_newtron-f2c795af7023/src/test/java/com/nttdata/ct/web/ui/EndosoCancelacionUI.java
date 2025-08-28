package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class EndosoCancelacionUI extends AbstractPage {

    @FindBy(xpath = "//a[@class='btn btn-infoVal ng-scope' and contains(./label/span, 'Aceptar')]")
    public WebElement btnAceptInfo;

    @FindBy(xpath = "//button[@class='btn btn-navigation ng-scope btn-icon-after-next' and contains(./span, 'Siguiente')]")
    public WebElement btnSiguiente;

    @FindBy(xpath = "//textarea[@name='txtEnrRsnTxtVal']")
    public WebElement inputObservacion;

    @FindBy (xpath = "//*[@id=\"app-content-container\"]/div/div/div[1]/div/div/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement btnAcepObservacion;

    @FindBy(xpath = "//a[@class='accordion-toggle' and contains(./span, 'Motivo suplemento')]")
    public  WebElement btnMotivoSuple;

    @FindBy(xpath = "//*[@id=\"1_chkAcnTypVal\"]")
    public WebElement checkFaltaPago;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[1]/div/div/fieldset/div/div/div/div/div[3]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public  WebElement btnAceptarSuplemento;

    @FindBy(xpath = "//button[@class='btn btn-navigation btn-icon-after-next ng-scope' and .//span[contains(text(), 'inalizar')]]")
    public WebElement btnFinalizar;

    @FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div/button[1]")
    public WebElement cerrarModal;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[1]/div/div/div[2]/div/button[1]")
    public WebElement btnSalir;

    @FindBy(xpath = "//button[.//span[contains(text(), 'Aceptar')]]")
    public WebElement btnAceptarGrabacion;

    @FindBy(xpath = "//td[@title='FALTA DE PAGO']")
    public WebElement labelFaltaPago;

    public EndosoCancelacionUI(DriverManager driverManager) {
        super(driverManager);
    }
}
