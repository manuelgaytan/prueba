package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class SiniestrosRoboUI extends AbstractPage {

    @FindBy(xpath = "//tr[td[3][text()='ROBO TOTAL']]")
    public WebElement btnRoboTotal;

    @FindBy(xpath = "//input[@id='NOM_CONTACTO_PRE_EXP_RTA']")
    public WebElement inputNombreCompleto;


    protected SiniestrosRoboUI(DriverManager driverManager) {
        super(driverManager);
    }
}
