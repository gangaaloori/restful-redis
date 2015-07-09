# restful-redis
Very basic RESTful APIs for interacting with Redis using SpringBoot.

# How to run
```shell
java -jar restful-redis-1.0.0-SNAPSHOT.jar
```

# How to test

* Set key-value pair to Redis
```shell
curl -H "Content-Type: application/json" -H "Accept: application/json" -X PUT -d "{\"key\": \"amit\",  \"value\": \"nfr tester\"}" http://localhost:8080/set
```

* Get value from Redis
```shell
curl -i -X GET "http://localhost:8080/get?key=ganga"
```

* List all key-value pairs
```shell
curl -i http://localhost:8080
```

