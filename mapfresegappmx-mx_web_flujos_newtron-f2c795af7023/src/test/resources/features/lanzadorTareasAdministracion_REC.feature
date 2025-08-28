@CSV
@Regresion-REC @LanzadorTareas-REC @AdministracionRegressionRec
Feature: Flujo completo Reportes de cobranza - Administración

  @CargaArchivo-REC
  Scenario: Envio de Archivos al Servidor
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Facturación
    And Seleccionar y cargar archivo

  @LanzadorTareas045LHD-REC
  Scenario Outline: Lanzador de tareas 045 - Listado histórico del diario
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0045'
    And Buscar tarea "<nombretxt>","<tarea45>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas103-REC
  Scenario Outline: Lanzador de tareas 103 - Reporte gestión de impagos
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0103'
    And Buscar tarea "<nombretxt>","<tarea103>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas118-REC
  Scenario Outline: Lanzador de tareas 118 - CP003_Prima cobrada
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0118'
    And Buscar tarea "<nombretxt>","<tarea118>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo 'Prima_cobrada' de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas127-REC
  Scenario Outline: Lanzador de tareas 127 - Reporte de polizas domiciliadas
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0127'
    And Buscar tarea "<nombretxt>","<tarea127>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas308-REC
  Scenario Outline: Lanzador de tareas 308 - Cambio masivo gestor de cobro
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGC00308'
    And Buscar tarea "<nombretxt>","<tarea308>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas172-REC
  Scenario Outline: Lanzador de tareas 172 - Carga de datos bancarios
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGC00172'
    And Buscar tarea "<nombretxt>","<tarea172>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas136-REC
  Scenario Outline: Lanzador de tareas 136 - RPT de pólizas domiciliadas
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0136'
    And Buscar tarea "<nombretxt>","<tarea136>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas305-REC
  Scenario Outline: Lanzador de tareas 305 - Borrado de buzón
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGC00305'
    And Buscar tarea "<nombretxt>","<tarea305>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas5-REC
  Scenario Outline: Lanzador de tareas 5 - Carga de órdenes de pago
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXTSL0005'
    And Buscar tarea "<nombretxt>","<tarea5>","<codArchivo>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |
