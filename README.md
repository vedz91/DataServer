# DataServer

How to start the DataServer application
---

1. Run `mvn clean install` to build your application
1. Build your packages by running `mvn package`
1. Start application with `java -jar target/DataServer-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9000/static`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`


## To Do
- [x] Create a Static Endpoint
- [x] Create a [fat jar](https://www.baeldung.com/executable-jar-with-maven)
- [x] Integrate Lombok
- [x] Integrate Endpoint which will perform Multiplication
- [x] Integrate Swagger
- [x] Test sf4j application logging
- [x] Implement custom exception Handler
- [ ] Maven exec plugin: exec-maven-plugin
- [x] Configure jUnit @ 5
- [ ] Setup CI
- [ ] Setup Authentication

## Nice To Have
- [ ] Enable PMD
- [ ] Enable Bugzilla  