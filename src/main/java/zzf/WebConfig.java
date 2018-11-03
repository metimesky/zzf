package zzf;

import freemarker.cache.WebappTemplateLoader;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan("zzf")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public PropertyPlaceholderConfigurer getTestPpc() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new ClassPathResource("jdbc.properties"));
        return ppc;
    }

    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setContentType("text/html;charset=utf-8");
/*
* 如果注释 resolver.setPrefix("/WEB-INF/views/");
* 下面config需要tplCfg.setTemplateLoader(new
* WebappTemplateLoader(servletContext,"/WEB-INF/views/"));
*/
//        resolver.setPrefix("/page/");
        resolver.setSuffix(".ftl");
        resolver.setViewClass(FreeMarkerView.class);
        return resolver;
    }

    /**
     * 配置freemarker
     *
     * @param servletContext
     * @return
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(ServletContext servletContext) {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        @SuppressWarnings("deprecation")
        freemarker.template.Configuration tplCfg = new freemarker.template.Configuration();
        tplCfg.setDefaultEncoding("UTF-8");
//        tplCfg.setTemplateLoader(new WebappTemplateLoader(servletContext, "/page"));
        tplCfg.setClassForTemplateLoading(this.getClass(), "/page");
//        try {
//            tplCfg.setDirectoryForTemplateLoading(new File("/Users/zhangxinwei/Documents/zzf/target/classes/page/"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        freeMarkerConfigurer.setConfiguration(tplCfg);

        return freeMarkerConfigurer;
    }

    /**
     * 通过调用enable方法，我们要求DispatcherServelet将
     * 对静态资源的请求转发到Servlet容器中的默认的Servlet上，
     * 不是DispatcherServelet本身处理
     *
     * @param configurer
     */
    public void configureDefaultServleHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}