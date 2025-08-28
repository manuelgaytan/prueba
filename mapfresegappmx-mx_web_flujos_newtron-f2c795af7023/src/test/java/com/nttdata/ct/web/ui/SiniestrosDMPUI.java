package com.nttdata.ct.web.ui;

import com.nttdata.ct.web.cucumber.page.AbstractPage;
import com.nttdata.ct.web.cucumber.page.aspect.PageObject;
import com.nttdata.ct.web.lib.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

@PageObject
public class SiniestrosDMPUI extends AbstractPage {

    @FindBy (xpath = "//input[@id='lssOcrDat']")
    public WebElement fechaSiniestro;

    @FindBy (xpath = "//input[@name='lssOcrTme']")
    public WebElement horaSiniestro;

    @FindBy(xpath = "//input[@id='lssCotDat']")
    public WebElement fechaDenuncia;

    @FindBy (xpath = "//input[@name='lssCotTme']")
    public WebElement horaDenuncia;

    @FindBy (xpath = "//input[@name='plyVal']")
    public WebElement numPoliza;

    @FindBy (xpath = "//button[text()='Buscar']")
    public WebElement btnBuscar;

    @FindBy (xpath = "//input[@id='rskVal']")
    public WebElement inputRiesgo;

    @FindBy (xpath = "//label[text()='Aceptar']")
    public WebElement btnAceptar;

    @FindBy (xpath = "//button[@type='button' and contains(@class, 'btn-navigation') and @ng-click='accept()']")
    public WebElement btnAceptarOpc;

    @FindBy (xpath = "(//input[@id='lssRsnVal'])[2]")
    public WebElement inputMotivoSiniestro;

//    @FindBy (xpath = "//span[@class='input-group-btn']/button[@id='valuesListButton-13I'] |" +
//            "//span[@class='input-group-btn']/button[@id='valuesListButton-13L'] |" +
//            "//span[@class='input-group-btn']/button[@id='valuesListButton-4F1']")


    @FindBy (xpath = "(//span[@class='input-group-btn']/button[contains(@id, 'valuesListButton-') and @type='button' and contains(@class, 'btn-default') and @mp-values-list='lssRsnValueList' and @name='lssRsnValueList'])[2]")
    public WebElement liMotivoSiniestro;

    @FindBy(xpath = "//input[@id='oLssExiFormC.oLssExiCDto.inyRlnTypVal']")
    public WebElement inpTipoRelacion;

    @FindBy(xpath = "//input[@name='thpDcmTypVal']")
    public WebElement inpTipoDocto;

    @FindBy(xpath = "//input[@name='thpDcmVal']")
    public WebElement inpDocumento;

    @FindBy(xpath = "//input[@name='thpNam']")
    public WebElement inputNombre;

    @FindBy(xpath = "//input[@name='thpSrn']")
    public WebElement inputApellidos;

    @FindBy(xpath = "//input[@name='cnhTxtVal_0']")
    public WebElement inpNumTelefono;

    @FindBy(xpath = "//input[@name='cnhTxtVal_1']")
    public WebElement inpNumMovil;

    @FindBy(xpath = "//input[@name='cnhTxtVal_2']")
    public WebElement inpCorreo;

    @FindBy(xpath = "//span[text()='erificar']")
    public WebElement btnVerificar;

    @FindBy(xpath = "//button[@ng-click='selectCqdT()']")
    public WebElement btnSelectCbx;

    @FindBy(xpath = "//span[text()='iguiente']")
    public WebElement btnSiguiente;

    /*******************************
    * Selección de consecuencias
    * ******************************/

    @FindBy (xpath = "//td[@title='DAÑOS A VEHICULO ASEGURADO']//ancestor::tr/td/input")
    public WebElement chkDanosVehiculoAsegurado;

    @FindBy (xpath = "//td[@title='DAOS A TERCERO BIENES Y PERS']//ancestor::tr/td/input")
    public WebElement chkDanosBienesTerceros;

    @FindBy (xpath = "//td[@title='ROTURA DE CRISTAL']//ancestor::tr/td/input")
    public WebElement chkRoturaCristal;


    @FindBy (xpath = "//td[@title='CONDUCTOR LESIONADO']//ancestor::tr/td/input") //td[text()='ROTURA DE CRISTAL']//ancestor::tr/td/input
    public WebElement chkConductorLesionado;

    @FindBy (xpath = "//td[@title='LESIONADOS VEHICULO ASEGURADO']//ancestor::tr/td/input")
    public WebElement chkLesionadosAsegurado;

    @FindBy (xpath = "//td[@title='DEFENSA JURIDICA']//ancestor::tr/td/input")
    public WebElement chkDefensaJuridica;

    @FindBy (xpath = "//td[@title='RESPONSABILIDAD CIVIL VIAJERO']//ancestor::tr/td/input")
    public WebElement chkResponsabililidadViajero;

