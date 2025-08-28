package com.nttdata.ct.web.task;

import com.nttdata.ct.web.Util;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import com.nttdata.ct.web.evidence.aspect.method.ShotAfter;
import com.nttdata.ct.web.lib.DriverManager;
import com.nttdata.ct.web.ui.SiniestrosDMPUI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Task
public class SiniestrosDMPTask {

    @Autowired
    public DriverManager manager;

    @Autowired
    public SiniestrosDMPUI siniestrosDMPUI;


    @ShotAfter(evidenceName = "Ingresar Información de Siniestro")
    public void ingresarInfoSiniestro(String riesgo){
        WebDriverWait wait = new WebDriverWait(manager.getDriver(), Duration.ofSeconds(60));

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.siniestrosDMPUI.fechaSiniestro.clear();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        formattedDate = formattedDate.replace("-","");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        //this.siniestrosDMPUI.fechaSiniestro.sendKeys(formattedDate);
        this.siniestrosDMPUI.fechaSiniestro.sendKeys("11/08/2025");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.siniestrosDMPUI.horaSiniestro.sendKeys("08:00 AM");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("Siniestro");
        Util.explicitWait(1);

        String jsonPoliza = ExcelData.readJsonIndividual();
        if (jsonPoliza != null){
            this.siniestrosDMPUI.numPoliza.sendKeys(jsonPoliza);
            System.out.println("La poliza es:"+jsonPoliza);
        } else {
            this.siniestrosDMPUI.numPoliza.sendKeys(datosSiniestro.get(0));
        }

        //this.siniestrosDMPUI.numPoliza.sendKeys(datosSiniestro.get(0));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnBuscar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        this.siniestrosDMPUI.inputRiesgo.clear();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.siniestrosDMPUI.inputRiesgo.sendKeys(datosSiniestro.get(1));
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnAceptar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);
        Util.scrollDown(manager.getDriver(),"400");
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(3);


        //button[contains(@class, 'btn-default') and contains(@class, 'btn-icon-textless-search')]

        Util.waitWebElementIsEnabled(15,manager.getDriver(),this.siniestrosDMPUI.liMotivoSiniestro);
        this.siniestrosDMPUI.liMotivoSiniestro.click();
        Util.explicitWait(1);
        WebElement opcTipoPais = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@title='"+riesgo+"']")));
        opcTipoPais.click();Util.explicitWait(1);
        this.siniestrosDMPUI.btnAceptarOpc.click();


//        Util.explicitWait(1);//1/2
//        WebElement opcTipoUso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='"+riesgo+"']")));
//        opcTipoUso.click();
//        Util.explicitWait(1);//1/2


