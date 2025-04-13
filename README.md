# Proyecto Gestión Académica

Este proyecto es parte de mi proyecto integrador, donde se desarrolla una **aplicación de Gestión Académica**. El objetivo principal es gestionar la información de **estudiantes**, **profesores** y **cursos**. 

## Tecnologías Utilizadas
- **Backend**: Spring Boot (Java)
- **Base de datos**: H2 (para pruebas), planeado a integrar con MySQL.
- **Pruebas de API**: Postman
- **Otros**: Maven para gestión de dependencias.

## Descripción del Proyecto

La aplicación permite gestionar estudiantes, profesores y cursos. Se pueden realizar operaciones como **crear**, **consultar**, **actualizar** y **eliminar** estudiantes, profesores y cursos mediante una API RESTful. La arquitectura sigue el patrón de capas: **Modelo**, **Repositorio**, **Servicio** y **Controlador**.

###. Estructura del Proyecto (Capas)
Explicación de las capas: model, repository, service, controller.

Los modelos:
También llamados entidades, son clases que representan las tablas de la base de datos.
Cada clase es una table, cada atributo (campo) es una columna de esa table y cada objeto creado a partir de esa clase sería una fila (registro) en la tabla.

Los Repositorios:
En Spring Boot, los repositorios son interfaces que se encargan de comunicar la aplicación con la base de datos. Se basan en Spring Data JPA y te permiten hacer operaciones CRUD sin necesidad de escribir SQL.

Los Servicios:
Los servicios son una capa intermedia entre los controladores y los repositorios.
Sirven para manejar la lógica de negocio de la aplicación.
Es todo lo que la aplicación debe hacer más allá de simplemente guardar o traer datos.
Por ejemplo:
Validaciones.
Cálculos.
Reglas específicas del proyecto.

Los controladores:
Un controlador (o controller) es como el puente entre el usuario y la aplicación.
ejemplo
El usuario quiere hacer algo (por ejemplo, ver todos los estudiantes).
Ese pedido llega como una URL o petición HTTP (por ejemplo, GET /estudiantes).
El controlador recibe ese pedido, habla con los servicios y devuelve una respuesta.

Endpoints
GET /api/cursos: Lista todos los cursos.

POST /api/cursos: Crea un nuevo curso.

GET /api/estudiantes: Lista todos los estudiantes.

POST /api/estudiantes: Crea un nuevo estudiante.

DELETE /api/profesores/{id}: Elimina un profesor por ID.

Notas
Actualmente, se usa H2 como base de datos en memoria para pruebas.

El proyecto se integrará con una base de datos MySQL real cuando esté disponible.

Créditos
Proyecto creado por Héctor Alejandro Gaviria Marin.