    @FindBy (xpath = "//td[@title='RESPONSABILIDAD CIVIL EN EXTR']//ancestor::tr/td/input")
    public WebElement chkResponsabilidadExterios;

    @FindBy (xpath = "//button[@ng-click='selectCqdT()']")
    public WebElement btnFlechaAbajo;



    /*******************************
     * Selección Relato
     * ******************************/



    @FindBy(xpath = "//textarea[@name='cisTxtVal']")
    public WebElement txtRelato;

    @FindBy(xpath = "//textarea[@name='dmgDspVal']")
    public WebElement txtDescripcion;

    @FindBy(xpath = "//textarea[@name='cisObsVal']")
    public WebElement txtObsRelato;

    @FindBy(xpath = "//*[contains(text(),'Aceptar')] | //button[@class='btn btn-primary ng-binding' and @ng-click='ok()' and text()='Aceptar']")
    public WebElement btnAceptarGlobal;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-binding' and @ng-click='ok()' and text()='Aceptar']")
    public WebElement btnAceptarSiniestro;

    @FindBy(xpath = "//span[@class='btn-navigation-label ng-binding' and text()='alir']")
    public WebElement btnSalir;


    /*******************************
     * Datos Siniestro
     * ******************************/

    //Ubicacion del Siniestro
    @FindBy(xpath = "//*[@id='COD_PAIS']")
    public WebElement txtCodPais;
    @FindBy(xpath = "//*[@id='COD_ESTADO']")
    public WebElement txtCodEstado;
    @FindBy(xpath = "//*[@id='COD_POBLACION']")
    public WebElement txtCodPoblacion;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI1']")
    public WebElement txtCalle;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI2']")
    public WebElement txtColonia;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI3']")
    public WebElement txtEntreCalles;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_UBI4']")
    public WebElement txtReferencia;
    @FindBy(xpath = "//*[@id='COD_POSTAL_UBI']")
    public WebElement txtCodPostal;
    @FindBy(xpath = "//*[@id='LATITUD']")
    public WebElement txtLatitud;
    @FindBy(xpath = "//*[@id='LONGITUD']")
    public WebElement txtLongitud;
    @FindBy(xpath = "//*[@id='TIP_UBI_VIA']")
    public WebElement txtUbiVia;
    @FindBy(xpath = "//*[@id='TXT_DIRECCION']")
    public WebElement txtDirA;

    // Datos Del Conductor
    @FindBy(xpath = "//*[@id='NOM_CONDUCTOR']")
    public WebElement txtNombreCond;
    @FindBy(xpath = "//*[@id='APE1_CONDUCTOR']")
    public WebElement txtApellidoPaternoCond;
    @FindBy(xpath = "//*[@id='APE2_CONDUCTOR']")
    public WebElement txtApellidoMaternoCond;
    @FindBy(xpath = "//*[@id='EDAD_CONDUCTOR']")
    public WebElement txtEdadCond;
    @FindBy(xpath = "//*[@id='COD_LICENCIA']")
    public WebElement txtNumLicenciaCond;
    @FindBy(xpath = "//*[@id='COD_EDO_EMI_LIC']")
    public WebElement txtEstadoLicenciaCond;
    @FindBy(xpath = "//*[@id='TIP_LICENCIA']")
    public WebElement txtTipoLicenciaCond;
    @FindBy(xpath = "//*[@id='MCA_PERMANENTE']")
    public WebElement txtPermanente;
    @FindBy(xpath = "//*[@id='FEC_VIG_LIC']")
    public WebElement txtFechaVigencia;

    //Datos Siniestro Ciscunstancias
    @FindBy(xpath = "//*[@id='TIP_CIRCUNSTANCIA']")
    public WebElement txtCircunstancia;
    @FindBy(xpath = "//*[@id='TIP_SUCESO']")
    public WebElement txtSuceso;

    //Vehiculo Asegurado
    @FindBy(xpath = "//*[@id='NUM_PLACA_ACTUAL']")
    public WebElement txtNumPlaca;
    @FindBy(xpath = "//*[@id='COD_COLOR_DTO_SINI']")
    public WebElement txtColorEst;
    @FindBy(xpath = "//*[@id='MCA_CON_COSTO']")
    public WebElement txtConCosto;
    @FindBy(xpath = "//*[@id='TIP_CAU_CIE_SIN_COSTO']")
    public WebElement txtCausaCierreSinCosto;

