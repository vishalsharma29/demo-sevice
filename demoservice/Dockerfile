FROM artifactory.cobalt.com/java8
USER root
WORKDIR /opt/demo-service
COPY target/demo-service-*.jar /opt/demo-service/demo-service.jar
LABEL vendor="Demo Service"
EXPOSE 8080
CMD ["java","-jar","/opt/demo-service/demo-service.jar"]