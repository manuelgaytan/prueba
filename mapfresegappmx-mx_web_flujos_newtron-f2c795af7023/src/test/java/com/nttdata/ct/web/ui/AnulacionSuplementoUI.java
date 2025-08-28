package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class AnulacionSuplementoUI extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"1_chkAcnTypVal\"]")
    public WebElement checkAnulacionSuplemento;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/fieldset/div/div/div/div/div[1]/div[2]/div/div[2]/fieldset/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement aceptObservacion;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[2]/div[2]/fieldset/div/div/div/div/div[2]/div[2]/div/div[2]/fieldset/div/div/div[2]/div/div/div/div/ul/li[4]/a")
    public WebElement aceptuplemento;

    @FindBy(xpath = "//*[@id=\"1\"]/td[2]")
    public WebElement labelSuplemento;

    @FindBy(xpath = "//button[span[contains(text(),'inalizar')]]")
    public WebElement btnFinalizar;

    @FindBy(xpath = "//button[span[contains(text(),'Aceptar')]]")
    public WebElement btnAceptGrabacion;

    @FindBy(xpath = "//button[span[contains(text(),'alir')]]")
    public WebElement btnSalir;



    private AnulacionSuplementoUI(DriverManager driverManager) {
        super(driverManager);
    }
}
