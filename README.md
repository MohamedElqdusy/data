# README

## System Requirements
Java8, Maven, Mongodb
## Run
From command line
1 - Generating a jar file
`$ ./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar`
2 - Run app with mongodb
`$ docker-compose up`
## Usage
After running the service, from your browser navigate to  (http://localhost:8080)
for realtime message display, press connect button.
##### Use cases:
- (http://localhost:8080/messages) endpoint: display all stored messages
- Adding a message: `curl -H 'content-type: application/json' -X POST -d '"{your message}"' http://localhost:8080/add
` 


