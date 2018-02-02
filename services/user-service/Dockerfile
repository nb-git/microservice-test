FROM jeanblanchard/java:latest
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
#CMD java -Xmx400m -Xms400m -Dspring.datasource.url=jdbc:mysql://mysql-ms-01/micorservice_example -jar microservice-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://mysql-ms-01/micorservice_example","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]