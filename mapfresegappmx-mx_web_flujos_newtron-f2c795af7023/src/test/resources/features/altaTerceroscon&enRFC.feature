@CSV
@Regresion @AltaTercerosCon&enRFC @TercerosRegressionUat
Feature: Alta de terceros con & en RFC

  @AltaTercerosCon&-UAT
  Scenario Outline: ALTA DE TERCEROS AGENTE CON &
    #alta_terceros.csv |
      Given Inicio la sesión con usuario y contrasena
    And Ir al Menu "Terceros" Opcion "Rutina de terceros"
    And Dar clic en Crear
    And CP001_Ingresar 'datos básicos' con & "<RazonSocial>","<FechaConstitucion>","<PersonaFisica>","<TipoDoc>","<Actividad>"
    And Crear Tercero
    And CP002_Ingresar 'persona moral' "<RazonSocial>"
    And CP003_Ingresar 'contacto' "<TipoUso>","<TipoMedio>","<ValorMedio>"
    And CP004_Ingresar 'dirección' "<TipoDireccion>","<Pais>","<Estado>","<Provincia>","<Ciudad>","<Distrito>","<CP>","<TipoDomicilio>","<Direccion>"
    And CP005_Ingresar 'documentos alternativos' "<TipoDocumento>","<Documento>","<PaisEmisor>","<Observaciones>"
    And CP006_Ingresar 'información agente' "<Situacion>","<TipoAgente>","<Comercial>","<FuenteProduccion>"
    And CP007_Ingresar 'datos bancarios 1' "<TipoMedioPago>","<ClaseMedio>","<TipoEntidad>","<EntidadBancario>","<PaisEmisor>","<Titular>","<TipoToken>","<TokenMedio>","<ValorMedio>","<ClaveMedio>","<TipoMovimiento>","<TipoUsoMovimiento>","<Moneda>","<MesVencido>","<AñoVencimiento>"
    Then CP008_Consulta tercero agente
      Examples:
| RazonSocial | FechaConstitucion | PersonaFisica | TipoDoc | Actividad | TipoUso | TipoMedio | ValorMedio | TipoDireccion | Pais | Estado | Provincia | Ciudad | Distrito | CP | TipoDomicilio | Direccion | TipoDocumento | Documento | PaisEmisor | Observaciones | TipoMedioPago | ClaseMedio | TipoEntidad | EntidadBancario | Titular | TipoToken | TokenMedio | ValorMedio | ClaveMedio | TipoMovimiento | TipoUsoMovimiento | Moneda | MedioPago | MesVencido | AñoVencimiento | Situacion | TipoAgente | Comercial | FuenteProduccion | 
| Consultora&Automatizacion | 24/10/1992 | N | RFC | AGENTE/AGENTS | PERSONAL | 2 | 5510203040 | RESIDENCIA | MEXICO		 | CIUDAD DE MEXICO | GUSTAVO A. MADERO | GUSTAVO A. MADERO | 0991 | 07000 | CALLE | CALLE PRUEBA | INE | 116375842 | MEXICO | NADA | TARJETA BANCARIA | CREDITO | MasterCard | BANAMEX | ERNESTO | Tronador | 100 | 100 | 100 | COBRO | CUALQUIERA | PESOS | 1 | 12 | 2030 | ACTIVO | AGENTES INDEPENDIENTES | AGENTES INDEPENDIENTES | OFICINA MAPFRE DIRECTA TRADICIONAL |

  @CopiaTercerosCon&-UAT
  Scenario Outline: COPIA DE TERCEROS "AGENTE A ASEGURADO"
    #copia_terceros.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir a Terceros
    And Dar clic en Crear
    And CP001_Ingresar 'datos básicos' asegurado "<RazonSocial>","<FechaConstitucion>","<PersonaFisica>","<TipoDoc>","<Actividad>"
    And CP002_Copiar desde terceros "<RFC>"
    Then CP003_Consulta tercero copiado "<RFC>"
      Examples:
| RazonSocial | FechaConstitucion | PersonaFisica | TipoDoc | Actividad | RFC | TipoAgente | Comercial | FuenteProduccion | 
| EMPRESA ASEGURASA SA | 02/02/1990 | N | RFC | ASEGURADOS/INSURERS | C&A921024DA8 | AGENTES INDEPENDIENTES | AGENTES INDEPENDIENTES | OFICIONA MAPFRE DIRECTIVA TRADICIONAL |

  @CopiaProvedoresCon&-UAT
  Scenario Outline: COPIA DE PROVEEDORES
    #alta_proveedor.csv |
    Given Inicio la sesión con usuario y contrasena
    And Ir a Proveedores
    And Dar clic en Crear Proveedor
    And CP001_Alta de Proveedor talleres "<TipoDoc>","<Documento>"
    And CP002_Copiar desde asegurado
    And CP003_Ingresar 'tipologia y categoria' proveedor "<Documento>","<Tipologia>","<CategoriaProveedor>"
    And CP004_Ingresar 'datos generales' proveedor "<TipoEstado>"
    And Crear Proveedor
    And Ir a Rutina Terceros
    Then CP005_Consulta proveedor copiado desde rutina de terceros "<TipoDoc>","<Documento>"
      Examples:
| TipoDoc | Documento | CodigoTercero | Tipologia | CategoriaProveedor | TipoEstado | 
| RFC | EMP900202IP0 | 920502 | AGENCIA TRADICIONAL | RED TRADICIONAL MULTIMARCA | ACTIVO |
