@CSV
@Regresion-REC @AdministracionRegressionRec
Feature: Flujo completo Alta de Agentes
  @AltaAgente-REC
  Scenario Outline: Alta de un agente
    #alta_Agente.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And CP001_Crear agente y completar datos basicos "<RazonSocial>","<PrimerApellido>","<SegundoApellido>","<PersonaFisica>","<TipoDocumento>"
    And CP002_Completar datos persona legal "<AliasTercero>"
    And CP003_Completar datos persona "<Nombre>", "<Apellido1>", "<Apellido2>"
    And CP004_Completar datos agente "<Situacion>","<Beneficiario>","<Comercial>","<TipoAgente>","<FuenteProduccion>","<TipoRetencion>","<FormaTerceroPc>","<CalidadTercero>","<AgrupamientoTercero>","<FormaGestion>","<TipoClasificacion>"
    And Fuentes de Distribuccion por agente "<FuenteProduccion>"
    When CP005_Consultar en rutina de terceros "<TipoDocumento>"
    Examples:
| RazonSocial | PrimerApellido | SegundoApellido | PersonaFisica | TipoDocumento | Actividad | AliasTercero | Nombre | Apellido1 | Apellido2 | Situacion | Beneficiario | Comercial | TipoAgente | FuenteProduccion | TipoRetencion | FormaTerceroPc | CalidadTercero | AgrupamientoTercero | FormaGestion | TipoClasificacion | 
| JOSE | ALVA | VEGA | S | RFC | 2 | Agente Seguros | Felipe | Jimenez | Lopez | 1 | 0 | 1301 | 1 | 1301 | RE | 1 | 1 | 1 | 2 | 3 |
