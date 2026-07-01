# Sandbox Maven Basics

Small Java project for learning Maven basics.

## What this project demonstrates

- Maven project structure
- `pom.xml`
- Maven coordinates
- external dependency
- resource loading from `src/main/resources`
- Maven lifecycle phases
- Maven Wrapper

## Main class

```text
com.roadmap.maven.ReceiptApp
```

## Commands
mvn validate
mvn compile
mvn compile exec:java
mvn package
mvn clean

With Maven Wrapper:
.\mvnw.cmd validate
.\mvnw.cmd compile
.\mvnw.cmd compile exec:java
.\mvnw.cmd package