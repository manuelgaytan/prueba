@CSV
@Regresion-REC @siniestrosCristalesLEO-Rec @SiniestrosRegressionRec
Feature: Flujos Siniestros

  @siniestrosCristales-REC
  Scenario Outline:Siniestro Colision
    #siniestro_cristales_rec.csv |
    Given Inicio la sesión con usuario y contrasena REC
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
| poliza | codigoMotivoSiniestro | codTipoAsegurado | consecuencia | consecuencia2 | codPais | codEstado | codPoblacion | codPostal | calle | colonia | entreCalles | mismoLugarRobo | codPaisRT | ubiVia | direccionA | codPoblacionRT | calleyNoRT | coloniaRT | entreCallesRT | referenciaRT | cpRT | color | cita | tipoAjuste | codAbogado | codAjustador | latitud | longitud | nombre | apellidoPat | apellidoMat | motivoSiniestro | 
| 4102500044074 | 6 | 5 | ROTURA DE CRISTAL | LESIONADOS VEHICULO ASEGURADO | MEX | 21 | 21197 | 73080 | Hidalgo | Centro | Privada de Juarez Y Guerrero | N | MEX | CAL | Calle Hidalgo #200 Col. Centro | 21197 | Testing | Centro | Privada de Juarez Y Guerrero | Ninguna referencia | 73080 | 1 | N | 1 | null | null | 20.250462910699095 | -97.9463570164121 | ERNESTO | MORALES | NEVAREZ | COLISION Y/O VOLCADURA |
  @CreacionExpedienteCristales-RE
  Scenario: CP002_Creacion de expendiente DPC
    #CP002_Creación| de expedientes
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a apertura de expediente cristales
    And Llenado de danos cristales
    And Datos Complementarios expediente
    Then Fiinalizar expediente

  @CreacionExpedienteLEO
  Scenario: CP003_Creacion de expendiente LEO
    #CP002_Creación| de expedientes
    Given Inicio la sesión con usuario y contrasena REC
    And Ir a apertura de expediente lesionados
    And Llenado de lesiones ocupantes
    And Datos Complementarios lesionados
    Then Finalizar expediente Leo



