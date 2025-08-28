@CSV
@Regresion-REC @ValidacionI-REC @EmisionesRegressionRec
Feature: Flujo completo de validación emisión automóviles individual

  @Val17EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 17 - Ramo 410
    #val_tar_17_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 5 | 1 | 89 | 18 | 8 | 2024 | 414 | 40001 | 17 | 50969.76 |

  @Val18EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 18 - Ramo 410
    #val_tar_18_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 6 | 1 | 54 | 16 | 1 | 2023 | 414 | 40001 | 18 | 70011.99 |

  @Val19EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 19 - Ramo 410
    #val_tar_19_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 7 | 1 | 51 | 2 | 1 | 2024 | 414 | 40001 | 19 | 48434.09 |

  @Val20EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 20 - Ramo 410
    #val_tar_20_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 8 | 1 | 43 | 1 | 1 | 2011 | 414 | 40001 | 20 | 35581.10 |

  @Val21EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 21 - Ramo 410
    #val_tar_21_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 9 | 1 | 74 | 169 | 6 | 2024 | 414 | 40001 | 21 | 117152.75 |

  @Val23EmisionIndividual-REC
  Scenario Outline: Validación de tarifa 23 - Ramo 410
    #val_tar_23_ind.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingreso información de poliza automoviles individual "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos individual "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas individual "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar individual
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa individual "<codTarifa>"
    Examples:
| n | numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| n | ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 614 | 6619 | 1 | 1 | 10 | 1 | 62 | 18 | 1 | 2024 | 414 | 40001 | 22 | 164081.28 |
