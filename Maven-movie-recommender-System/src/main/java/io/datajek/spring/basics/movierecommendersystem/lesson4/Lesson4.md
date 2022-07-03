# Lesson 4

## Autowired by name 

we add @Autowired before the name of class and use the filer to make the 
annotation that we are using. Here we are making interface autowired while
accessing the beans.

We will begin by omitting the @Primary annotation from the 
CollaborativeFilter class. Now, to let Spring know which bean to use, 
we will change the variable name in the RecommenderImplementation 
class to match the bean name as follows:

Now when the application is run, it chooses the ContentBasedFilter bean for autowiring. When Spring finds two beans of the same type (Filter), it determines that the bean to inject is the one whose name matches the bean with the @Component annotation. In other words, the variable name (contentBasedFilter)
matches the bean name (ContentBasedFilter).



