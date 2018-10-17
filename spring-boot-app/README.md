# Simple SpringBoot Based App

## Requirements

The following is a list of requirements:
 - maven 3
 - java `1.8`
 - postgres 10
 
## Description

This is a simple spring-boot app. The application connects to postgres database (connection defined in `application.yml`) and connects to node-app.

```
GET /java/api/v1/status
```
Returns a status of an application as following JSON:

```json
{
 "status": "UP",
 "postgresVersion": "PostgreSQL 10.4 (Debian 10.4-1.pgdg90+1) on x86_64-pc-linux-gnu, compiled by gcc (Debian 6.3.0-18+deb9u1) 6.3.0 20170516, 64-bit" 
}
```
*Note: `postgresVersion` can differ based on your postgres database.*

```
GET /java/api/v1/node
```

Calls a node application defined in `application.yml` file as `app.node.url` and returns a result from that call as a following JSON:

```json
{
 "data": "Hello world from node app" 
}
```

## Building

To build run:

```
mvn clean package
```

This will create a jar in `target` dir ie. `target/spring-boot-app-1.0-SNAPSHOT.jar`.

To run this jar, use:

`java -jar target/spring-boot-app-1.0-SNAPSHOT.jar`

The app will listen on port `8080`.

In order to start application with custom config file pass `--spring.config.location` argument to java command, for example:

`java -jar target/spring-boot-app-1.0-SNAPSHOT.jar --spring.config.location=my-conf.yml`

Use `spring-boot-app/src/main/resources/application.yml` as reference to see which properties are available.