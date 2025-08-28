@CSV @CIMSAdministracion2-REC @AdministracionRegressionRec
Feature: Flujo completo Reportes de cobranza - Administración

  @LanzadorTareas047-REC
  Scenario Outline: Lanzador de tareas 047 - Reporte general recobros
    #lanzador_tareas.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0047'
    And Buscar tarea "<nombretxt>","<tarea47>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'rpt_cobro_siniestros_recobro' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1289807560 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas051-REC
  Scenario Outline: Lanzador de tareas 051 - Prima cancelación automática
    #lanzador_tareas.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0051'
    And Buscar tarea "<nombretxt>","<tarea51>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'CANCELACION REAL' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1289807560 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas0113-REC
  Scenario Outline: Lanzador de tareas 113 - Agentes. Previo de Comisiones
    #lanzador_tareas.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0113'
    And Buscar tarea "<nombretxt>","<tarea113>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'gc_k_pagos_comis_agt' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1289807560 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas118-REC
  Scenario Outline: Lanzador de tareas 118 - CP003_Prima cobrada
    #lanzador_tareas.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0118'
    And Buscar tarea "<nombretxt>","<tarea118>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'Prima_cobrada' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1289807560 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas154-REC
  Scenario Outline: Lanzador de tareas 154 - Reporte de emison a detalle
    #lanzador_tareas.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXCOL0154'
    And Buscar tarea "<nombretxt>","<tarea154>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'Emision_a_detalle_canal' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1289807560 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |
