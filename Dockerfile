FROM openjdk:14-alpine
COPY build/libs/micronaut-kotlin-*-all.jar micronaut-kotlin.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-kotlin.jar"]