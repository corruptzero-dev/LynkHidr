FROM gradle:7.6.0-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build shadowJar --no-daemon

FROM amazoncorretto:11-alpine-jdk

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/lynkhidr.jar

ENTRYPOINT ["java","-jar","/app/lynkhidr.jar"]