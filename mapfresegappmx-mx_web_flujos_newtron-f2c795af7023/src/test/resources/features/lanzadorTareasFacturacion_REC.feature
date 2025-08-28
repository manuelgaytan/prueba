@CSV
@Regresion-REC @LanzadorTareasF-REC @FacturacionRegressionRec
Feature: Flujo completo Reportes de cobranza - facturación

  @CargaArchivo-REC
  Scenario: Envio de Archivos al Servidor
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Facturación
    And Seleccionar y cargar archivo

  @LanzadorTareas45-REC
  Scenario Outline: Lanzador de tareas 45
  #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0045'
    And Completar el formulario de atributos "<bloquet>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |

  @LanzadorTareas002-REC
  Scenario Outline: Lanzador de tareas 002
    #lanzador_tareas_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a Tareas
    And Ejecutar tarea 'MMXGCL0002'
    And Ingresar archivo .txt "<nombretxt>","<tarea002>"
    And Validar situación del archivo .txt
    And CP002_Descarga archivo de salida tarea
    Examples:
| tarea002 | tarea103 | tarea127 | tarea308 | tarea172 | tarea304 | tarea179 | tarea131 | tarea305 | tarea5 | tarea11 | tarea136 | tarea45 | tarea50 | nombretxt | bloquet | codArchivo | tarea118 | tarea154 | tarea51 | tarea47 | tarea113 | 
| MMXGCL0002 | MMXGCL0103 | MMXGCL0127 | MMXGC00308 | MMXGC00172 | MMXGC00304 | TRNGC00179 | MMXGC00131 | MMXGC00305 | MMXTSL0005 | MMXTSL0011 | MMXGCL0136 | MMXGCL0045 | MMXGCL0050 | test.txt | 21024002205 | 1486677949 | MMXGCL0118 | MMXCOL0154 | MMXGCL0051 | MMXGCL0047 | MMXGCL0113 |
