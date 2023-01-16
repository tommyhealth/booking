FROM maven:3.8.6 AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package -DskipTests

FROM bellsoft/liberica-openjdk-alpine-musl:17
ARG JAR_FILE=booking-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","booking-0.0.1-SNAPSHOT.jar"]
