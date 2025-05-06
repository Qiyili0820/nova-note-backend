# 第一階段：用 Maven 打包 Spring Boot JAR
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -B clean package -DskipTests

# 第二階段：執行可執行 JAR
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/nova-note.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
