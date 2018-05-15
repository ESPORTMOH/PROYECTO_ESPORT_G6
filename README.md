# PROYECTO_ESPORT_G6
Por Miguel Olmo Hernando

# NOVEDADES

* Esta versión Fase 4 v4 incluye lo siguiente:

	* Se han realizado varios cambios en los atributos de la BD y generado una nueva tabla llamada Clasificación. Se han creado las alteraciones necesarias para la nueva tabla y generado un nuevo SCRIPT DDL para ORACLE.
	* Se han creado 3 procedimientos nuevos que se incluyen en el paquete PAQUETE_SPORT_MOH_2, todos ellos tienen como fin rellenar un combo utilizando un cursor.
	* Se han realizado cambios en los CRUD. A falta de pulir unos detalles.
	* Se ha codificado lo necesario para la autogeneracion de la jornada.
	* Se ha mejorado la interfaz gráfica.

* La versión Fase 4 v5 corrige varios problemas en los CRUD

# CONTENIDO DEL REPOSITORIO

* La Carpeta [**BASES_DE_DATOS**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/BASES_DE_DATOS) contiene las siguientes:

	* **DIGAGRAMAS:** Aquí se encuentra el Diagrama de Clases, el MER y el Modelo Relacional, se irán actualizando en función a los cambios que vaya realizando en la codificación del programa. Se incluyen los editables de estos.
	
	* **PROCEDURES:** Contiene los dos PAQUETES que se piden para el proyecto y otros. Se incluyen los editables de estos.
				
	* **SCRIPTS_ORACLE:** Contiene el Script DDL para ser lanzado mediante Oracle SQL Developer. Este genera la Base de Datos utilizada en mi proyecto.	Se incluye el Script DDL para ser cargado mediante MySQL si se quiere.
	
	* **TRIGGERS:** Contiene los dos DISPARADORES que se piden para el proyecto y otros. Se incluyen los editables de estos.
		

* La Carpeta [**BLOG**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/BLOG) es donde guardo las imagenes usadas en WordPress a modo de copia de seguridad. Pueden visitar el Blog mediante el siguiente link: [**Proyectodawsport**](https://proyectodawsport.wordpress.com/). 

* La Carpeta [**CAJON_DEL_DESASTRE**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/CAJON_DEL_DESASTRE) es donde almaceno editables o pruebas que han sido descartadas. Se incluye una copia del programa USBWEBSERVER, esta es una version que no requiere de permisos y que funciona perfectamente en el aula del centro. NOTA: Las versiones más nuevas de este no funcionan.

* La Carpeta [**ENUNCIADO**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/ENUNCIADO) tiene una copia actualizada del mismo.

* La Carpeta [**PROGRAMACION_JAVA**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH) es donde tiene lugar la codificación del programa. Esta codificación la realizo mediante Netbeans.

# REQUISITOS PARA EJECUTAR EL PROGRAMA:

* [**1º.-**] Descargar el repositorio o clonarlo en tu PC. Abrirlo o descomprimirlo, etc...

* [**2º.-**] Realiza los siguientes pasos para la instalación de [**Oracle 12c en Linux con Vagrant**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH)

* [**3º.-**] Utiliza SQL Developer para generar la Base de Datos mediante el SCRIPT DDL DE ORACLE, cargar los PAQUETES y los DISPARADORES mencionados anteriormente.

* [**4º.-**] Instalar [**Netbeans**](https://netbeans.org/)

* [**5º.-**] Ejecuta Netbeans e importa [**MyCalendar y MyLibrary**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH/src)

* [**6º.-**] Edita la Clase  [**GenericoBD**](https://github.com/migueloh/PROYECTO_ESPORT_G6/blob/master/PROGRAMA_JAVA/ProyectoEsport_MOH/src/ModelBD/GenericoBD.java) con los datos que utilices en el paso **2º**.

* [**7º.-**] Ejecuta el programa. El **usuario y clave** por defecto del usuario **Administrador** son **root / root**.
