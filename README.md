# ms-productos

## Descripción

Microservicio desarrollado con Spring Boot para la gestión de productos.

Permite:

* Registrar productos
* Listar productos
* Obtener productos por ID
* Actualizar productos
* Eliminación lógica de productos

El proyecto utiliza PostgreSQL como base de datos y sigue una arquitectura basada en capas:

* Controller
* Service
* Repository
* Entity
* DTO
* Exception Handler

---

# Tecnologías utilizadas

* Java 17
* Spring Boot 4
* Spring Web
* Spring Data JPA
* PostgreSQL
* Hibernate
* Maven
* Lombok
* Docker
* Render
* Neon

---

# Endpoints disponibles

## Crear producto

POST `/api/productos`

### Body

```json
{
  "nombre": "Laptop Lenovo",
  "descripcion": "Laptop Ryzen 7",
  "precio": 3500,
  "stock": 10,
  "estado": true
}
```

---

## Listar productos

GET `/api/productos`

---

## Obtener producto por ID

GET `/api/productos/{id}`

---

## Actualizar producto

PUT `/api/productos/{id}`

### Body

```json
{
  "nombre": "Laptop HP",
  "descripcion": "Laptop Intel i7",
  "precio": 4200,
  "stock": 5,
  "estado": true
}
```

---

## Eliminar producto (eliminación lógica)

DELETE `/api/productos/{id}`

---

# Variables de entorno necesarias

```properties
DB_URL=
DB_USERNAME=
DB_PASSWORD=
PORT=
```

---

# application.properties

```properties
spring.application.name=ms-productos

server.port=${PORT:8081}

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

# Instrucciones para ejecutar en local

## 1. Clonar repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

---

## 2. Ingresar al proyecto

```bash
cd ms-productos
```

---

## 3. Configurar variables de entorno

Ejemplo:

```properties
DB_URL=jdbc:postgresql://localhost:5432/bdproductos
DB_USERNAME=postgres
DB_PASSWORD=123456
```

---

## 4. Ejecutar proyecto

```bash
mvn spring-boot:run
```

---

# Docker

## Construir imagen

```bash
docker build -t ms-productos .
```

---

# Instrucciones básicas de despliegue

## Render

1. Crear nuevo Web Service
2. Conectar repositorio GitHub
3. Configurar variables de entorno
4. Deploy automático

---

## Neon

1. Crear proyecto PostgreSQL
2. Copiar credenciales de conexión
3. Configurar variables DB_URL, DB_USERNAME y DB_PASSWORD en Render

---

# URL del servicio desplegado

https://ms-productos-le1k.onrender.com

