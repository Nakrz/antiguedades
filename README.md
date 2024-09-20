

# **Proyecto Backend de Gestión de Entidades**

El proyecto consiste en una API REST para la gestión de diversas entidades, implementada en Java utilizando Spring Boot. Esta API permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre un conjunto de entidades definidas.
Componentes Clave:

## Controlador (EntidadController):

​    Maneja las peticiones HTTP relacionadas con las entidades.
​    Utiliza el servicio EntidadService para interactuar con la base de datos.

## Operaciones:

​    Listar: Devuelve una lista de todas las entidades en formato DTO.
​    Obtener por ID: Permite obtener el atributo de una entidad específica mediante su ID.
​    Crear: Acepta un objeto de la entidad en el cuerpo de la petición y lo guarda en la base de datos.
​    Actualizar: Actualiza el atributo de una entidad existente si se proporciona un ID válido.
​    Eliminar: Elimina el atributo de una entidad mediante su ID, si existe.

### DTO (Data Transfer Object):

​    Se utiliza para transferir datos de las entidades de forma simplificada y evitar exponer la estructura de la entidad original.

Este sistema proporciona una interfaz sencilla para la gestión de diferentes entidades, facilitando la integración y el manejo de datos en aplicaciones que requieran esta funcionalidad.



### **Endpoints**



#### GET:

http://localhost:8080/NombreEntidad

#### POST:

http://localhost:8080/NombreEntidad/nuevo

#### PUT:

http://localhost:8080/NombreEntidad/actualizar/id

#### DELETE:

http://localhost:8080/NombreEntidad/eliminar/id



