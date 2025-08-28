@CSV
@Regresion1-UAT @AutomovilesIndividual-UAT
Feature: Flujo completo reporte de siniestro automoviles

  @ReporteSiniestroIndividual-UAT
  Scenario Outline: CP009_Reporte de siniestro Individual - Ramo 410
    #siniestro_colision.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir a Consulta de siniestro
    And Busqueda de siniestro
    And Validación de consulta siniestro "<motivoSiniestro>"
    Examples:
| poliza | codigoMotivoSiniestro | codTipoAsegurado | consecuencia | codPais | codEstado | codPoblacion | codPostal | calle | colonia | entreCalles | mismoLugarRobo | codPaisRT | ubiVia | direccionA | codPoblacionRT | calleyNoRT | coloniaRT | entreCallesRT | referenciaRT | cpRT | color | cita | tipoAjuste | codAbogado | codAjustador | latitud | longitud | nombre | apellidoPat | apellidoMat | motivoSiniestro | 
| 4112500000266 | 1 | 5 | DAOS A TERCERO BIENES Y PERS | MEX | 21 | 21197 | 73080 | Hidalgo | Centro | Privada de Juarez Y Guerrero | N | MEX | CAL | Calle Hidalgo #200 Col. Centro | 21197 | Testing | Centro | Privada de Juarez Y Guerrero | Ninguna referencia | 73080 | 1 | N | 1 | null | null | 20.250462910699095 | -97.9463570164121 | ERNESTO	 | MORALES | NEVAREZ | COLISION Y/O VOLCADURA |


