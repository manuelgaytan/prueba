@CSV
@Regresion-UAT @ValidacionF-UAT @EmisionesRegressionUat
Feature: Flujo completo de validación emisión automóviles Flotillas

  @Val8EmisionFlotillas-UAT
  Scenario Outline: Emision Flotilla - Tarifa 8 - Ramo 411
    #val_tar_8_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "codTarifa"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4SCOTIAMASWEB | 45708 | 99999 | RFC | AAAA481203RR6 | 92230 | 718 | 5389 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 8 | 60482.20 |

  @Val8EmisionFlotillasDescuento-UAT @cierreSiniestros-UAT
  Scenario Outline: Emision Flotilla Descuento - Tarifa 8 - Ramo 411
    #val_tar_8_flo_desc.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas y descuento "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "codTarifa"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | descuento | 
| 4SCOTIAMASWEB | 45708 | 99999 | RFC | AAAA481203RR6 | 92230 | 718 | 5389 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 8 | 63483.11 | 10 |

  @Val9EmisionFlotillas-UAT
  Scenario Outline: Emision Flotilla - Tarifa 9 - Ramo 411
    #val_tar_9_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4SCOTIAMASWEB | 45708 | 99999 | RFC | AAAA481203RR6 | 92230 | 718 | 5389 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 8 | 60482.20 |

  @Val9EmisionFlotillasDescuento-UAT @cierreSiniestros-UAT
  Scenario Outline: Validación de tarifa 9 Ramo 411
    #val_tar_9_flo_desc.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas y descuento "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4SCOTIAMASWEB | 45708 | 99999 | RFC | AAAA481203RR6 | 92230 | 718 | 5389 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 8 | 63483.11 |


  @Val10EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 10 Ramo 411
    #val_tar_10_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4NRFMFINCRED2 | 46909 | 99999 | RFC | AAAA481203RR6 | 92984 | 826 | 256 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 16 | 15445.67 |

  @Val10EmisionFlotillasDescuentos-UAT
  Scenario Outline: Validación de Descuentos tarifa 10 Ramo 411
    #val_tar_10_flo_desc.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas y descuento "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4NRFMFINCRED2 | 46909 | 99999 | RFC | AAAA481203RR6 | 92984 | 826 | 256 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 16 | 16185.47 |

  @Val16EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 16 Ramo 411
    #val_tar_16_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4NRFMFINCRED2 | 46909 | 99999 | RFC | AAAA481203RR6 | 92984 | 826 | 256 | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 2020 | 401 | 40001 | 16 | 15445.67 |

  @Val17EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 17 Ramo 411
    #val_tar_17_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 5 | 1 | 89 | 18 | 8 | 2024 | 414 | 40001 | 17 | 50714.56 |

  @Val18EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 18 Ramo 411
    #val_tar_18_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 6 | 1 | 54 | 16 | 1 | 2023 | 414 | 40001 | 18 | 69756.79 |

  @Val19EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 19 Ramo 411
    #val_tar_19_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 7 | 1 | 51 | 2 | 1 | 2024 | 414 | 40001 | 19 | 48178.89 |

  @Val20EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 20 Ramo 411
    #val_tar_20_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 8 | 1 | 43 | 1 | 1 | 2011 | 414 | 40001 | 20 | 35209.90 |

  @Val21EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 21 Ramo 411
    #val_tar_21_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 9 | 1 | 74 | 169 | 6 | 2024 | 414 | 40001 | 21 | 116781.55 |

  @Val22EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 22 - Ramo 411
    #val_tar_22_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 10 | 1 | 62 | 18 | 1 | 2024 | 414 | 40001 | 22 | 163710.08 |

  @Val23EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 23 - Ramo 411
    #val_tar_23_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| ZZZZZZZZZZZZZ | 99999 | 99999 | RFC | AAAA481203RR6 | 59510 | 615 | 6619 | 1 | 1 | 10 | 1 | 62 | 18 | 1 | 2024 | 414 | 40001 | 22 | 163710.08 |

  @Val26EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 26 - Ramo 411
    #val_tar_26_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4NRFMFINCRED2 | 46908 | 99999 | RFC | AAAA481203RR6 | 92984 | 826 | 256 | 1 | 1 | 6 | 1 | 54 | 16 | 1 | 2024 | 401 | 40001 | 26 | 71737.38 |

  @Val30EmisionFlotillas-UAT
  Scenario Outline: Validación de tarifa 30 - Ramo 411
    #val_tar_30_flo.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ingreso información de poliza automoviles Flotillas "<numPolizaGrupo>", "<numContrato>", "<numSubcontrato>"
    And CP001_Validar atributos Flotillas "<numPolizaGrupo>", "<tipoDocumento>", "<rfcUsuario>", "<codAgente>", "<cuadCom>", "<codigoOficina>"
    And CP002_Validar tarifa y coberturas Flotillas "<codTarifa>", "<codAmbCirculacion>", "<codTipoVehi>", "<tipoIndemnizacion>", "<codMarca>", "<codModelo>", "<codSubModelo>", "<anioSubModelo>", "<codUsoVehiculo>", "<codModalidad>"
    And Ingreso datos para validar Flotillas
    And CP003_Validar prima tarifa "<cantPrima>"
    Then CP004_Emisión con la tarifa "<codTarifa>"
    Examples:
| numPolizaGrupo | numContrato | numSubcontrato | tipoDocumento | rfcUsuario | codAgente | cuadCom | codigoOficina | codAmbCirculacion | codProducto | codTipoVehi | tipoIndemnizacion | codMarca | codModelo | codSubModelo | anioSubModelo | codUsoVehiculo | codModalidad | codTarifa | cantPrima | 
| 4ANZENNRFMSG1 | 47019 | 99999 | RFC | AAAA481203RR6 | 92619 | 834 | 256 | 1 | 1 | 1 | 1 | 1 | 6 | 1 | 2015 | 401 | 40001 | 30 | 7928.60 |



