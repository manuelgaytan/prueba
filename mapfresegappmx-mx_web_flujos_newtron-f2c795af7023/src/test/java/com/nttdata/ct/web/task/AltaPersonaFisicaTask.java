package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.AltaPersonaFisicaUI;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Task
public class AltaPersonaFisicaTask {

    @Autowired
    public DriverManager manager;
    @Autowired
    public AltaPersonaFisicaUI altaPersonaFisicaUI;

    private String rfcGenerado;


    @ShotAfter(evidenceName = "Ir apertura de Tercero")
    public void irProveedores() {
        Util.explicitWait(2);
        this.altaPersonaFisicaUI.btnTercero.click();
    }

    @ShotAfter(evidenceName = "Ingreso datos generales para Proveedores")
    public void ingresoDatosGeneralesProveedores() {
        Util.explicitWait(2);
        this.altaPersonaFisicaUI.linkProveedor.click();
    }

    @ShotAfter(evidenceName = "Busqueda de apertura de proveedores")
    public void busquedaAperturaProveedores(String tipoDocTercero, String actividadTercero) {
        this.altaPersonaFisicaUI.getInputTipeDocTercero.sendKeys(tipoDocTercero);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputActividadTercero.sendKeys(actividadTercero);
        Util.explicitWait(2);
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Clic botón Crear")
    public void clicBtnCrear() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.altaPersonaFisicaUI.clicBtnCrear.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }

