FROM adoptopenjdk/openjdk11:alpine
LABEL project="Sales"
LABEL name="Marcelo T. Fraga"
LABEL mail="marcelotfraga@gmail.com"
VOLUME tmp
RUN mkdir /opt/app \ 
apk update && apk upgrade \
apk add curl \
apk add busybox-extras
COPY target/sale-0.0.1-SNAPSHOT.jar /opt/app/app.jar
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=dev", "-cp", "/opt/app", "-jar", "/opt/app/app.jar"]