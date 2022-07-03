package io.datajek.spring.basics.movierecommendersystem.lesson1;

import io.datajek.spring.basics.movierecommendersystem.lesson2.CollaborativeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class MavenMovieRecommenderSystemApplication {

    public static void main(String[] args) {
        /*
        SpringApplication.run(MavenMovieRecommenderSystemApplication.class, args);
         */


        RecommenderImplementation recommender = new
                RecommenderImplementation();
        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));


    }

}
