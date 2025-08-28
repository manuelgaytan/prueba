package com.nttdata.ct.web.ui;
import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class LoginUI extends AbstractPage {

    // Selectores Newtron

    /** Xpath login Newtron (usuario y contraseña) **/

    @FindBy(xpath = "//*[@id=\"nuuma\" or @type=\"email\"]")
    public WebElement inputUser;
    @FindBy(xpath = "//*[@id=\"contrasena\" or @name=\"passwd\"] | //input[@id='i0118']")
    public WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"es_log\" or @type=\"submit\"]/..")
    public WebElement buttonLogin;



    @Autowired
    public LoginUI(DriverManager driverManager) {
        super(driverManager);
    }

}
