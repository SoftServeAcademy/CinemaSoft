package softServe.academy.cinemasoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import softServe.academy.cinemasoft.common.MovieFormInterceptor;

@Configuration
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

    private final MovieFormInterceptor movieFormInterceptor;

    @Autowired
    public WebMvcInterceptorConfig(MovieFormInterceptor movieFormInterceptor) {
        this.movieFormInterceptor = movieFormInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.movieFormInterceptor)
                .addPathPatterns("/movies/add", "/movies/edit/{id}", "/movies/delete/{id}");
    }
}
