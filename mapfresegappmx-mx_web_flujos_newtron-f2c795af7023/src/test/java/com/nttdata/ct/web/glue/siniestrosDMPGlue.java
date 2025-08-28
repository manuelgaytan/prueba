package com.nttdata.ct.web.glue;


import org.springframework.beans.factory.annotation.Autowired;
import com.nttdata.ct.web.task.SiniestrosDMPTask;
import io.cucumber.java.en.And;

public class siniestrosDMPGlue {

    @Autowired
    SiniestrosDMPTask siniestroDMPTask;

    @And ("Ingresar informacion del siniestro {string}")
        public void ingresarInformacionSiniestro(String riesgo){
            siniestroDMPTask.ingresarInfoSiniestro(riesgo);
        }

    @And ("Seleccionar consecuencias {string}")
    public void seleccionarConsecuencias(String consecuencias){
        siniestroDMPTask.seleccionarConsecuencias(consecuencias);

    }


    @And("Relatos sobre siniestro DMP")
    public void relatosSobreSiniestroDMP() {
        siniestroDMPTask.relatosiniestroDMP();
        siniestroDMPTask.aceptarrelatosiniestroDMP();
    }


    @And("Llenar Datos del siniestro {string}")
    public void llenarDatosDelSiniestro(String consecuencias) {
        siniestroDMPTask.ubicacionsiniestro();
        siniestroDMPTask.datosconductor();
        siniestroDMPTask.circunstancias();
        siniestroDMPTask.vehiculoAsegurado(consecuencias);
        siniestroDMPTask.datosajustador(consecuencias);
        siniestroDMPTask.cita();
        siniestroDMPTask.finalizardatossiniestro();
    }

    @And("Llenar Datos Complementarios {string}")
    public void llenarDatosComplementarios(String consecuencias) {
        siniestroDMPTask.llenardatoscomplementarios(consecuencias);
        siniestroDMPTask.finalizarsiniestro(consecuencias);
        siniestroDMPTask.salirapertura();

    }

    @And("Crear Expedientes {string}")
    public void crearExpedientes(String consecuencias) {
        siniestroDMPTask.crearexpediente(consecuencias);
    }

    @And("Ir a apertura de expediente {string}")
    public void irAAperturaDeExpediente(String consecuencias) {
        siniestroDMPTask.iraperturaexpediente(consecuencias);
    }
}
