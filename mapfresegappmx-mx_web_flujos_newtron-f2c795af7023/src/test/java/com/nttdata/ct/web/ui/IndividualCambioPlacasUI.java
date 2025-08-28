package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class IndividualCambioPlacasUI  extends AbstractPage {

    @FindBy(xpath = "//input[@id='NUM_MATRICULA']")
    public WebElement inputCambioPlca;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div/div[3]/div[2]/div[1]/div/div[2]/div/fieldset/ul/li[6]/div/div/div[2]/div/div/div/div/div/ul/li[4]/a")
    public WebElement btnNumPlaca;

    @FindBy(xpath = "//td[@title= 'SIN MOVIMIENTO']")
    public WebElement labelDismiPrim;
    protected IndividualCambioPlacasUI(DriverManager driverManager) {
        super(driverManager);
    }
}