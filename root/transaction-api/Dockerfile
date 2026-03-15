FROM amazoncorretto:25
EXPOSE 80
COPY ./target/transaction-api-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]