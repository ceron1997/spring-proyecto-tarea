<b> Descripción del Proyecto de Gestión de Proyectos con Spring Boot </b>
<b>Descripción General: </b>
<p>Se ha desarrollado una aplicación de gestión de proyectos utilizando el framework Spring Boot. La aplicación permite
    la creación, lectura, actualización y eliminación (CRUD) de proyectos y tareas asociadas. La implementación se basa
    en los siguientes aspectos:
</p>
<b>Modelado de Datos: </b>
<p>
    • Se definen dos modelos principales: Proyecto y Tarea.
</p>
<p>
    • Se establece una relación uno a muchos entre los modelos, donde un proyecto puede tener múltiples tareas
    asociadas.
</p>
<b>
    Implementación RESTful:
</b>
<p>
    • Se implementan controladores REST para gestionar las operaciones CRUD de proyectos y tareas.
</p>
<p>
    • Se utiliza la anotación @RestController para indicar los controladores como puntos de entrada RESTful.
</p>
<p>
    • Se emplean métodos HTTP estándar (GET, POST, PUT, DELETE) para cada operación CRUD.
</p>

<b>
    Lógica de Negocio:
</b>
<p>
    • Se desarrolla la lógica de negocio utilizando servicios de Spring Boot.
</p>
<p>
    • Los servicios encapsulan la funcionalidad principal de la aplicación, como la creación, validación y actualización
    de proyectos y tareas.

</p>
<p>
    • La inyección de dependencias se utiliza para gestionar las dependencias entre los servicios.
</p>
<b>
    Documentación de la API:
</b>
<p>
    • Se utiliza Swagger para documentar las APIs de la aplicación.
</p>
<p>
    • Se añaden anotaciones en los métodos de los controladores para definir resúmenes, parámetros de entrada,
    descripciones detalladas y posibles respuestas de las operaciones.

</p>
<p>
    • La documentación de Swagger incluye ejemplos de solicitudes y respuestas, facilitando la comprensión y utilización
    de las APIs por parte de otros desarrolladores.

</p>

<b>
    Gestión de Dependencias:
</b>

<p>
    • Se utiliza Maven para gestionar las dependencias y configuraciones de la aplicación.

</p>
<p>
    • Se incluyen bibliotecas como spring-boot-starter-web, spring-boot-starter-data-jpa, Lombok y mysql-connector-j.

</p>



<b>
    Pruebas Unitarias:
</b>
<p>
    • Se realizan pruebas unitarias exhaustivas de las APIs utilizando el plugin Thunder Client en Visual Studio Code.

</p>
<p>
    • Las pruebas garantizan el correcto funcionamiento y la precisión de las respuestas de las APIs.

</p>
