package com.nttdata.ct.web.glue;
import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class AutomovilesSiniestroNewGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;


    @And("Ingreso datos generales para siniestro nuevo {string}")
    public void datosGenerales(String poliza) {
        tasks.automovilesSiniestronewTask.ingresarDatosGeneralesnew(poliza);
        tasks.automovilesSiniestronewTask.aceptarDatosGeneralesnew();
    }

    @And("Busqueda de apertura de siniestro nuevo {string},{string},{string}")
    public void ingresoDatosPantalla1(String codigoMotivoSiniestro, String codTipoAsegurado, String motivoSiniestro) {
        tasks.automovilesSiniestronewTask.motivoSiniestronew(codigoMotivoSiniestro, codTipoAsegurado, motivoSiniestro);
        tasks.automovilesSiniestronewTask.motivoSiniestro2new();
    }

    @And("Llenamos relatos sobre siniestro nuevo")
    public void datosComplementariosGlue1() {
        tasks.automovilesSiniestronewTask.datosComplementariosnew();
    }

    @And("Llenamos ubicación del siniestro: nuevo {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void datosComplementariosGlue2(String codPais,String codEstado,String codPoblacion, String codPostal, String calle, String colonia, String entreCalles, String latitud, String longitud, String ubiVia, String direccionA) {
        tasks.automovilesSiniestronewTask.datosComplementarios2new(codPais, codEstado, codPoblacion, codPostal, calle,colonia,entreCalles);
        tasks.automovilesSiniestronewTask.ubicacionSiniestronew(latitud, longitud, ubiVia, direccionA);
    }

    @And("Llenamos datos de robo total: nuevo {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void roboTotalGlue(String consecuencia,String mismoLugarRobo, String codPaisRT, String ubiVia, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT) {
        tasks.automovilesSiniestronewTask.lugarDelRobo(consecuencia,mismoLugarRobo,codPaisRT,ubiVia,codPoblacionRT,calleyNoRT,coloniaRT,entreCallesRT,referenciaRT,cpRT);
    }

    @And("Vehículo asegurado: nuevo {string}")
    public void roboTotalGlue(String color) {
        tasks.automovilesSiniestronewTask.vehiculoAseguradonew(color);
    }

    @And("Ajustador: nuevo {string},{string}")
    public void ajustadorGlue(String consecuencia, String codAjustador) {
        tasks.automovilesSiniestronewTask.ajustadornew(consecuencia, codAjustador);
    }

    @And("Abogado: nuevo {string},{string}")
    public void abogadoGlue(String consecuencia, String codAbogado) {
        tasks.automovilesSiniestronewTask.abogadonew(consecuencia, codAbogado);
    }

    @And("Llenamos datos complementarios de siniestro: nuevo {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void datosComplementariosGlue2(String nombre, String apellidoPat, String apellidoMat, String cita, String codEstado, String codPoblacionRT, String calleyNoRT, String coloniaRT, String entreCallesRT, String referenciaRT, String cpRT, String latitud, String longitud, String tipoAjuste) {
        tasks.automovilesSiniestronewTask.datosComplementarios3new(nombre, apellidoPat, apellidoMat);
        tasks.automovilesSiniestronewTask.datosComplementarios4new(cita, codEstado, codPoblacionRT, calleyNoRT, coloniaRT, entreCallesRT, referenciaRT, cpRT, latitud, longitud);
        tasks.automovilesSiniestronewTask.tipoAjustenew(tipoAjuste);
    }

    @And("Clic finalizar siniestro nuevo")
    public void datosComplementariosGlue3() {
        tasks.automovilesSiniestronewTask.datosComplementarios5new();
    }


    @And("Ventana de siniestro Colision exitoso nuevo")
    public void noPolizaColision() {
        tasks.automovilesSiniestronewTask.polizaSiniestroColisionnew();
    }

    @And("Ventana de siniestro Robo Total exitoso nuevo")
    public void noPolizaRoboTotal() {
        tasks.automovilesSiniestronewTask.polizaSiniestroRobonew();
    }

}