     //Datos para Ajuste
    @FindBy(xpath = "//*[@id='MCA_LESIONADO']")
    public WebElement txtLesionados;
    @FindBy(xpath = "//*[@id='MCA_CIRCULAR']")
    public WebElement txtVehiculoPuedeCircular;
    @FindBy(xpath = "//*[@id='MCA_ESTACIONADO']")
    public WebElement txtVehiculoEstabaEstacionado;
    @FindBy(xpath = "//*[@id='MCA_INVOLUCRADOS']")
    public WebElement txtHayOtroInvolucrado;
    @FindBy(xpath = "//*[@id='MCA_CUENTA']")
    public WebElement txtEsCuentaEspecial;

    //Cita
    @FindBy(xpath = "//*[@id='MCA_CITA']")
    public WebElement txtCita;
    @FindBy(xpath = "//*[@id='HOR_CITA']")
    public WebElement txtHoraDeLaCita;
    @FindBy(xpath = "//*[@id='MCA_UBI_CITA']")
    public WebElement txtMismaUbicacionDelSiniestroCita;
    @FindBy(xpath = "//*[@id='FEC_CITA']")
    public WebElement txtFechaDeCita;
    @FindBy(xpath = "//*[@id='COD_ESTADO_CITA']")
    public WebElement txtEstadoCita;
    @FindBy(xpath = "//*[@id='COD_POBLACION_CITA']")
    public WebElement txtPoblacionCita;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_CITA1']")
    public WebElement txtCalleYNoCita;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_CITA2']")
    public WebElement txtColoniaCita;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_CITA3']")
    public WebElement txtEntreCallesCita;
    @FindBy(xpath = "//*[@id='NOM_DOMICILIO_CITA4']")
    public WebElement txtReferenciaCita;
    @FindBy(xpath = "//*[@id='COD_POSTAL_CITA']")
    public WebElement txtCodigoPostalCita;
    @FindBy(xpath = "//*[@id='LATITUD_CITA']")
    public WebElement txtLatitudCita;
    @FindBy(xpath = "//*[@id='LONGITUD_CITA']")
    public WebElement txtLongitudCita;
    @FindBy(xpath = "//*[@id='OBS_CITA']")
    public WebElement txtObservacionesCita;
    @FindBy(xpath = "//*[@id='TIP_ESTATUS_CITA']")
    public WebElement txtEstadoDeLaCita;

    @FindBy(xpath = "//*[@id='TIP_AJUSTE']")
    public WebElement txtTipoAjuste;


    /*******************************
     * Datos Numero vehiculo tercero
     * ******************************/
    @FindBy(xpath = "//input[@name='ocaNUM_VEHI_TERCERO']")
    public WebElement btnNumeroVehiculoTercero;

   // Contacto Preferente
    @FindBy(xpath = "//*[@id='TIP_DOCUM_TERCERO']")
    public WebElement txtTipoDocumento;
    @FindBy(xpath = "//*[@id='COD_DOCUM_TERCERO']")
    public WebElement txtCodigoDocumento;
    @FindBy(xpath = "//*[@id='NOM_CONTACTO_PREF']")
    public WebElement txtNombreCompleto;
    @FindBy(xpath = "//*[@id='DESC_CTO_PREF_RELAC']")
    public WebElement txtRelacionConConductor;
    @FindBy(xpath = "//*[@id='COD_CONTACTO_PREF']")
    public WebElement txtMedioContacto;
    @FindBy(xpath = "//*[@id='TLF_NUMERO_PREF1']")
    public WebElement txtTelefono;
    @FindBy(xpath = "//*[@id='EMAIL_PREF']")
    public WebElement txtEmail;

    // Datos del Tercero
    @FindBy(xpath = "//*[@id='NOM_TERCERO']")
    public WebElement txtNombreRazonTercero;
    @FindBy(xpath = "//*[@id='APE1_TERCERO']")
    public WebElement txtAppTercero;
    @FindBy(xpath = "//*[@id='APE2_TERCERO']")
    public WebElement txtApmTercero;
    @FindBy(xpath = "//*[@id='COD_LICENCIA_TERCERO']")
    public WebElement txtNumLicenciaTercero;
    @FindBy(xpath = "//*[@id='COD_EDO_EMI_LIC_TERC']")
    public WebElement txtEstadoLicenciaTercero;
    @FindBy(xpath = "//*[@id='TIP_PERSONA_ASEG']")
    public WebElement txtTipoPersonaTercero;
    @FindBy(xpath = "//*[@id='COD_CIRCUNSTANCIA']")
    public WebElement txtCircunstanciaTercero;
    @FindBy(xpath = "//*[@id='TIP_LICENCIA_TERCERO']")
    public WebElement txtTipoLicenciaTercero;
    @FindBy(xpath = "//*[@id='MCA_PERMANENTE_TERCERO']")
    public WebElement txtPermanenteTercero;
    @FindBy(xpath = "//*[@id='FEC_VIG_LIC_TERCERO']")
    public WebElement txtFechaVigenciaTercero;
    @FindBy(xpath = "//*[@id='TIP_RESPONSABILIDAD']")
    public WebElement txtResponsabilidadTercero;
    @FindBy(xpath = "//*[@id='TIP_CONVENIO']")
    public WebElement txtTipoConvenioTercero;
    @FindBy(xpath = "//*[@id='TXT_DANO']")
    public WebElement txtDescripcionDanioTercero;

