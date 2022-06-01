package haut.se.finalwork.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        WebMvcConfigurer.super.addViewControllers(registry);
        registry.addViewController("/user_signup_page").setViewName("user_signup");
    }
}
