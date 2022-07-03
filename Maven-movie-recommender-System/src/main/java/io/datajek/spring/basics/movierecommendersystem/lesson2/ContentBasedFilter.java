package io.datajek.spring.basics.movierecommendersystem.lesson2;

public class ContentBasedFilter implements Filter{
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
