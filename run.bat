@Echo off
mvn spring-boot:run -Dspring-boot.run.profiles="%1" -q