# User Manager API

Este proyecto es una API REST para la gestión de usuarios, desarrollada con **Spring Boot**. En el marco de la postulación al cargo de desarrollador backend java.

## Descripción

La aplicación permite:

- Crear usuarios
- Listar todos los usuarios
- Obtener una usuario por ID
- Actualizar un usuario
- Eliminar un usuario

Incluye documentación interactiva con Swagger UI.

---

## Requisitos

- Java 17+
- Gradle
- Curl para probar endpoints (Opcional)

---

## Base de datos

La base de datos que utiliza este proyecto, es una base de datos en memoria H2. La cual se reinicia cada vez que se levanta la aplicación, borrando los datos que se hayan generado durante la ejecución del proyecto.

---

## Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/hgajardofrancino/desafio-java-nttdata.git

2. Construí el proyecto:

    ```bash
   ./gradlew clean build

3. Ejecutá la aplicación:

    ```bash
    ./gradlew bootRun

---
## Swagger

Para probar los endpoint se puede realizar mediante la interfaz de usuario de swagger, la cual se puede encontrar en la url: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

##  Endpoints principales

A coninuacion se muestran los CURLs asociados a los endpoints disponibles para la gestion de usuarios. Estos puedes ejecutarse directamente en consola o bien exportarlos a Postman.
> En los curl de ejemplo PUT, GET, DELETE donde se requiere un ID, se debe cambiar el Id por uno existente.

```
    -H "Authorization: Bearer <TOKEN>"
```

###  - Crear usuario

```bash
    curl -X POST http://localhost:8080/api/user/ \
      -H 'Content-Type: application/json' \
      -d '{
        "nombre": "Pedro Picapiedra",
        "correo": "pedro.picapiedra@email.com",
        "contraseña": "claveSegura123",
        "telefonos": [
                {
                    "numero": 123456789,
                    "codigoCiudad": 1,
                    "codigoPais": 57
                }
            ]
    }'
```

### - Listar todos los usuarios

```bash
    curl -X GET http://localhost:8080/api/user/ \
      -H 'Content-Type: application/json'
  
```

### - Obtener usuario por ID

```bash
    
    curl -X GET http://localhost:8080/api/user/550e8400-e29b-41d4-a716-446655440000 \
      -H 'Content-Type: application/json'
    
```

### - Actualizar usuario

```bash
    curl -X PUT  http://localhost:8080/api/user/550e8400-e29b-41d4-a716-446655440000 \
          -H 'Content-Type: application/json' \
          -d '{
            "nombre": "Pedro Picapiedra Actualizado",
            "correo": "pedro.nueva@email.com",
            "contraseña": "nuevaClave1234",
            "telefonos": [
                {
                    "numero": 123456789,
                    "codigo_ciudad": 2,
                    "codigo_pais": 57
                }
            ]
        }'
```

### - Eliminar usuario

```bash
    curl -X DELETE http://localhost:8080/api/user/550e8400-e29b-41d4-a716-446655440000 \
      -H 'Content-Type: application/json'

```

---

## Swagger UI

Podés ver la documentación completa:

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Contacto

Para consultas o sugerencias, favor escribirme a [hgajardofrancino@gmail.com](mailto:hgajardofrancinol@gmail.com).