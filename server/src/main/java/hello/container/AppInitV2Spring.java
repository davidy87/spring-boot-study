package hello.container;

import hello.spring.HelloConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {

    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // Spring container 생성
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(HelloConfig.class);

        // Spring MVC DispatcherServlet 생성, container 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // DispatcherServlet을 servlet container에 연결
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcherServlet);

        // /spring/* 요청이 DispatcherServlet을 통하도록 설정
        servlet.addMapping("/spring/*");
    }
}
