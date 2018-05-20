# PROYECTO_ESPORT_G6
Por Miguel Olmo Hernando

# NOVEDADES

* Esta versión Fase 4 v9.5.1 incluye lo siguiente:

	* Cambios importantes en el SCRIPT DLL de Oracle (cambios en tablas, creacion de datos para la presentacion).
	* Mejorados los PAQUETES que incluyen los procedimientos.
	* Mejorados los DISPARADORES.
	* Todos los CRUD funcionando.
	* Genera una temporada o las que se quieran.
	* Genera una clasificacion o las que se quieran en base a las temporadas que se tengan.
	* Inserta los puntos obtenidos de los partidos jugados en una temporada y jornada.
	* Dueños pueden hacer fichajes.
	* Usuarios pueden ver los resultados.
	* Creación íntegra del Javadoc.
	* Se ha mejorado la interfaz gráfica.
	* Se incluye una nueva carpeta llamada DOCUMENTACION al repositorio, esta va a contenter los manuales y la presentación.
	* Trabajando en los diferentes manuales y la presentación.
	

# CONTENIDO DEL REPOSITORIO

* La Carpeta [**BASES_DE_DATOS**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/BASES_DE_DATOS) contiene las siguientes:

	* **DIGAGRAMAS:** Aquí se encuentra el Diagrama de Clases, el MER y el Modelo Relacional, se irán actualizando en función a los cambios que vaya realizando en la codificación del programa. Se incluyen los editables de estos.
	
	* **PROCEDURES:** Contiene los dos PAQUETES que se piden para el proyecto y otros. Se incluyen los editables de estos.
				
	* **SCRIPTS_ORACLE:** Contiene el Script DDL para ser lanzado mediante Oracle SQL Developer. Este genera la Base de Datos utilizada en mi proyecto.	Se incluye el Script DDL para ser cargado mediante MySQL si se quiere.
	
	* **TRIGGERS:** Contiene los dos DISPARADORES que se piden para el proyecto y otros. Se incluyen los editables de estos.
		

* La Carpeta [**BLOG**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/BLOG) es donde guardo las imagenes usadas en WordPress a modo de copia de seguridad. Pueden visitar el Blog mediante el siguiente link: [**Proyectodawsport**](https://proyectodawsport.wordpress.com/). Ahora también contiene las capturas usadas en la Documentación.

* La Carpeta [**CAJON_DEL_DESASTRE**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/CAJON_DEL_DESASTRE) es donde almaceno editables o pruebas que han sido descartadas. Se incluye una copia del programa USBWEBSERVER, esta es una version que no requiere de permisos y que funciona perfectamente en el aula del centro. NOTA: Las versiones más nuevas de este no funcionan.

* La Carpeta [**ENUNCIADO**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/ENUNCIADO) tiene una copia actualizada del mismo.

* La Carpeta [**PROGRAMACION_JAVA**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH) es donde tiene lugar la codificación del programa. Esta codificación la realizo mediante Netbeans.

* La Carpeta [**DOCUMENTACION**] va a contener toda la documentación (manuales, presentacion).


# REQUISITOS PARA EJECUTAR EL PROGRAMA:

* [**1º.-**] Descargar el repositorio o clonarlo en tu PC. Abrirlo o descomprimirlo, etc...

* [**2º.-**] Realiza los siguientes pasos para la instalación de [**Oracle 12c en Linux con Vagrant**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH)

* [**3º.-**] Utiliza SQL Developer para generar la Base de Datos mediante el SCRIPT DDL DE ORACLE, cargar los PAQUETES y los DISPARADORES mencionados anteriormente.

* [**4º.-**] Instalar [**Netbeans**](https://netbeans.org/)

* [**5º.-**] Ejecuta Netbeans e importa [**MyCalendar y MyLibrary**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH/src)

* [**6º.-**] Edita la Clase  [**GenericoBD**](https://github.com/migueloh/PROYECTO_ESPORT_G6/blob/master/PROGRAMA_JAVA/ProyectoEsport_MOH/src/ModelBD/GenericoBD.java) con los datos que utilices en el paso **2º**.

* [**7º.-**]* Si quieren entender el funcionamiento de la aplicación al detalle, revisen la siguiente carpeta:
	* [**JAVADOC**](https://github.com/migueloh/PROYECTO_ESPORT_G6/tree/master/PROGRAMA_JAVA/ProyectoEsport_MOH/dist/javadoc) Esta contiene la documentación de la APi en formato HTML. Si abren el INDEX.HTML con un Navegador Web de su elección, le permitirá analizar la estructura de la aplicación. **Destacar** que la aplicación se encuentra con comentarios, procedimientos, funciones, clases y métodos desarrollados de tal forma que explican al detalle que hace cada uno y cómo.
	
* [**8º.-**] Ejecuta el programa. El **usuario y clave** por defecto del **Administrador** es **ROOT / ROOT**.

* [**9º.-**] El **usuario y clave** por defecto del **Dueño** es **SUPER / DUEÑO****.

* [**10º.-**] El **usuario y clave** por defecto del **Usuario** es **SUPER / USUARIO**.

![alt text](https://github.com/migueloh/PROYECTO_ESPORT_G6/blob/master/BLOG/Captura1.PNG)
