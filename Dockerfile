FROM openjdk:11

WORKDIR /app

FROM maven

COPY . .

RUN mvn dependency:resolve

CMD ["mvn", "test", "-Dsuite=${SUITE_NAME}"]