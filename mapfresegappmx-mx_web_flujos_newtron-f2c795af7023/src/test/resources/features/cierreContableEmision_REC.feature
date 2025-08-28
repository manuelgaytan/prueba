@CSV
@Regresion-REC @CierreEmision-REC @CIMSAdministracion-REC @AdministracionRegressionRec
Feature: Flujos Administracion Cierre contable de Emisión
   #CP002_Cierre contable de emisión

  @PrecontableEmision-REC
 Scenario: precontable de Emisión
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "TRNGCA0010"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

   ###########################
   ###ASIENTO DE EMISION ####
  ###########################
  @AsientosEmisionAnulacionTarea001-REC
  Scenario: Asientos de Emisión Anulacion 001
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "TRNGCA0001"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea002-REC
  Scenario: Asientos de Emisión 002
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGCA0002"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea098-REC
  Scenario: Asientos de Emisión 098
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00098"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea128-REC
  Scenario: Asientos de Emisión 128
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00128"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea129-REC
  Scenario: Asientos de Emisión 129
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00129"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo


    ###########################
    ### REPORTE DE EMISION ####
    ###########################
  @ReporteEmisionTarea010-REC
  Scenario: Reporte de Emisión 010
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0010"
    And Completar el formulario de atributos Reportes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "EMIANA"

  @ReporteEmisionTarea015-REC
  Scenario: Reporte de Emisión 015
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0015"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5022"

  @ReporteEmisionTarea016-REC
  Scenario: Reporte de Emisión 016
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0016"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5027"

  @ReporteEmisionTarea017-REC
  Scenario: Reporte de Emisión 017
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0017"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5028"

  @ReporteEmisionTarea018-REC
  Scenario: Reporte de Emisión 018
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0018"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5039"

  @ReporteEmisionTarea154-REC
  Scenario: Reporte de Emisión 154
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0154"
    And Completar el formulario de atributos Primero a Fin de Mes con codigo de sector
    And Validar situación del archivo
    Then Validar que se descargue el reporte "Emision_a_detalle_canal"

  @ReporteEmisionTarea193-REC
  Scenario: Reporte de Emisión 193
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXGCL0193"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpt_dev_detalle"

  @ReporteEmisionTarea192-REC
  Scenario: Reporte de Emisión 192
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXGCL0192"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "lista_dev_control"

  @ReporteEmisionTarea0009-REC
  Scenario: Reporte de Emisión 009
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXGCL0009"
    And Completar el formulario de atributos Primero a Fin de Mes con codigo de sector
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpt_asto_few"
    And Salir del reporte
    And Salir Lanzador Tareas


    ###############################
    #### Validador de Asientos ####
    ###############################
  @ValidadorAsientosEMI-REC
 Scenario Outline: Validador de Asientos EMI
    #cierre_emision.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","EMI","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_EMI"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_EMI" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosANE-REC
  Scenario Outline: Validador de Asientos ANE
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","ANE","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_ANE"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_ANE" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosANU-REC
  Scenario Outline: Validador de Asientos ANU
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","ANU","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_ANU"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_ANU" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosREW-REC
  Scenario Outline: Validador de Asientos REW
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","REW","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_REW"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_REW" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosFEW-REC
  Scenario Outline: Validador de Asientos FEW
    Given Inicio la sesión con usuario y contrasena REC
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","FEW","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_FEW_det"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_FEW_DE" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |
