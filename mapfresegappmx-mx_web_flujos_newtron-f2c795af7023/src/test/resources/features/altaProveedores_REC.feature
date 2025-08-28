@CSV
@Regresion-REC @AltaProveedores-REC
Feature: Flujo completo de Alta Proveedores

  #ALTA PERSONA FISICA
  @AltaProvPersonaFisica-REC
  Scenario Outline: ALTA DE PROVEEDOR PERSONA FÍSICA
    #proveedores.csv |
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    And CP002_Ingresar tipologia y categoria "<dataBasicTipologia>","<categoriaProveedor>"
    And CP003_Ingresar datos generales "<dataGeneralTipoStateProveedor>"
    And CP004_Ingresar persona fisica "<personaNombre>","<personaApellido1>","<personaApellido2>"
    And CP005_Ingresar contacto "<contactTipoUsoMedioContacto>","<contactTipoMedioContacto>","<contactValorMedioContacto>","<contactNameMedioContacto>","<contactApellidoContacto>","<contactTipoCargoEmpresa>","<contactObservacion>"
    And CP006_Ingresar dirección "<direccionTipoDireccion>","<direccionPais>","<direccionProvincia>","<direccionDistrito>","<direccionEstado>","<direccionCiudad>","<direccionCodigoPostal>","<direccionDomicilio>","<direccionAddress>","<direccionNumber>","<direccionObservacion>"
    And CP007_Ingresar documentos alternativos "<docAfterTipoDoc>","<docAfterDoc>","<docAfterPaisDoc>","<docAfterObsrDoc>"
    And CP008_Ingresar datos bancarios 1 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    And CP009_Ingresar datos bancarios 2 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Then Creación de Persona Fisica
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  #ALTA PERSONA MORAL
  @AltaPersonaMoral1-REC
  Scenario Outline: ALTA DE PROVEEDOR PERSONA MORAL
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    And CP002_Ingresar tipologia y categoria "<dataBasicTipologia>","<categoriaProveedor>"
    And CP003_Ingresar datos generales "<dataGeneralTipoStateProveedor>"
    And CP004_Ingresar persona moral "<personaNombre>"
    And CP005_Ingresar contacto "<contactTipoUsoMedioContacto>","<contactTipoMedioContacto>","<contactValorMedioContacto>","<contactNameMedioContacto>","<contactApellidoContacto>","<contactTipoCargoEmpresa>","<contactObservacion>"
    And CP006_Ingresar dirección "<direccionTipoDireccion>","<direccionPais>","<direccionProvincia>","<direccionDistrito>","<direccionEstado>","<direccionCiudad>","<direccionCodigoPostal>","<direccionDomicilio>","<direccionAddress>","<direccionNumber>","<direccionObservacion>"
    And CP007_Ingresar documentos alternativos "<docAfterTipoDoc>","<docAfterDoc>","<docAfterPaisDoc>","<docAfterObsrDoc>"
    And CP008_Ingresar datos bancarios 1 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    And CP009_Ingresar datos bancarios 2 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Then Creación de Persona Moral
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  #ALTA PERSONA &
  @AltaPersonaAmpersand-REC
  Scenario Outline: ALTA DE PROVEEDOR PERSONA AMPERSAND
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Alta de proveedor con &
    And CP002_Ingresar tipologia y categoria "<dataBasicTipologia>","<categoriaProveedor>"
    And CP003_Ingresar datos generales "<dataGeneralTipoStateProveedor>"
    And CP004_Ingresar persona moral "<personaNombre>"
    And CP005_Ingresar contacto "<contactTipoUsoMedioContacto>","<contactTipoMedioContacto>","<contactValorMedioContacto>","<contactNameMedioContacto>","<contactApellidoContacto>","<contactTipoCargoEmpresa>","<contactObservacion>"
    And CP006_Ingresar dirección "<direccionTipoDireccion>","<direccionPais>","<direccionProvincia>","<direccionDistrito>","<direccionEstado>","<direccionCiudad>","<direccionCodigoPostal>","<direccionDomicilio>","<direccionAddress>","<direccionNumber>","<direccionObservacion>"
    And CP007_Ingresar documentos alternativos "<docAfterTipoDoc>","<docAfterDoc>","<docAfterPaisDoc>","<docAfterObsrDoc>"
    And CP008_Ingresar datos bancarios 1 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    And CP009_Ingresar datos bancarios 2 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Then Creación de Persona con Ampersand
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP001-REC
  Scenario Outline: CP001 Ingresar datos básicos

    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    Then CP001_Ingresar datos básicos
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaAmpersandCP001-REC
  Scenario Outline: CP001_Alta de proveedor con &
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    Then CP001_Alta de proveedor con &
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP002-REC
  Scenario Outline: CP002 Ingresar tipologia y categoria
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP002_Ingresar tipologia y categoria "<dataBasicTipologia>","<categoriaProveedor>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP003-REC
  Scenario Outline: CP003 Ingresar datos generales
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP003_Ingresar datos generales "<dataGeneralTipoStateProveedor>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP004-REC
  Scenario Outline: CP004 Ingresar persona fisica
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP004_Ingresar persona fisica "<personaNombre>","<personaApellido1>","<personaApellido2>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaMoralCP004-REC
  Scenario Outline: CP004 Ingresar persona moral
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP004_Ingresar persona moral "<personaNombre>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP005-REC
  Scenario Outline: CP005 Ingresar contacto
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP005_Ingresar contacto "<contactTipoUsoMedioContacto>","<contactTipoMedioContacto>","<contactValorMedioContacto>","<contactNameMedioContacto>","<contactApellidoContacto>","<contactTipoCargoEmpresa>","<contactObservacion>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP006-REC
  Scenario Outline: CP006 Ingresar dirección
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP006_Ingresar dirección "<direccionTipoDireccion>","<direccionPais>","<direccionProvincia>","<direccionDistrito>","<direccionEstado>","<direccionCiudad>","<direccionCodigoPostal>","<direccionDomicilio>","<direccionAddress>","<direccionNumber>","<direccionObservacion>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP007-REC
  Scenario Outline: CP007 Ingresar documentos alternativos
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP007_Ingresar documentos alternativos "<docAfterTipoDoc>","<docAfterDoc>","<docAfterPaisDoc>","<docAfterObsrDoc>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP008-REC
  Scenario Outline: CP008 Ingresar datos bancarios 1
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP008_Ingresar datos bancarios 1 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaFisicaCP009-REC
  Scenario Outline: CP009 Ingresar datos bancarios 2
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    And CP009_Ingresar datos bancarios 2 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Then CP009_Ingresar datos bancarios 2 "<dataBankTipoPagoCobro>","<dataBankClasePagoCobro>","<dataBankTipoEntidad>","<dataBankEntidadBancaria>","<dataBankPais>","<dataBankTitular>","<dataBankTipoToken>","<dataBankTokenPagoCobro>","<dataBankValorPagoCobro>","<dataBankClavePagoCobro>","<dataBankTipoMovimiento>","<dataBankTipoMovPagoCobro>","<dataBankMoneda>","<dataBankMesVencimiento>","<dataBankAnoVencimiento>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaRfcYaExiste-REC
  Scenario Outline: CP001 Alta de un proveedor cuando el RFC ya existe en otra actividad
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Alta de un proveedor cuando el RFC ya existe en otra actividad
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPersonaRfcDupli-REC
  Scenario Outline: CP002 Validar que ya no se muestre la lupa que está junto a código del documento
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    Then CP002_Validar que ya no se muestre la lupa que está junto a código del documento
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  #ALTA DE PROVEEDORES CON DIRECCIÓN AMPLIA
  @AltaPesonaDireccionAmpliaDirreccionAmplia-REC
  Scenario Outline: CP005_Alta de proveedor con dirección de más de 80 caracteres
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    Then CP005_Alta de proveedor con dirección de más de ochenta caracteres "<direccionTipoDireccion>","<direccionDomicilio>"
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPesonaDireccionAmplia2-REC
  Scenario Outline: CP006_Modificar dirección de proveedor con dirección de más de ochenta caractéres
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Crear
    And CP001_Ingresar datos básicos
    And CP005_Alta de proveedor con dirección de más de ochenta caracteres "<direccionTipoDireccion>","<direccionDomicilio>"
    Then CP006_Modificar dirección de proveedor con dirección de más de ochenta caractéres
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |

  @AltaPesonaDireccionAmplia1-REC
  Scenario Outline: CP007_Consulta proveedor - dirección
    Given Inicio la sesión con usuario y contrasena REC
    When Ir apertura de Tercero
    And Ingreso datos generales para Proveedores
    And Busqueda de apertura de proveedores "<tipoDocTercero>","<actividadTercero>"
    And Clic botón Buscar
    Then CP007_Consulta proveedor dirección
    Examples:
