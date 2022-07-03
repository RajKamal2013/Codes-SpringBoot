package io.datajek.spring.basics.movierecommendersystem.lesson1;

import io.datajek.spring.basics.movierecommendersystem.lesson2.CollaborativeFilter;

public class RecommenderImplementation {

    public String[] recommendMovies(String movie) {
        CollaborativeFilter filter = new CollaborativeFilter();
        String[] results =
                filter.getRecommendations("Finding Dory");
        return results;
    }
    /*
    public String[] recommendMovies(String movie) {
        //use content based filter to find similar movies
        ContentBasedFilter filter = new ContentBasedFilter();
        String[] results = filter.getRecommendations("Finding Dory");
        //return the results
        return results;
    }
    */

    /*
    public String[] recommendMovies (String movie) {
        //use content based filter to find similar movies
        //return the results
        return new String[] {"M1", "M2", "M3"};
    }
     */

}
