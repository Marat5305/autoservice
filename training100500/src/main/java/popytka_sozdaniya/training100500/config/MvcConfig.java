package popytka_sozdaniya.training100500.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        /*registry.addViewController("/index/info").setViewName("info");
        registry.addViewController("/index/info/carinfo").setViewName("carinfo");*/
    }

}