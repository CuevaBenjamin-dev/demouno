# ====== STAGE 1: build ======
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos pom.xml primero (mejora cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del proyecto
COPY src ./src

# Construimos el jar
RUN mvn clean package -DskipTests


# ====== STAGE 2: runtime ======
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar desde el stage build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