    @ShotAfter(evidenceName = "Ingreso Datos Basicos")
    public void ingresoDatosBasicos() {
        Util.pageStatus(manager.getDriver());
        WebDriverWait wait = Util.wait(manager.getDriver());

        try {
            Util.activarIframe(manager.getDriver(), "//iframe");
            boolean rfcValido = false;
            int intentos = 0;
            while (!rfcValido && intentos < 5) {
                rfcGenerado = Util.generarRFCAleatorio(); // Generar y asignar el RFC
                intentos++;
                if (esRFCAceptado(rfcGenerado)) {
                    System.out.println("El rfc es:"+rfcGenerado);
                    rfcValido = true;
                } else {
                    System.out.println("Intento " + intentos + ": RFC generado inválido: " + rfcGenerado);
                    altaPersonaFisicaUI.getInputModalDoc.sendKeys("");
                }
            }
            if (!rfcValido) {
                throw new IllegalStateException("No se pudo generar un RFC válido después de " + intentos + " intentos.");
            }
            wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.getInputModalDoc))
                    .sendKeys(rfcGenerado);
            Util.pageStatus(manager.getDriver());
            wait.until(ExpectedConditions.elementToBeClickable(altaPersonaFisicaUI.clicBtnAceptar))
                    .click();
        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo encontrar un elemento esperado dentro del tiempo especificado.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error durante el ingreso de datos básicos.", e);
        } finally {
            manager.getDriver().switchTo().defaultContent();
        }


    }


    private boolean esRFCAceptado(String rfc) {
        return rfc != null && !rfc.trim().isEmpty() && rfc.matches("[A-Z]{4}\\d{6}[A-Z0-9]{3}");
    }


    @ShotAfter(evidenceName = "Alta de proveedor con &")
    public void altaProveedorAmpsd() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(3);
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.activarIframe(manager.getDriver(), "//iframe");
        Util.runRfcAleatorio("rfcPersonarFisica");
        String rfc = ExcelData.readJsonGlobal("rfcPersonarFisica");
        String rfcAleatorioAmpsd = Util.generarRFCAleatorioConAmpersand();
        this.altaPersonaFisicaUI.getInputModalDoc.sendKeys(rfc);
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAceptar);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAceptar.click();
    }

    @ShotAfter(evidenceName = "Completar Tipologia y Categoria")
    public void completarTipologiaCategoria(String dataBasicTipologia, String categoriaProveedor) {
        Util.waitSpinner(manager.getDriver(),5);
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.activarIframe(manager.getDriver(), "//iframe");
        Util.tab(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputDataBasicTipologia.sendKeys(dataBasicTipologia);
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBasicCategoriaProveedor);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBasicCategoriaProveedor.sendKeys(categoriaProveedor);
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAceptarTipologiaCat);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAceptarTipologiaCat.click();
    }

    @ShotAfter(evidenceName = "Completar Datos Generales")
    public void completarDatosGenerales(String dataGeneralTipoStateProveedor) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Datos Generales')]");
        Util.tab(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputGeneralTipoStateProveedor.sendKeys(dataGeneralTipoStateProveedor);
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.clicBtnAceptarDatosGenerales.click();
    }

    @ShotAfter(evidenceName = "Completar Persona")
    public void completarPersona(String personaNombre, String personaApellido1, String personaApellido2) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Persona')])[3]");
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        if (this.altaPersonaFisicaUI.getInputPersonaNombre.isEnabled()) {
            this.altaPersonaFisicaUI.getInputPersonaNombre.sendKeys(personaNombre);
        } else {
            System.out.println("El campo 'Nombre' no está habilitado.");
        }
        Util.tab(manager.getDriver());
        //Util.explicitWait(3);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        if (this.altaPersonaFisicaUI.getInputApellido1.isEnabled()) {
            this.altaPersonaFisicaUI.getInputApellido1.sendKeys(personaApellido1);
        } else {
            System.out.println("El campo 'Apellido 1' no está habilitado.");
        }
        Util.tab(manager.getDriver());
        //Util.explicitWait(3);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        // Verificar si el campo de apellido 2 está habilitado antes de enviar texto
        if (this.altaPersonaFisicaUI.getInputApellido2.isEnabled()) {
            this.altaPersonaFisicaUI.getInputApellido2.sendKeys(personaApellido2);
        } else {
            System.out.println("El campo 'Apellido 2' no está habilitado.");
        }
    }

    @ShotAfter(evidenceName = "Completar Contacto")
    public void completarContacto(String contactTipoUsoMedioContacto, String contactTipoMedioContacto, String contactValorMedioContacto, String contactNameMedioContacto, String contactApellidoContacto, String contactTipoCargoEmpresa, String contactObservacion) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Contacto')])[1]");
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAnadirContacto);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAnadirContacto.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::h3[contains(text(), 'Datos Contacto')]");
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputContactTipoUsoMedioContacto.sendKeys(contactTipoUsoMedioContacto);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactTipoMedioContacto);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactTipoMedioContacto.sendKeys(contactTipoMedioContacto);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactValorMedioContacto);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactValorMedioContacto.sendKeys(contactValorMedioContacto);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactNameMedioContacto);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactNameMedioContacto.sendKeys(contactNameMedioContacto);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactApellidoContacto);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactApellidoContacto.sendKeys(contactApellidoContacto);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactTipoCargoEmpresa);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactTipoCargoEmpresa.sendKeys(contactTipoCargoEmpresa);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Contacto']/..//input[@id='thpCntW_vldDat']", "dd/MM/yyyy");
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputContactObservacion);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputContactObservacion.sendKeys(contactObservacion);
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicCheckBoxRegistroDefecto);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicCheckBoxRegistroDefecto.click();
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicCheckBoxContactoComprobado);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicCheckBoxContactoComprobado.click();
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicCheckBoxContactoPrioritario);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicCheckBoxContactoPrioritario.click();
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Contacto')])[1]");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.clicBtnConfirmarContacto.click();
    }

    @ShotAfter(evidenceName = "Completar Dirección")
    public void completarDireccion(String direccionTipoDireccion, String direccionPais, String direccionProvincia, String direccionDistrito, String direccionEstado, String direccionCiudad, String direccionCodigoPostal, String direccionDomicilio, String direccionAddress, String direccionNumber, String direccionObservacion) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[1]");
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAnadirDireccion);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAnadirDireccion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[2]");
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputDireccionTipoDireccion.sendKeys(direccionTipoDireccion);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionPais);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionPais.sendKeys(direccionPais);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionProvincia);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionProvincia.sendKeys(direccionProvincia);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionDistrito);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionDistrito.sendKeys(direccionDistrito);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionEstado);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionEstado.sendKeys(direccionEstado);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionCiudad);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionCiudad.sendKeys(direccionCiudad);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionCodigoPostal);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionCodigoPostal.sendKeys(direccionCodigoPostal);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionTipoDomicilio);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionTipoDomicilio.sendKeys(direccionDomicilio);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionAddress);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionAddress.sendKeys(direccionAddress);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionNumber);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionNumber.sendKeys(direccionNumber);
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.clicCheckboxDireccionDefecto.click();
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicCheckboxDireccionDomicilioComprobado);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicCheckboxDireccionDomicilioComprobado.click();
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());

        Util.waitWebElementIsEnabled(30, manager.getDriver(), this.altaPersonaFisicaUI.clicCheckboxDireccionDomicilioFiscal); //Neto
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicCheckboxDireccionDomicilioFiscal.click();
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Dirección']/..//input[@id='thpAdrW_vldDat']", "dd/MM/yyyy");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDireccionObservacion);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDireccionObservacion.sendKeys(direccionObservacion);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[1]");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnConfirmarDireccion);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnConfirmarDireccion.click();

    }

    @ShotAfter(evidenceName = "Completar Documento Alternativo")
    public void completarDocAlternativo(String docAfterTipoDoc, String docAfterDoc, String docAfterPaisDoc, String docAfterObsrDoc) {
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::span[contains(text(), 'Documentos Alternativos')])[1]");
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAnadirDocAlter);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAnadirDocAlter.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Documento Alternativo')])[1]");
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputDocAlterTipoDocumento.sendKeys(docAfterTipoDoc);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDoctAlterDocumento);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDoctAlterDocumento.sendKeys(docAfterDoc);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmIsuDat']", "dd/MM/yyyy");
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.ingresarFechaConAnioSiguiente(manager.getDriver(), "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmExyDat']", "dd/MM/yyyy");
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDocAfterPaisDoc);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDocAfterPaisDoc.sendKeys(docAfterPaisDoc);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.getClicCheckBoxDocAfterDocComprobado.click();
        Util.tab(manager.getDriver());
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Documento Alternativo']/..//input[@name='alrThpDcmCckDat']", "dd/MM/yyyy");
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Documento Alternativo']/..//input[@name='vldDat']", "dd/MM/yyyy");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDocAfterObsrDoc);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDocAfterObsrDoc.sendKeys(docAfterObsrDoc);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::span[contains(text(), 'Documentos Alternativos')])[1]");
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnConfirmarDocAfter.click();

    }

    @ShotAfter(evidenceName = "Completar Documentos Bancarios")
    public void completarDatosBancarios( String dataBankTipoPagoCobro, String dataBankClasePagoCobro,
                                          String dataBankTipoEntidad, String dataBankEntidadBancaria,
                                          String dataBankPais, String dataBankTitular,
                                          String dataBankTipoToken, String dataBankTokenPagoCobro,
                                          String dataBankValorPagoCobro, String dataBankClavePagoCobro,
                                          String dataBankTipoMovimiento, String dataBankTipoMovPagoCobro,
                                          String dataBankMoneda, String dataBankMesVencimiento,
                                          String dataBankAnoVencimiento) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Datos bancarios')]");
        Util.pageStatus(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(),'Datos bancarios')]/../../../..//span[text()='Añadir']");
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnAnadirDataBank.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::h3[contains(text(), 'Datos bancarios')]");
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputDataBankTipoPagoCobro.sendKeys(dataBankTipoPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankClasePagoCobro);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankClasePagoCobro.sendKeys(dataBankClasePagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoEntidad);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankTipoEntidad.sendKeys(dataBankTipoEntidad);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankEntidadBancaria);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankEntidadBancaria.sendKeys(dataBankEntidadBancaria);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankPais);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankPais.sendKeys(dataBankPais);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTitular);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankTitular.sendKeys(dataBankTitular);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoToken);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankTipoToken.sendKeys(dataBankTipoToken);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTokenPagoCobro);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankTokenPagoCobro.sendKeys(dataBankTokenPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankValorPagoCobro);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankValorPagoCobro.sendKeys(dataBankValorPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankClavePagoCobro);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankClavePagoCobro.sendKeys(dataBankClavePagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoMovimiento);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankTipoMovimiento.sendKeys(dataBankTipoMovimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMedioPagoCobro);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankMedioPagoCobro.sendKeys(dataBankTipoMovPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMoneda);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankMoneda.sendKeys(dataBankMoneda);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMesVencimiento);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankMesVencimiento.sendKeys(dataBankMesVencimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankAnoVencimiento);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getInputDataBankAnoVencimiento.sendKeys(dataBankAnoVencimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getClicCheckBoxDataBankPagoCobroValidado);
        //Util.explicitWait(1);
        this.altaPersonaFisicaUI.getClicCheckBoxDataBankPagoCobroValidado.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.CheckBoxMedioPagoCobroDefecto.click();
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.CheckBoxMedioPagoCobroPreferido.click();
        Util.explicitWait(3);
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Datos bancarios']/..//input[@id='oThpPcmForm.cnf.fldT.vldDat.id']", "dd/MM/yyyy");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Datos bancarios')]");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnConfirmarDataBank);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnConfirmarDataBank.click();

    }


    @ShotAfter(evidenceName = "Completar Documentos Bancarios2")
    public void completarDatosBancarios2( String dataBankTipoPagoCobro, String dataBankClasePagoCobro,
                                         String dataBankTipoEntidad, String dataBankEntidadBancaria,
                                         String dataBankPais, String dataBankTitular,
                                         String dataBankTipoToken, String dataBankTokenPagoCobro,
                                         String dataBankValorPagoCobro, String dataBankClavePagoCobro,
                                         String dataBankTipoMovimiento, String dataBankTipoMovPagoCobro,
                                         String dataBankMoneda, String dataBankMesVencimiento,
                                         String dataBankAnoVencimiento) {
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Datos bancarios')]");
        Util.pageStatus(manager.getDriver());
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(),'Datos bancarios')]/../../../..//span[text()='Añadir']");
        Util.waitWebElementIsEnabled(20,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnAnadirDataBank);
        this.altaPersonaFisicaUI.clicBtnAnadirDataBank.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::h3[contains(text(), 'Datos bancarios')]");
        Util.tab(manager.getDriver());
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoPagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankTipoPagoCobro.sendKeys(dataBankTipoPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankClasePagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankClasePagoCobro.sendKeys(dataBankClasePagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoEntidad);
        this.altaPersonaFisicaUI.getInputDataBankTipoEntidad.sendKeys(dataBankTipoEntidad);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankEntidadBancaria);
        this.altaPersonaFisicaUI.getInputDataBankEntidadBancaria.sendKeys(dataBankEntidadBancaria);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankPais);
        this.altaPersonaFisicaUI.getInputDataBankPais.sendKeys(dataBankPais);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTitular);
        this.altaPersonaFisicaUI.getInputDataBankTitular.sendKeys(dataBankTitular);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoToken);
        this.altaPersonaFisicaUI.getInputDataBankTipoToken.sendKeys(dataBankTipoToken);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTokenPagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankTokenPagoCobro.sendKeys(dataBankTokenPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankValorPagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankValorPagoCobro.sendKeys(dataBankValorPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankClavePagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankClavePagoCobro.sendKeys(dataBankClavePagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankTipoMovimiento);
        this.altaPersonaFisicaUI.getInputDataBankTipoMovimiento.sendKeys(dataBankTipoMovimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMedioPagoCobro);
        this.altaPersonaFisicaUI.getInputDataBankMedioPagoCobro.sendKeys(dataBankTipoMovPagoCobro);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMoneda);
        this.altaPersonaFisicaUI.getInputDataBankMoneda.sendKeys(dataBankMoneda);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankMesVencimiento);
        this.altaPersonaFisicaUI.getInputDataBankMesVencimiento.sendKeys(dataBankMesVencimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getInputDataBankAnoVencimiento);
        this.altaPersonaFisicaUI.getInputDataBankAnoVencimiento.sendKeys(dataBankAnoVencimiento);
        Util.tab(manager.getDriver());
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.getClicCheckBoxDataBankPagoCobroValidado);
        this.altaPersonaFisicaUI.getClicCheckBoxDataBankPagoCobroValidado.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Datos bancarios']/..//input[@id='oThpPcmForm.cnf.fldT.vldDat.id']", "dd/MM/yyyy");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Datos bancarios')]");
        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.altaPersonaFisicaUI.clicBtnConfirmarDataBank);
        Util.explicitWait(1);
        this.altaPersonaFisicaUI.clicBtnConfirmarDataBank.click();
    }

    @ShotAfter(evidenceName = "Creación de Persona")
    public void clicCrearPersona() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(5);
        this.altaPersonaFisicaUI.clicCrearPersona.click();
    }

    @ShotAfter(evidenceName = "CP001_Alta de un proveedor cuando el RFC ya existe en otra actividad")
    public void ingresoRfcExistente() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        String rfcExistente = ExcelData.readJsonGlobal("rfcProveedorHijo");
        try {
            Util.activarIframe(manager.getDriver(), "//iframe");
            wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.getInputModalDoc))
                    .sendKeys(rfcExistente);
            Util.pageStatus(manager.getDriver());
            wait.until(ExpectedConditions.elementToBeClickable(altaPersonaFisicaUI.clicBtnAceptar))
                    .click();
            modalAlertDataBasic(rfcExistente);
        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo encontrar un elemento esperado dentro del tiempo especificado.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error durante el ingreso de datos básicos.", e);
        } finally {
            manager.getDriver().switchTo().defaultContent();
        }
    }

    public void modalAlertDataBasic(String rfcExistente) {
        WebDriverWait wait = Util.wait(manager.getDriver());
        try {
            if (Util.isElementVisible(manager.getDriver(), altaPersonaFisicaUI.viewModalAlertDataBasic, 5)) {
                String titulo = wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.viewTitleAlertDataBasic))
                        .getText();
                String mensaje = wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.viewMssgAlertDataBasic))
                        .getText();
                System.out.println("Modal detectado:");
                System.out.println("Título: " + titulo);
                System.out.println("Mensaje: " + mensaje);

                if (mensaje.contains("RFC ya existe")) {
                    System.out.println("El RFC ingresado ya existe: " + rfcExistente);
                } else {
                    System.out.println("El modal no corresponde al RFC duplicado.");
                }
            } else {
                System.out.println("No se detectó ningún modal de alerta.");
            }

        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo encontrar el modal de alerta dentro del tiempo especificado.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error durante la verificación del modal de alerta.", e);
        } finally {
            manager.getDriver().switchTo().defaultContent();
        }
    }


    public void modalAlertDataBasic() {
        WebDriverWait wait = Util.wait(manager.getDriver());
        try {
            if (Util.isElementVisible(manager.getDriver(), altaPersonaFisicaUI.viewModalAlertDataBasic, 5)) {
                String titulo = wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.viewTitleAlertDataBasic))
                        .getText();
                String mensaje = wait.until(ExpectedConditions.visibilityOf(altaPersonaFisicaUI.viewMssgAlertDataBasic))
                        .getText();
                System.out.println("Modal detectado:");
                System.out.println("Título: " + titulo);
                System.out.println("Mensaje: " + mensaje);
            } else {
                System.out.println("No se detectó ningún modal.");
            }

        } catch (TimeoutException e) {
            throw new RuntimeException("No se pudo encontrar un elemento esperado dentro del tiempo especificado.", e);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error durante la verificación del modal de alerta.", e);
        } finally {
            manager.getDriver().switchTo().defaultContent();
        }
    }


    @ShotAfter(evidenceName = "CP002_Validar que ya no se muestre la lupa que está junto a código del documento")
    public void validarQueNoAparezcaIconoSearchDoc() {
        try {
            WebDriverWait wait = Util.wait(manager.getDriver());
            wait.until(ExpectedConditions.invisibilityOf(altaPersonaFisicaUI.IconSearchDoc));
            if (altaPersonaFisicaUI.IconSearchDoc.isDisplayed()) {
                System.out.println("Fallo en la validación: El ícono de lupa todavía es visible.");
                throw new AssertionError("El ícono de lupa está visible cuando no debería.");
            } else {
                System.out.println("Validación exitosa: El ícono de lupa no es visible.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Validación exitosa: El ícono de lupa no está presente en el DOM.");
        } catch (TimeoutException e) {
            System.out.println("Fallo en la validación: El ícono de lupa sigue siendo visible después del tiempo de espera.");
            throw new AssertionError("El ícono de lupa sigue siendo visible después del tiempo de espera.");
        } catch (Exception e) {
            throw new RuntimeException("Ocurrió un error al intentar validar la ausencia del ícono de lupa.", e);
        }
    }

    @ShotAfter(evidenceName = "CP005_Alta de proveedor con dirección de más de ochenta caracteres")
    public void direccionOchentaCaracteres(String direccionTipoDireccion, String direccionDomicilio){
        WebDriverWait wait = Util.wait(manager.getDriver());
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[1]");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(5);
        this.altaPersonaFisicaUI.clicBtnAnadirDireccion.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[2]");
        Util.tab(manager.getDriver());
        //Util.explicitWait(5);
        Util.explicitWait(1);
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        this.altaPersonaFisicaUI.getInputDireccionTipoDireccion.sendKeys(direccionTipoDireccion);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.getInputDireccionTipoDomicilio.sendKeys(direccionDomicilio);
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        String direccionLarga = Util.generarDireccionLarga();
        this.altaPersonaFisicaUI.getInputDireccionAddress.sendKeys(direccionLarga);
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.ingresarFechaActual(manager.getDriver(), "//h3[text()='Dirección']/..//input[@id='thpAdrW_vldDat']", "dd/MM/yyyy");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[1]");
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnConfirmarDireccion.click();
    }

    @ShotAfter(evidenceName = "CP006_Modificar dirección de proveedor con dirección de más de ochenta caractéres")
    public void modificarDireccion(){
        Util.pageStatus(manager.getDriver());
        //Util.waitElementNoVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "(//body/descendant::h3[contains(text(), 'Dirección')])[1]");
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnConfirmarDireccion.click();
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnModificarDireccion.click();
        Util.tab(manager.getDriver());
        Util.explicitWait(3);
        Util.limpiarCampo(altaPersonaFisicaUI.getInputDireccionAddress, null);
        String direccionLarga = Util.generarDireccionLarga();
        this.altaPersonaFisicaUI.getInputDireccionAddress.sendKeys(direccionLarga);
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnConfirmarDireccion.click();
    }

    @ShotAfter(evidenceName = "Clic botón Buscar")
    public void clicBtnBuscar(){
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        this.altaPersonaFisicaUI.clicBtnBuscar.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.waitSpinner(manager.getDriver(),5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.getSelectFilaProveedor.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.altaPersonaFisicaUI.clicBtnConsulta.click();
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        }

    @ShotAfter(evidenceName = "CP007_Consulta proveedor dirección")
    public void consultaProveedorDireccion(){
        WebDriverWait wait = Util.wait(manager.getDriver());
        Util.explicitWait(2);
        Util.waitSpinner(manager.getDriver(),5);
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        boolean modalConsulta = Util.isElementVisible(manager.getDriver(), altaPersonaFisicaUI.modalConsultaProveedor, 5);
        if (modalConsulta) {
            System.out.println("El modal es visible.");
        } else {
            System.out.println("El modal no es visible.");
        }
        List<WebElement> iframes = manager.getDriver().findElements(By.xpath("//iframe"));
        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        if(Util.webElementIsEnabled(3,manager.getDriver(),this.altaPersonaFisicaUI.getSelectFilaConsulta)) {
            this.altaPersonaFisicaUI.getSelectFilaConsulta.click();
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(3);
            this.altaPersonaFisicaUI.clicFilaConsultaAceptar.click();
        } //Mantenimiento Ernesto

        if (!iframes.isEmpty()) {
            Util.activarIframe(manager.getDriver(), "//iframe");
        } else {
            System.err.println("No hay iframes disponibles en la página actual.");
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.scrollToElement(manager.getDriver(), "//body/descendant::span[contains(text(), 'Dirección')]");
    }

}

