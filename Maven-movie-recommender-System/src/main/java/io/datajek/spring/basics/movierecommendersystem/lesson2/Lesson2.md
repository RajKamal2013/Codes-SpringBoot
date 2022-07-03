
# DeCoupling 

1. Create an interface Filter with method "getRecommendations()"
2. Create a class ContentBased by implementing Filter and defining getRecommendatations()
3. Create a class CollaborativeBased by implementing Filter and defining getRecommendatations()
4. Class RecommederImplementation and it takes Filter class in it's 
constructor and in recommendMovies() method, call the the class passed 
getRocommendations() method. 

Now Filter is a dependency of RecommenderImplementation.
We still have to create an object of RecommenderImplementation 
and an object of Filter and pass the objects to the constructor. 

In the next lesson, we will see how Spring takes over the job 
of managing dependencies.

