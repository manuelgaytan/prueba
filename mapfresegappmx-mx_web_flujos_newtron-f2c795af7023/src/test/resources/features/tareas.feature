@CSV
@Regresion1 @Tareas @A1EmisionesG @AdministracionRegressionUat
Feature: Flujo aplicacion masiva de bancos

  @aplicacionMasivaDeBancos-UAT
  Scenario Outline:APLICACIÓN MASIVA DE BANCOS
    #tareas.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingresar a Envio de Archivos al Servidor Tronweb Report
    And CP001_Carga de archivo a TronWeb reports
    And Ingresar a Lanzador de Tareas
    And CP002_Ejecución de tarea MMXGC00171 "<tarea>", "<codigoDeCampania>", "<tipoProceso>", "<orden>", "<tipoDeGestor>", "<codigoDeGestor>", "<tipoDeNegocio>", "<descuentoComision>", "<formaDeCompensacion>", "<repocesaPolConError>", "<nombreArchivo>"
    And CP003_Descargar archivo de salida
    And CP004_Consulta aplicación de cobros
    Then CP005_Aplicacion cobros

    Examples:
| tarea | codigoDeCampania | tipoProceso | orden | tipoDeGestor | codigoDeGestor | tipoDeNegocio | descuentoComision | formaDeCompensacion | repocesaPolConError | nombreArchivo | 
| MMXGC00171 | 1 | 20 | 1 | BA | 3 | 704 | N | 2 | S | COBROSELE.txt |
