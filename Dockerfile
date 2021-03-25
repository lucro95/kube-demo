FROM openjdk:8-jdk-alpine 
VOLUME C:\\Users\\lucer\\\workspace 
COPY target/kube-demo-0.0.1-SNAPSHOT.jar app.jar 
ENTRYPOINT ["java","-jar","/app.jar"]