    // Daños
    @FindBy(xpath = "//*[@id='MCA_COST_TRAS_DER']")
    public WebElement txtCostadoTraseroDerecho;
    @FindBy(xpath = "//*[@id='MCA_COST_TRAS_IZQ']")
    public WebElement txtCostadoTraseroIzquierdo;
    @FindBy(xpath = "//*[@id='MCA_CRI_PUE_DEL_DER']")
    public WebElement txtCristalPuertaDelanteraDer;
    @FindBy(xpath = "//*[@id='MCA_CRI_PUE_DEL_IZQ']")
    public WebElement txtCristalPuertaDelanteraIzq;
    @FindBy(xpath = "//*[@id='MCA_CRI_PUE_TRAS_DER']")
    public WebElement txtCristalPuertaTraseraDerecha;
    @FindBy(xpath = "//*[@id='MCA_CRI_PUE_TRAS_IZQ']")
    public WebElement txtCristalPuertaTraseraIzq;
    @FindBy(xpath = "//*[@id='MCA_MAR_RADIADOR']")
    public WebElement txtMarcoRadiador;
    @FindBy(xpath = "//*[@id='MCA_ESP_LAT_DER']")
    public WebElement txtEspejoLateralDerecho;
    @FindBy(xpath = "//*[@id='MCA_ESP_LAT_IZQ']")
    public WebElement txtEspejoLateralIzquierdo;
    @FindBy(xpath = "//*[@id='MCA_ESTRIBO']")
    public WebElement txtEstribo;
    @FindBy(xpath = "//*[@id='MCA_FAR_DELANTEROS']")
    public WebElement txtFarosDelanteros;
    @FindBy(xpath = "//*[@id='MCA_FAR_TRASEROS']")
    public WebElement txtFarosTraseros;
    @FindBy(xpath = "//*[@id='MCA_FAC_DELANTERA']")
    public WebElement txtFaciaDelantera;
    @FindBy(xpath = "//*[@id='MCA_FAC_TRASERA']")
    public WebElement txtFaciaTrasera;
    @FindBy(xpath = "//*[@id='MCA_LAT_DERECHO']")
    public WebElement txtLateralDerecho;
    @FindBy(xpath = "//*[@id='MCA_LAT_IZQUIERDO']")
    public WebElement txtLateralIzquierdo;
    @FindBy(xpath = "//*[@id='MCA_MEC_COLISION']")
    public WebElement txtMecanicaPorColision;
    @FindBy(xpath = "//*[@id='MCA_MEDALLON']")
    public WebElement txtMedallon;
    @FindBy(xpath = "//*[@id='MCA_PARABRISAS']")
    public WebElement txtParabrisas;
    @FindBy(xpath = "//*[@id='MCA_PARRILLA']")
    public WebElement txtParrilla;
    @FindBy(xpath = "//*[@id='MCA_PAR_BAJAS']")
    public WebElement txtPartesBajas;
    @FindBy(xpath = "//*[@id='MCA_PISO_CAJUELA']")
    public WebElement txtPisoCajuela;
    @FindBy(xpath = "//*[@id='MCA_POSTES']")
    public WebElement txtPostes;
    @FindBy(xpath = "//*[@id='MCA_PUE_DEL_DER']")
    public WebElement txtPuertaDelanteraDerecha;
    @FindBy(xpath = "//*[@id='MCA_PUE_DEL_IZQ']")
    public WebElement txtPuertaDelanteraIzquierda;
    @FindBy(xpath = "//*[@id='MCA_PUE_TRAS_DER']")
    public WebElement txtPuertaTraseraDerecha;
    @FindBy(xpath = "//*[@id='MCA_PUE_TRAS_IZQ']")
    public WebElement txtPuertaTraseraIzquierda;
    @FindBy(xpath = "//*[@id='MCA_SALP_DEL_DER']")
    public WebElement txtSalpicaderaDelanteraDerecha;
    @FindBy(xpath = "//*[@id='MCA_SALP_DEL_IZQ']")
    public WebElement txtSalpicaderaDelanteraIzq;
    @FindBy(xpath = "//*[@id='MCA_SALP_TRAS_DER']")
    public WebElement txtSalpicaderaTraseraDerecha;
    @FindBy(xpath = "//*[@id='MCA_SALP_TRAS_IZQ']")
    public WebElement txtSalpicaderaTraseraIzquierda;
    @FindBy(xpath = "//*[@id='MCA_TAP_CAJUELA']")
    public WebElement txtTapaCajuela;
    @FindBy(xpath = "//*[@id='MCA_TOLDO']")
    public WebElement txtToldo;
    @FindBy(xpath = "//*[@id='MCA_TOL_ESCAPE']")
    public WebElement txtTolvaDeEscape;
    @FindBy(xpath = "//*[@id='MCA_TOL_PARABRISAS']")
    public WebElement txtTolvaDeParabrisas;

