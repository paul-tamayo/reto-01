FROM amazoncorretto:25
EXPOSE 80
COPY ./target/spring-cloud-gateway-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]