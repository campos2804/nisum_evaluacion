# Evaluación NISUM

_Este proyecto fue realizado para responder la evaluacion enviada por la empresa nisum._

## Comenzando 🚀

_Descarga el codigo fuente del repositorio, guardarlo en una carpeta para facilitar encontrarlo y poder cargarlo en un IDE para ver el codigo fuente.(Eres libre de modificarlo ;))_

_Run as Spring Boot App._

### Pre-requisitos 📋

_Spring tool suite (STS), como herramienta ide para ver y ejecutar el proyecto ( https://spring.io/tools )_
_Java 8+ (https://www.oracle.com/java/technologies/downloads/)  _

### Instalación 🔧

_Una vez descargado el proyecto y sus archivos fuentes se debe abrir con STS, "File -> Import...  Maven-> Existing Maven Projects -> Next "_
_Con el explorador buscas la carpeta donde se descargo el proyecto, marcar el archivo "/pom.xml" y seleccionar la opcion Finish_
_En la perspectiva de proyecto aparecerá el proyecto de nombre "demo"._
_Ahora se debe realizar un clean del proyecto. Boton izquierdo sonbre el nombre del proyecto "demo", opcion "Run as... " -> "Maven clean..."_
_Para ejecutar se debe ir al nombre del proyecto "demo", hacer clik izquierdo y seleccionar la opcion "Run as..."  -> "Spring boot app"_
_¡Listo! ahora se esta ejecutando la aplicacion demo._
_ El servidor funciona en el puerto 9898_
![Image text](https://github.com/campos2804/nisum_evaluacion/blob/main/ejecutar.jpg)


## Diagrama  ⌨️

_El diagrama de clases es muy sencillo dos clases en una relacion de uno a muchos._
![Image text](https://github.com/campos2804/nisum_evaluacion/blob/main/diagrama-clases.JPG

## Base de Datos 🔩
_La base de datos utilizada es H2, por lo cual no se agrega un script, todas las clases con la etiqueta @Entity seran creadas automaticamente por la aplicaicon al momento de ejecutarla._ 
_se puede ingresar a la consola de administracion de H2 en el link (http://localhost:9898/h2-console/)_
_![Image text](https://github.com/campos2804/nisum_evaluacion/blob/main/baseh2-login.JPG) _
_En el archivo application.properties estan los datos para realizar la conexion a la base:_ 
_Driver Class: org.h2.Driver_
_JDBC URL:	jdbc:h2:mem:testdb_
_User Name: nisum_
_Password: musin_
_![Image text](https://github.com/campos2804/nisum_evaluacion/blob/main/baseh2-primeravista.JPG)_

## Probando la aplicacion



