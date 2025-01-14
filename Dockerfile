FROM openjdk:21

COPY target/IMSapp.jar myapp.jar

ENTRYPOINT ["java","-jar","myapp.jar"]