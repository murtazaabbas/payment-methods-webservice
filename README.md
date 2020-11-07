# Simple Demo Payment Method Service

  - This application will automatically create the table in DB on start service startup, however sql files have also been placed in folder "mysql-files"
  - Postman collection "DemoPaymentWebService.postman_collection.json" is available to test the service endpoints
  - This application is created in Java 8

#### How to run the application
First create empty schema in mysql
```sh
CREATE DATABASE `demo_payment`
```
Run app using mvn:
```sh
mvn spring-boot:run
```
You can also run this application from IDE. just import this project as maven project and run the main class "SpringbootCrudRestfulWebservicesApplication"
