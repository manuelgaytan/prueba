@CSV
@Regresion @GestorCobro @AdministracionRegressionUat
Feature: Flujo Gestor de Cobros

  @LanzadorTareasGC-UAT
  Scenario Outline: GESTOR DE COBRO
    #gestor_cobro.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu 'Tareas' Opcion 'Lanzador de tareas'
    And Ejecutar tarea 'TRNEMMEXGC'
    And Completar formulario Atributos "<NumPoliza>","<SecuenciaMedia>","<CodigoGestor>","<FechaEfecto>","<DiaPago>"
    And Ir al Menu 'Emisión' Opcion 'Consultar póliza'
    And CP003_Consultar Poliza "<NumPoliza>"

    Examples:
| NumPoliza | SecuenciaMedia | CodigoGestor | FechaEfecto | DiaPago | 
| 4102500044061 | 2 | SANTANDER | 09/09/2025 | 12 |
