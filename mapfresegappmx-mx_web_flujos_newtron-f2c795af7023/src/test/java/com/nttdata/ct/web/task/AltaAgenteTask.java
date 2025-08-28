package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AltaAgenteUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Task
public class AltaAgenteTask {

    @Autowired
    public DriverManager manager;

    @Autowired
    public AltaAgenteUI altaAgenteUI;

    @ShotAfter(evidenceName = "Ingreso Datos Basicos")
    public void crearAgenteDatosBasicos(String razonSocial, String primerApellido, String segundoApellido, String personaFisica, String tipoDocumento) {
        Util.explicitWait(2);
        this.altaAgenteUI.btnTerceros.click();
        Util.explicitWait(2);
        this.altaAgenteUI.btnRutinaTerceros.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.altaAgenteUI.btnCrear.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.txtNomRazonSocial.sendKeys(razonSocial);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.txtPrimerApellido.sendKeys(primerApellido);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.txtSegundoApellido.sendKeys(segundoApellido);
        Util.tab(manager.getDriver());
        String rfc = Util.generarRFCAleatorio();
        String fechaStr = rfc.substring(4, 10);
        String part1 = fechaStr.substring(0, 2); // "96"
        String part2 = fechaStr.substring(2);    // "1124"
        // Reorganizamos las partes para obtener el resultado deseado
        String fechaModificada =part2.substring(2) + part2.substring(0, 2) + "19"+part1  ;
        Util.explicitWait(2);
        this.altaAgenteUI.txtFechaNacimiento.sendKeys(fechaModificada);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.pageStatus(manager.getDriver());

        this.altaAgenteUI.txtPersonaFisica.sendKeys(personaFisica);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.txtTipoDocumento.sendKeys(tipoDocumento);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        ExcelData.writeJsonAgente(rfc);
        this.altaAgenteUI.txtDocumento.sendKeys(rfc);
        System.out.println("El RFC: "+rfc);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);


        this.altaAgenteUI.txtActividad.sendKeys("2");
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        String valor =Util.generarnumerosaletorios();
        this.altaAgenteUI.txtCodTercero.sendKeys(valor);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.btnAceptarTerceros.click();
        Util.tab(manager.getDriver());
        WebDriverWait wait = Util.wait(manager.getDriver());
        //html/body/div/div[1]/div
        List<WebElement> procesoGrabacionModal = manager.getDriver().findElements(By.xpath("/html/body/div/div[1]/div/div/div/div/div/div/div/h1"));
        int aceptModal12 = procesoGrabacionModal.size();
        System.out.println("Valor: "+aceptModal12);
        while (aceptModal12 > 0) {
            String valor2 =Util.generarnumerosaletorios();
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[1]/div/div/div/div/div/div/div/h1")));
            this.altaAgenteUI.cerrarModal.click();
            this.altaAgenteUI.txtCodTercero.clear();
            this.altaAgenteUI.txtCodTercero.sendKeys(valor2);
            this.altaAgenteUI.btnAceptarTerceros.click();
            Util.explicitWait(2);
            List<WebElement>  persona = manager.getDriver().findElements(By.xpath("//*[@id=\"app-content-container\"]/div/div/div/div[1]/div/div[2]/div[1]/h4/a/span"));
            int cerrar = persona.size();
            if(cerrar>0){
                break;
            }

        }
        Util.explicitWait(3);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }
    @ShotAfter(evidenceName = "Ingreso Nombre Persona Legal")
    public void datosPersonaLegal(String aliasTercero) {
        Util.scrollDown(manager.getDriver(),"500");
        this.altaAgenteUI.txtAliasTercero.sendKeys(aliasTercero);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
    }
    @ShotAfter(evidenceName = "Ingreso Nombre Persona")
    public void datosPersona(String nombre, String apellido1, String apellido2) {
        Util.scrollDown(manager.getDriver(),"1800");
        this.altaAgenteUI.txtNombrePersona.sendKeys(nombre);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.txtApellidoPersona1.sendKeys(apellido1);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.txtApellidoPersona2.sendKeys(apellido2);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Ingresar Datos de Agente")
    public void completarDatosAgente(String situacion, String beneficiario, String comercial, String tipoAgente, String fuenteProduccion,
                                     String tipoRetencion, String formaTerceroPc, String calidadTercero, String AgrupamientoTercero, String FormaGestion, String TipoClasificacion) {
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"app-content-container\"]/div/div/div/div[1]/div/div[7]/div[2]");
        this.altaAgenteUI.inputSituacion.sendKeys(situacion);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inpClaseBeneficiario.sendKeys(beneficiario);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inputComercial.sendKeys(comercial);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inpTipoAgente.sendKeys(tipoAgente);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inpProduccionDirecta.sendKeys(fuenteProduccion);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inpTipoRetencion.sendKeys(tipoRetencion);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inpFormaTerceroCobraPaga.sendKeys(formaTerceroPc);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.inpCalidadTercero.sendKeys(calidadTercero);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.inpAgrupamientoTercero.sendKeys(AgrupamientoTercero);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.inpFormaGestion.sendKeys(FormaGestion);
        Util.tab(manager.getDriver());
        Util.enter(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.inpTipoClasificacion.sendKeys(TipoClasificacion);
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
    }
    @ShotAfter(evidenceName = "Fuentes de produccion")
    public void distribucionPorAgente(String fuenteProduccion) {
        Util.scrollToElement(manager.getDriver(),"//*[@id=\"nwtThpAgnConfData.id\"]/div/div/div[16]");

        this.altaAgenteUI.btnFuentesProduccion.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.botonCrear.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.inputCanalDistribucion.sendKeys(fuenteProduccion);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        Util.ingresarFechaActual(manager.getDriver(),"//input[@id='oDsrRacForm.cnf.fldT.vldDat.id']","ddMMyyyy");
        Util.tab(manager.getDriver());


    }
    @ShotAfter(evidenceName = "Consultar agente en terceros")
    public void consultaAgente(String tipoDocumento) {
        this.altaAgenteUI.btonSalir.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.btonCrear.click();
        Util.tab(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());

        this.altaAgenteUI.inputTipoDocumentoTercero.sendKeys(tipoDocumento);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        String rfc =  ExcelData.readJsonAgente();
        this.altaAgenteUI.inputDocumento.sendKeys(rfc);
        Util.tab(manager.getDriver());
        Util.explicitWait(2);

        this.altaAgenteUI.btonBuscar.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        this.altaAgenteUI.selectDocumento.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        String agenteRfc = this.altaAgenteUI.rfcDocumento.getText();
        Assert.assertEquals(rfc,agenteRfc);
        Util.explicitWait(2);
        this.altaAgenteUI.btnConsultar.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());

        this.altaAgenteUI.btnAceptarConsulta.click();
        Util.tab(manager.getDriver());
        Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }
}
