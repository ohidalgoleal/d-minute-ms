#docker build -t d-minute-ms -f Dockerfile .
FROM java:8
# Microservicio port
EXPOSE 8080
ADD build/libs/d-minute-ms-1.0.0.jar /app/d-minute-ms-1.0.0.jar

# Fix zona horaria de Chile
RUN apt-get update && apt-get install -y tzdata
ENV TZ America/Santiago

WORKDIR /app
CMD if [ -n "${DNS1}" ]; then echo "nameserver ${DNS1}\n" > /etc/resolv.conf; fi \
    && if [ -n "${DNS2}" ]; then echo "nameserver ${DNS2}\n" >> /etc/resolv.conf; fi \
    && java -Xms128m -Xmx128m -jar d-minute-ms-1.0.0.jar