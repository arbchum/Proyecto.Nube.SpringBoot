FROM amazoncorretto:17-alpine-jdk

COPY target/spring_converter_csvs_to_excel-0.0.1-SNAPSHOT.jar /api-v1.jar

ENTRYPOINT ["java", "-jar", "/api-v1.jar"]