| tipoDocTercero | actividadTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | fatherTipoDocTercero | dataBasicTipologia | categoriaProveedor | dataGeneralTipoStateProveedor | personaNombre | personaApellido1 | personaApellido2 | contactTipoUsoMedioContacto | contactTipoMedioContacto | contactValorMedioContacto | contactNameMedioContacto | contactApellidoContacto | contactTipoCargoEmpresa | contactObservacion | direccionTipoDireccion | direccionPais | direccionProvincia | direccionDistrito | direccionEstado | direccionCiudad | direccionCodigoPostal | direccionDomicilio | direccionAddress | direccionNumber | direccionObservacion | docAfterTipoDoc | docAfterDoc | docAfterPaisDoc | docAfterObsrDoc | dataBankTipoPagoCobro | dataBankClasePagoCobro | dataBankTipoEntidad | dataBankEntidadBancaria | dataBankPais | dataBankTitular | dataBankTipoToken | dataBankTokenPagoCobro | dataBankValorPagoCobro | dataBankClavePagoCobro | dataBankTipoMovimiento | dataBankTipoMovPagoCobro | dataBankMoneda | dataBankMesVencimiento | dataBankAnoVencimiento | 
| RFC | 17 | EMB | PMM | AC | CML | EMB | PMM | AC | Tomas | Arteaga | Riquelme | 1 | 2 | 9542464611111 | Tomas | Arteaga Riquelme | 3 | Observacion Prueba | 1 | MEX | 9005 | 0991 | 9 | 9005 | 07000 | 1 | CALLE FALSA | 10 | NINGUNA | INE | 116375842 | MEX | NINGUNA | 2 | 1 | 1 | 0002 | MEX | LOLA MENDEZ | TRN | 200 | 200 | 200 | 1 | 1 | 1 | 11 | 2025 |