//        List<WebElement> inputsMotivo = manager.getDriver().findElements(By.xpath("//input[@id='lssRsnVal']"));
//        for(WebElement we : inputsMotivo){
//            try{
//                we.sendKeys(datosSiniestro.get(2));
//                Util.pageStatus(manager.getDriver());
//                Util.explicitWait(1);
//                break;
//            }catch (Exception ex){
//                System.out.println("Exc"+ ex);
//            }
//        }


        //this.siniestrosDMPUI.inputMotivoSiniestro.sendKeys(datosSiniestro.get(2));


        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        if(!datosSiniestro.get(3).equals("5")) {
            this.siniestrosDMPUI.inpTipoRelacion.sendKeys(datosSiniestro.get(3));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inpTipoDocto.sendKeys(datosSiniestro.get(4));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inpDocumento.sendKeys(datosSiniestro.get(5));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inputNombre.sendKeys(datosSiniestro.get(6));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inputApellidos.sendKeys(datosSiniestro.get(7));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inpNumTelefono.sendKeys(datosSiniestro.get(8));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inpNumMovil.sendKeys(datosSiniestro.get(9));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
            this.siniestrosDMPUI.inpCorreo.sendKeys(datosSiniestro.get(10));
        }else {
            this.siniestrosDMPUI.inpTipoRelacion.sendKeys(datosSiniestro.get(3));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(3);
            this.siniestrosDMPUI.inpNumTelefono.sendKeys(datosSiniestro.get(8));
            Util.pageStatus(manager.getDriver());
            Util.explicitWait(1);
        }
        this.siniestrosDMPUI.btnVerificar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);

        List<WebElement> errores = manager.getDriver().findElements(By.xpath("//h1[contains(text(),'Tiene errores')]"));
        if(errores.size()!=0){
            Assert.assertFalse("Error al validar la informacion",true);
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnSiguiente.click();
    }


    @ShotAfter(evidenceName = "Seleccionar Consecuencia")
    public void seleccionarConsecuencias(String consecuencias){
        String [] expediente = consecuencias.split(",");
        int tamanio = expediente.length;
        for(int i=0;i<tamanio;i++){
            switch (expediente[i]){
                case "DMP":
                    this.siniestrosDMPUI.chkDanosVehiculoAsegurado.click();
                    Util.pageStatus(manager.getDriver());
                    Util.explicitWait(1);
                    break;
                case "DJA":
                    this.siniestrosDMPUI.chkDefensaJuridica.click();
                    Util.pageStatus(manager.getDriver());
                    Util.explicitWait(2);
                    break;
                case "DCP":
                    this.siniestrosDMPUI.chkRoturaCristal.click();
                    Util.pageStatus(manager.getDriver());
                    Util.explicitWait(2);
                    break;
                case "LEO":

                    if(!this.siniestrosDMPUI.chkLesionadosAsegurado.isSelected()){  //Modificado Ernesto
                    //if(!this.siniestrosDMPUI.chkConductorLesionado.isSelected()){
                        this.siniestrosDMPUI.chkLesionadosAsegurado.click();
                        Util.pageStatus(manager.getDriver());
                        Util.explicitWait(2);
                    }else if(!this.siniestrosDMPUI.chkConductorLesionado.isSelected()){ //Modificado Ernesto
                    //}else if(!this.siniestrosDMPUI.chkLesionadosAsegurado.isSelected()){
                        this.siniestrosDMPUI.chkConductorLesionado.click();
                        Util.pageStatus(manager.getDriver());
                        Util.explicitWait(2);
                    }else{
                        System.out.println("Lesionados ya seleccionados");
                    }
                    break;
                case "GSR":
                    this.siniestrosDMPUI.chkDanosVehiculoAsegurado.click();
                    Util.pageStatus(manager.getDriver());
                    Util.explicitWait(1);
                    break;

                default:
                    System.out.println("Opción no valida: "+expediente[i]);
            }
        }
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(1);
        this.siniestrosDMPUI.btnSelectCbx.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnVerificar.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);

        List<WebElement> errores = manager.getDriver().findElements(By.xpath("//label[contains(text(),'OBLIGATORIO SELECCIONAR')]"));
        if(errores.size()!=0){
            Assert.assertFalse("Error al validar la informacion",true);
        }
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnSiguiente.click();
    }

    @ShotAfter(evidenceName = "Información Relato")
    public void relatosiniestroDMP() {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);//*[contains(text(),'Aceptar')]
        //Util.scrollToElement(manager.getDriver(), "//textarea[@name='cisTxtVal']");


        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Relato:')]");
        Util.scrollDown(manager.getDriver(),"-200");
        this.siniestrosDMPUI.txtRelato.sendKeys("RELATO SINIESTRO");
        Util.pageStatus(manager.getDriver());
        //Util.scrollToElement(manager.getDriver(), "//textarea[@name='dmgDspVal']");
        this.siniestrosDMPUI.txtDescripcion.sendKeys("DESCRIPCION SINIESTRO");
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Observaciones Relato:')]");
        Util.scrollDown(manager.getDriver(),"-200");
        //Util.scrollToElement(manager.getDriver(), "//textarea[@name='cisObsVal']");
        this.siniestrosDMPUI.txtObsRelato.sendKeys("OBSERVACION RELATO");
    }

    public void aceptarrelatosiniestroDMP() {
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.btnAceptarGlobal.click();
    }


    @ShotAfter(evidenceName = "Ubicación del Siniestro")
    public void ubicacionsiniestro() {
        Util.scrollDown(manager.getDriver(),"-300");
        //Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Ubicacin del Siniestro')]");
        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtCodPais.sendKeys(datosSiniestro.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodEstado.sendKeys(datosSiniestro.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodPoblacion.sendKeys(datosSiniestro.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCalle.sendKeys(datosSiniestro.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtColonia.sendKeys(datosSiniestro.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEntreCalles.sendKeys(datosSiniestro.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtReferencia.sendKeys(datosSiniestro.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodPostal.sendKeys(datosSiniestro.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtLatitud.sendKeys(datosSiniestro.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtLongitud.sendKeys(datosSiniestro.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtUbiVia.sendKeys(datosSiniestro.get(10));
        Util.explicitWait(1);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDirA.sendKeys(datosSiniestro.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }


    @ShotAfter(evidenceName = "Datos del Conductor")
    public void datosconductor() {
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Tipo Documento:')]");
        Util.scrollDown(manager.getDriver(),"-100");

        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNombreCond.sendKeys(datosSiniestro.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoPaternoCond.sendKeys(datosSiniestro.get(13));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoMaternoCond.sendKeys(datosSiniestro.get(14));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEdadCond.sendKeys(datosSiniestro.get(15));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNumLicenciaCond.sendKeys(datosSiniestro.get(16));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEstadoLicenciaCond.sendKeys(datosSiniestro.get(17));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoLicenciaCond.sendKeys(datosSiniestro.get(18));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPermanente.sendKeys(datosSiniestro.get(19));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtFechaVigencia.sendKeys(datosSiniestro.get(20));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Circunstancias Siniestro")
    public void circunstancias() {
        Util.pageStatus(manager.getDriver());
        //Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Tipo Documento:')]");
        //Util.scrollDown(manager.getDriver(),"-100");

        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtCircunstancia.sendKeys(datosSiniestro.get(21));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtSuceso.sendKeys(datosSiniestro.get(22));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

    }
    @ShotAfter(evidenceName = "Vehiculo Asegurado")
    public void vehiculoAsegurado(String consecuencias) {
        Util.pageStatus(manager.getDriver());
        //Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Tipo Documento:')]");
        //Util.scrollDown(manager.getDriver(),"-100");

        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNumPlaca.sendKeys(datosSiniestro.get(23));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtColorEst.sendKeys(datosSiniestro.get(24));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        String [] expediente = consecuencias.split(",");
        int tamanio = expediente.length;
        for(int i=0;i<tamanio;i++){
            switch (expediente[i]){
                case "DED":
                    this.siniestrosDMPUI.txtConCosto.sendKeys(datosSiniestro.get(25));
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());

                    if(datosSiniestro.get(25).equals("N")){
                        this.siniestrosDMPUI.txtCausaCierreSinCosto.sendKeys(datosSiniestro.get(26));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());
                    }
                    break;
            }
        }

    }

    @ShotAfter(evidenceName = "Datos del ajustador")
    public void datosajustador(String consecuencias) {
        Util.pageStatus(manager.getDriver());
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Datos para ajuste')]");
        Util.scrollDown(manager.getDriver(),"-200");

        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);

        String [] expediente = consecuencias.split(",");
        int tamanio = expediente.length;
        boolean leoEjecutado = false; // Variable para controlar la ejecución
        int Leo = 0;

        for(int i=0;i<tamanio;i++){
            switch (expediente[i]){
                case "LEO":
                    if (!leoEjecutado) {
                        this.siniestrosDMPUI.txtLesionados.sendKeys(datosSiniestro.get(27));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());
                        this.siniestrosDMPUI.txtVehiculoPuedeCircular.sendKeys(datosSiniestro.get(28));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());
                        this.siniestrosDMPUI.txtVehiculoEstabaEstacionado.sendKeys(datosSiniestro.get(29));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());
                        this.siniestrosDMPUI.txtHayOtroInvolucrado.sendKeys(datosSiniestro.get(30));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());
                        this.siniestrosDMPUI.txtEsCuentaEspecial.sendKeys(datosSiniestro.get(31));
                        Util.tab(manager.getDriver());
                        Util.pageStatus(manager.getDriver());

                        numerolsionadosVehiculoAsegurado("LEOVehiculoAsegurado");
                        Util.explicitWait(5);
                        Util.scrollDown(manager.getDriver(), "-500");

                        //numeroVehiculoTercero();


                        leoEjecutado = true; // Marcar como ejecutado
                    }
                    if (Leo>=1){
                        numerolsionadosVehiculoAsegurado("LEO2VehiculoAsegurado");
                    }

                    Leo++;

                    break;
            }
        }
        Util.explicitWait(2);

    }

    @ShotAfter(evidenceName = "Información de Cita")
    public void cita() {
        Util.pageStatus(manager.getDriver());
        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosSiniestros");
        Util.explicitWait(2);


        this.siniestrosDMPUI.txtCita.sendKeys(datosSiniestro.get(32));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        if(datosSiniestro.get(32).equals("S")) {
            this.siniestrosDMPUI.txtHoraDeLaCita.sendKeys(datosSiniestro.get(33));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            this.siniestrosDMPUI.txtMismaUbicacionDelSiniestroCita.sendKeys(datosSiniestro.get(34));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
            this.siniestrosDMPUI.txtFechaDeCita.sendKeys(datosSiniestro.get(35));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtEstadoCita.sendKeys(datosSiniestro.get(36));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtPoblacionCita.sendKeys(datosSiniestro.get(37));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtCalleYNoCita.sendKeys(datosSiniestro.get(38));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtColoniaCita.sendKeys(datosSiniestro.get(39));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtEntreCallesCita.sendKeys(datosSiniestro.get(40));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtReferenciaCita.sendKeys(datosSiniestro.get(41));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtCodigoPostalCita.sendKeys(datosSiniestro.get(42));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtLatitudCita.sendKeys(datosSiniestro.get(43));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtLongitudCita.sendKeys(datosSiniestro.get(44));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtObservacionesCita.sendKeys(datosSiniestro.get(45));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            this.siniestrosDMPUI.txtEstadoDeLaCita.sendKeys(datosSiniestro.get(46));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            Util.explicitWait(2);

        }


            this.siniestrosDMPUI.txtTipoAjuste.sendKeys(datosSiniestro.get(47));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());

            Util.explicitWait(2);





    }

    @ShotAfter(evidenceName = "Finalizar Datos del Siniestro")
    public void finalizardatossiniestro() {
        Util.pageStatus(manager.getDriver());

        //Util.scrollToElement(manager.getDriver(), "//span[@class='ng-binding' and contains(text(), 'Verificar')]");
        Util.scrollDown(manager.getDriver(),"400");

        this.siniestrosDMPUI.btnVerificarDatosDelSiniestro.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosDelSiniestro.click();
        Util.explicitWait(2);
    }


    @ShotAfter(evidenceName = "Llenar Datos Complementarios")
    public void llenardatoscomplementarios(String consecuencias) {

        String [] expediente = consecuencias.split(",");
        int tamanio = expediente.length;
        for(int i=0;i<tamanio;i++){
            switch (expediente[i]){
                case "DMP":
                    DMP();

                    break;
                case "DCP":
                    DCP();
                    break;
                case "DJA":

                    break;
                case "LEO":

                    break;
                default:
                    System.out.println("Opción no valida: "+expediente[i]);
            }
        }

    }
    @ShotAfter(evidenceName = "Finalizar Siniestro")
    public void finalizarsiniestro(String consecuencias) {
        Util.pageStatus(manager.getDriver());
        Util.waitWebElementIsEnabled(10,manager.getDriver(),this.siniestrosDMPUI.btnVerificarDatosGlobal);
        this.siniestrosDMPUI.btnVerificarDatosGlobal.click();
        Util.explicitWait(3);
        this.siniestrosDMPUI.btnFinalizarGlobal.click();
        Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']/descendant::label[1]")));

        this.siniestrosDMPUI.labelNoEmision.isEnabled();
        String noPoliza = this.siniestrosDMPUI.labelNoEmision.getText();
        String noPoliza1 = noPoliza.replace("EL SINIESTRO ", "");
        String noPoliza2 = noPoliza1.replace("SE HA CREADO CORRECTAMENTE.", "");
        ExcelData.writeJsonSiniestroDMP("Poliza_"+consecuencias, noPoliza2);
        Util.explicitWait(2);
        System.out.println("Poliza:"+noPoliza2);
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarSiniestro.click();
        Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    }





    public void DCP() {
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.menuDaniosPropiosCristales.click();
        Util.explicitWait(3);

        ArrayList<String> datosLEO = ExcelData.readExcelSiniestros("LEOVehiculoAsegurado");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.sendKeys(datosLEO.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConElContratanteLEOAseg.sendKeys(datosLEO.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMedioDeContactoLEOAseg.sendKeys(datosLEO.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTelefono1LEOAseg.sendKeys(datosLEO.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEmailLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtEmailLEOAseg.sendKeys(datosLEO.get(4));

        ArrayList<String> datosDMP = ExcelData.readExcelSiniestros("DPC");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtTipoDeAtencionDPC.sendKeys(datosDMP.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtActividadDeAtencionDPC.sendKeys(datosDMP.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoCdrDPC.sendKeys(datosDMP.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodigoTerceroDPC.sendKeys(datosDMP.get(3));
        Util.pageStatus(manager.getDriver());

        Util.scrollDown(manager.getDriver(), "200");
        this.siniestrosDMPUI.btnNumeroDeCristalesDPC.click();
        Util.explicitWait(4);

        // Desplazarse hasta el elemento "Añadir"
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Añadir')]");
        Util.scrollDown(manager.getDriver(), "-100");
// Verificar si el botón "Añadir" está presente en el DOM
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));
        if (addButton.isDisplayed()) {
            System.out.println("El elemento está en el DOM.");
            // Hacer clic en el botón "Añadir"
            addButton.click();
        } else {
            System.out.println("No está");
        }
        Util.explicitWait(2);

        this.siniestrosDMPUI.txtTipoCristalDPC.sendKeys(datosDMP.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        //Desplazarse hasta el elemento verificar
        Util.scrollToElement(manager.getDriver(), "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']");
        Util.scrollDown(manager.getDriver(),"-200");
        Util.explicitWait(1);

        this.siniestrosDMPUI.btnVerificarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnConfirmarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosVehiculoTercero.click();
        Util.explicitWait(2);

        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(3);
        //Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Daos')]");
        Util.explicitWait(2);


        this.siniestrosDMPUI.txtMarcaDeducibleDPC.sendKeys(datosDMP.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtFechaDelServicioPrestadoDPC.sendKeys(datosDMP.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtHoraDelServicioPrestadoDPC.sendKeys(datosDMP.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtRequirioDPC.sendKeys(datosDMP.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtTipoDPC.sendKeys(datosDMP.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtCodigoDeProveedorDPC.sendKeys(datosDMP.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtPosibleFraudeDPC.sendKeys(datosDMP.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtIqrDPC.sendKeys(datosDMP.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Transversal')]");
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnVerificarDatosDelSiniestro.click();
        Util.explicitWait(3);
        this.siniestrosDMPUI.btnAceptarDatosDelSiniestro.click();



    }


    public void DMP(){
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.menuDaniosMateriales.click();
        Util.explicitWait(3);

        ArrayList<String> datosLEO = ExcelData.readExcelSiniestros("LEOVehiculoAsegurado");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.sendKeys(datosLEO.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConElContratanteLEOAseg.sendKeys(datosLEO.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMedioDeContactoLEOAseg.sendKeys(datosLEO.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTelefono1LEOAseg.sendKeys(datosLEO.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEmailLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtEmailLEOAseg.sendKeys(datosLEO.get(4));

        ArrayList<String> datosDMP = ExcelData.readExcelSiniestros("DMP");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtDireccionImpacto.sendKeys(datosDMP.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMagnitud.sendKeys(datosDMP.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.btnNumeroDanios.click();
        Util.explicitWait(3);

        // Desplazarse hasta el elemento "Añadir"
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Añadir')]");
        Util.scrollDown(manager.getDriver(), "-300");
// Verificar si el botón "Añadir" está presente en el DOM
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));
        if (addButton.isDisplayed()) {
            System.out.println("El elemento está en el DOM.");
            // Hacer clic en el botón "Añadir"
            addButton.click();
        } else {
            System.out.println("No está");
        }

        agregardanio("Danios");

        //Desplazarse hasta el elemento verificar
        Util.scrollToElement(manager.getDriver(), "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']");
        Util.scrollDown(manager.getDriver(),"-200");
        Util.explicitWait(1);

        this.siniestrosDMPUI.btnVerificarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnConfirmarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosVehiculoTercero.click();
        Util.explicitWait(2);

        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(3);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Daos')]");
        Util.explicitWait(2);

        this.siniestrosDMPUI.txtEnCola.sendKeys(datosDMP.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRequirio.sendKeys(datosDMP.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoGrua.sendKeys(datosDMP.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodDeProveedor.sendKeys(datosDMP.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtVcAlMomentoDelSiniestro.sendKeys(datosDMP.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEstimacionDeLosDaos.sendKeys(datosDMP.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPagoEnCrucero.sendKeys(datosDMP.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtResponsabilidad.sendKeys(datosDMP.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtAplicaRecuperacion.sendKeys(datosDMP.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMarcaDeducible.sendKeys(datosDMP.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDeducibleAdicionalPorPen.sendKeys(datosDMP.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Transversal')]");
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnVerificarDatosDelSiniestro.click();
        Util.explicitWait(3);
        this.siniestrosDMPUI.btnAceptarDatosDelSiniestro.click();



    }





    // Este metodo se usa cuando se apertura un Numero Lesionado Vehiculo Asegurado (LEO)
    @ShotAfter(evidenceName = "Datos Leo")
    public void numerolsionadosVehiculoAsegurado(String leo) {
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.btnNumeroLesionadosAseurado.click();
        Util.explicitWait(3);

        // Desplazarse hasta el elemento "Añadir"
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Añadir')]");
        Util.scrollDown(manager.getDriver(), "-300");


// Verificar si el botón "Añadir" está presente en el DOM
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));

        if (addButton.isDisplayed()) {
            System.out.println("El elemento está en el DOM.");
            // Hacer clic en el botón "Añadir"
            addButton.click();
        } else {
            System.out.println("No está");
        }

        ArrayList<String> datosLEO = ExcelData.readExcelSiniestros(leo);
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.sendKeys(datosLEO.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConElContratanteLEOAseg.sendKeys(datosLEO.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMedioDeContactoLEOAseg.sendKeys(datosLEO.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTelefono1LEOAseg.sendKeys(datosLEO.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEmailLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtEmailLEOAseg.sendKeys(datosLEO.get(4));




        this.siniestrosDMPUI.txtRequiereLEOAseg.sendKeys(datosLEO.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        if(datosLEO.get(5).equals("S")) {
            this.siniestrosDMPUI.txtCodProveedorAmbulanciaLEOAseg.sendKeys(datosLEO.get(6));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Lesionado')]");
        Util.scrollDown(manager.getDriver(), "-300");

        this.siniestrosDMPUI.txtNumeroDeOcupantes.sendKeys(datosLEO.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());


        if(datosLEO.get(8).equals("S")){
            this.siniestrosDMPUI.txtCabezaCara.clear();
            Util.explicitWait(1);
            this.siniestrosDMPUI.txtCabezaCara.sendKeys(datosLEO.get(8));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        if(datosLEO.get(9).equals("S")) {
            this.siniestrosDMPUI.txtCuello.clear();
            this.siniestrosDMPUI.txtCuello.sendKeys(datosLEO.get(9));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        if(datosLEO.get(10).equals("S")) {
            this.siniestrosDMPUI.txtTorax.clear();
            this.siniestrosDMPUI.txtTorax.sendKeys(datosLEO.get(10));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        if(datosLEO.get(11).equals("S")) {
            this.siniestrosDMPUI.txtExtremidadesSuperiores.clear();
            this.siniestrosDMPUI.txtExtremidadesSuperiores.sendKeys(datosLEO.get(11));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        if(datosLEO.get(12).equals("S")) {
            this.siniestrosDMPUI.txtExtremidadesInferiores.clear();
            this.siniestrosDMPUI.txtExtremidadesInferiores.sendKeys(datosLEO.get(12));
            Util.tab(manager.getDriver());
            Util.pageStatus(manager.getDriver());
        }

        this.siniestrosDMPUI.txtLesionGravedad.sendKeys(datosLEO.get(13));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConContratante.sendKeys(datosLEO.get(14));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPosicionEnElAuto.sendKeys(datosLEO.get(15));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoDeDocumento.sendKeys(datosLEO.get(16));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodigoDeDocumento.sendKeys(datosLEO.get(17));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNombre.sendKeys(datosLEO.get(18));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoPaterno.sendKeys(datosLEO.get(19));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoMaterno.sendKeys(datosLEO.get(20));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtFechaDeNacimiento.sendKeys(datosLEO.get(21));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEdad.sendKeys(datosLEO.get(22));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtLesionesCorresAlSiniestro.sendKeys(datosLEO.get(23));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtGenero.sendKeys(datosLEO.get(24));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoEstimadoDeLesion.sendKeys(datosLEO.get(25));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());


        // Desplazarse hasta el elemento verificar
        Util.scrollToElement(manager.getDriver(), "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']");
        Util.scrollDown(manager.getDriver(),"-200");
        Util.explicitWait(1);

        this.siniestrosDMPUI.btnVerificarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnConfirmarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosVehiculoTercero.click();
        Util.explicitWait(2);

        //Util.waitWebElementIsEnabled(15,manager.getDriver(),this.siniestrosDMPUI.txtCita);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(5);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Número Lesionados Vehi. Aseg.:')]");
        Util.explicitWait(2);
        //Util.scrollDown(manager.getDriver(),"-400");
    }


    // Este metodo se usa cuando se le pega a alguien más
    public void numeroVehiculoTercero() {
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.btnNumeroVehiculoTercero.click();
        Util.explicitWait(3);

        // Desplazarse hasta el elemento "Añadir"
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Añadir')]");
        Util.scrollDown(manager.getDriver(), "-300");

// Verificar si el botón "Añadir" está presente en el DOM
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));

        if (addButton.isDisplayed()) {
            System.out.println("El elemento está en el DOM.");
            // Hacer clic en el botón "Añadir"
            addButton.click();
        } else {
            System.out.println("No está");
        }

        ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DatosVehiculoTercero");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtTipoDocumento.sendKeys(datosSiniestro.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodigoDocumento.sendKeys(datosSiniestro.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNombreCompleto.sendKeys(datosSiniestro.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConConductor.sendKeys(datosSiniestro.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMedioContacto.sendKeys(datosSiniestro.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTelefono.sendKeys(datosSiniestro.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEmail.sendKeys(datosSiniestro.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        // Desplazarse hasta el elemento
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Nombre/razón Social:')]");
        Util.scrollDown(manager.getDriver(), "-200");

        this.siniestrosDMPUI.txtNombreRazonTercero.sendKeys(datosSiniestro.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtAppTercero.sendKeys(datosSiniestro.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApmTercero.sendKeys(datosSiniestro.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNumLicenciaTercero.sendKeys(datosSiniestro.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEstadoLicenciaTercero.sendKeys(datosSiniestro.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoPersonaTercero.sendKeys(datosSiniestro.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCircunstanciaTercero.sendKeys(datosSiniestro.get(13));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoLicenciaTercero.sendKeys(datosSiniestro.get(14));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPermanenteTercero.sendKeys(datosSiniestro.get(15));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtFechaVigenciaTercero.sendKeys(datosSiniestro.get(16));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtResponsabilidadTercero.sendKeys(datosSiniestro.get(17));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoConvenioTercero.sendKeys(datosSiniestro.get(18));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDescripcionDanioTercero.sendKeys(datosSiniestro.get(19));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        // Desplazarse hasta el elemento
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Costado Trasero Derecho :')]");
        Util.scrollDown(manager.getDriver(), "-300");

        agregardanio("Danios");


        // Desplazarse hasta el elemento
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Descripcion Marca :')]");
        Util.scrollDown(manager.getDriver(),"-200");

        this.siniestrosDMPUI.txtTipo.sendKeys(datosSiniestro.get(20));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMarca.sendKeys(datosSiniestro.get(21));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDescripcionMarca.sendKeys(datosSiniestro.get(22));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtModelo.sendKeys(datosSiniestro.get(23));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDescripcionModelo.sendKeys(datosSiniestro.get(24));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtSubmodelo.sendKeys(datosSiniestro.get(25));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDescripcionSubModelo.sendKeys(datosSiniestro.get(26));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtAnio.sendKeys(datosSiniestro.get(27));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtColor.sendKeys(datosSiniestro.get(28));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNumeroDeSerie.sendKeys(datosSiniestro.get(29));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPlacas.sendKeys(datosSiniestro.get(30));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtUso.sendKeys(datosSiniestro.get(31));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEnCorralon.sendKeys(datosSiniestro.get(32));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEstimacionDeLosDanios.sendKeys(datosSiniestro.get(33));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

// Desplazarse hasta el elemento verificar
        Util.scrollToElement(manager.getDriver(), "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']");
        Util.scrollDown(manager.getDriver(),"-200");
        Util.explicitWait(1);

        this.siniestrosDMPUI.btnVerificarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnConfirmarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosVehiculoTercero.click();
        Util.explicitWait(2);

    }

    public void agregardanio(String danio) {
        ArrayList<String> datosDanio = ExcelData.readExcelSiniestros(danio);

        // Verificar si el valor para cada campo es "SI" y capturar los datos correspondientes
        String[] campos = {
                "txtCostadoTraseroDerecho",
                "txtCostadoTraseroIzquierdo",
                "txtCristalPuertaDelanteraDer",
                "txtCristalPuertaDelanteraIzq",
                "txtCristalPuertaTraseraDerecha",
                "txtCristalPuertaTraseraIzq",
                "txtMarcoRadiador",
                "txtEspejoLateralDerecho",
                "txtEspejoLateralIzquierdo",
                "txtEstribo",
                "txtFarosDelanteros",
                "txtFarosTraseros",
                "txtFaciaDelantera",
                "txtFaciaTrasera",
                "txtLateralDerecho",
                "txtLateralIzquierdo",
                "txtMecanicaPorColision",
                "txtMedallon",
                "txtParabrisas",
                "txtParrilla",
                "txtPartesBajas",
                "txtPisoCajuela",
                "txtPostes",
                "txtPuertaDelanteraDerecha",
                "txtPuertaDelanteraIzquierda",
                "txtPuertaTraseraDerecha",
                "txtPuertaTraseraIzquierda",
                "txtSalpicaderaDelanteraDerecha",
                "txtSalpicaderaDelanteraIzq",
                "txtSalpicaderaTraseraDerecha",
                "txtSalpicaderaTraseraIzquierda",
                "txtTapaCajuela",
                "txtToldo",
                "txtTolvaDeEscape",
                "txtTolvaDeParabrisas"
        };

        for (int i = 0; i < campos.length; i++) {
            if (datosDanio.get(i).equals("SI")) {
                try {
                    // Obtener el campo correspondiente usando reflexión
                    WebElement campo = (WebElement) this.siniestrosDMPUI.getClass().getField(campos[i]).get(this.siniestrosDMPUI);
                    campo.clear();
                    Util.explicitWait(1);
                    campo.sendKeys(datosDanio.get(i));
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace(); // Manejo de excepciones si el campo no existe
                }
            }
        }

    }





    /*******************************
     * Crear Expediente
     * ******************************/

    @ShotAfter(evidenceName = "Apertura de expediente")
    public void crearexpediente(String consecuencias) {
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(1);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(3);
        Util.activarIframe(manager.getDriver(), "//iframe");
        Util.explicitWait(1);
        String [] expediente = consecuencias.split(",");
        int tamanio = expediente.length;
        int Leo = 0;



        for(int i=0;i<tamanio;i++){
            switch (expediente[i]){
                case "DMP":
                    this.siniestrosDMPUI.btnDMP.click();
                    Util.explicitWait(2);
                    this.siniestrosDMPUI.btnSiguiente.click();
                    aperturaexpediente();
                    finalizaraperturaexpediente();
                    break;
                case "DCP":
                    this.siniestrosDMPUI.btnDCP.click();
                    Util.explicitWait(2);
                    this.siniestrosDMPUI.btnSiguiente.click();
                    aperturaexpediente();

                    expedienteDCP();
                    finalizaraperturaexpedientecristales();

                    break;
                case "DJA":
                    this.siniestrosDMPUI.btnDJA.click();
                    Util.explicitWait(2);
                    this.siniestrosDMPUI.btnSiguiente.click();
                    aperturaexpediente();
                    ArrayList<String> datosSiniestro = ExcelData.readExcelSiniestros("DJA");
                    Util.explicitWait(2);
                    this.siniestrosDMPUI.txtAbogado.sendKeys(datosSiniestro.get(0));
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());
                    this.siniestrosDMPUI.txtFechaAsignacion.sendKeys(datosSiniestro.get(1));
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());
                    this.siniestrosDMPUI.txtHoraAsignacion.clear();
                    Util.explicitWait(1);
                    this.siniestrosDMPUI.txtHoraAsignacion.sendKeys(datosSiniestro.get(2));
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());

                    finalizaraperturaexpediente();

                    break;
                case "LEO":
                    if (Leo==0) { // Información para el Primer LEO
                        this.siniestrosDMPUI.btnLEO.click();
                        Util.explicitWait(2);
                        this.siniestrosDMPUI.btnSiguiente.click();
                        aperturaexpediente();
                        expedienteLEO("1","LEOVehiculoAsegurado","DMP");
                        finalizaraperturaexpediente();
                    }
                    else if (Leo==1){ //Información para el Segundo LEO
                        this.siniestrosDMPUI.btnLEO.click();
                        Util.explicitWait(2);
                        this.siniestrosDMPUI.btnSiguiente.click();
                        aperturaexpediente();
                        expedienteLEO("2","LEO2VehiculoAsegurado","DMP");
                        finalizaraperturaexpediente();
                    }
                    Leo++;


                    break;
                case "DED":
                    this.siniestrosDMPUI.liPaginas.click();
                    Util.scrollDown(manager.getDriver(),"100");
                    Util.explicitWait(1);

                    this.siniestrosDMPUI.btnDED.click();
                        Util.explicitWait(2);
                        this.siniestrosDMPUI.btnSiguiente.click();

                        this.siniestrosDMPUI.txtNumeroExpediente.sendKeys("1");
                    Util.tab(manager.getDriver());
                    Util.pageStatus(manager.getDriver());

                        aperturaexpediente();

                        expedienteDED();

                    finalizaraperturaexpediente();
                    break;
                default:
                    System.out.println("Opción no valida: "+expediente[i]);
            }
        }
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosDMPUI.btnFinalizar.click();
        Util.waitWebElementIsEnabled(10,manager.getDriver(),this.siniestrosDMPUI.txtMensajeTerminarAperturaExp);
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnAceptarGlobal.click();
        Util.explicitWait(1);

    }

    @ShotAfter(evidenceName = "Información de Apertura DED")
    public void expedienteDED(){
        ArrayList<String> ExpLEO = ExcelData.readExcelSiniestros("ExpDED");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtDeducibleResponsable.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtDeducibleResponsable.sendKeys(ExpLEO.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoDeducibleResponsable.sendKeys(ExpLEO.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDeduciblePorConductorUni.sendKeys(ExpLEO.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoPorDedConductorUni.sendKeys(ExpLEO.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDeduciblePorDesbielamiento.sendKeys(ExpLEO.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoPorDedDesbielamiento.sendKeys(ExpLEO.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDeduciblePorInspeccionOtros.sendKeys(ExpLEO.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoPorDedInspeccionOtros.sendKeys(ExpLEO.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMontoTotalDeducible.sendKeys(ExpLEO.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtDeducibleAdministrativo.sendKeys(ExpLEO.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtIqr.sendKeys(ExpLEO.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtFraude.sendKeys(ExpLEO.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Información de Apertura DPC")
    public void expedienteDCP(){
        Util.scrollDown(manager.getDriver(), "200");
        ArrayList<String> datosDPC = ExcelData.readExcelSiniestros("DPC");
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtTipoDeAtencionDPC.sendKeys(datosDPC.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtActividadDeAtencionDPC.sendKeys(datosDPC.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoCdrDPC.sendKeys(datosDPC.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodigoTerceroDPC.sendKeys(datosDPC.get(3));
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.btnNumeroDeCristalesDPC.click();
        Util.explicitWait(4);

        // Desplazarse hasta el elemento "Añadir"
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Añadir')]");
        Util.scrollDown(manager.getDriver(), "-100");
// Verificar si el botón "Añadir" está presente en el DOM
        WebElement addButton = manager.getDriver().findElement(By.cssSelector("a[href='javascript:;'] img[src='commons/img/new.png']"));
        if (addButton.isDisplayed()) {
            System.out.println("El elemento está en el DOM.");
            // Hacer clic en el botón "Añadir"
            addButton.click();
        } else {
            System.out.println("No está");
        }
        Util.explicitWait(2);

        this.siniestrosDMPUI.txtTipoCristalDPC.sendKeys(datosDPC.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        //Desplazarse hasta el elemento verificar
        Util.scrollToElement(manager.getDriver(), "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']");
        Util.scrollDown(manager.getDriver(),"-200");
        Util.explicitWait(1);

        this.siniestrosDMPUI.btnVerificarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnConfirmarDatosVehiculoTercero.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarDatosVehiculoTercero.click();
        Util.explicitWait(2);


        /*
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.explicitWait(2);


        this.siniestrosDMPUI.txtMarcaDeducibleDPC.sendKeys(datosDPC.get(4));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtFechaDelServicioPrestadoDPC.sendKeys(datosDPC.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtHoraDelServicioPrestadoDPC.sendKeys(datosDPC.get(6));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtRequirioDPC.sendKeys(datosDPC.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtTipoDPC.sendKeys(datosDPC.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtCodigoDeProveedorDPC.sendKeys(datosDPC.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtPosibleFraudeDPC.sendKeys(datosDPC.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        this.siniestrosDMPUI.txtIqrDPC.sendKeys(datosDPC.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());

        Util.explicitWait(1);
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Transversal')]");
        Util.explicitWait(1);
        this.siniestrosDMPUI.btnVerificarDatosDelSiniestro.click();
        Util.explicitWait(3);
        this.siniestrosDMPUI.btnAceptarDatosDelSiniestro.click();

         */

    }


    @ShotAfter(evidenceName = "Información de Apertura LEO")
    public void expedienteLEO(String lesionado, String leo, String dmp){
        this.siniestrosDMPUI.txtLesionadosLEO.sendKeys(lesionado);
        ArrayList<String> datosLEO = ExcelData.readExcelSiniestros(leo);
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtNombreCompletoLEOAseg.sendKeys(datosLEO.get(0));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionConElContratanteLEOAseg.sendKeys(datosLEO.get(1));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtMedioDeContactoLEOAseg.sendKeys(datosLEO.get(2));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTelefono1LEOAseg.sendKeys(datosLEO.get(3));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEmailLEOAseg.clear();
        Util.explicitWait(1);
        this.siniestrosDMPUI.txtEmailLEOAseg.sendKeys(datosLEO.get(4));
        Util.scrollToElement(manager.getDriver(), "//*[contains(text(),'Lesionado')]");
        ArrayList<String> datosRecuperacion = ExcelData.readExcelSiniestros(dmp);
        Util.explicitWait(2);
        this.siniestrosDMPUI.txtResponsabilidad.sendKeys(datosRecuperacion.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtAplicaRecuperacion.sendKeys(datosRecuperacion.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCabezaCara.sendKeys(datosLEO.get(8));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCuello.sendKeys(datosLEO.get(9));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTorax.sendKeys(datosLEO.get(10));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtExtremidadesSuperiores.sendKeys(datosLEO.get(11));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtExtremidadesInferiores.sendKeys(datosLEO.get(12));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNumeroDeOcupantes.sendKeys(datosLEO.get(7));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtLesionGravedad.sendKeys(datosLEO.get(13));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRequiereAmbulancia.sendKeys(datosLEO.get(5));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtRelacionContratante.sendKeys(datosLEO.get(14));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtPosicionEnElAuto.sendKeys(datosLEO.get(15));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtTipoDeDocumento.sendKeys(datosLEO.get(16));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtCodigoDeDocumento.sendKeys(datosLEO.get(17));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtNombre.sendKeys(datosLEO.get(18));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoPaterno.sendKeys(datosLEO.get(19));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtApellidoMaterno.sendKeys(datosLEO.get(20));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtFechaDeNacimiento.sendKeys(datosLEO.get(21));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtEdad.sendKeys(datosLEO.get(22));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        this.siniestrosDMPUI.txtGenero.sendKeys(datosLEO.get(24));
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Completar información del expediente")
public void aperturaexpediente() {
    Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
    Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Fecha de Autorización del Control Técnico:')]");
    this.siniestrosDMPUI.btnAceptarExpediente1.click();
    Util.explicitWait(2);
    Util.pageStatus(manager.getDriver());

    Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Expediente:')]");
    Util.scrollDown(manager.getDriver(),"-200");
    this.siniestrosDMPUI.menuExpediente1.click();
    Util.explicitWait(3);
}

    @ShotAfter(evidenceName = "Finalizar la apertura de Expediente")
    public void finalizaraperturaexpediente() {
        Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Fraude')]");
        this.siniestrosDMPUI.btnVerificarAperturaExp.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAcceptarAperturaExp.click();
        Util.explicitWait(3);

        this.siniestrosDMPUI.btnVerificarDatosGlobal.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnSiguiente.click();

        Util.explicitWait(3);

        if(Util.webElementIsEnabled(10,manager.getDriver(),this.siniestrosDMPUI.btnVerificarDatosGlobal)) {
            this.siniestrosDMPUI.btnVerificarDatosGlobal.click();
            Util.explicitWait(2);
            this.siniestrosDMPUI.btnSiguiente.click();
        }

        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosDMPUI.btnAceptarGlobal.click();
    }

    @ShotAfter(evidenceName = "Finalizar la apertura de Expediente Cristales")
    public void finalizaraperturaexpedientecristales() {
        Util.scrollToElement(manager.getDriver(),"//*[contains(text(),'Fraude')]");
        this.siniestrosDMPUI.btnVerificarAperturaExp.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAcceptarAperturaExp.click();
        Util.explicitWait(3);

        this.siniestrosDMPUI.btnVerificarDatosGlobal.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnSiguiente.click();

        Util.explicitWait(3);

        if(Util.webElementIsEnabled(10,manager.getDriver(),this.siniestrosDMPUI.btnAceptarModoValoracionExp)) {
            this.siniestrosDMPUI.cbAutomatico.click();
            Util.explicitWait(1);
            this.siniestrosDMPUI.btnAceptarModoValoracionExp.click();
            Util.explicitWait(2);
            this.siniestrosDMPUI.btnSiguiente.click();
        }

        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosDMPUI.btnAceptarGlobal.click();
    }

    @ShotAfter(evidenceName = "Menú Apertura de Expediente")
    public void iraperturaexpediente(String consecuencias) {
        String numSimiestro = ExcelData.readJsonSiniestroDMP("Poliza_"+consecuencias);

        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosDMPUI.inputNumSimiestro.sendKeys(numSimiestro);
        Util.tab(manager.getDriver());
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        this.siniestrosDMPUI.btnSiguienteApertura.click();
        Util.pageStatus(manager.getDriver());
        Util.explicitWait(2);
        Util.waitElementItsNotVisible(manager.getDriver(), "//div[@class='loading-container ng-isolate-scope darkness']");
        Util.pageStatus(manager.getDriver());
    }

    @ShotAfter(evidenceName = "Salir de Apertura de Siniestro")
    public void salirapertura() {
        Util.pageStatus(manager.getDriver());
        Util.activarIframe(manager.getDriver(), "//iframe");
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnSalir.click();
        Util.explicitWait(2);
        this.siniestrosDMPUI.btnAceptarGlobal.click();
        Util.explicitWait(1);
    }
}