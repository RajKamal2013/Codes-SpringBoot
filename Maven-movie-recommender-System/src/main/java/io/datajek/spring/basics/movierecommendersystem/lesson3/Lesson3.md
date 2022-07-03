# Lesson 3 

Managing creating instances using Spring Boot 

1. @Component 
2. @Autowired


As like before 
1. ContentBasedFilter Class
2. CollaborativeBasedFilter Class
3. RecommenderImplementation Class
4. Filter Interface
5. MavenMovieRecommendationSystemApplication 

Next : 
1. Edit ContentBasedFilter Class and add annotation @component before declaring class
2. Edit RecommenderImplementation Class and add annotation @Component before
declaring class. Also add @Autowired before defining Filter variable.
3. In MavenMovieRecommendationSystemApplication Class, add @SpringBootApplication
annotation before defining class. 
   1. Get MavenMovieRecommendation appplication context using SpringApplication.run()
      ApplicationContext appContext = SpringApplication.run(        
      MavenMovieRecommenderSystemApplication.class, args);
   2. Get RecommenderClass bean from application context created before.
      RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);
   3. call the method 
      1. String[] result = recommender.recommendMovies("Finding Dory")

Spring automates the above process of creating objects and binding them together. It takes the responsibility of creating instances of classes and binding instances based on their dependencies. The instances or objects that Spring manages are called beans. To manage objects and dependencies, Spring requires information about three things:

1. Beans
2. Dependencies
3. Location of beans



# @Component
If we want Spring to create and manage objects, we can do so by 
adding the @Component annotation at the beginning of the class and 
importing org.springframework.stereotype.Component.

For now, we want Spring to manage objects of RecommenderImplementation 
and ContentBasedFilter class only, so we will add the @Component
annotation at two places in the code:


The Spring container will have two beans, one of type RecommenderImplementation and the other of type 
ContentBasedFilter.


# @Autowired
The second thing Spring needs to know is the dependencies of each object.
The @Autowired annotation is used for this purpose and we need to 
import org.springframework.beans.factory.annotation.Autowired to 
be able to use this annotation.


# @ComponentScan
The third thing that Spring requires from the developer, is the location 
of the beans so that it can find them and autowire the dependencies. 
The @ComponentScan annotation is used for this purpose. 
This annotation can be used with or without arguments. 
It tells Spring to scan a specific package and all of its sub-packages. 
In our case, all the files that contain beans are in the same package, 
io.datajek.springbasics, so we want Spring to do a component scan on this package.
Since we are using Spring Boot, it uses the @SpringBootApplication 
annotation on the MovieRecommenderSystemApplication class. 
This annotation is equivalent to the following three annotations:

## @Configuration
declares a class as the source for bean definitions

## @EnableAutoConfiguration
allows the application to add beans using classpath definitions

## @ComponentScan
which directs Spring to search for components in the path specified


## @SpringBootApplication#
@SpringBootApplication tells Spring to scan all the files in the package where the class with this annotation 
is present. 
It also scans any sub-packages of the package where it is placed.

When we use the @Component, @Autowired, and @SpringBootApplication 
annotations, the following line in our code becomes redundant as 
it is automatically done by Spring:


## Application Context
The beans that Spring creates are managed by the Application Context.
We can get information about a bean from the Application Context. 
The run method returns the ApplicationContext, which can be assigned 
to a variable appContext. 
Then the getBean method of ApplicationContext can be used to get the 
bean of a particular class. We will create a local variable
recommender and assign the bean to it as follows:



## application.properties
To understand what goes on in the background, we will change the
logging level to debug. This can be done by adding the following to 
the application.properties file in src/main/resources:

###  Logging.level.org.springframework = debug


NoUniqueBeanDefinitionException
We will add the @Component annotation on the CollaborativeFilter
class to declare it a bean. Now both implementations of the Filter 
interface are beans. Previously, when Spring searched for a dependency 
to be autowired in the RecommenderImplementation object, it only found 
one bean of matching type. Now when we run the application, it fails to
start.

The NoUniqueBeanDefinitionException occurs. 
The error message says: Required a single bean but two were found.


## @Primary annotation
One way Spring can choose between two beans of the same type is by 
giving one bean priority over the other. 
The @Primary annotation is used for making a component the default 
choice when multiple beans of the same type are found.

Using @Primary is called autowiring by type. We are looking for instances of type Filter.

