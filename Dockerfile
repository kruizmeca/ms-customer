FROM openjdk:11
VOLUME /tmp
EXPOSE 8013
ADD ./target/ms-customer-0.0.1-SNAPSHOT.jar ms-customer.jar
ENTRYPOINT ["java","-jar","/ms-customer.jar"]
