Use browser extensions to property view markdown(.md) files. e.g Markdown Preview Plus for google-chrome

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

+ Create a java package to house all java files. Lets name it "springdemo".
+ For simplicity we'll create all files in the same package.

+ REF_1 : http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#dependency-management
+ REF_2 : http://spring.io/blog/2009/12/02/obtaining-spring-3-artifacts-with-maven/

##### Overriding WebApplicationInitializer

Lets make our spring configuration fully annotation based .

+ Include these 2 dependencies :

```
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.0.1</version>
		</dependency>
```

+ Create ApplicationInitializer to implement WebApplicationInitializer and follow REF_1 article.

+ REF_1 :: http://kielczewski.eu/2013/11/spring-mvc-without-web-xml-using-webapplicationinitializer/


##### Creating a WebMvcConfig file 

+ Create a class where we'll specify any configuration thats needed
+ Place component scan annotation to tell spring which packages to scan.
+ For now class body can remain empty

```
@Configuration
@ComponentScan(basePackages = "springdemo")
public class WebMvcConfig extends WebMvcConfigurationSupport {
}

```	


##### Creating controllers-services

+ Create a simple controller marked with @Controller
+ Create a controller method (use "@RequestMapping" and "@ResponseBody") and let it return a simple string.

```
@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public @ResponseBody String hello(){
		return "Controller Hit";
	}

}

```

+ Run and test. It should work.


##### Adding Response Converter

+ Create a simple Model object marked with @Component
+ Modify the controller method and let it return the above model object

```
@RequestMapping("/hello")
	public @ResponseBody HelloModel hello(){
		HelloModel helloModel = new HelloModel();
		helloModel.setId(1);
		helloModel.setName("Hello");
		return helloModel;
	}

```

+ Run the server. This should give a 406 error.

+ To fix we add a Custom HttpMessageConverter (Jackson)
+ Add Jackson dependency 

```
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.2.2</version>
		</dependency>
```

+ Define a custom message converter in WebMvcConfig file

```
@Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }

```

+ REF_1 :: http://websystique.com/springmvc/spring-mvc-requestbody-responsebody-example/

##Enter JPA/Hibernate

In progress
