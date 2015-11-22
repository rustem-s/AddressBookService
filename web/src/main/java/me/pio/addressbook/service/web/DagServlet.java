package me.pio.addressbook.service.web;

import me.pio.addressbook.service.domain.Common;
import me.pio.addressbook.service.ejb.Dag;

import javax.ejb.EJB;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Rustem.Saidaliyev on 22.11.2015.
 */
public class DagServlet implements Servlet {

    @EJB(name = "DagEJB")
    private Dag ejb;


    public void init(ServletConfig servletConfig) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletOutputStream out = servletResponse.getOutputStream();
        out.println("<html><body>");
        out.println("<p>Servlet says hey.</p>");
        Common common = new Common();
        out.println("<p>" + common.sayHey() + "</p>");
        out.println("<p>" + ejb.sayHey() + "</p>");
        out.println("</body></html>");
        out.flush();

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
