FROM mysql:latest

ENV MYSQL_ROOT_PASSWORD: 12345 \
    MYSQL_DATABASE: micorservice_example \
    MYSQL_USER: spring_user \
    MYSQL_PASSWORD: 12345 \

ADD db.sql /docker-entrypoint-initdb.d

EXPOSE 3306:3306