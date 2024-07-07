# microservices demo project
La solucion consiste en 2 microservicios y una base de datos Postgres, cada uno de ellos desplegado en un contenedor
##  customer-service
### base de datos
[schema](customer-db.sql)
### Construir servicios
```
cd customer-service
mvn install
```
### Ejecutar pruebas unitarias y de integracion
```
mvn test
```
### Ejecutar servicio y base de datos
```
cd customer-service
docker compose -p devsu up
```
### Postman collection
[collection](Customers.postman_collection.json)
##  account-service
### Construir servicios
```
cd account-service
mvn test
mvn install
```
### Ejecutar servicio y base de datos
```
cd account-service
docker compose -p devsu up
```
## Ejecutar pruebas con Postman
[Contribution guidelines for this project](settings.xml)



