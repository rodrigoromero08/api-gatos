FROM openjdk:11.0.3-jdk

VOLUME /tmp

COPY target/api-busca-gatos-1.0.0.jar api-busca-gatos.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/api-busca-gatos.jar"]

