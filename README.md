# SSO Demo

This repository contains three Spring Boot services demonstrating custom JWT-based SSO:

- **auth-server** – issues JWT tokens after basic authentication.
- **service1** – resource server exposing `/service1/hello`.
- **service2** – resource server exposing `/service2/greet`.

## Running

Build and start each service in separate terminals:

```bash
mvn -q -f auth-server/pom.xml spring-boot:run
mvn -q -f service1/pom.xml spring-boot:run
mvn -q -f service2/pom.xml spring-boot:run
```

Retrieve a token from the authentication server:

```bash
curl -u user:password -X POST http://localhost:9000/auth/token
```

Call the protected endpoints using the token:

```bash
curl -H "Authorization: Bearer <token>" http://localhost:9001/service1/hello
curl -H "Authorization: Bearer <token>" http://localhost:9002/service2/greet
```
