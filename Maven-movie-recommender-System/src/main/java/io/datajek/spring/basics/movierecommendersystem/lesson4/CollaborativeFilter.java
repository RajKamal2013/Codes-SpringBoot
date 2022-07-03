package io.datajek.spring.basics.movierecommendersystem.lesson4;

import org.springframework.stereotype.Component;

@Component
public class CollaborativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] { };
    }

}
