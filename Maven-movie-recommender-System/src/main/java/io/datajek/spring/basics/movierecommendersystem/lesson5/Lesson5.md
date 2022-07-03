# Lesson5 


## Qualifier Annotation
Like @Primary, the @Qualifier annotation gives priority to one bean over
the other if two beans of the same type are found. The bean whose name 
is specified in the @Qualifier annotation qualifies to be injected as
a dependency. The @Qualifier annotation can be used in a scenario when
we have multiple objects of the same type and autowiring by name cannot
be used because the variable name doesn’t match any bean name.

Add below before the bean class defination
@Component
@Qualifier("<name>")

Add before interface
@Autowired
@Qualifier("<name>")
private Filter filter;

## The @Qualifier annotation takes precedence over the @Primary annotation