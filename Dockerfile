FROM openjdk:21-jdk-slim
COPY build/libs/user-0.0.1-SNAPSHOT.jar owner.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "owner.jar"]