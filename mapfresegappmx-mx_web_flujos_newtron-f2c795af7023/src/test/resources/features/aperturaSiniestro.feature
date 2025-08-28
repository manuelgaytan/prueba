@CSV
@Regresion-UAT @SiniestrosRegresion-UAT
Feature: Flujo completo de siniestro automóviles

  @SiniestroIndividualOtros-UAT
  Scenario Outline: CP001_Apertura de siniestro - OTROS
    #siniestro_otros.csv |
      Given Inicio la sesión con usuario y contrasena
    And Ir apertura de siniestro
    And Ingreso datos generales para siniestro "<poliza>"
    And Busqueda de apertura de siniestro "<codigoMotivoSiniestro>","<codTipoAsegurado>","<consecuencia>"
    And Llenamos relatos sobre siniestro
    And Llenamos ubicación del siniestro: "<codPais>","<codEstado>","<codPoblacion>","<codPostal>","<calle>","<colonia>","<entreCalles>","<latitud>","<longitud>","<ubiVia>","<direccionA>"
    And Llenamos datos de robo total: "<consecuencia>","<mismoLugarRobo>","<codPaisRT>","<ubiVia>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>"
    And Vehículo asegurado: "<color>"
    And Ajustador: "<consecuencia>","<codAjustador>"
    And Abogado: "<consecuencia>","<codAbogado>"
    And Llenamos datos complementarios de siniestro: "<nombre>","<apellidoPat>","<apellidoMat>","<cita>","<codEstado>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>","<latitud>","<longitud>","<tipoAjuste>"
    And Clic finalizar siniestro
    And Ventana de siniestro exitoso
    Examples:
| poliza | codigoMotivoSiniestro | codTipoAsegurado | consecuencia | codPais | codEstado | codPoblacion | codPostal | calle | colonia | entreCalles | mismoLugarRobo | codPaisRT | ubiVia | direccionA | codPoblacionRT | calleyNoRT | coloniaRT | entreCallesRT | referenciaRT | cpRT | color | cita | tipoAjuste | codAbogado | codAjustador | latitud | longitud | nombre | apellidoPat | apellidoMat | motivoSiniestro | 
| 4112500000266 | 1 | 5 | DAOS A TERCERO BIENES Y PERS | MEX | 21 | 21197 | 73080 | Hidalgo | Centro | Privada de Juarez Y Guerrero | N | MEX | CAL | Calle Hidalgo #200 Col. Centro | 21197 | Testing | Centro | Privada de Juarez Y Guerrero | Ninguna referencia | 73080 | 1 | N | 1 | null | null | 20.250462910699095 | -97.9463570164121 | OSCAR | HERRERA | ESPINOSA | COLISION Y/O VOLCADURA |

  @SiniestroIndividualRobo-UAT @SmiestrosPrueba-UAT
  Scenario Outline: CP001_Apertura de siniestro - ROBO TOTAL
    #siniestro_robo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir apertura de siniestro
    And Ingreso datos generales para siniestro "<poliza>"
    And Busqueda de apertura de siniestro "<codigoMotivoSiniestro>","<codTipoAsegurado>","<consecuencia>"
    And Llenamos relatos sobre siniestro
    And Llenamos ubicación del siniestro: "<codPais>","<codEstado>","<codPoblacion>","<codPostal>","<calle>","<colonia>","<entreCalles>","<latitud>","<longitud>","<ubiVia>","<direccionA>"
    And Llenamos datos de robo total: "<consecuencia>","<mismoLugarRobo>","<codPaisRT>","<ubiVia>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>"
    And Vehículo asegurado: "<color>"
    And Ajustador: "<consecuencia>","<codAjustador>"
    And Abogado: "<consecuencia>","<codAbogado>"
    And Llenamos datos complementarios de siniestro: "<nombre>","<apellidoPat>","<apellidoMat>","<cita>","<codEstado>","<codPoblacionRT>","<calleyNoRT>","<coloniaRT>","<entreCallesRT>","<referenciaRT>","<cpRT>","<latitud>","<longitud>","<tipoAjuste>"
    And Clic finalizar siniestro
    And Ventana de siniestro exitoso
    Examples:
| poliza | codigoMotivoSiniestro | codTipoAsegurado | consecuencia | codPais | codEstado | codPoblacion | codPostal | calle | colonia | entreCalles | mismoLugarRobo | codPaisRT | ubiVia | direccionA | codPoblacionRT | calleyNoRT | coloniaRT | entreCallesRT | referenciaRT | cpRT | color | cita | tipoAjuste | codAbogado | codAjustador | latitud | longitud | nombre | apellidoPat | apellidoMat | 
| 4102500000019 | 2 | 5 | ROBO TOTAL | MEX | 21 | 21197 | 73080 | Hidalgo | Centro | Privada de Juarez Y Guerrero | S | MEX | CAL | Calle Benito Juarez # 560 | 21197 | Calle Benito Juarez # 560 | Centro | Privada de Juarez Y Guerrero | ninguna | 07470 | 1 | N | 3 | null | null | 19.250462910699095 | -99.9463570164121 | FERNANDO | VARGAS | ORTIZ |
