FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/career-compass-service-0.0.1-SNAPSHOT.jar career-compass-servic.jar
ENTRYPOINT ["java","-jar","/career-compass-servic.jar"]