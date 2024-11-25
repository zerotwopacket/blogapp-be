FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar app.jar
EXPOSE 8080
ENV BLOGAPP_DB_HOST=localhost
ENV BLOGAPP_DB_PORT=3306
ENV BLOGAPP_DB_USER=root
ENV BLOGAPP_DB_PASSWORD=kakokaba
ENTRYPOINT ["java","-jar","/app.jar","-Dspring.datasource.url=${BLOGAPP_DB_HOST}","-Dspring.datasource.username=${BLOGAPP_DB_USER}","-Dspring.datasource.password=${BLOGAPP_DB_PASSWORD}"]