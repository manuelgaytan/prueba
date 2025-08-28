# Continuous Testing (Web automation)

Este es un proyecto que utiliza una librería basada en las siguientes herramientas con la finalidad de,
agilizar el desarrollo de la pruebas automatizadas en lenguaje Java:

* SpringBoot: adoptamos las características del Framework de Spring para aplicar 
  * la inyección de dependencias, 
  * configuración de ambientes de prueba,
  * inyección y lectura de propiedades,
  * programación orienta a aspectos,
  * creación y eliminación de drivers por Bean,
  * acelaración en la creación de código
  * conexiones rápidas hacia BD soportadas por el SpringBoot
  * menos líneas de, código limpio
* Selenium 4: Utilizado como motor principal de automatización de acciones y creación de drivers.
* JUnit: Como todo framework de automatización de pruebas, es necesario un framework de pruebas.
* CucumberBDD: Una herramienta bastante utilizada para automatizar el comportamiento de las funcionalidades, 
muy compatible con técnicas en el marco de agilidad.

### Dependencias:
| **Librería** | **Versión** |
|--------------|-------------|
| SpringBoot   | 2.7.2       |
| SpringAspect | 5.3.15      |
| Selenium     | 4.3.0       |
| Cucumber     | 7.4.1       |
| JUnit        | 5.8.2       |

####Propiedades soportadas:

**Genéricas**

| Propiedad                     | Valor                                                                              | Descripción                                                                                                                                                                                                                              |
|-------------------------------|------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| webdriver.browser             | **chrome**, firefox, safari, edge                                                  | Indica que instancia de browser se utilizará en la ejecución de la <br/>prueba automatizada.<br/>Si no se especifica tomará **chrome** como browser por defecto.                                                                         |
| webdriver.implicitWait        | Numerico. Ejemplo: 15, 30                                                          | Valor numerico que indica el tiempo IMPLICITO de espera en segundos del driver <br/>al identificar un elemento e instrumentalizarlo. Valor por decto: 15 segundos                                                                        |
| webdriver.url                 | Ejemplo: http://saucedemo.com                                                      | Url base del aplicativo web. Si la propiedad no se especifica,<br/> la url podrá ser agregada <br/> programaticamente.                                                                                                                   |
| webdriver.path                | Ruta del driver local descargado                                                   | Indica cual será la ruta del driver a utilizar en caso <br/>no se tenga las variables de entorno configuradas                                                                                                                            |
| webdriver.windowSize          | **Implicito**: MAXIMIZE, MINIMIZE, FULL</br>**Explicito** <width,height>: 1024,768 | Indica el tamaño que tendrá la ventana del browser elegido.<br/>**Tamaño por defecto**: MAXIMIZE<br/> Para ejecuciones de tipo headless es necesario indicar <br/>el tamaño de manera **explicita**.                                     |
| webdriver.headless            | true, false<br/>_YAML_: on, off                                                    | Indica si la ejecución será de tipo HeadLess o regular.<br/>Esta opción no es compatible con Safari Browser.                                                                                                                             |
| webdriver.acceptInsecureCerts | true, false<br/>_YAML_: on, off                                                    | Permite ejecutar pruebas autoamtizadas sobre sitios NO seguros.                                                                                                                                                                          |
| webdriver.screenShotsPath     | target,shots                                                                       | Define la ruta en donde se guardaran las evidencias tomadas.<br/> **La ruta por defecto es:** raiz/shots</br>El formato de la ruta debe estar separada por el signo ',' entre cada directorio.<br/>Por ejemplo: target/shots --> target,shots |

**Por browser**

Chrome:

| Propiedad                | Valor                           | Descripción                                                                                                                                                                          |
|--------------------------|---------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| chrome-options.extraArgs | arg1,arg2,arg3...,argN          | Opciones de Google Chrome que puedan ser añadidas.                                                                                                                                   |
| chrome-options.extension | Ejemplo: extension/3.1.27_0.crx | Permite instalar una extensión en el browser antes de la ejecución.<br/>Para ello hay que indicar la ruta de la extensión en su formato comprimido '.crx'<br/>compatible con Chrome. |

Firefox:

| Propiedad                 | Valor                           | Descripción                                  |
|---------------------------|---------------------------------|----------------------------------------------|
| firefox-options.extraArgs | arg1,arg2,arg3...,argN          | Opciones de Firefox que puedan ser añadidas. |

Safari:

| Propiedad                | Valor                           | Descripción                                 |
|--------------------------|---------------------------------|---------------------------------------------|
| safari-options.extraArgs | arg1,arg2,arg3...,argN          | Opciones de Safari que puedan ser añadidas. |

Edge:

| Propiedad              | Valor                           | Descripción                                |
|------------------------|---------------------------------|--------------------------------------------|
| edge-options.extraArgs | arg1,arg2,arg3...,argN          | Opciones de Edgge que puedan ser añadidas. |

### Uso desde Nexus Umane:

1. Agregar dependencia en el archivo gestor de dependencias:

```
   <dependency>
            <groupId>com.nttdata.ct</groupId>
            <artifactId>web-automation</artifactId>
            <version>LATEST</version>
   </dependency>       
```

2. Agregar referencia de la conexión de los repositorios en la etiqueta <project>:

