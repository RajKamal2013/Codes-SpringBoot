package io.datajek.springbootweb.recommenderapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RecommendationsController {

    @GetMapping("/movies")
//	@RequestMapping(method=RequestMethod.GET, value="/movies")
    public List<Movie> getAllMovies() {

        return Arrays.asList(new Movie(1, "Ice Age", 7.0),
                new Movie(2, "Happy Feet", 6.4),
                new Movie(3, "Shark Tales", 6.0) );
    }

}
