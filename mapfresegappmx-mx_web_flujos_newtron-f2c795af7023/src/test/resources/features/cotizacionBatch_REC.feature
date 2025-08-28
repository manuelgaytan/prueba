@CSV
@Regresion-REC @batch-REC
Feature: Flujo completo de Cotización Batch

  @cotizacionBatch-REC
  Scenario Outline: CP025_Cotización Batch General
    #cot_batch.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Voy al apartado suplemento de administracion de tareas
    And Voy al apartado de tareas "<tarea>", "<codEstructura>"
    And Validamos tareas

    Examples:
| tarea | codEstructura | 
| MMXCARFIGR | MMXEATEMPR |
