package com.nttdata.ct.web.task;


import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.CreacionExpedientesUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Duration;

import java.time.Duration;
import java.util.List;

import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class CreacionExpedientesTask {
    @Autowired
    public DriverManager manager;

    @Autowired
    private CreacionExpedientesUI creacionExpedientesUI;

    @ShotAfter(evidenceName = "Finalizar poliza")
    public void finalizarApertura() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.creacionExpedientesUI.btnAceptarSimiestro.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(8);
        this.creacionExpedientesUI.btnFinalizar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.creacionExpedientesUI.botonAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.creacionExpedientesUI.btnOperacionFinalizada.click();
    }

    @ShotAfter(evidenceName = "Apertura de expediente")
    public void irAperturaExpedientes() {
        String numSimiestro = ExcelData.readJsonSiniestro("polizaSiniestroColision");
//        Util.pageStatus(manager.getDriver());
//        Util.explicitWait(5);
//        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
//        Util.explicitWait(5);
//        this.creacionExpedientesUI.menuSimiestros.click();
//        Util.pageStatus(manager.getDriver());
//        Util.explicitWait(2);
//        this.creacionExpedientesUI.btnAperturaExpediente.click();
        //Mantenimiento Ernesto,comente lo anterior por que agregue ingresar al modulo desde un step

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.creacionExpedientesUI.inputNumSimiestro.sendKeys(numSimiestro);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.creacionExpedientesUI.btnSiguienteApertura.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.creacionExpedientesUI.btnDMP.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnSiguient.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //this.creacionExpedientesUI.btnExpediente1.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[3]");
        this.creacionExpedientesUI.btnAcept.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(5);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Daños materiales parciales")
    public void irAperturaSimiestro2() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div[2]/div/div[2]/div[3]/div[2]/div/div/div/div/div[1]");
//        this.creacionExpedientesUI.btnDanosParciales.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.inputNombreCompleto.sendKeys("OSCAR HERRERA ESPINOSA");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputRelacionContratante.sendKeys("CONTRATANTE");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputContacto.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputTelefono.sendKeys("558050752");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputDireccionImpacto.sendKeys("1-1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputMagnitud.sendKeys("1");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.btnDescripcionDanos.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToEnd(manager.getDriver());
        Util.explicitWait(2);
        String xpathAdd = "//*[@id=\"oca_1NY\"]/div/div[1]/div/div/div/fieldset[2]/nwt-crud-w-drv/div/a[1]";

        //WebElement motivoSiniestro1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathAdd)));
        //motivoSiniestro1.click();
        //this.creacionExpedientesUI.btnAgregar.click();
        String pagina = manager.getDriver().getPageSource();
        System.out.println(pagina);
        if (pagina.contains("<a ng-if=\"objBtn.btnAdd\" ng-disabled=\"!objBtn.btnAdd.mdf()\" ng-click=\"objBtn.btnAdd.mdf() &amp;&amp; objBtn.btnAdd.onClick()\" ng-show=\"!objBtn.btnAdd.vsb || objBtn.btnAdd.vsb()\" href=\"javascript:;\" class=\"M10px pull-left ng-scope\">\n" +
                "        <img src=\"commons/img/new.png\" alt=\"\">\n" +
                "        <label class=\"textSm\"><span ng-bind-html=\"('mpGridCrud.create' | translate)\" class=\"ng-binding\">Añadir</span></label>\n" +
                "    </a>")) {
            System.out.println("El elemento está en el DOM.");

        }else{
            System.out.println("No esta");
        }
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));

        // Hacer clic en el botón "Añadir"
        addButton.click();

        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToEnd(manager.getDriver());
        this.creacionExpedientesUI.inputCostadoTraseroDerecho.sendKeys("S");
        Util.explicitWait(2);
        Util.tab(manager.getDriver());

        this.creacionExpedientesUI.inputCostadoTraseroIzquierdo.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputCPDDer.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputCPDIzq.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputCPTDer.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputCPTIzq.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputELD.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputELI.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputEstribo.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputFarosDelanteros.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputFarosTraseros.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputFaciaDelantera.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputFaciaTrasera.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputLD.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputLIzq.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputMR.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputMpColi.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputMedallon.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputParabrisas.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputParrilla.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPartesBajas.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPisoCajuela.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPostes.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPuertaDelanteraDerecha.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPuertaDelanteraIzquierda.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPuertaTraseraDerecha.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputPuertaTraseraIzquierda.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputSalpicaderaDelanteraDerecha.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputSalpicaderaDelanteraIzq.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputSalpicaderaTraseraDerecha.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputSalpicaderaTraseraIzquierda.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputTapaCajuela.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputToldo.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputTolvaDeEscape.sendKeys("N");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        this.creacionExpedientesUI.inputTolvaDeParabrisas.sendKeys("N");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        WebElement verificarButton = manager.getDriver().findElement(By.xpath("//a[contains(@ng-if, 'objBtn.btnVrf') and contains(@ng-click, 'objBtn.btnVrf.onClick()') and contains(@class, 'M10px pull-right ng-scope') and @href='javascript:;']"));
        // Click the "Verificar" button
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[9]");
        Util.explicitWait(2);
        verificarButton.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        WebElement confirmarBton = manager.getDriver().findElement(By.xpath("//a[@ng-if='objBtn.btnAcp' and @class='M10px pull-right ng-scope']"));
        confirmarBton.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnAceptarOcurrencia.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"plyAtrPssLssSetFrmW\"]/div/div/div[5]");
        Util.explicitWait(2);
        this.creacionExpedientesUI.inputResponsable.sendKeys("R");
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnVerificar.click();
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.getBtnAceptarExpediente.click();
        Util.explicitWait(5);
    }

    @ShotAfter(evidenceName = "Datos complementarios")
    public void datosComplementarios() {
        Util.explicitWait(2);
        this.creacionExpedientesUI.getBtnSiguient3.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.provedoresExpedientes.click();
        Util.pageStatus(manager.getDriver());
        //WebElement confirmarBton = manager.getDriver().findElement(By.xpath("//*[@id=\"1\"]/td[1]"));
        //String texto = this.creacionExpedientesUI.provedoresExpedientes.getText();
        //String texto = confirmarBton.getText();
        //Assert.assertEquals(texto,"PROVEEDORES DE EXPEDIENTES");
        Util.explicitWait(5);

    }

    @ShotAfter(evidenceName = "No. póliza para siniestro de autos")
    public void finalizarExpediente() {
        this.creacionExpedientesUI.botonVerificar.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.botonSiguiente.click();
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.aceptarExped.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btonFinalizar.click();
        Util.explicitWait(5);
    }


    public void finalizarExpediente2() {
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnAceptTerm.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.creacionExpedientesUI.btnAceptOpera.click();
        Util.explicitWait(5);
    }

}
