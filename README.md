# devsu-challenge
La solucion consiste en 2 microservicios y una base de datos Postgres, cada uno de ellos desplegado en un contenedor
## Construir servicios
cd customer-service
mvn clean install
## Ejecutar servicios y base de datos
docker compose up
## Ejecutar pruebas unitarias
mvn test
## Ejecutar pruebas con Postman
[Contribution guidelines for this project](CONTRIBUTING.md)



