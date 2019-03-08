# WEB TEMPLATE

## Version - initial

* Basic spring mvc rest api (**base version**)
* Can be used as an initial web template
 
> version sequence 
* initial
* message - properties
* database - jdbc, jndi?
* flyway - 
* rest-api
* swagger
* oauth
* docker
* ??


#### Clone Repository
```
https://github.com/<username>/web-template.git
```


## Docker

##### Build the image (local)
```
docker build --pull --no-cache -t webtemplate:<VERSION> .
```

##### Run the image (local)
```
docker run --rm -d -p8080:8080 web-template:<VERSION>
```

##### Build the image for remote (pull / push)
```
docker login --username <username> https://hub.docker.com/
docker build --pull --no-cache -t https://hub.docker.com/web-template:<VERSION> .
docker push https://hub.docker.com/web-template:<VERSION>
```