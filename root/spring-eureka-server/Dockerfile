FROM amazoncorretto:25
EXPOSE 80
COPY ./target/spring-eureka-server-*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]