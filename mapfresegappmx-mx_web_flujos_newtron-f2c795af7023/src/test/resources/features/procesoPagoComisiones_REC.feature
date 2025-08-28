@CSV
@ProcesoPagoComision-REC @CIMSAdministracion23-REC @AdministracionRegressionRec
Feature: Proceso Pago Comisión

  @TareaMMXGCL0113-REC
  Scenario Outline: Lanzador de tareas MMXGCL0113
    #proceso_pago_comision.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu 'Tareas' Opcion 'Lanzador de tareas'
    And Ejecutar tarea 'MMXGCL0113'
    And Completar formulario Atributos de Proceso Pago Comision "<FechaProInicial>","<FechaProFinal>","<Detalle/Resumido>","<CodAgente>"
    And Descargar archivo de salida que comience con 'gc_k_pagos_comis_agt_59510_'
    And Validar que se muestre el archivo que comienza con 'gc_k_pagos_comis_agt_59510_' y no contenga 'log'
    Examples:
| CodCompania | FechaProInicial | FechaProFinal | Detalle/Resumido | CodAgente | 
| 1 | 01/01/2025 | 22/01/2025 | D | 59510 |
