package hello.container;

import hello.servlet.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class AppInitV1Servlet implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("애플리케이션 초기화 후 서블릿 등록");
        
        /*
            순수 서블릿 등록
            ServletContext는 서블릿 컨테이너 그자체이며 addServlet으로 순수 서블릿을 등록한다.
         */
        ServletRegistration.Dynamic helloServlet = servletContext.addServlet("helloServlet", new HelloServlet());

        // 컨트롤러의 requestMapping로서 아래 경로를 호출하면 new HelloServlet이 호출된다.
        helloServlet.addMapping("/hello-servlet");
    }
}
