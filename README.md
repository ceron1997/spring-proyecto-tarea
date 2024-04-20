Descripción del Proyecto de Gestión de Proyectos con Spring Boot
Descripción General:
Se ha desarrollado una aplicación de gestión de proyectos utilizando el framework Spring Boot. La aplicación permite la creación, lectura, actualización y eliminación (CRUD) de proyectos y tareas asociadas. La implementación se basa en los siguientes aspectos:
Modelado de Datos:
•	Se definen dos modelos principales: Proyecto y Tarea.
•	Se establece una relación uno a muchos entre los modelos, donde un proyecto puede tener múltiples tareas asociadas.
Implementación RESTful:
•	Se implementan controladores REST para gestionar las operaciones CRUD de proyectos y tareas.
•	Se utiliza la anotación @RestController para indicar los controladores como puntos de entrada RESTful.
•	Se emplean métodos HTTP estándar (GET, POST, PUT, DELETE) para cada operación CRUD.
Lógica de Negocio:
•	Se desarrolla la lógica de negocio utilizando servicios de Spring Boot.
•	Los servicios encapsulan la funcionalidad principal de la aplicación, como la creación, validación y actualización de proyectos y tareas.
•	La inyección de dependencias se utiliza para gestionar las dependencias entre los servicios.
Documentación de la API:
•	Se utiliza Swagger para documentar las APIs de la aplicación.
•	Se añaden anotaciones en los métodos de los controladores para definir resúmenes, parámetros de entrada, descripciones detalladas y posibles respuestas de las operaciones.
•	La documentación de Swagger incluye ejemplos de solicitudes y respuestas, facilitando la comprensión y utilización de las APIs por parte de otros desarrolladores.
Gestión de Dependencias:
•	Se utiliza Maven para gestionar las dependencias y configuraciones de la aplicación.
•	Se incluyen bibliotecas como spring-boot-starter-web, spring-boot-starter-data-jpa, Lombok y mysql-connector-j.
Pruebas Unitarias:
•	Se realizan pruebas unitarias exhaustivas de las APIs utilizando el plugin Thunder Client en Visual Studio Code.
•	Las pruebas garantizan el correcto funcionamiento y la precisión de las respuestas de las APIs.
