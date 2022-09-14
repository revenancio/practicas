package mudanza.mudanzaui;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewController(ViewControllerRegistry registry){
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/preguntas").setViewName("preguntas");
    }
    
}
