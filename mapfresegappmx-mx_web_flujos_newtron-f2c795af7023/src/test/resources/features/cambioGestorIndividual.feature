@CSV
@Regresion @CambioGestorIndvidualCompleto @AdministracionRegressionUat
Feature: Flujo cambio de gestor de forma Individual
#Solo se aplicara en UAT
  @CambioGestorIndividual-UAT
  Scenario: Realizar cambio de gestor de forma Individual
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea 'MMXGC00303'
    And Atributos de poliza

  @CambioGestorIndividualConsultarCambios-UAT
  Scenario: Consultar cambio de gestor de forma Individual
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Emisión" Opcion "Consultar póliza"
    Then Consultar cambios