    //Vehiculo
    @FindBy(xpath = "//*[@id='COD_TIP_VEHI']")
    public WebElement txtTipo;
    @FindBy(xpath = "//*[@id='COD_MARCA']")
    public WebElement txtMarca;
    @FindBy(xpath = "//*[@id='DESC_MARCA_SINI']")
    public WebElement txtDescripcionMarca;
    @FindBy(xpath = "//*[@id='COD_MODELO_SINI']")
    public WebElement txtModelo;
    @FindBy(xpath = "//*[@id='DESC_MODELO']")
    public WebElement txtDescripcionModelo;
    @FindBy(xpath = "//*[@id='COD_SUBMODELO']")
    public WebElement txtSubmodelo;
    @FindBy(xpath = "//*[@id='DESC_SUBMODELO']")
    public WebElement txtDescripcionSubModelo;
    @FindBy(xpath = "//*[@id='COD_ANIO']")
    public WebElement txtAnio;
    @FindBy(xpath = "//*[@id='COD_COLOR']")
    public WebElement txtColor;
    @FindBy(xpath = "//*[@id='NUM_SERIE']")
    public WebElement txtNumeroDeSerie;
    @FindBy(xpath = "//*[@id='NUM_PLACAS']")
    public WebElement txtPlacas;
    @FindBy(xpath = "//*[@id='TIP_USO_VEHICULO']")
    public WebElement txtUso;
    @FindBy(xpath = "//*[@id='MCA_CORRALON']")
    public WebElement txtEnCorralon;
    @FindBy(xpath = "//*[@id='VAL_EST_DANO']")
    public WebElement txtEstimacionDeLosDanios;

    @FindBy(xpath = "//img[@src='commons/img/icon-save.png' and @ng-if='!objBtn.btnVrf.loading']")
    public WebElement btnVerificarDatosVehiculoTercero;

    @FindBy(xpath = "//span[contains(@class, 'ng-binding') and text()='Confirmar']")
    public WebElement btnConfirmarDatosVehiculoTercero;

    @FindBy(xpath = "//span[contains(@class, 'ng-binding') and text()='Aceptar']")
    public WebElement btnAceptarDatosVehiculoTercero;




    /*******************************
     * Datos Lesionado Vehiculo Asegurado (LEO)
     * ******************************/

    @FindBy(xpath = "//input[@type='image' and @src='commons/img/ocu.svg' and @name='ocaNUM_VEHI_LES']")
    public WebElement btnNumeroLesionadosAseurado;


    //Contacto Preferente
    @FindBy(xpath = "//*[@id='NOM_CONTACTO_PREF'] | //*[@id='NOM_CONTACTO_PREF_EXP']")
    public WebElement txtNombreCompletoLEOAseg;
    @FindBy(xpath = "//*[@id='DESC_CONTACTO_PREF_RELAC'] | //*[@id='DESC_RELAC_CONT_PRE'] | //*[@id='DESC_RELAC_CONT_PRE_EXP']")
    public WebElement txtRelacionConElContratanteLEOAseg;
    @FindBy(xpath = "//*[@id='COD_CONTACTO_PREF'] | //*[@id='COD_CONTACTO_PREF_EXP']")
    public WebElement txtMedioDeContactoLEOAseg;
    @FindBy(xpath = "//*[@id='TLF_NUMERO_PREF1'] | //*[@id='TLF_NUMERO_PREF1_EXP']")
    public WebElement txtTelefono1LEOAseg;
    @FindBy(xpath = "//*[@id='TLF_NUMERO_PREF2'] | //*[@id='TLF_NUMERO_PREF2_EXP']")
    public WebElement txtTelefono2LEOAseg;
    @FindBy(xpath = "//*[@id='EMAIL_PREF'] | //*[@id='EMAIL_PREF_EXP']")
    public WebElement txtEmailLEOAseg;

    //Ambulancia
    @FindBy(xpath = "//*[@id='MCA_AMBULANCIA']")
    public WebElement txtRequiereLEOAseg;
    @FindBy(xpath = "//*[@id='COD_PROVEEDOR_AMBULANCIA']")
    public WebElement txtCodProveedorAmbulanciaLEOAseg;

