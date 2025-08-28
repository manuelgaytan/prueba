@CSV
@CIMSAdministracion3  @AdministracionRegressionUat
Feature: Flujos Administracion

  @aplicacionMasiva-UAT @Regresion-UAT @RegresionCIMS-UAT
  Scenario Outline: Aplicación masiva
  # En readCSV se tiene que dejar las siguientes dos lineas despues de // Se usan para local // para pruebas locales o manteimiento
    # y para produción se tiene que dejar las siguientes dos lineas despues de // Se usan para producción //
    #CP006_Aplicación masiva de bancos
    #aplicacion_masiva_bancos.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "<facturacion>" Opcion "<envioArchivos>"
    And Cargar Archivo "<NombreArchivo>"
    And Ir al Menu "<tareas>" Opcion "<lanzadorTareas>"
    And Ejecutar tarea "<tarea>"
    And Completar formulario Atributos AMB "<CodCompania>","<TipoProceso>","<TipoGestor>"
    And Completar formulario Atributos AMB2 "<CodigoGestor>","<TipoNegocio>","<FormaCompensacion>","<NombreArchivo>"
    And Aceptar formulario "<CodCompania>","<NombreArchivo>"
    And Descargar archivo de salida
    And Consulta aplicación de cobros
    Examples:
| facturacion | envioArchivos | lanzadorTareas | tareas | tarea | CodCompania | TipoProceso | TipoGestor | CodigoGestor | TipoNegocio | FormaCompensacion | NombreArchivo | 
| Facturación | Envío de Archivos al Servidor TronWeb Reports | Lanzador de tareas | Tareas | MMXGC00171 | 1 | 20 | BA | 3 | Banamex - 1 - B1301 - x 2432 | 2 | cobrosselec.txt |

  @HistoricoCobro-UAT @Regresion-UAT @RegresionCIMS-UAT
  Scenario: Historico de Cobro
    #CP006_Historico de cobro
    # Requiere de la ejecución de aplicación masiva de bancos @aplicacionMasiva
    # extrae numeroAviso de @aplicacionMasiva mediante un json
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Tesorería" Opcion "Histórico cobros"
    Then Historico cobros


  @CargaBatch-UAT @Regresion-UAT @RegresionCIMS-UAT
  Scenario: Generación Carga Batch
    # CP013_Generacion carga batch
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu 'Tesorería' Opcion 'Gestión cobros batch'
    And Añadir proceso
    And Validar carga situacion de carga
    #And Filtrar recibo por DB
    #And Gestionar Archivo


  @GenerarAvisoBatch-UAT
  Scenario: Generar Avisos Batch
    # CP014_Generar Avisos Batch
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu 'Tesorería' Opcion 'Gestión cobros batch'
    And Consultar ya excepcionado
    And Filtrar recibo por 'DB'
    And Gestionar Archivo

  @CrearLayoutBancario-UAT
  Scenario: Layout Bancario
    # CP014_Creaciónn de layout bancarios
    Given Inicio la sesión con usuario y contrasena
    And Validar que se descargue el reporte "1e"


#  @DomiciliacionMasiva
#  Scenario: Realizar la domiciliación masiva
#    CP011_Realizar la domiciliacion de forma masiva tarea MMXGC00002
#    Given Inicio la sesión con usuario y contrasena
#    And Ir al Menu "Tareas" Opcion "Lanzador de tareas"
#    Then Ejecutar tarea 'MMXGC00002'
#    And Completar Atributos "TA_DOMI_DESA.TXT", "Cfakepathtadomi" el valor "C:\fakepath\TA_DOMI_DESA.TXT"
#    And Validar situación del archivo .txt




