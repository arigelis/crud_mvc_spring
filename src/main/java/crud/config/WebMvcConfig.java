package crud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig {
    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    @Value("${spring.mvc.view.suffix}")
    private String suffix;

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(suffix);
        viewResolver.setPrefix(prefix);
        return viewResolver;
    }
}