    //Sesionado
    @FindBy(xpath = "//*[@id='NUM_OCUPANTES'] | //*[@id='NUM_OCUPANTES_EXP']")
    public WebElement txtNumeroDeOcupantes;
    @FindBy(xpath = "//*[@id='MCA_CAB_CARA']")
    public WebElement txtCabezaCara;
    @FindBy(xpath = "//*[@id='MCA_CAB_CAR_EXT_SUP']")
    public WebElement txtCuello;
    @FindBy(xpath = "//*[@id='MCA_TORAX']")
    public WebElement txtTorax;
    @FindBy(xpath = "//*[@id='MCA_EXT_SUP']")
    public WebElement txtExtremidadesSuperiores;
    @FindBy(xpath = "//*[@id='MCA_EXT_INF']")
    public WebElement txtExtremidadesInferiores;
    @FindBy(xpath = "//*[@id='TIP_LES']")
    public WebElement txtLesionGravedad;
    @FindBy(xpath = "//*[@id='TXT_RELAC_LES']")
    public WebElement txtRelacionConContratante;
    @FindBy(xpath = "//*[@id='TIP_LESI_UBICACION']")
    public WebElement txtPosicionEnElAuto;
    @FindBy(xpath = "//*[@id='TIP_DOCUM_LES'] | //*[@id='TIP_DOCUM_LES_EXP_LEO']")
    public WebElement txtTipoDeDocumento;
    @FindBy(xpath = "//*[@id='COD_DOCUM_LES'] | //*[@id='COD_DOCUM_LES_EXP_LEO']")
    public WebElement txtCodigoDeDocumento;
    @FindBy(xpath = "//*[@id='NOM_LES'] | //*[@id='NOM_LES_EXP_LEO']")
    public WebElement txtNombre;
    @FindBy(xpath = "//*[@id='APE1_LES'] | //*[@id='APE1_LES_EXP_LEO']")
    public WebElement txtApellidoPaterno;
    @FindBy(xpath = "//*[@id='APE2_LES'] | //*[@id='APE2_LES_EXP_LEO']")
    public WebElement txtApellidoMaterno;
    @FindBy(xpath = "//*[@id='FEC_NAC_LES'] | //*[@id='FEC_NAC_LES_EXP_LEO']")
    public WebElement txtFechaDeNacimiento;
    @FindBy(xpath = "//*[@id='EDAD_LES'] | //*[@id='EDAD_LES_EXP_LEO']")
    public WebElement txtEdad;
    @FindBy(xpath = "//*[@id='MCA_LESION_SINI_SIN']")
    public WebElement txtLesionesCorresAlSiniestro;
    @FindBy(xpath = "//*[@id='MCA_SEXO_SINI'] | //*[@id='MCA_SEXO_EXP_LEO']")
    public WebElement txtGenero;
    @FindBy(xpath = "//*[@id='IMP_MTO_LESION']")
    public WebElement txtMontoEstimadoDeLesion;


    /*******************************
     * Datos Siniestro
     * ******************************/


    @FindBy(xpath = "//*[contains(text(),'DAÑOS MATERIALES PARCIALES')]")
    public WebElement menuDaniosMateriales;

    @FindBy(xpath = "//*[contains(text(),'DAÑOS PROPIOS CRISTALES')]")
    public WebElement menuDaniosPropiosCristales;

    @FindBy(xpath = "//*[contains(text(),'Expediente:')]")
    public WebElement menuExpediente1;

    @FindBy(xpath = "//*[contains(text(),'ceptar')]")
    public WebElement btnAceptarExpediente1;

    //Danios
    @FindBy(xpath = "//*[@id='COD_IMPACTO']")
    public WebElement txtDireccionImpacto;
    @FindBy(xpath = "//*[@id='TIP_DANO_EXP']")
    public WebElement txtMagnitud;
    @FindBy(xpath = "//input[@type='image' and @src='commons/img/ocu.svg' and @name='ocaNUM_COD_PARTE']")
    public WebElement btnNumeroDanios;
    @FindBy(xpath = "//*[@id='MCA_CORRALON']")
    public WebElement txtEnCola;

    //Grua
    @FindBy(xpath = "//*[@id='MCA_GRUA']")
    public WebElement txtRequirio;
    @FindBy(xpath = "//*[@id='TIP_GRUA']")
    public WebElement txtTipoGrua;
    @FindBy(xpath = "//*[@id='COD_GRUA']")
    public WebElement txtCodDeProveedor;

    //Daos
    @FindBy(xpath = "//*[@id='IMP_VAL_COM_VEHI']")
    public WebElement txtVcAlMomentoDelSiniestro;
    @FindBy(xpath = "//*[@id='IMP_VAL_DAN']")
    public WebElement txtEstimacionDeLosDaos;
    @FindBy(xpath = "//*[@id='MCA_PAGO_CRUCERO']")
    public WebElement txtPagoEnCrucero;

