FROM openjdk:11.0.11-jdk
EXPOSE 9090
ADD /build/libs/secondApplication-0.0.1-SNAPSHOT.jar second.jar
ENTRYPOINT ["java", "-jar", "second.jar"]