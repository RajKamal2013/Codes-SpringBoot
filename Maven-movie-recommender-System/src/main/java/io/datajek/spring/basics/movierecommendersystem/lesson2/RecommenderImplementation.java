package io.datajek.spring.basics.movierecommendersystem.lesson2;

public class RecommenderImplementation {

    //use filter interface to select filter
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

    /*
    public String[] recommendMovies(String movie) {
        CollaborativeFilter filter = new CollaborativeFilter();
        String[] results =
                filter.getRecommendations("Finding Dory");
        return results;
    }
    */
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
