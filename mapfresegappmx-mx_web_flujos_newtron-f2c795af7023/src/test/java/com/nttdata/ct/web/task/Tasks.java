package com.nttdata.ct.web.task;
import com.nttdata.ct.web.cucumber.task.aspect.Task;
import org.springframework.beans.factory.annotation.Autowired;

@Task
public class Tasks {

    @Autowired
    public EmisionIndividualTask emisionIndividualTask;
    @Autowired
    public AutomovilesSuplementoTask automovilesSuplementoTask;
    @Autowired
    public AutomovilesConsultaTask automovilesConsultaTask;
    @Autowired
    public AutomovilesPresupuestoTask automovilesPresupuestoTask;
    @Autowired
    public AutomovilesSiniestroTask automovilesSiniestroTask;
    @Autowired
    public AutomovilesSiniestroNewTask automovilesSiniestronewTask;
    @Autowired
    public ReporteSiniestroTask reporteSiniestroTask;
    @Autowired
    public AutomovilesFlotillasTask automovilesFlotillasTask;
    @Autowired
    public AutoFlotillasSuplementoTask autoFlotillasSuplementoTask;
    @Autowired
    public  AutoFlotillasConsultaTask autoFlotillasConsultaTask;
    @Autowired
    public  ValidacionEmisionIndividualTask validacionEmisionIndividualTask;
    @Autowired
    public  ValidacionEmisionFlotillasTask validacionEmisionflotillasTask;
    @Autowired
    public IndividualEndosoDisminucionTask individualEndosoDisminucionTask;
    @Autowired
    public AltaPersonaFisicaTask altaPersonaFisicaTask;
    @Autowired
    public AltaPersonaMoralTask altaPersonaMoralTask;
    @Autowired
    public IndividualCambioPlacasTask individualCambioPlacasTask;
    @Autowired
    public EndosoCambioPlanPagoTask endosoCambioPlanPago;
    @Autowired
    public EndosoCambioAgenteTask endosoCambioAgenteTask;
    @Autowired
    public LanzadorTareasTask lanzadorTareasTask;
    @Autowired
    public MetodosComunesTask metodosComunesTask;
    @Autowired
    public GestorCobroTask gestorCobroTask;
    @Autowired
    public  BatchTask batchTask;
    @Autowired
    public EndosoCancelacionTask endosoCancelacionTask;
    @Autowired
    public ProveedorPadreTask proveedorPadreTask;
    @Autowired
    public AltaTercerosConAmpersonenRFCTask altaTercerosConAmpersonenRFCTask;
    @Autowired
    public ConsultaFacturaTask consultaFacturaTask;
    @Autowired
    public EmisionGestionControlTecnicoTask emisionGestionControlTecnicoTask;
    @Autowired
    public EmisionConsultaPolizaTask emisionConsultaPolizaTask;
    @Autowired
    public TareasTask tareasTask;
    @Autowired
    public AnulacionSuplementoTask anulacionSuplementoTask;
    @Autowired
    public ConductorHabitualTask conudctorHabitualTask;
    @Autowired
    public ContratanteTomadorTask contratanteTomadorTask;
    @Autowired
    public PagoChequeTask pagoChequeTask;
    @Autowired
    public AplicacionMasivaDeBancosTask aplicacionMasivaDeBancosTask;
    @Autowired
    public ProcesoPagoComisionTask procesoPagoComisionTask;
    @Autowired
    public AltaAgenteTask altaAgenteTask;
    @Autowired
    public CreacionExpedientesTask creacionExpedientesTask;
    @Autowired
    public CambioGestionIndividualTask cambioGestionIndividualTask;
    @Autowired
    public TerminacionExpedienteTask terminacionExpedienteTask;
    @Autowired
    public RehabilitarExpedienteTask rehabilitarExpedienteTask;
    @Autowired
    public SiniestrosTask siniestrosTask;
    @Autowired
    public DomiTask domiTask;
    @Autowired
    public CierreContableSimiestrosTask cierreContableSimiestrosTask;
    @Autowired
    public DatosBancariosPolizaTask datosBancariosPolizaTask;
    @Autowired
    public SiniestrosCristalesTask siniestrosCristalesTask;
    @Autowired
    public SiniestrosDMPTask siniestrosDMPTask;
    @Autowired
    public SiniestrosRoboTask siniestrosRoboTask;

}
