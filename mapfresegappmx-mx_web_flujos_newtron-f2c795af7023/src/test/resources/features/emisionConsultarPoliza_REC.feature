@CSV
@Regresion-REC @AutomovilesIndividual-REC
Feature: Flujo validaciones de consulta de recibos

  @ConsultaPoliza-REC
  Scenario Outline:CP001_Consulta de recibos en módulo de "pólizas"
    #emision_consulta_poliza.csv |
    Given Inicio la sesión con usuario y contrasena REC
    And Ingresar a Consulta Poliza Emision
    And Buscar Poliza Consulta Poliza "<numeroPoliza>"
    And Ingresar a Recibos de poliza
    Examples:
| numeroPoliza | observaciones | numeroPolizaRechazar | observacionesRechazar | 
| 4102400002173 | observaciones | 4112400002229 | observaciones |

