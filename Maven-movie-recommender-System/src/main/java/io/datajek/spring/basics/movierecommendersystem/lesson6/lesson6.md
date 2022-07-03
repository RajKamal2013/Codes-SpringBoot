# Lesson 6 

# Primary, Qualifier 

@Primary annotation should be used if there is one clear favorite to be used in a majority of situations. In some cases, one algorithm might be more efficient or more important than the rest and is declared as the primary choice. The bean with @Primary gets chosen unless another bean is required, which can be specified with @Qualifier. The bean with @Qualifier is only used to request an “alternate” bean in case the primary choice is not required.

@Autowired annotation resolves dependencies by type. If there are more than one beans of the same type, a conflict arises. We have seen three different approaches to resolve conflicts. They can be resolved using the @Primary annotation, renaming the variable to match the name of the class, or by using the @Qualifier annotation.