```
    <repositories>
        <repository>
            <id>my_public_repository</id>
            <url>https://umane.everis.com/nexus/repository/public/</url>
        </repository>
        <repository>
            <id>my_snapshot_repository</id>
            <url>https://umane.everis.com/nexus/repository/CONTESTING.Snapshot/</url>
        </repository>
        <repository>
            <id>my_release_repository</id>
            <url>https://umane.everis.com/nexus/repository/CONTESTING.Release/</url>
        </repository>
    </repositories>
```

3. Agregar conexión de usuario y contraseña en el archivo settings.xml

* username: User name nttdata con acceso al repositorio.
* password: Password de cuenta

```
    <server>
      <id>my_public_repository</id>
      <username>XXXXX</username>
      <password>XXXXX</password>
    </server>
    <server>
      <id>my_snapshot_repository</id>
      <username>XXXXX</username>
      <password>XXXXX</password>
    </server>
    <server>
      <id>my_release_repository</id>
      <username>XXXXX</username>
      <password>XXXXX</password>
    </server>
```

### Lectura de datos de prueba desde *.csv en archivos *.feature

Si se desea habilitar el soporte de lectura de datos desde un archivo de tipo CSV, se debe configurar lo siguiente:

* En la clase Runner de Junit con la integración de Cucumber, cambiar el motor de ejecución de
**Cucumber.class --> CucumberCSVSupport.class**

```
@RunWith(CucumberCSVSupport.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber/cucumber-report.html","json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"com.nttdata.ct.web.cucumber.hook",
                "com.nttdata.ct.web.cucumber.glue"},
        tags = "@Regresion"
)
...
```

* Para soportar la lectura de estos archivos de datos *.csv en los archivos feature *.feature. 
Es necesario utilizar los escenarios con ejemplos **"Scenario Outiline" | "Escenario del Esquema"**
* Donde, en la tabla de ejemplos se va a referenciar el nombre del archivo de datos con extension *.csv, 
en el siguiente formato: **file@nombre_de_archivo.csv**. Y este archivo debe estar ubicado en **"src/resources/data/nombre_de_archivo.csv"**
* Por último, en cada uno de los features que serán procesados con la lectura de datos,
se les agrega la anotacion **"@CSV"** en la parte superior. 
De está manera no procesa todos los features, si no, únicamente los que necesiten obtener datos desde un archivo .*csv. 

```
@CSV
@Regresion
Feature: SauceDemo

  @caso1
  Scenario Outline: caso1 - login csv
    Given que me encuentro en la pagina de SauceDemo
    When inicio sesión con las credenciales "<user>", "<pass>"
    Then se debería mostrar el titulo del catalogo "PRODUCTS"

    Examples:
      | file@nombre_de_archivo.csv |
```

* Eso es todo. El framework irá a buscar el archivo de datos en la ruta especificada, 
procesará los datos y sobreescribirá los examples dependendiendo de la cantidad de filas en el archivo .*csv.
* El formato de los datos en el archivo .*csv deberá ser separado por comas **","** 
* Donde la primera fila será el nombre de las cabeceras de la tabla de ejemplos 
y el resto de filas serán las filas de la tabla de datos ejemplos

```
-> nombre_de_archivo.csv 

user,pass
standard_user,secret_sauce
problem_user,secret_sauce

-> tabla_de_ejemplos_procesada

Examples:
| user          | pass         |
| standard_user | secret_sauce |
| problem_user  | problem_user |

```

### Ejecución de los scripts

**JUNIT**
* Ejecutamos los scripts directamente en la clase de tipo test Junit.

```
@SpringBootTest
class SauceDemoTest{

    @Test
    void loginTest_1() {
        #comportamiento automatizado
    }
    
    @Test
    void loginTest_2() {
        #comportamiento automatizado
    }
}
```

**JUNIT + Cucumber**

* Ejecutamos los scripts directamente en la clase de tipo Runnertest de Junit con el motor de **Cucucumber.class o CucumberCSVSupport.class**
* Tenemos la posibilidad de modificar directamente la opción de Cucumber **"tags"** para ejecutar uno o más escenarios 
dependiendo de la estregia de pruebas que se implemente.

_**Junit + CucumberBDD**_
```
@RunWith(Cucumber.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber/cucumber-report.html","json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"com.nttdata.ct.web.cucumber.hook",
                "com.nttdata.ct.web.cucumber.glue"},
        tags = "@Regresion"
)
public class RunnerTest {}
```

_**Junit + CucumberBDD + Soporte de lectura de datos .csv**_
```
@RunWith(CucumberCSVSupport.class)
@CucumberOptions(
        stepNotifications = true,
        plugin = {"html:target/cucumber/cucumber-report.html","json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features/",
        glue = {"com.nttdata.ct.web.cucumber.hook",
                "com.nttdata.ct.web.cucumber.glue"},
        tags = "@Regresion"
)
public class RunnerTest {}
```

**Maven**
* Ejecución directa de todos los features y sus escenarios que estén marcados por defectos por la anotación 
configurada en la propiedad **"tags"** de la clase de Junit de tipo RunnerTest:

```
$ mvn clean verify
```

* Ejecución directa de todos los features y sus escenarios que estén marcados por una anotación enviada como parametro 
a través del comando de cucumber:

```
$ mvn clean verify -Dcucumber.filter.tags="@TAG"
```