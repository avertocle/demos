##Create
---

We start by creating a new maven project and opening it in eclipse.

1. eclipse -> file -> new-maven-project
1. check : create-a-simple-project 
1. location : create a directory springdemo somewhere and put its path here
1. next
1. GroupId=ArtifactId=Name=Description=springdemo
1. Packaging=war
1. finish


##Compile and Run
---

Lets try to build this as a maven project.

+ open terminal -> navigate to project location -> `mvn clean install`
+ this might give an error : "Error assembling WAR: webxml attribute is required"
+ to fix this : project-right-click -> java-ee-tools -> generate-deployment-descriptor-stub
+ open terminal -> navigate to project location -> `mvn clean install`

From here on out we assume that : tomcat8-server is added in eclipse, and its base path is set to /

+ project-right-click -> maven -> update-project
+ project-right-click -> run-as -> run-on-server

This will build our war and run it on the above tomcat-instance.

+ open http://localhost:8080/ in a browser 

This gives 404. Not cool. Lets add a welcome page.

+ project -> javascript-resources -> src/main/webapp -> right-click -> new-html-file -> index.html
+ write something in index.html created above
+ open http://localhost:8080/ in a browser 

Now we see index.html we added in the previous step.

##Enter Spring
---

We start by adding the basic spring-framework-dependency to our pom.xml. version-to-taste.

REF_1 :: http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#dependency-management
REF_2 :: http://spring.io/blog/2009/12/02/obtaining-spring-3-artifacts-with-maven/

```
	<properties>
		<spring.version>4.1.2.RELEASE</spring.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
	</dependencies>
```







