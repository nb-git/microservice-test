FROM jeanblanchard/java:latest
ADD build/libs/microservice-example-0.0.1-SNAPSHOT.jar app.jar
CMD java -Xmx400m -Xms400m -jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://mysql-ms-01/micorservice_example", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]