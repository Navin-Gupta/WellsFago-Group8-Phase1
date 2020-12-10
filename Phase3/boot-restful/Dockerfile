# install Linux O/S
# install jdk-8
# clubbed image of alpine O/S with JDK 8
FROM openjdk:8-jdk-alpine

# Copy the jar file from local machine to filesystem of VM
COPY target/boot-restful-0.0.1-SNAPSHOT.jar /tmp/boot-restful.jar

# instruction to run the jar file
# will execute when container is launched
# CMD "java -jar /tmp/boot-restful.jar"
CMD ["java", "-jar", "/tmp/boot-restful.jar"]