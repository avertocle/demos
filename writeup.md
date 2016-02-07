###Creation


1. eclipse -> file -> new-maven-project
1. check : create-a-simple-project 
1. location : create a directory springdemo somewhere and put its path here
1. next
1. GroupId=ArtifactId=Name=Description=springdemo
1. Packaging=war
1. finish

this will create a new maven project and open it in eclipse.

###Compiling

+ open terminal, navigate to project location
+ `mvn clean install`
+ this might give errors : "Error assembling WAR: webxml attribute is required"
+ project-right-click -> java-ee-tools -> generate-deployment-descriptor-stub
+ `mvn clean install`
+ project-right-click -> maven -> update-project

assuming tomcat server is added in eclipse, and its base path is set to /, from here on out.

+ project-right-click -> run-as -> run-on-server

this will build your war and run it on a tomcat instance.

+ open http://localhost:8080/ in a browser => gives 404 => on track so far

###Enter spring




