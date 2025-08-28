@CSV
@Regresion @siniestrosCristalesLEO @SiniestrosRegressionUat
Feature: Flujos Siniestros

  @siniestrosCristales
  Scenario Outline:Siniestro Colision
    #siniestro_cristales.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Apertura siniestro"
    And Ingreso datos generales para siniestro nuevo "<poliza>"
    And Busqueda de apertura de siniestro nuevo "<codigoMotivoSiniestro>","<codTipoAsegurado>","<consecuencia>","<consecuencia2>"
    And Llenamos relatos sobre siniestro nuevo
    And Llenamos ubicación del siniestro: nuevo "<codPais>","<codEstado>","<codPoblacion>","<codPostal>","<calle>","<colonia>","<entreCalles>","<latitud>","<longitud>","<ubiVia>","<direccionA>"
    And Llenamos datos de robo total: nuevo "<consecuencia>","<mismoLugarRobo>","<codPaisRT>","<ubiVia>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>"
    And Vehículo asegurado: nuevo "<color>"
    And Ajustador: nuevo "<consecuencia>","<codAjustador>"
    And Abogado: nuevo "<consecuencia>","<codAbogado>"
    And Llenamos datos complementarios de siniestro: nuevo "<nombre>","<apellidoPat>","<apellidoMat>","<cita>","<codEstado>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>","<latitud>","<longitud>","<tipoAjuste>"
    And Clic finalizar siniestro nuevo
    And Ventana de siniestro Cristales exitoso nuevo
    Examples:
      | file@data_siniestro_cristales.csv |

  @CreacionExpedienteCristales
  Scenario: CP002_Creacion de expendiente DPC
    #CP002_Creación| de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir a apertura de expediente cristales
    And Llenado de danos cristales
    And Datos Complementarios expediente
    Then Fiinalizar expediente

  @CreacionExpedienteLEO
  Scenario: CP003_Creacion de expendiente LEO
    #CP002_Creación| de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir a apertura de expediente lesionados
    And Llenado de lesiones ocupantes
    And Datos Complementarios lesionados
    Then Finalizar expediente Leo



