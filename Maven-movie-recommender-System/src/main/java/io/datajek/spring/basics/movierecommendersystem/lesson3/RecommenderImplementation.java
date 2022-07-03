package io.datajek.spring.basics.movierecommendersystem.lesson3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Filter is a dependency of RecommenderImplementation
    @Autowired
    private Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("Name of the filter in use: " + filter + "\n");

        String[] results = filter.getRecommendations("Finding Dory");

        return results;
    }

}
