@CSV
@Regresion @CierreEmision @CIMSAdministracion @AdministracionRegressionUat
Feature: Flujos Administracion Cierre contable de Emisión
   #CP002_Cierre contable de emisión

  @PrecontableEmision-UAT
 Scenario: precontable de Emisión
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "TRNGCA0010"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

   ###########################
   ###ASIENTO DE EMISION ####
  ###########################
  @AsientosEmisionAnulacionTarea001-UAT
  Scenario: Asientos de Emisión Anulacion 001
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "TRNGCA0001"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea002-UAT
  Scenario: Asientos de Emisión 002
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGCA0002"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea096-UAT
  Scenario: Asientos de Emisión 096
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGCL0096"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea098-UAT
  Scenario: Asientos de Emisión 098
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00098"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea128-UAT
  Scenario: Asientos de Emisión 128
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00128"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo

  @AsientosEmisionTarea129-UAT
  Scenario: Asientos de Emisión 129
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    And Ejecutar tarea "MMXGC00129"
    And Completar el formulario de atributos Primero a Fin de Mes
    Then Validar situación del archivo


    ###########################
    ### REPORTE DE EMISION ####
    ###########################
  @ReporteEmisionTarea010-UAT
  Scenario: Reporte de Emisión 010
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0010"
    And Completar el formulario de atributos Reportes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "EMIANA"

  @ReporteEmisionTarea015-UAT
  Scenario: Reporte de Emisión 015
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0015"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5022"

  @ReporteEmisionTarea016-UAT
  Scenario: Reporte de Emisión 016
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0016"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5027"

  @ReporteEmisionTarea017-UAT
  Scenario: Reporte de Emisión 017
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0017"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5028"

  @ReporteEmisionTarea018-UAT
  Scenario: Reporte de Emisión 018
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0018"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpex5039"

  @ReporteEmisionTarea154-UAT
  Scenario: Reporte de Emisión 154
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXCOL0154"
    And Completar el formulario de atributos Primero a Fin de Mes con codigo de sector
    And Validar situación del archivo
    Then Validar que se descargue el reporte "Emision_a_detalle_canal"

  @ReporteEmisionTarea193-UAT
  Scenario: Reporte de Emisión 193
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXGCL0193"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "rpt_dev_detalle"

  @ReporteEmisionTarea192-UAT
  Scenario: Reporte de Emisión 192
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "MMXGCL0192"
    And Completar el formulario de atributos Primero a Fin de Mes
    And Validar situación del archivo
    Then Validar que se descargue el reporte "lista_dev_control"

  @ReporteEmisionTarea0009-UAT
  Scenario: Reporte de Emisión 009
    Given Inicio la sesión con usuario y contrasena
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
  @ValidadorAsientosEMI-UAT
 Scenario Outline: Validador de Asientos EMI
    #cierre_emision.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","EMI","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_EMI"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_EMI" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosANE-UAT
  Scenario Outline: Validador de Asientos ANE
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","ANE","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_ANE"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_ANE" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosANU-UAT
  Scenario Outline: Validador de Asientos ANU
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","ANU","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_ANU"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_ANU" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosREW-UAT
  Scenario Outline: Validador de Asientos REW
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","REW","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_REW"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_REW" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |

  @ValidadorAsientosFEW-UAT
  Scenario Outline: Validador de Asientos FEW
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
    Given Ejecutar tarea "TRNCO10000"
    And Completar el formulario de atributos Validador de Asientos "<CodEjercicio>","FEW","<NumeroAsiento>","<ListaErrores>","<BorraAsiento>","<ListadoCampos>","CO_VAL_FEW_det"
    And Validar situación del archivo
    Then Validar que se descargue el reporte que comienza con "CO_VAL_FEW_DE" y termine en "_det"
    Examples:
| CodEjercicio | NumeroAsiento | ListaErrores | BorraAsiento | ListadoCampos | Resumido | Reprocesar | 
| 2024 | 1 | S | N | E | N | N |
