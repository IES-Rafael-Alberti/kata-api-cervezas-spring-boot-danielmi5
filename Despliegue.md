# Levantar la aplicación (BD en Docker, app en local)

Este documento describe pasos para levantar la base de datos con `docker-compose` (MariaDB + Adminer) y ejecutar la aplicación Spring Boot localmente.

## 1 Levantar la base de datos y Adminer**

Desde la raíz del proyecto ejecuta:

```bash
docker compose up -d
```

Verifica los logs del servicio `db` para confirmar la inicialización de los scripts SQL:

```bash
docker compose logs -f db
```

Adminer estará disponible en `http://localhost:8888`.

Conéctate con:
- Sistema: `MySQL`
- Server: `localhost`
- Usuario: `root`
- Password: `Super`
- Database: `kata-api`

## 2 Ejecutar la aplicación localmente**

Desde la raíz del proyecto ejecuta (usar el wrapper si está disponible):

```bash
./mvnw spring-boot:run
# o
mvn spring-boot:run
```

Observa la salida: busca mensajes de conexión JDBC o excepciones. La app por defecto escucha en `http://localhost:8080`.