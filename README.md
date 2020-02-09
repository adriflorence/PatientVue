# Patient Vue

### Data Source
PatientVue uses the [Patient View API](https://patientviewbasic.docs.apiary.io), a set of JSON-based REST endpoints that allow retrieval of a patient's hospital records.

### Application

- The web application uses Spring Boot as a proxy to access PatientView's resource server.
- The object mapping from JSON to Java is done with the help of [Jackson](https://github.com/FasterXML/jackson) - previously known as the standard JSON library for Java.
- The client was created with Vue.js with the help of [Vue CLI 3](https://cli.vuejs.org).
- Data is retrieved from the FHIR (Fast Healthcare Interoperability Resources) Database.