@CSV
@EmisionesBatch-REC
Feature: Proceso completo de emisiones por medio de batch.

    @BatchEmisionGeneral-REC
    Scenario Outline: CP001 Emision General Batch
      #emisionGralbatch.csv |
      Given Inicio la sesión con usuario y contrasena REC
      And Ingresar a Envio de Archivos al Servidor
      And Cargar archivos Emision Batch "<archivoGRL>", "<archivoINT>", "<archivoRYC>"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "MMXCARFIGR"
      And Ingresar atributos Batch General "<nombreGRL>", "<nombreINT>", "<nombreRYC>"
      And Ingresar a menu Consultar Proceso Masivo
      And Ingresar atributos Proceso Masivo
      And Obtener numero orden emision general
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "INFPLYGNL"
      Then Ingresar Datos Orden "Emision General"
      Examples:
| archivoGRL | archivoINT |  | archivoRYC | nombreGRL | nombreINT | nombreRYC | 
| \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\GENERAL_EMI_GRL_GUSMARIN.TXT | \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\GENERAL_EMI_INT_GUSMARIN.TXT |  | \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\GENERAL_EMI_RYC_GUSMARIN.TXT | GENERAL_EMI_GRL_GUSMARIN.TXT | GENERAL_EMI_INT_GUSMARIN.TXT | GENERAL_EMI_RYC_GUSMARIN.TXT |

    @BatchEmisionNE-REC
    Scenario Outline: CP00X Emisión Batch NE Creacion Orden
      #emisionBatch.csv |
      Given Inicio la sesión con usuario y contrasena REC
      And Ingresar a Envio de Archivos al Servidor
      And Cargar archivo Emision NE "<archivoEmision>"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "MMXCARFIC"
      Then Cargar Atributos del Archivo "<txtEmision>" y "MMXNRFMEMI", "<procesoEmision>"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "TRNEMNWT50"
      Then Ingresar Atributos Tarea Batch "Emision NE"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "INFCARNISS"
      Then Ingresar Datos Orden "Emision NE"
      Examples:
| archivoEmision | txtEmision | archivoCancelar | txtCancelar | 
| \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\BATCHNRFM_COMP_MODI.TXT | BATCHNRFM_COMP_MODI.TXT | \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\CANCELPOLIZABATCH.TXT | CANCELPOLIZABATCH.TXT |

    @ConsultaVigenciaPolizaNE-REC
    Scenario: CP00X  Consulta Vigencia Poliza NE
      Given Inicio la sesión con usuario y contrasena REC
      Then Validar informacion de poliza

    @CancelarEmisionNE-REC
    Scenario Outline: CP00X Cancelacion Emision NE
      #emisionBatch.csv |
      Given Inicio la sesión con usuario y contrasena REC
      And Ingresar a Envio de Archivos al Servidor
      And Cargar archivo Cancelacion Batch "<archivoCancelar>"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "MMXCARFIC"
      Then Cargar Atributos del Archivo "<txtCancelar>" y "MMXNRFMCAN", "<procesoCancelar>"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "TRNEMNWT50"
      Then Ingresar Atributos Tarea Batch "Cancelar"
      And Ingresar al Lanzador de Tareas
      And Ejecutar tarea "INFCANGNL"
      Examples:
| archivoEmision | txtEmision | archivoCancelar | txtCancelar | 
| \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\BATCHNRFM_COMP_MODI.TXT | BATCHNRFM_COMP_MODI.TXT | \\\\SMX000CTX000V1\\Ctx_Data$\\JOELWILL\\Downloads\\CANCELPOLIZABATCH.TXT | CANCELPOLIZABATCH.TXT |
