/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filters;

import entities.Projectgroups;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;
import restClient.commonClient;

/**
 *
 * @author Bhatt Jaimin
 */
@WebFilter(filterName = "authFilter", urlPatterns = {"/login.xhtml"})
public class authFilter implements Filter {

    commonClient cc = new commonClient();
    
    public authFilter() {

    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession ses = req.getSession();
        String token = (String) ses.getAttribute("authToken");
        if (token != null) {
            Response rs = cc.authenticateReq(token);
            if (rs.getStatus() == 200) {
                Projectgroups g1 = rs.readEntity(Projectgroups.class);
                String s1 = g1.getGroupName();
                if (s1.equals("player")) {
                    res.sendRedirect("/ps8/player/home.xhtml");
                    chain.doFilter(request, response);
                    
                } else if (s1.equals("organizer")) {
                    res.sendRedirect("/ps8/organizer/home.xhtml");
                    chain.doFilter(request, response);

                } else if (s1.equals("auctioneer")) {
                    res.sendRedirect("/ps8/auctioneer/home.xhtml");
                    chain.doFilter(request, response);
                } else if (s1.equals("owner")) {
                    res.sendRedirect("/ps8/owner/home.xhtml");
                    chain.doFilter(request, response);
                }
            }else{
                    chain.doFilter(request, response);
                }

        }else{
             chain.doFilter(request, response);
        }
    }



    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    
    }

 
 

}
