# Library - Fullstack project

Este proyecto es una aplicación fullstack desarrollada con Java (Spring Boot) en el backend y Vue.js en el frontend. Utiliza Docker para la administración de contenedores y combina tecnologías como JavaScript, Tailwind CSS y PostgreSQL para crear una aplicación completa.

## Clonar el Proyecto

Para comenzar a trabajar con este proyecto, clona el repositorio en tu máquina local utilizando el siguiente comando:

```
git clone https://url-del-repositorio.git
```

Configuración del Entorno
Cliente (Vue.js)
Crea un archivo .env en la carpeta client basado en el .env.sample proporcionado.

### Configura la variable API_ENDPOINT en el archivo .env para apuntar a la URL de la API del servidor:

```
API_ENDPOINT=http://localhost:8080/api
```

Servidor (Java - Spring Boot)
Configura el archivo application.properties en la carpeta server según las configuraciones de tu base de datos. Aquí hay un ejemplo para PostgreSQL:

```
server.port=8082
spring.datasource.url=jdbc:postgresql://localhost:5433/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```
Asegúrate de ajustar la URL, el nombre de usuario y la contraseña según tu configuración de base de datos.

Ejecutar la Aplicación con Docker
Asegúrate de tener Docker instalado en tu máquina.

Desde la raíz del proyecto, ejecuta el siguiente comando para iniciar la aplicación con Docker Compose:
```
docker-compose up
```
Este comando construirá y ejecutará los contenedores de cliente y servidor, así como la base de datos PostgreSQL