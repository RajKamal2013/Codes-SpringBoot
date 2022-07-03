# Lesson1 

Example of  tight coupling. 
1. Create ContentBasedFilter class and define getRecommendations() method
2. Create RecommenderImplementation class and its constructor takes ContentBasedFilter
class as parameter. Define RecommendMovie method and call the getRecommendation()
method of ContentBasedFilter class. 
3. In the main, create object of RecommenderImplementation and call RecommendMovies()


This is tight coupling, to add new filter, we have to change the RecommenderImplementation 
class and also need to add new filter class. 

