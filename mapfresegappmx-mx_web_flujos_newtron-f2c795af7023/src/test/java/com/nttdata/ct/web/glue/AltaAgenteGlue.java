package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaAgenteGlue {
    @Autowired
    private Tasks tasks;

    @And("CP001_Crear agente y completar datos basicos {string},{string},{string},{string},{string}")
    public void cp_CrearAgenteYCompletarDatosBasicos(String razonSocial, String primerApellido, String segundoApellido, String personaFisica, String tipoDocumento) {
        tasks.altaAgenteTask.crearAgenteDatosBasicos(razonSocial,primerApellido,segundoApellido,personaFisica,tipoDocumento);
    }

    @And("CP002_Completar datos persona legal {string}")
    public void cp_CompletarDatosPersonaLegal( String aliasTercero) {
        tasks.altaAgenteTask.datosPersonaLegal(aliasTercero);
    }

    @And("CP003_Completar datos persona {string}, {string}, {string}")
    public void cp_CompletarDatosPersona( String nombre, String apellido1, String apellido2) {
        tasks.altaAgenteTask.datosPersona(nombre,apellido1,apellido2);
    }

    @And("CP004_Completar datos agente {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void cp_CompletarDatosAgente(String situacion, String beneficiario, String comercial, String tipoAgente, String fuenteProduccion,
                                        String tipoRetencion, String formaTerceroPc, String calidadTercero, String AgrupamientoTercero, String FormaGestion, String TipoClasificacion) {

        tasks.altaAgenteTask.completarDatosAgente(situacion,beneficiario,comercial,tipoAgente,fuenteProduccion,tipoRetencion,formaTerceroPc,calidadTercero,AgrupamientoTercero,FormaGestion,TipoClasificacion);
    }

    @And("Fuentes de Distribuccion por agente {string}")
    public void fuentesDeDistribuccionPorAgente(String fuenteProduccion) {
        tasks.altaAgenteTask.distribucionPorAgente(fuenteProduccion);
    }

    @When("CP005_Consultar en rutina de terceros {string}")
    public void cp_ConsultarEnRutinaDeTerceros( String tipoDocumento) {
        tasks.altaAgenteTask.consultaAgente(tipoDocumento);
    }
}