    //Recuperacion
    @FindBy(xpath = "//*[@id='TIP_RESPONSABILIDAD'] | //*[@id='TIP_RESPONSABILIDAD_EXP']")
    public WebElement txtResponsabilidad;
    @FindBy(xpath = "//*[@id='TIP_RECUPERACION'] | //*[@id='TIP_RECUPERACION']")
    public WebElement txtAplicaRecuperacion;
    @FindBy(xpath = "//*[@id='MCA_DEDUCIBLE']")
    public WebElement txtMarcaDeducible;
    @FindBy(xpath = "//*[@id='PCT_DEDUCIBLE_ADIC']")
    public WebElement txtDeducibleAdicionalPorPen;


    /*******************************
     * Datos Siniestro Cristales
     * ******************************/

    //Cristales
    @FindBy(xpath = "//*[@id='TIP_ATENCION'] | //*[@id='TIP_ATENCION_EXP'] ")
    public WebElement txtTipoDeAtencionDPC;
    @FindBy(xpath = "//*[@id='COD_ACT_ATE'] | //*[@id='COD_ACT_ATE_EXP']")
    public WebElement txtActividadDeAtencionDPC;
    @FindBy(xpath = "//*[@id='TIP_CDR'] | //*[@id='TIP_CDR_EXP']")
    public WebElement txtTipoCdrDPC;
    @FindBy(xpath = "//*[@id='COD_TERCERO'] | //*[@id='COD_TERCERO_EXP_DPC']")
    public WebElement txtCodigoTerceroDPC;
    @FindBy(xpath = "//input[@type='image' and @src='commons/img/ocu.svg' and @name='ocaNUM_CRISTALES'] | " +
            "//input[@type='image' and @src='commons/img/ocu.svg' and @name='ocaNUM_CRISTALES_EXP']")
    public WebElement btnNumeroDeCristalesDPC;
    @FindBy(xpath = "//*[@id='MCA_DEDUCIBLE'] | //*[@id='MCA_DEDUCIBLE_EXP']")
    public WebElement txtMarcaDeducibleDPC;
    //Cristal
    @FindBy(xpath = "//*[@id='TIP_CRISTAL'] | //*[@id='TIP_CRISTAL_EXP']")
    public WebElement txtTipoCristalDPC;


    //Cristaleria
    @FindBy(xpath = "//*[@id='FEC_SERV_PRESTADO']")
    public WebElement txtFechaDelServicioPrestadoDPC;
    @FindBy(xpath = "//*[@id='HOR_SERV_PRESTADO']")
    public WebElement txtHoraDelServicioPrestadoDPC;

    //Grua
    @FindBy(xpath = "//*[@id='MCA_GRUA']")
    public WebElement txtRequirioDPC;
    @FindBy(xpath = "//*[@id='TIP_GRUA']")
    public WebElement txtTipoDPC;
    @FindBy(xpath = "//*[@id='COD_PROVEEDOR']")
    public WebElement txtCodigoDeProveedorDPC;

    //Transversal
    @FindBy(xpath = "//*[@id='MCA_FRAUDE_SIN']")
    public WebElement txtPosibleFraudeDPC;
    @FindBy(xpath = "//*[@id='MCA_IQR']")
    public WebElement txtIqrDPC;








    @FindBy(xpath = "//*[contains(text(),'DATOS DEL SINIESTRO')]")
    public WebElement txtMenuDatosSiniestro;


    @FindBy(xpath = "(//span[@ng-bind-html=\"('BtnVrf.lbl' | translate)\" and contains(text(), 'erificar') ])[1]")
    public WebElement btnVerificarDatosDelSiniestro;
    @FindBy(xpath = "(//span[@ng-bind-html=\"('BtnAcp.lbl' | translate)\" and contains(text(), 'ceptar') ])[1]")
    public WebElement btnAceptarDatosDelSiniestro;

    @FindBy(xpath = "//span[text()='inalizar']")
    public WebElement btnFinalizar;

    @FindBy(xpath = "//*[contains(text(),'¿ DESEA TERMINAR LA APERTURA DE EXPEDIENTES ?')]")
    public WebElement txtMensajeTerminarAperturaExp;

    @FindBy(xpath = "//div[@class='modal-body']/descendant::label[1]")
    public WebElement labelNoEmision;

    @FindBy(xpath = "//body/descendant::u[contains(text(),'V')][last()]")
    public WebElement btnVerificarDatosGlobal;
    @FindBy(xpath = "//body/descendant::u[contains(text(),'F')][last()]")
    public WebElement btnFinalizarGlobal;


    /*******************************
     * Crear Expediente
     * ******************************/

