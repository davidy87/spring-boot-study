package hello.embedded;

import hello.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcatServletMain {

    public static void main(String[] args) throws LifecycleException {
        System.out.println("EmbeddedTomcatServletMain.main");

        // Tomcat 설정
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        // Servlet 등록
        Context context = tomcat.addContext("", "/");
        tomcat.addServlet("", "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello-servlet", "helloServlet");
        tomcat.start();
    }
}
