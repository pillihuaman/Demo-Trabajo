ARG MS_NAME=management
FROM amazoncorretto:11-alpine-jdk
ARG MS_NAME
ARG TARGET_FOLDER=/target
ARG PORT_APP=8080
WORKDIR /app
COPY $TARGET_FOLDER/bs-crss-milestone-management-v1-1.0.0.jar .
ENV PORT $PORT_APP
EXPOSE $PORT
CMD ["java", "-jar", "bs-crss-milestone-management-v1-1.0.0.jar"]