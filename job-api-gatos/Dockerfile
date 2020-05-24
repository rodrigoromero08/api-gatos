FROM openjdk:11.0.3-jdk

VOLUME /tmp

COPY target/job-api-gatos-1.0.0.jar job-api-gatos.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/job-api-gatos.jar"]

