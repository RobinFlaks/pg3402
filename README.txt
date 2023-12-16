things needed to start the project:

mvn installed on the computer
to get the database up and running:
- docker (docker desktop) installed
- make sure docker engine is running
- run "docker compose up -d" in terminal while being in the pg3402 folder
- go to localhost:5050 and make the password: "pass"
- go to "add new server"
- name the new server "pg3402"
- under the connection tab name the host name/address "postgres"
- in the same tab make the username "pg3402" and password "pass", then click save
- under the servers tab on the left right-click "Databases" and create a new database "users"
- do the same to make a database "cheaters"


in a real environment I would create a postgres service for each microservice in the docker-compose.yml, but due to limited space I have chosen for all the microservices to use the same postgres service.