package io.datajek.spring.basics.movierecommendersystem.lesson7;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeFilter implements Filter {
    public String[] getRecommendations(String movie) {
        //logic of collaborative filter
        return new String[] { };
    }

}
