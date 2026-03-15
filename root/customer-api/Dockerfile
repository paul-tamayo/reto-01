FROM amazoncorretto:25
EXPOSE 80
COPY ./target/customer-api-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]