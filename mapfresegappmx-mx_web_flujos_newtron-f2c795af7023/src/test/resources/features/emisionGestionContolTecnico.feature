@CSV
@Regresion @ControlTecnico @EmisionesRegressionUat
Feature: Flujo completo de Gestión Control Tecnico Emision

  @Autorizacion-UAT
  Scenario Outline: CP001_AUTORIZACIÓN CT
    #gestion_control_tecnico.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingresar a Gestión Control Técnico Emisión
    And Buscar poliza
    And Seleccionar poliza "<observaciones>"
    And Autorizar poliza
    Examples:
| numeroPoliza | observaciones | numeroPolizaRechazar | observacionesRechazar | 
| 4112400002238 | observaciones | 4112400002229 | observaciones |


  @Rechazo-UAT
  Scenario Outline: CP002_RECHAZO CT
    Given Inicio la sesión con usuario y contrasena
    And Ingresar a Gestión Control Técnico Emisión
    And Buscar poliza
    And Seleccionar poliza "<observacionesRechazar>"
    And Rechazar poliza
    Examples:
| numeroPoliza | observaciones | numeroPolizaRechazar | observacionesRechazar | 
| 4112400002238 | observaciones | 4112400002229 | observaciones |
