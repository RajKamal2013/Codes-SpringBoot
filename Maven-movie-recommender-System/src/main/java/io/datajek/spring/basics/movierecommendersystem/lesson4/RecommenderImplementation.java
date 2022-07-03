package io.datajek.spring.basics.movierecommendersystem.lesson4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    //Autowiring by name
    @Autowired
    private Filter contentBasedFilter;

    //use a filter to find recommendations
    public String [] recommendMovies (String movie) {

        //print the name of interface implementation being used
        System.out.println("\nName of the filter in use: " + contentBasedFilter + "\n");

        String[] results = contentBasedFilter.getRecommendations("Finding Dory");

        return results;
    }

}
