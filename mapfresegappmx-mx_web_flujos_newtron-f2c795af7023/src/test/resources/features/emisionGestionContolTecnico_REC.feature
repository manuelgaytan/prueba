@CSV
@Regresion-RECNO @ControlTecnico-REC @EmisionesRegressionRec
Feature: Flujo completo de Gestión Control Tecnico Emision

  @Autorizacion-REC
  Scenario Outline: CP001_AUTORIZACIÓN CT
    #gestion_control_tecnico_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingresar a Gestión Control Técnico Emisión
    And Buscar poliza
    And Seleccionar poliza "<observaciones>"
    And Autorizar poliza
    Examples:
| numeroPoliza | observaciones | numeroPolizaRechazar | observacionesRechazar | 
| 2541010063380 | observaciones | 4112500076187 | observaciones |


  @Rechazo-REC
  Scenario Outline: CP002_RECHAZO CT
    Given Inicio la sesión con usuario y contrasena REC
    And Ingresar a Gestión Control Técnico Emisión
    And Buscar poliza
    And Seleccionar poliza "<observacionesRechazar>"
    And Rechazar poliza
    Examples:
| numeroPoliza | observaciones | numeroPolizaRechazar | observacionesRechazar | 
| 2541010063380 | observaciones | 4112500076187 | observaciones |
