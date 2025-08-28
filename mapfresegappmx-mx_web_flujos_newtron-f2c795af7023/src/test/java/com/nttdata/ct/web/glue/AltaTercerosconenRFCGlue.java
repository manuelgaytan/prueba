package com.nttdata.ct.web.glue;

import com.nttdata.ct.web.task.Tasks;
import com.nttdata.ct.web.ui.LoginUI;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;


public class AltaTercerosconenRFCGlue {
    @Autowired
    private Tasks tasks;
    @Autowired
    private LoginUI loginUI;


    /*************************/
    /** Alta Terceros con & **/
    /*************************/

    @And("Ir a Terceros")
    public void irATerceros() {
    tasks.altaTercerosConAmpersonenRFCTask.irTerceros();}

    @And("Dar clic en Crear")
    public void clicCrear() {
        tasks.altaTercerosConAmpersonenRFCTask.clicCrear();
    }

    @And("CP001_Ingresar 'datos básicos' con & {string},{string},{string},{string},{string}")
    public void ingresarTercero(String razonsocial,String fechaconstitucion,String personafisica,String tipodocumento,String actividad) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioTerceros(razonsocial,fechaconstitucion,personafisica,tipodocumento,actividad);}

    @And("Crear Tercero")
    public void clicAceptar() {
        tasks.altaTercerosConAmpersonenRFCTask.clicAceptar();
    }

    @And("CP002_Ingresar 'persona moral' {string}")
    public void ingresarDatosPersona(String razonsocial) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioPersona(razonsocial);}

    @And("CP003_Ingresar 'contacto' {string},{string},{string}")
    public void ingresarDatosPersona(String tipouso,String tipomedio,String valormedio) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioContacto(tipouso,tipomedio,valormedio);
        tasks.altaTercerosConAmpersonenRFCTask.completardatosContacto();}

    @And("CP004_Ingresar 'dirección' {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void ingresarDatosDireccion(String tipodireccion,String pais,String estado,String provincia,String ciudad,String distrito,String cp,String tipodomicilio,String direccion) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioDirección(tipodireccion,pais,estado,provincia,ciudad,distrito,cp,tipodomicilio,direccion);
        tasks.altaTercerosConAmpersonenRFCTask.completardatosDireccion();}

    @And("CP005_Ingresar 'documentos alternativos' {string},{string},{string},{string}")
    public void ingresarDatosDocumentoAlternativo(String tipodocumento,String documento,String paisemisor,String observaciones) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioDocumentoAlternativo(tipodocumento,documento,paisemisor,observaciones);
        tasks.altaTercerosConAmpersonenRFCTask.completardatosDocumentosAlternativos();}

    @And("CP006_Ingresar 'información agente' {string},{string},{string},{string}")
    public void ingresarDatosAgente(String situacion,String tipoagente,String comercial,String fuenteproduccion) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioAgente(situacion,tipoagente,comercial,fuenteproduccion);}

    @And("CP007_Ingresar 'datos bancarios 1' {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void ingresarDatosBancarios(String TipoMedioPago,String ClaseMedio,String TipoEntidad,String EntidadBancario,String pais,String Titular,String TipoToken,String TokenMedio,String ValorMedio,String CalveMedio, String TipoMovimiento,String TipoUso,String Moneda,String MesVencido, String AñoVencimiento) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioDatosBancarios(TipoMedioPago,ClaseMedio,TipoEntidad,EntidadBancario,pais,Titular,TipoToken,TokenMedio,ValorMedio,CalveMedio,TipoMovimiento,TipoUso,Moneda,MesVencido,AñoVencimiento);
    tasks.altaTercerosConAmpersonenRFCTask.completardatosBancarios();}

    @And("CP008_Consulta tercero agente")
    public void consultaAltaCreada(){
        tasks.altaTercerosConAmpersonenRFCTask.consultaAltaCreada();
    }


    /******************************/
    /** Copia de Terceros con & **/
    /*****************************/

    @And("CP001_Ingresar 'datos básicos' asegurado {string},{string},{string},{string},{string}")
    public void ingresarAsegurado(String razonsocial,String fechaconstitucion,String personafisica,String tipodocumento,String actividad) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioAsegurado(razonsocial,fechaconstitucion,personafisica,tipodocumento,actividad);
        tasks.altaTercerosConAmpersonenRFCTask.crearFormularioAsegurado(razonsocial,fechaconstitucion,actividad);
    }

    @And("CP002_Copiar desde terceros {string}")
    public void copiardesdetercero(String rfc) {
        tasks.altaTercerosConAmpersonenRFCTask.copiardesdetercero(rfc);
    }


    @And("CP003_Consulta tercero copiado {string}")
    public void validacionDeCopia(String rfc){
        tasks.altaTercerosConAmpersonenRFCTask.validarCopia();
        tasks.altaTercerosConAmpersonenRFCTask.crearAlta();
        tasks.altaTercerosConAmpersonenRFCTask.consultarCopiaTerceros(rfc);
    }


    /************************/
    /** Copia de Proveedor **/
    /************************/

    @And("Ir a Proveedores")
    public void irProveedores() {
        tasks.altaTercerosConAmpersonenRFCTask.irProveedor();}

    @And("Dar clic en Crear Proveedor")
    public void clicCrearProveedor() {
        tasks.altaTercerosConAmpersonenRFCTask.clicCrearProveedor();
    }

    @And("CP001_Alta de Proveedor talleres {string},{string}")
    public void ingresarProveedor(String tipodocumento,String documento) {
        tasks.altaTercerosConAmpersonenRFCTask.completarFormularioProveedor(tipodocumento,documento);}

    @And("CP002_Copiar desde asegurado")
    public void copiardesdeasegurado() {
        tasks.altaTercerosConAmpersonenRFCTask.copiardesdeasegurado();
    }

    @And("CP003_Ingresar 'tipologia y categoria' proveedor {string},{string},{string}")
    public void validarDatosBasicosProveedor(String documento,String tipologia,String categoria) {
        tasks.altaTercerosConAmpersonenRFCTask.ingresarTipologiayCategoria(documento,tipologia,categoria);}

    @And("CP004_Ingresar 'datos generales' proveedor {string}")
    public void ingresarDatosGeneralesProveedor(String tipoestado) {
        tasks.altaTercerosConAmpersonenRFCTask.ingresarDatosGeneralesProveedor(tipoestado);}

    @And("Crear Proveedor")
    public void crearProveedor() {
        tasks.altaTercerosConAmpersonenRFCTask.crearProveedor();
    }

    @And("Ir a Rutina Terceros")
    public void irRutinaTerceros() {
        tasks.altaTercerosConAmpersonenRFCTask.irRutinaTerceros();
    }

    @And("CP005_Consulta proveedor copiado desde rutina de terceros {string},{string}")
    public void consultacopiaproveedor(String rfc, String documento){
        tasks.altaTercerosConAmpersonenRFCTask.consultaCopiaProveedor(rfc,documento);
    }


}


