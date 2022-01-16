# WEB TEMPLATE

## Version - initial

* Basic spring mvc rest api (**base version**)
* Can be used as an initial web template
 
> version sequence 
* initial
* message - properties
* database - jdbc, jndi?
* flyway - 
* resttest
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

## GIT credential and gitignore
stored credentials using following

git config --global credential.helper store
You can add a global .gitignore file that defines rules for adding files to ignore. This configuration can be done in the following way:

@link: https://www.educative.io/edpresso/how-to-add-a-file-to-gitignore-on-github

Create a .gitignore_global file on the computer.
Open Terminal.
Configure git to use this file as .gitignore for all repositories by using the command:
git config --global core.excludesfile PATH
