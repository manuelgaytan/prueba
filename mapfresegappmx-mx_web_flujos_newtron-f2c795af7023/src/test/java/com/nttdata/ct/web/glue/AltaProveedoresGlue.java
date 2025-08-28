package com.nttdata.ct.web.glue;


import com.nttdata.ct.web.task.Tasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AltaProveedoresGlue {

    @Autowired
    private Tasks tasks;

    @When("Ir apertura de Tercero")
    public void irAperturaTercero() {
        tasks.altaPersonaFisicaTask.irProveedores();
    }

    @And("Ingreso datos generales para Proveedores")
    public void ingresoDatosGeneralesProveedores(){
        tasks.altaPersonaFisicaTask.ingresoDatosGeneralesProveedores();
    }

    @And("Busqueda de apertura de proveedores {string},{string}")
    public void busquedaAperturaProveedores(String tipoDocTercero, String actividadTercero){
        tasks.altaPersonaFisicaTask.busquedaAperturaProveedores(tipoDocTercero, actividadTercero);
    }

    @And("Clic botón Crear")
    public void clicBtnCrear(){
        tasks.altaPersonaFisicaTask.clicBtnCrear();
    }

    @And("CP001_Ingresar datos básicos")
    public void ingresoDatosBasicos(){
        tasks.altaPersonaFisicaTask.ingresoDatosBasicos();
    }

    @And("CP001_Alta de proveedor con &")
    public void altaProveedorAmpsd(){
        tasks.altaPersonaFisicaTask.altaProveedorAmpsd();
    }

    @And("CP002_Ingresar tipologia y categoria {string},{string}")
    public void completarTipologiaCategoria(String dataBasicTipologia, String categoriaProveedor){
        tasks.altaPersonaFisicaTask.completarTipologiaCategoria(dataBasicTipologia, categoriaProveedor);
    }

    @And("CP003_Ingresar datos generales {string}")
    public void completarDatosGenerales(String dataGeneralTipoStateProveedor){
        tasks.altaPersonaFisicaTask.completarDatosGenerales(dataGeneralTipoStateProveedor);
    }

    @And("CP004_Ingresar persona fisica {string},{string},{string}")
    public void completarPersona(String personaNombre, String personaApellido1, String personaApellido2){
        tasks.altaPersonaFisicaTask.completarPersona(personaNombre, personaApellido1, personaApellido2);
    }

    @And("CP005_Ingresar contacto {string},{string},{string},{string},{string},{string},{string}")
    public void completarContact(String contactTipoUsoMedioContacto, String contactTipoMedioContacto, String contactValorMedioContacto, String contactNameMedioContacto, String contactApellidoContacto, String contactTipoCargoEmpresa, String contactObservacion){
        tasks.altaPersonaFisicaTask.completarContacto(contactTipoUsoMedioContacto, contactTipoMedioContacto, contactValorMedioContacto, contactNameMedioContacto, contactApellidoContacto, contactTipoCargoEmpresa, contactObservacion);
    }

    @And("CP006_Ingresar dirección {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void completarDireccion(String direccionTipoDireccion,String direccionPais,String direccionProvincia,String direccionDistrito,String direccionEstado,String direccionCiudad,String direccionCodigoPostal,String direccionDomicilio,String direccionAddress,String direccionNumber, String direccionObservacion){
        tasks.altaPersonaFisicaTask.completarDireccion(direccionTipoDireccion,direccionPais,direccionProvincia,direccionDistrito,direccionEstado,direccionCiudad,direccionCodigoPostal,direccionDomicilio,direccionAddress,direccionNumber,direccionObservacion);
    }

    @And("CP007_Ingresar documentos alternativos {string},{string},{string},{string}")
    public void completarDocAlternativo(String docAfterTipoDoc, String docAfterDoc, String docAfterPaisDoc, String docAfterObsrDoc){
        tasks.altaPersonaFisicaTask.completarDocAlternativo(docAfterTipoDoc, docAfterDoc, docAfterPaisDoc, docAfterObsrDoc);
    }

    @And("CP008_Ingresar datos bancarios 1 {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void completarDatosBancariosUno(String dataBankTipoPagoCobro,String dataBankClasePagoCobro,String dataBankTipoEntidad,String dataBankEntidadBancaria,String dataBankPais,String dataBankTitular,String dataBankTipoToken,String dataBankTokenPagoCobro,String dataBankValorPagoCobro,String dataBankClavePagoCobro,String dataBankTipoMovimiento,String dataBankTipoMovPagoCobro,String dataBankMoneda,String dataBankMesVencimiento,String dataBankAnoVencimiento){
        tasks.altaPersonaFisicaTask.completarDatosBancarios(dataBankTipoPagoCobro,dataBankClasePagoCobro,dataBankTipoEntidad,dataBankEntidadBancaria,dataBankPais,dataBankTitular,dataBankTipoToken,dataBankTokenPagoCobro,dataBankValorPagoCobro,dataBankClavePagoCobro,dataBankTipoMovimiento,dataBankTipoMovPagoCobro,dataBankMoneda,dataBankMesVencimiento,dataBankAnoVencimiento);
    }

    @And("CP009_Ingresar datos bancarios 2 {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void completarDatosBancariosDos(String dataBankTipoPagoCobro,String dataBankClasePagoCobro,String dataBankTipoEntidad,String dataBankEntidadBancaria,String dataBankPais,String dataBankTitular,String dataBankTipoToken,String dataBankTokenPagoCobro,String dataBankValorPagoCobro,String dataBankClavePagoCobro,String dataBankTipoMovimiento,String dataBankTipoMovPagoCobro,String dataBankMoneda,String dataBankMesVencimiento,String dataBankAnoVencimiento){
        tasks.altaPersonaFisicaTask.completarDatosBancarios2(dataBankTipoPagoCobro,dataBankClasePagoCobro,dataBankTipoEntidad,dataBankEntidadBancaria,dataBankPais,dataBankTitular,dataBankTipoToken,dataBankTokenPagoCobro,dataBankValorPagoCobro,dataBankClavePagoCobro,dataBankTipoMovimiento,dataBankTipoMovPagoCobro,dataBankMoneda,dataBankMesVencimiento,dataBankAnoVencimiento);
    }

    @And("Creación de Persona Fisica")
    public void creacionPersonaFisica(){tasks.altaPersonaFisicaTask.clicCrearPersona();}

    @And("Creación de Persona Moral")
    public void creacionPersonaMoral(){tasks.altaPersonaFisicaTask.clicCrearPersona();}

    @And("Creación de Persona con Ampersand")
    public void creacionPersonaAmpsd(){tasks.altaPersonaFisicaTask.clicCrearPersona();}

    @And("CP004_Ingresar persona moral {string}")
    public void completarPersona(String personaNombre){
        tasks.altaPersonaMoralTask.clicCheckFisicaJuridica();
        tasks.altaPersonaFisicaTask.completarPersona(personaNombre,"","");
    }

    @And("CP001_Alta de un proveedor cuando el RFC ya existe en otra actividad")
    public void rfcExistenteOtraActividad(){
        tasks.altaPersonaFisicaTask.ingresoRfcExistente();
    }

    @And("CP002_Validar que ya no se muestre la lupa que está junto a código del documento")
    public void noDetectarIconoSearchDoc(){
        tasks.altaPersonaFisicaTask.validarQueNoAparezcaIconoSearchDoc();
    }

    @And("CP005_Alta de proveedor con dirección de más de ochenta caracteres {string},{string}")
    public void direccionOchentaCaracteres(String direccionTipoDireccion, String direccionDomicilio){
        tasks.altaPersonaFisicaTask.direccionOchentaCaracteres(direccionTipoDireccion,direccionDomicilio);}

    @And("CP006_Modificar dirección de proveedor con dirección de más de ochenta caractéres")
    public void modificarDireccion(){ tasks.altaPersonaFisicaTask.modificarDireccion(); }

    @And("Clic botón Buscar")
    public void clicBtnBuscar(){tasks.altaPersonaFisicaTask.clicBtnBuscar(); }

    @And("CP007_Consulta proveedor dirección")
    public void consultaProveedorDireccion(){tasks.altaPersonaFisicaTask.consultaProveedorDireccion();}

}
