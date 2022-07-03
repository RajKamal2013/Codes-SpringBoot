package io.datajek.spring.basics.movierecommendersystem.lesson2;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class MavenMovieRecommenderSystemApplication {

    public static void main(String[] args) {
        /*
        SpringApplication.run(MavenMovieRecommenderSystemApplication.class, args);
         */
        /*
        RecommenderImplementation recommender = new
                RecommenderImplementation();
        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));
        */


        //SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        //passing name of the filter as constructor argument
       // RecommenderImplementation recommender = new RecommenderImplementation(new ContentBasedFilter());
        RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeFilter());

        //call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dory");

        //display results
        System.out.println(Arrays.toString(result));

    }

}
