FROM openjdk:14.0.1-jdk
EXPOSE 9966
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} appimage.jar
ENTRYPOINT ["java","-jar","/appimage.jar"]