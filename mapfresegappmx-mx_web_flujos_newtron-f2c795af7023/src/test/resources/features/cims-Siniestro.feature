@CSV
@Regresion @CIMSSiniestro @SiniestrosRegressionUat
Feature: Flujos Siniestros

  @SiniestroColision-UAT @RegresionCIMS-UAT
  Scenario Outline:Siniestro Colision
    #siniestro_colision.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Apertura siniestro"
    And Ingreso datos generales para siniestro nuevo "<poliza>"
    And Busqueda de apertura de siniestro nuevo "<codigoMotivoSiniestro>","<codTipoAsegurado>","<consecuencia>"
    And Llenamos relatos sobre siniestro nuevo
    And Llenamos ubicación del siniestro: nuevo "<codPais>","<codEstado>","<codPoblacion>","<codPostal>","<calle>","<colonia>","<entreCalles>","<latitud>","<longitud>","<ubiVia>","<direccionA>"
    And Llenamos datos de robo total: nuevo "<consecuencia>","<mismoLugarRobo>","<codPaisRT>","<ubiVia>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>"
    And Vehículo asegurado: nuevo "<color>"
    And Ajustador: nuevo "<consecuencia>","<codAjustador>"
    And Abogado: nuevo "<consecuencia>","<codAbogado>"
    And Llenamos datos complementarios de siniestro: nuevo "<nombre>","<apellidoPat>","<apellidoMat>","<cita>","<codEstado>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>","<latitud>","<longitud>","<tipoAjuste>"
    And Clic finalizar siniestro nuevo
    And Ventana de siniestro Colision exitoso nuevo
    Examples:
| poliza | codigoMotivoSiniestro | codTipoAsegurado | consecuencia | codPais | codEstado | codPoblacion | codPostal | calle | colonia | entreCalles | mismoLugarRobo | codPaisRT | ubiVia | direccionA | codPoblacionRT | calleyNoRT | coloniaRT | entreCallesRT | referenciaRT | cpRT | color | cita | tipoAjuste | codAbogado | codAjustador | latitud | longitud | nombre | apellidoPat | apellidoMat | motivoSiniestro | 
| 4112500000266 | 1 | 5 | DAOS A TERCERO BIENES Y PERS | MEX | 21 | 21197 | 73080 | Hidalgo | Centro | Privada de Juarez Y Guerrero | N | MEX | CAL | Calle Hidalgo #200 Col. Centro | 21197 | Testing | Centro | Privada de Juarez Y Guerrero | Ninguna referencia | 73080 | 1 | N | 1 | null | null | 20.250462910699095 | -97.9463570164121 | ERNESTO	 | MORALES | NEVAREZ | COLISION Y/O VOLCADURA |

  @CreacionExpediente-UAT @RegresionCIMS-UAT
  Scenario: CP002_Creacion de expendientes
    #CP002_Creación| de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Apertura expediente"
    And Ir a apertura de expediente
    And Llenado de daños parciales
    And Datos Complementarios
    Then Fiinalizar expediente


  @TerminacionExpediente-UAT @RegresionCIMS-UAT
  Scenario: CP003_Terminacion expedientes
    #CP003_Terminación de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Terminar expediente"
    And Ir a terminacion de expedientes
    And Motivo de terminacion
    Then Finaliza expediente


  @RehabilitacionExpediente-UAT @RegresionCIMS-UAT
  Scenario: CP004_Rehabilitar expediente
    #CP005_Rehabilitación de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Rehabilitar expediente"
    And Causa de rehabilitacion
    And Consecuencia rehabilitacion
    Then Finalizar Rehabilitacion

  @rehabilitacionSiniestro-UAT @RegresionCIMS-UAT
  Scenario: Rehabilitar Siniestro
    #CP006_Rehabilitación de siniestros
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Terminar expediente"
    And Introduccion de datos "425411661900349","DMP"
    And Ir al Menu "Siniestros" Opcion "Rehabilitar siniestro"
    And Introduccion de datos rehabilitar siniestro "425411661900349","DMP"
    And Seleccionar Motivo de Siniestro
    And Aceptar datos complementarios


  @modificacionExpediente-UAT @RegresionCIMS-UAT
  Scenario: Modificar Expediente
    #CP007_Modificación de expedientes
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Modificar información expediente"
    And Introduccion de datos modificiacion de expediente "425411661900340","DJA"
    And Seleccionar Abogado


  @modificacionSiniestro-UAT @RegresionCIMS-UAT
  Scenario: Modificación de siniestro
    #CP008_Modificación de siniestros
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Modificar siniestro"
    And Introduccion de datos para modificar siniestro "425411661900340"
    And Modificiar siniestro

  @noAbrirExpediente-UAT @RegresionCIMS-UAT
  Scenario: No se puede abrir ningun expediente por definicion
    #CP009_Si no se puede aperturar ningún expediente por definición, validar que se muestre el mensaje
      # "NO SE PUEDE ABRIR NINGUN TIPO DE EXPEDIENTE POR DEFINICION"
    Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Siniestros" Opcion "Apertura expediente"
    And Introduccion de datos apertura expediente "425411661900349"
