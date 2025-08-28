package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomovilesSiniestroGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;

    @And("Busqueda de apertura de siniestro {string},{string},{string}")
    public void ingresoDatosPantalla1(String codigoMotivoSiniestro, String codTipoAsegurado, String motivoSiniestro) {
        tasks.automovilesSiniestroTask.motivoSiniestro(codigoMotivoSiniestro, codTipoAsegurado, motivoSiniestro);
        tasks.automovilesSiniestroTask.motivoSiniestro2();
    }

    @And("Ir apertura de siniestro")
    public void ingresoDatosSegundaPantalla1() {
        tasks.automovilesSiniestroTask.irAperturaSiniestro();
    }

    @And("Ingreso datos generales para siniestro {string}")
    public void datosGenerales(String poliza) {
        tasks.automovilesSiniestroTask.ingresarDatosGenerales(poliza);
        tasks.automovilesSiniestroTask.aceptarDatosGenerales();
    }
    @And("Llenamos relatos sobre siniestro")
    public void datosComplementariosGlue1() {
        tasks.automovilesSiniestroTask.datosComplementarios();
    }
    @And("Llenamos ubicación del siniestro: {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void datosComplementariosGlue2(String codPais,String codEstado,String codPoblacion, String codPostal, String calle, String colonia, String entreCalles, String latitud, String longitud, String ubiVia, String direccionA) {
        tasks.automovilesSiniestroTask.datosComplementarios2(codPais, codEstado, codPoblacion, codPostal, calle,colonia,entreCalles);
        tasks.automovilesSiniestroTask.ubicacionSiniestro(latitud, longitud, ubiVia, direccionA);
    }

    @And("Llenamos datos de robo total: {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void roboTotalGlue(String consecuencia,String mismoLugarRobo, String codPaisRT, String ubiVia, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT) {
        tasks.automovilesSiniestroTask.lugarDelRobo(consecuencia,mismoLugarRobo,codPaisRT,ubiVia,codPoblacionRT,calleyNoRT,coloniaRT,entreCallesRT,referenciaRT,cpRT);
    }
    @And("Vehículo asegurado: {string}")
    public void roboTotalGlue(String color) {
        tasks.automovilesSiniestroTask.vehiculoAsegurado(color);
    }
    @And("Abogado: {string},{string}")
    public void abogadoGlue(String consecuencia, String codAbogado) {
        tasks.automovilesSiniestroTask.abogado(consecuencia, codAbogado);
    }
    @And("Ajustador: {string},{string}")
    public void ajustadorGlue(String consecuencia, String codAjustador) {
        tasks.automovilesSiniestroTask.ajustador(consecuencia, codAjustador);
    }
    @And("Llenamos datos complementarios de siniestro: {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void datosComplementariosGlue2(String nombre, String apellidoPat, String apellidoMat, String cita, String codEstado, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT, String latitud, String longitud, String tipoAjuste) {
        tasks.automovilesSiniestroTask.datosComplementarios3(nombre, apellidoPat, apellidoMat);
        tasks.automovilesSiniestroTask.datosComplementarios4(cita, codEstado, codPoblacionRT, calleyNoRT, coloniaRT, entreCallesRT, referenciaRT, cpRT, latitud, longitud);
        tasks.automovilesSiniestroTask.tipoAjuste(tipoAjuste);
    }

    @And("Clic finalizar siniestro")
    public void datosComplementariosGlue3() {
        tasks.automovilesSiniestroTask.datosComplementarios5();
    }

    @And("Ventana de siniestro exitoso")
    public void noPoliza() {
        tasks.automovilesSiniestroTask.polizaSiniestro();
    }

    @And("Ventana de siniestro Colision exitoso")
    public void noPolizaColision() {
        tasks.automovilesSiniestroTask.polizaSiniestroColision();
    }

    @And("Ventana de siniestro Robo Total exitoso")
    public void noPolizaRoboTotal() {
        tasks.automovilesSiniestroTask.polizaSiniestroRobo();
    }

}