    @FindBy(xpath = "//tr[td[contains(text(), 'DAÑOS MATERIALES PARCIALES')]]")
    public WebElement btnDMP;
    @FindBy(xpath = "//tr[td[contains(text(), 'DEDUCIBLE')]]")
    public WebElement btnDED;
    @FindBy(xpath = "//tr[td[contains(text(), 'DEFENSA JURIDICA ASEGURADO')]]")
    public WebElement btnDJA;
    @FindBy(xpath = "//tr[td[contains(text(), 'LESIONES OCUPANTES')]]")
    public WebElement btnLEO;
    @FindBy(xpath = "//tr[td[contains(text(), 'DAÑOS CRISTALES')]]")
    public WebElement btnDCP;

    @FindBy(xpath = "//input[@type='image' and @src='commons/img/ocu.svg' and @name='ocaNUM_PARTE_EXP']")
    public WebElement btnDescripcionDanios;

    @FindBy(xpath = "//button[@class='btn btn-navigation pull-right ng-scope' and contains(span/text(), 'erificar')]")
    public WebElement btnVerificarAperturaExp;

    @FindBy(xpath = "//button[@class='btn btn-navigation pull-right ng-scope' and contains(span/text(), 'ceptar')]")
    public WebElement btnAcceptarAperturaExp;

    @FindBy(xpath = "//*[@id='COD_ABOGADO_EXP']")
    public WebElement txtAbogado;
    @FindBy(xpath = "//*[@id='FEC_ASIG_EXP']")
    public WebElement txtFechaAsignacion;
    @FindBy(xpath = "//*[@id='HOR_ASIG_EXP']")
    public WebElement txtHoraAsignacion;


    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[1]/div/div/form/div/div[4]/div[3]/div[1]/input")
    public WebElement inputNumSimiestro;

    @FindBy(xpath = "//*[@id=\"app-content-container\"]/div/div[2]/div/div/button[3]")
    public WebElement btnSiguienteApertura;

    @FindBy(xpath = "//select[@class='ui-pg-selbox']/option[@value='15']")
    public WebElement liPaginas;

    /*******************************
     * Crear Expediente LEO
     * ******************************/

    @FindBy(xpath = "//*[@id='COD_LESIONADOS_EXP']")
    public WebElement txtLesionadosLEO;

    @FindBy(xpath = "//*[@id='MCA_AMBULANCIA_EXP']")
    public WebElement txtRequiereAmbulancia;
    @FindBy(xpath = "//*[@id='TXT_RELAC_LES']")
    public WebElement txtRelacionContratante;

    /*******************************
     * Crear Expediente DED
     * ******************************/

    @FindBy(xpath = "//input[@type='number' and @name='nmrAfdFilVal' and @ng-model='oLssFliForm.oLssFliS.afdFilVal']")
    public WebElement txtNumeroExpediente;

    @FindBy(xpath = "//*[@id='MCA_DED_RESP_EXP']")
    public WebElement txtDeducibleResponsable;
    @FindBy(xpath = "//*[@id='VAL_MTO_DED_RESP_EXP']")
    public WebElement txtMontoDeducibleResponsable;
    @FindBy(xpath = "//*[@id='MCA_DED_COND_UNI_EXP']")
    public WebElement txtDeduciblePorConductorUni;
    @FindBy(xpath = "//*[@id='VAL_MTO_DED_COND_UNI_EXP']")
    public WebElement txtMontoPorDedConductorUni;
    @FindBy(xpath = "//*[@id='MCA_DED_DESBI_EXP']")
    public WebElement txtDeduciblePorDesbielamiento;
    @FindBy(xpath = "//*[@id='VAL_MTO_DED_DESBI_EXP']")
    public WebElement txtMontoPorDedDesbielamiento;
    @FindBy(xpath = "//*[@id='TIP_DED_INSP_OTR_EXP']")
    public WebElement txtDeduciblePorInspeccionOtros;
    @FindBy(xpath = "//*[@id='VAL_MTO_DED_INSP_OTR_EXP']")
    public WebElement txtMontoPorDedInspeccionOtros;
    @FindBy(xpath = "//*[@id='IMP_VAL_DEDUCIBLE_TOTAL']")
    public WebElement txtMontoTotalDeducible;
    @FindBy(xpath = "//*[@id='MCA_DED_ADM_EXP']")
    public WebElement txtDeducibleAdministrativo;
    @FindBy(xpath = "//*[@id='MCA_IQR_EXP']")
    public WebElement txtIqr;
    @FindBy(xpath = "//*[@id='MCA_FRAUDE_EXP']")
    public WebElement txtFraude;


    @FindBy(xpath = "//button[@class='btn btn-default ng-binding' and @ng-click='btnAcept()' and text()='ceptar']")
    public WebElement btnAceptarModoValoracionExp;

    @FindBy(xpath = "//input[@ng-model='mnlOtn']")
    public WebElement cbAutomatico;





    @Autowired
    public SiniestrosDMPUI(DriverManager driverManager){
        super(driverManager);
    }
}
