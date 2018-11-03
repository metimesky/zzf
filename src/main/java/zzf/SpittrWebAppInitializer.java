package zzf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author CELINE
 *
 */
//扩展自Abstrac~Initializer的任意类，都会自动地配置Dispatcher-Servlet和Spring应用上下文
//spring的应用上下文会位于程序的Servlet上下文之中
public class SpittrWebAppInitializer  extends
        AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    //映射“/”，表示会使用默认的Servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

}