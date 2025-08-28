package com.nttdata.ct.web.task;
import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.ReporteSiniestroUI;
import com.nttdata.ct.web.ui.LoginUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.Duration;
import static com.nttdata.ct.web.task.ExcelData.readExcel;

@Task
public class ReporteSiniestroTask {
    @Autowired
    public DriverManager manager;
    @Autowired
    private ReporteSiniestroUI reporteSiniestroUI;

    @ShotAfter(evidenceName = "Ir al apartado consultar póliza")
    public void irConsultarPoliza() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.reporteSiniestroUI.selectSiniestros.click();
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.reporteSiniestroUI.optionConsultaSiniestro.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
    }

    @ShotAfter(evidenceName = "Busqueda de siniestro")
    public void busquedaSiniestro() {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        String noPolizaSiniestro = ExcelData.readJsonSiniestro("polizaSiniestro");
        this.reporteSiniestroUI.inputPolizaSiniestro.sendKeys(noPolizaSiniestro);
        Util.explicitWait(2);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Validamos la consulta Siniestro")
    public void validacionConsulta( ){

        this.reporteSiniestroUI.btnSiguienteGlobal.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
       // Util.scrollToElement(manager.getDriver(), "//body/descendant::*[contains(text(),'"+motivoSiniestro+"')][1]");
        Util.pageStatus(manager.getDriver());

    }
    @ShotAfter(evidenceName = "Validamos los datos Siniestro")
    public void validacionConsulta2(String motivoSiniestro) {
        String segundosEspera = readExcel("dataWebAutomoviles", 4, 0);
        int segundEsp = Integer.parseInt(segundosEspera);
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(segundEsp));
        this.reporteSiniestroUI.tabCausas.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        if (this.reporteSiniestroUI.causaSimiestro.getText() == motivoSiniestro) {
            WebElement motivoSiniestro1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='" + motivoSiniestro + "']")));
            motivoSiniestro1.isEnabled();
        }else if(this.reporteSiniestroUI.causaSimiestro.getText() == "ROBO TOTAL"){
            WebElement motivoSiniestro1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='ROBO TOTAL']")));
            motivoSiniestro1.isEnabled();
        }

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
    }
}
