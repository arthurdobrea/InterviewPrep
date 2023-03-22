FROM eclipse-temurin:17-jdk-jammy

EXPOSE 8080
EXPOSE 3306

WORKDIR /app
COPY target/practice-0.0.1-SNAPSHOT.war .

CMD ["java", "-jar", "practice-0.0.1-SNAPSHOT.war"]