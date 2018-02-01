FROM jeanblanchard/java:latest
ADD build/libs/microservice-example-0.0.1-SNAPSHOT.jar .
CMD java -Xmx400m -Xms400m -Dspring.datasource.url=jdbc:mysql://mysql-ms-01/micorservice_example -jar microservice-example-0.0.1-SNAPSHOT.jar
EXPOSE 8080
#ENTRYPOINT ["java","-Dspring.datasource.url=jdbc:mysql://mysql-ms-01/micorservice_example", "-Djava.security.egd=file:/dev/./urandom","-jar","/microservice-example-0.0.1-SNAPSHOT.jar"]