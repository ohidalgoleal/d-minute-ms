FROM openjdk:8-jdk-alpine
# Add Maintainer Info
LABEL maintainer="ohidalgoleal@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside this container
EXPOSE 8001

# Fix zona horaria de Chile
#RUN apk update && apk install -y tzdata
#ENV TZ America/Santiago

ENV CONFIG_SERVER_DMINUTE=https://dminute-config-server.herokuapp.com/
ENV EUREKA_ENDPOINT=https://d-minute-eureka.herokuapp.com/eureka/
ENV DOMAIN_NAME=dminuteapi.herokuapp.com

# The application's jar file
ARG JAR_FILE=target/d-minute-ms-1.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} dminute.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=docker","-jar","/dminute.jar"]