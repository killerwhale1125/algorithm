package hello.embeded;

import org.apache.catalina.connector.Connector;
import hello.spring.HelloConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class EmbededTomcatSpringMain {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbededTomcatSpringMain.main");

        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8000);
        tomcat.setConnector(connector);

        AnnotationConfigWebApplicationContext springContainer = new AnnotationConfigWebApplicationContext();
        springContainer.register(HelloConfig.class);

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContainer);

        Context context = tomcat.addContext("", "/");
        tomcat.addServlet("", "dispatcherServlet", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcherServlet");
        tomcat.start();
    }
}
